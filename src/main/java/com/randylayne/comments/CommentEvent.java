package com.randylayne.comments;

import com.randylayne.comments.CommentEntity;
import com.randylayne.eventhandler.Event;

public class CommentEvent extends Event {
  public CommentEvent(CommentEntity comment) {
    super("comment", comment.getUuid());
    this.addContentItem("content", comment.getContent());
  }
}
