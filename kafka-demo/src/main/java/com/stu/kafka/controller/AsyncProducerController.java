package com.stu.kafka.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncProducerController {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @GetMapping("/send/async/{message}")
    public String asyncSend(@PathVariable String message) {
        ProducerRecord<Integer, String> record = new ProducerRecord<>("demoTopic",0,3,message);
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(record);
        // 添加回调，异步等待响应
        future.addCallback(new ListenableFutureCallback<SendResult<Integer,String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送失败: " + throwable.getMessage());
            }
            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                System.out.println("发送成功："
                        + result.getRecordMetadata().topic() + "\t"
                        + result.getRecordMetadata().partition() + "\t"
                        + result.getRecordMetadata().offset()
                );
            }
        });
        return "success";
    }
}
