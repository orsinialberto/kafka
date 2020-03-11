package com.demo.kafka.springbootwithkafka.models;

import java.util.Objects;

public class Message {

  private String message;

  private Long timestamp;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Message)) return false;
    Message message1 = (Message) o;
    return Objects.equals(message, message1.message) &&
      Objects.equals(timestamp, message1.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, timestamp);
  }

  @Override
  public String toString() {
    return "Message{" +
      "message='" + message + '\'' +
      ", ts=" + timestamp +
      '}';
  }
}
