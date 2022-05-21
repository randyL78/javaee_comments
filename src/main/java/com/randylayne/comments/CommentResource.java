package com.randylayne.comments;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.UUID;

@Path("{postId}/comments")
public class CommentResource {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCommentsForPost(@PathParam("postId")UUID postUUID) {
    return Response.ok(CommentRepository.getCommentsForPost(postUUID)).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createCommentForPost(@Context UriInfo uriInfo, @PathParam("postId")UUID postUUID, CommentEntity comment) {
    comment.setUuid(UUID.randomUUID());
    comment.setPostUUID(postUUID);
    CommentRepository.createComment(comment);
    return Response.created(URI.create(uriInfo.getPath() + comment.getUuid())).entity(comment).build();
  }
}