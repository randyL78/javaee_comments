package com.randylayne.eventhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Event {
  private static ObjectMapper mapper = new ObjectMapper();
  private String type;
  private Object data;

  public Event() {
  }

  public Event(String type) {
    this.type = type;
  }

  public Event(String type, Object data) {
    this.type = type;
    this.data = data;
  }
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  @Override
  public String toString() {
    try {
      return mapper.writeValueAsString(this);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
