package com.randylayne.comments;

import java.util.UUID;

public class CommentEntity {
  public enum Status {
    PENDING, APPROVED, REJECTED
  }
  private UUID uuid;
  private String content;
  private UUID postUUID;
  private Status status;

  public CommentEntity() {
    this.status = Status.PENDING;
  }

  public CommentEntity(UUID uuid, String content, UUID postUUID, Status status) {
    this.uuid = uuid;
    this.content = content;
    this.postUUID = postUUID;
    this.status = status;
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

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
