package com.demo.kafka.springbootwithkafka.engine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

  private static final Logger logger = LoggerFactory.getLogger(Producer.class);
  private static final String TOPIC = "demo";
  private static final ObjectMapper MAPPER = new ObjectMapper();

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(final Object message) {
    try {
      final String kafkaMessage = MAPPER.writeValueAsString(message);

      logger.info(String.format("producing message: %s", kafkaMessage));

      this.kafkaTemplate.send(TOPIC, kafkaMessage);

    } catch (JsonProcessingException e) {
      logger.error("cannot parse message: ", e);
    }
  }
}
