package com.allen.ccontroller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang_tao@<yangtao.letzgo.com.cn>
 * @version 1.0
 * @date 2018-04-18 17:39
 */
@RestController
public class TestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/send")
    public String send(@RequestParam("msg") String msg) {

        kafkaTemplate.send("Hello-Kafka-Topic", msg);
        return "success";
    }

    @KafkaListener(id = "0", groupId = "allen-kafka-consumer-0", topics = "Hello-Kafka-Topic")
    public void listener(ConsumerRecord<String, String> record) {
        System.out.println(record.topic());
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.offset());
        System.out.println(record.timestamp());
    }

}
