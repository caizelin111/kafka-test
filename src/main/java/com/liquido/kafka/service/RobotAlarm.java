package com.liquido.kafka.service;

import org.springframework.stereotype.Service;

@Service
public class RobotAlarm {
    public void alarm() {
        System.out.println("机器人告警啦！！！");
    }
}
