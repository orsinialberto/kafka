package com.demo.kafka.springbootwithkafka.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "demo", groupId = "demo_kafka")
    public void consume(final String message) {
      LOGGER.info("CONSUMER has consumed message: {}", message);
    }

}
