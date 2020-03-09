package com.demo.kafka.springbootwithkafka.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "demo", groupId = "demo_kafka")
    public void consume(final String message) {
      logger.info(String.format("CONSUMER has consumed message: %s", message));
    }

}
