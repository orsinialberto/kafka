package com.demo.kafka.springbootwithkafka.engine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
public class Producer {

  private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
  private static final ObjectMapper MAPPER = new ObjectMapper();

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  public Producer(final KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessageToTopic(final Object message, final String topic) {

    requireNonNull(topic, "topic must not be null");
    requireNonNull(message, "message must not be null");

    try {

      final var kafkaMessage = MAPPER.writeValueAsString(message);

      LOGGER.info("send message {} to topic {}", kafkaMessage, topic);

      this.kafkaTemplate.send(topic, kafkaMessage);

    } catch (JsonProcessingException e) {
      LOGGER.error("cannot parse message {} ", message, e);
    }
  }
}
