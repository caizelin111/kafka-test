package com.liquido.kafka.concurrentLimit.advise;

import com.liquido.kafka.concurrentLimit.annotations.ConcurrentLimit;
import com.liquido.kafka.concurrentLimit.core.factory.DefaultConcurrentLimitLayerFactory;
import com.liquido.kafka.concurrentLimit.core.layer.AbstractConcurrentLimitLayer;
import com.liquido.kafka.concurrentLimit.core.factory.LayerFactory;
import com.liquido.kafka.concurrentLimit.core.layer.ConcurrentLimitHandler;
import com.liquido.kafka.concurrentLimit.core.layer.DowngradeHandlerStrategy;
import com.liquido.kafka.concurrentLimit.core.layer.impl.DefaultConcurrentLimitHandler;
import com.liquido.kafka.concurrentLimit.core.layer.impl.DefaultConcurrentLimitInvokeLayer;
import com.liquido.kafka.concurrentLimit.core.layer.impl.DiscardStrategy;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.function.Function;

@Slf4j
@Component
@Aspect
@AllArgsConstructor
public class ConcurrentLimitAspectj implements ApplicationContextAware {

    @Resource
    private LayerFactory layerFactory;

    /**
     * springEL parser
     */
    private static final ExpressionParser parser = new SpelExpressionParser();

    private static ApplicationContext APP_CONTEXT;
    private static final String keyPattern = "%:%:%";

    @Pointcut("@annotation(com.liquido.kafka.concurrentLimit.annotations.ConcurrentLimit)")
    private void currentLimit() {

    }

    /**
     * @param joinPoint
     */
    @SneakyThrows
    @Around("currentLimit()")
    public void currentLimit(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Parameter[] parameters = method.getParameters();
        if (null == parameters || 0 == parameters.length) {
            throw new RuntimeException("parameters can not null");
        }

        ConcurrentLimit concurrentLimit = method.getAnnotation(ConcurrentLimit.class);
        if (null == concurrentLimit) {
            return;
        }

        Object elKey = parseExpressionSpEL(concurrentLimit.key(), joinPoint, parameters);

        // generate business key;
        String businessKey = method.getName() + ":" + elKey;

        // wrap target method to runnable
        // todo 响应需要返回一下 应该使用 function
        Runnable runnable = () -> {
            try {
                joinPoint.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        };

        // todo 这里需要调整一下
        AbstractConcurrentLimitLayer limitLayer;
        // 若使用默认的handler 和 strategy，则从默认工厂中拿即可
        if (concurrentLimit.currentLimitHandler().equals(DefaultConcurrentLimitHandler.class) && concurrentLimit.downgradeHandlerStrategy().equals(DiscardStrategy.class)) {
            DefaultConcurrentLimitLayerFactory factory = new DefaultConcurrentLimitLayerFactory();
            limitLayer = factory.createLimitLayer();
        } else {
            // 不是默认的， 则手动加载
            ConcurrentLimitHandler handler = APP_CONTEXT.getBean(concurrentLimit.currentLimitHandler());
            DowngradeHandlerStrategy strategy = APP_CONTEXT.getBean(concurrentLimit.downgradeHandlerStrategy());
            limitLayer = new DefaultConcurrentLimitInvokeLayer(handler, strategy);
        }

        limitLayer.invokeConcurrentLimit(businessKey, concurrentLimit.limitCount(), concurrentLimit.fixedWindow(), runnable);
    }


    /**
     * 解析SpEL
     *
     * @param spELStr
     * @param joinPoint
     * @param parameters
     * @return
     */
    private Object parseExpressionSpEL(String spELStr, ProceedingJoinPoint joinPoint, Parameter[] parameters) {

        // parse expression
        Expression expression = parser.parseExpression(spELStr);
        // construct context
        joinPoint.getTarget();
        EvaluationContext context = new StandardEvaluationContext(joinPoint.getTarget());
        // set value
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < parameters.length; i++) {
            context.setVariable(parameters[i].getName(), args[i]);
        }
        return expression.getValue(context);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APP_CONTEXT = applicationContext;
    }
}
