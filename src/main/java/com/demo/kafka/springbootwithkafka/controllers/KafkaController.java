package com.demo.kafka.springbootwithkafka.controllers;

import com.demo.kafka.springbootwithkafka.engine.Producer;
import com.demo.kafka.springbootwithkafka.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static java.lang.System.currentTimeMillis;

@RestController
@RequestMapping(value = "/spring-boot-with-kafka")
public class KafkaController {

  private final Producer producer;

  @Autowired
  public KafkaController(final Producer producer) {
    this.producer = producer;
  }

  @PostMapping(value = "/topic/{topic}/send-message")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void sendMessageToKafkaTopic(@RequestBody final Message message, @PathVariable final String topic) {

    message.setTimestamp(currentTimeMillis());

    this.producer.sendMessageToTopic(message, topic);
  }
}
