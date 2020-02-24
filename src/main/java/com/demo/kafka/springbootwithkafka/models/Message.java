package com.demo.kafka.springbootwithkafka.models;

import java.util.Objects;

public class Message {

  private String message;
  private Long ts;

  public Message(String message, Long ts) {
    this.message = message;
    this.ts = ts;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getTs() {
    return ts;
  }

  public void setTs(Long ts) {
    this.ts = ts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Message)) return false;
    Message message1 = (Message) o;
    return Objects.equals(message, message1.message) &&
      Objects.equals(ts, message1.ts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, ts);
  }

  @Override
  public String toString() {
    return "Message{" +
      "message='" + message + '\'' +
      ", ts=" + ts +
      '}';
  }
}
