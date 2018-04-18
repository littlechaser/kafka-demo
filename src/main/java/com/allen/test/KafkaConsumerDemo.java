package com.allen.test;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * @author yang_tao@<yangtao.letzgo.com.cn>
 * @version 1.0
 * @date 2018-04-18 16:32
 */
public class KafkaConsumerDemo {
    public static void main(String[] args) {
        Properties prop = ResourceUtil.loadProperties("kafka-consumer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(prop);
        consumer.subscribe(Collections.singletonList("Hello-Kafka-Topic"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(200);
            records.forEach(record -> {
                System.out.println(record.topic());
                System.out.println(record.partition());
                System.out.println(record.key());
                System.out.println(record.value());
                System.out.println(record.offset());
                System.out.println(record.timestamp());
            });
        }
    }
}
