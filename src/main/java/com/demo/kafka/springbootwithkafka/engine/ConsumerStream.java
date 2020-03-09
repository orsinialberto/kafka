package com.demo.kafka.springbootwithkafka.engine;

import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerStream {

  private static final Logger logger = LoggerFactory.getLogger(ConsumerStream.class);

  @StreamListener
  public void requestListener(final @Input(MessageBinding.REQUESTS_IN) KStream<String, String> requestsIn) {
    requestsIn.foreach((key, value) -> logger.info(String.format("CONSUMER STREAM has consumed message with key: %s and value %s", key, value)));
  }
}
