package com.randylayne.comments;

import java.util.UUID;

public class CommentEntity {
  private UUID uuid;
  private String content;
  private UUID postUUID;

  public CommentEntity() {
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public UUID getPostUUID() {
    return postUUID;
  }

  public void setPostUUID(UUID postUUID) {
    this.postUUID = postUUID;
  }
}
