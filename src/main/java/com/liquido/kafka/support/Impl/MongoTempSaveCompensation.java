package com.liquido.kafka.support.Impl;

import com.liquido.kafka.support.KafkaCompensationHandler;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class MongoTempSaveCompensation implements KafkaCompensationHandler {
    @Override
    public void handle(Object object) {

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "{\\\"payload\\\":{\\\"after\\\":{\\\"amount\\\":\\\"100.00\\\",\\\"async_process_tag\\\":0,\\\"balance\\\":\\\"\\\",\\\"bank_code\\\":\\\"137\\\",\\\"bank_id\\\":\\\"40137\\\",\\\"bank_name\\\":\\\"BANCOPPEL\\\",\\\"branch_id\\\":\\\"\\\",\\\"country\\\":\\\"MX\\\",\\\"create_time\\\":\\\"2022-08-10T02:19:02Z\\\",\\\"currency\\\":\\\"MXN\\\",\\\"external_id\\\":\\\"GWiag30220810196179677070000922\\\",\\\"final_status_time\\\":\\\"\\\",\\\"final_status_unix_time\\\":0,\\\"flags\\\":0,\\\"id\\\":1090609,\\\"idempotency_key\\\":\\\"GWiag30220810196179677070000922\\\",\\\"need_retry\\\":0,\\\"original_idem_key\\\":\\\"\\\",\\\"payee_comment\\\":\\\"\\\",\\\"payer_comment\\\":\\\"Kwai Liquido\\\",\\\"payment_type\\\":\\\"BankTransfer\\\",\\\"reference_number\\\":\\\"0097942\\\",\\\"reserve\\\":\\\"\\\",\\\"response\\\":\\\"\\\",\\\"schedule_date\\\":\\\"2022-08-10\\\",\\\"spei_tid\\\":\\\"\\\",\\\"status\\\":\\\"IN_PROGRESS\\\",\\\"submit_time\\\":\\\"2022-08-10 02:19:02 GMT+00:00\\\",\\\"submit_unix_time\\\":1660097942,\\\"target_account_id\\\":\\\"137180104050554790\\\",\\\"target_document_id\\\":\\\"\\\",\\\"target_document_type\\\":\\\"\\\",\\\"target_email\\\":\\\"\\\",\\\"target_last_name\\\":\\\"Ana line Angeles lugo\\\",\\\"target_name\\\":\\\"Ana l A l A l A lugo\\\",\\\"transaction_fee\\\":\\\"\\\",\\\"transaction_id\\\":\\\"\\\",\\\"transfer_error_msg\\\":\\\"\\\",\\\"transfer_status_code\\\":200,\\\"update_time\\\":\\\"2022-08-10T02:19:02Z\\\",\\\"user_id\\\":\\\"tP7dYVvbF03i7mdR14WPG7v9ZzDdnZPU5Fwdr7CD\\\",\\\"vendor_create_time\\\":\\\"\\\",\\\"vendor_error_code\\\":\\\"\\\",\\\"vendor_error_message\\\":\\\"\\\",\\\"vendor_name\\\":\\\"UNIPAGOS\\\",\\\"version\\\":0},\\\"before\\\":null,\\\"op\\\":\\\"c\\\",\\\"source\\\":{\\\"connector\\\":\\\"mysql\\\",\\\"db\\\":\\\"liquido\\\",\\\"file\\\":\\\"mysql-bin-changelog.032864\\\",\\\"gtid\\\":null,\\\"name\\\":\\\"aquarius-prod-2\\\",\\\"pos\\\":65877,\\\"query\\\":null,\\\"row\\\":0,\\\"sequence\\\":null,\\\"server_id\\\":1793605057,\\\"snapshot\\\":\\\"false\\\",\\\"table\\\":\\\"payout_kwai\\\",\\\"thread\\\":316425,\\\"ts_ms\\\":1660097942000,\\\"version\\\":\\\"1.9.0.Final\\\"},\\\"transaction\\\":null,\\\"ts_ms\\\":1660097942397},\\\"schema\\\":{\\\"fields\\\":[{\\\"field\\\":\\\"before\\\",\\\"fields\\\":[{\\\"field\\\":\\\"id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int64\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"idempotency_key\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"external_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"transaction_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"reference_number\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"status\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"amount\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"transaction_fee\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"balance\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"currency\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"submit_time\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"1970-01-01T00:00:00Z\\\",\\\"field\\\":\\\"create_time\\\",\\\"name\\\":\\\"io.debezium.time.ZonedTimestamp\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\",\\\"version\\\":1},{\\\"default\\\":\\\"1970-01-01T00:00:00Z\\\",\\\"field\\\":\\\"update_time\\\",\\\"name\\\":\\\"io.debezium.time.ZonedTimestamp\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\",\\\"version\\\":1},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"payment_type\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"payer_comment\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"payee_comment\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"country\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"user_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"bank_name\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"bank_code\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"bank_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"branch_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"target_account_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"target_name\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"target_last_name\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"target_email\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"target_document_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"target_document_type\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"schedule_date\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"submit_unix_time\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int64\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"final_status_time\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"final_status_unix_time\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int64\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"vendor_create_time\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"spei_tid\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"vendor_error_code\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"vendor_error_message\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"response\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"reserve\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"version\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int32\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"transfer_status_code\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int32\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"transfer_error_msg\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"flags\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int32\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"original_idem_key\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"need_retry\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int32\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"vendor_name\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"async_process_tag\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int32\\\"}],\\\"name\\\":\\\"aquarius_prod_2.liquido.payout_kwai.Value\\\",\\\"optional\\\":true,\\\"type\\\":\\\"struct\\\"},{\\\"field\\\":\\\"after\\\",\\\"fields\\\":[{\\\"field\\\":\\\"id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int64\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"idempotency_key\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"external_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"transaction_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"reference_number\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"status\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"amount\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"transaction_fee\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"balance\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"currency\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"submit_time\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"1970-01-01T00:00:00Z\\\",\\\"field\\\":\\\"create_time\\\",\\\"name\\\":\\\"io.debezium.time.ZonedTimestamp\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\",\\\"version\\\":1},{\\\"default\\\":\\\"1970-01-01T00:00:00Z\\\",\\\"field\\\":\\\"update_time\\\",\\\"name\\\":\\\"io.debezium.time.ZonedTimestamp\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\",\\\"version\\\":1},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"payment_type\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"payer_comment\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"payee_comment\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"country\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"user_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"bank_name\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"bank_code\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"bank_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"branch_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"target_account_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"target_name\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"target_last_name\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"target_email\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"target_document_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"target_document_type\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"schedule_date\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"submit_unix_time\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int64\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"final_status_time\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"final_status_unix_time\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int64\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"vendor_create_time\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"spei_tid\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"vendor_error_code\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"vendor_error_message\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"response\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"reserve\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"version\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int32\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"transfer_status_code\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int32\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"transfer_error_msg\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"flags\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int32\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"original_idem_key\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"need_retry\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int32\\\"},{\\\"default\\\":\\\"\\\",\\\"field\\\":\\\"vendor_name\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"default\\\":0,\\\"field\\\":\\\"async_process_tag\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int32\\\"}],\\\"name\\\":\\\"aquarius_prod_2.liquido.payout_kwai.Value\\\",\\\"optional\\\":true,\\\"type\\\":\\\"struct\\\"},{\\\"field\\\":\\\"source\\\",\\\"fields\\\":[{\\\"field\\\":\\\"version\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"field\\\":\\\"connector\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"field\\\":\\\"name\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"field\\\":\\\"ts_ms\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int64\\\"},{\\\"default\\\":\\\"false\\\",\\\"field\\\":\\\"snapshot\\\",\\\"name\\\":\\\"io.debezium.data.Enum\\\",\\\"optional\\\":true,\\\"parameters\\\":{\\\"allowed\\\":\\\"true,last,false,incremental\\\"},\\\"type\\\":\\\"string\\\",\\\"version\\\":1},{\\\"field\\\":\\\"db\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"field\\\":\\\"sequence\\\",\\\"optional\\\":true,\\\"type\\\":\\\"string\\\"},{\\\"field\\\":\\\"table\\\",\\\"optional\\\":true,\\\"type\\\":\\\"string\\\"},{\\\"field\\\":\\\"server_id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int64\\\"},{\\\"field\\\":\\\"gtid\\\",\\\"optional\\\":true,\\\"type\\\":\\\"string\\\"},{\\\"field\\\":\\\"file\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"field\\\":\\\"pos\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int64\\\"},{\\\"field\\\":\\\"row\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int32\\\"},{\\\"field\\\":\\\"thread\\\",\\\"optional\\\":true,\\\"type\\\":\\\"int64\\\"},{\\\"field\\\":\\\"query\\\",\\\"optional\\\":true,\\\"type\\\":\\\"string\\\"}],\\\"name\\\":\\\"io.debezium.connector.mysql.Source\\\",\\\"optional\\\":false,\\\"type\\\":\\\"struct\\\"},{\\\"field\\\":\\\"op\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"field\\\":\\\"ts_ms\\\",\\\"optional\\\":true,\\\"type\\\":\\\"int64\\\"},{\\\"field\\\":\\\"transaction\\\",\\\"fields\\\":[{\\\"field\\\":\\\"id\\\",\\\"optional\\\":false,\\\"type\\\":\\\"string\\\"},{\\\"field\\\":\\\"total_order\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int64\\\"},{\\\"field\\\":\\\"data_collection_order\\\",\\\"optional\\\":false,\\\"type\\\":\\\"int64\\\"}],\\\"optional\\\":true,\\\"type\\\":\\\"struct\\\"}],\\\"name\\\":\\\"aquarius_prod_2.liquido.payout_kwai.Envelope\\\",\\\"optional\\\":false,\\\"type\\\":\\\"struct\\\"}}";
        int a = str.getBytes("UTF-8").length;
        System.out.println(a);
    }
}

// 11786B = 11KB