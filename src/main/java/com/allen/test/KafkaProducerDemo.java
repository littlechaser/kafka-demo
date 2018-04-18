package com.allen.test;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author yang_tao@<yangtao.letzgo.com.cn>
 * @version 1.0
 * @date 2018-04-17 15:10
 */
public class KafkaProducerDemo {
    public static void main(String[] args) throws InterruptedException {
        Properties prop = ResourceUtil.loadProperties("kafka-producer");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(prop)) {
            for (int i = 0; i < 10; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>("Hello-Kafka-Topic", "test message " + i);
                producer.send(record);
                Thread.sleep(1000);
            }
        }

    }
}
