package com.demo.kafka.springbootwithkafka.controllers;

import com.demo.kafka.springbootwithkafka.engine.Producer;
import com.demo.kafka.springbootwithkafka.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static java.lang.System.currentTimeMillis;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

  private final Producer producer;

  @Autowired
  public KafkaController(final Producer producer) {
    this.producer = producer;
  }

  @PostMapping(value = "/publish")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void sendMessageToKafkaTopic(@RequestBody final Message message, @RequestParam final String topic) {

    message.setTimestamp(currentTimeMillis());

    this.producer.sendMessageToTopic(message, topic);
  }
}
