package com.demo.kafka.springbootwithkafka.controller;

import com.demo.kafka.springbootwithkafka.engine.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

  private final Producer producer;

  @Autowired
  public KafkaController(final Producer producer) {
    this.producer = producer;
  }

  @PostMapping(value = "/topic/{topic}/send")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void sendMessageToKafkaTopic(@RequestBody final Object message, @PathVariable final String topic) {

    requireNonNull(topic, "topic must not be null");
    requireNonNull(message, "message must not be null");

    this.producer.sendMessageToTopic(message, topic);
  }
}
