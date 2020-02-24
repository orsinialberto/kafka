package com.demo.kafka.springbootwithkafka.controllers;

import com.demo.kafka.springbootwithkafka.engine.Producer;
import com.demo.kafka.springbootwithkafka.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

  private final Producer producer;

  @Autowired
  public KafkaController(Producer producer) {
    this.producer = producer;
  }

  @PostMapping(value = "/publish")
  public void sendMessageToKafkaTopic(final @RequestBody String message) {

    final Message kafkaMessage = new Message(message, System.currentTimeMillis());

    this.producer.sendMessage(kafkaMessage);
  }
}
