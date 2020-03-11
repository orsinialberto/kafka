package com.demo.kafka.springbootwithkafka.engine;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface MessageBinding {

  String REQUESTS_IN = "requests-in";

  @Input(REQUESTS_IN)
  KStream<String, String> requestsIn();
}
