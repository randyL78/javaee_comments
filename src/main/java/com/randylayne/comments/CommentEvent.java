package com.randylayne.comments;

import com.randylayne.eventhandler.Event;

public class CommentEvent extends Event {
  public enum TYPES {
      CREATED {
        @Override
        public String toString() {
          return  "CommentCreated";
        };
      }
  }
  public CommentEvent(TYPES type, CommentEntity comment) {
    super(TYPES.CREATED.toString(), comment);
  }

  public static CommentEvent buildCommentCreated(CommentEntity comment) {
    return new CommentEvent(TYPES.CREATED, comment);
  }
}
