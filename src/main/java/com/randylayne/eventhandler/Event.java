package com.randylayne.eventhandler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Event {
  private String type;
  private UUID typeUUID;
  private Map<String, String> content;

  public Event() {
    content = new HashMap<>();
  }
  public Event(String type, UUID typeUUID) {
    this.type = type;
    this.typeUUID = typeUUID;
    content = new HashMap<>();
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public UUID getTypeUUID() {
    return typeUUID;
  }

  public void setTypeUUID(UUID typeUUID) {
    this.typeUUID = typeUUID;
  }

  public Map<String, String> getContent() {
    return content;
  }

  public void setContent(Map<String, String> content) {
    this.content = content;
  }

  public void addContentItem(String key, String value) {
    content.put(key, value);
  }
}
