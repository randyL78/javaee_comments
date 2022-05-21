package com.randylayne.comments;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class CommentRepository {
  private static Set<CommentEntity> comments = new HashSet<>();

  public CommentRepository() {
  }

  public static List<CommentEntity> getCommentsForPost(UUID postUUID) {
    return comments
        .stream()
        .filter(comment -> comment.getPostUUID().equals(postUUID))
        .collect(Collectors.toList());
  }

  public static void createComment(CommentEntity comment) {
    comments.add(comment);
  }

  public static Set<CommentEntity> getComments() {
    return comments;
  }

  public static void setComments(Set<CommentEntity> comments) {
    CommentRepository.comments = comments;
  }
}
