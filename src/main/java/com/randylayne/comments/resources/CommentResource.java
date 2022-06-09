package com.randylayne.comments.resources;

import com.randylayne.comments.CommentEntity;
import com.randylayne.comments.CommentEvent;
import com.randylayne.comments.CommentRepository;
import com.randylayne.eventhandler.EventBusService;
import java.net.URI;
import java.util.UUID;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("posts/{postId}/comments")
public class CommentResource {

  @Inject
  private EventBusService bus;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCommentsForPost(@PathParam("postId") UUID postUUID) {
    return Response.ok(CommentRepository.getCommentsForPost(postUUID)).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createCommentForPost(@Context UriInfo uriInfo, @PathParam("postId") UUID postUUID,
      CommentEntity comment) {
    comment.setUuid(UUID.randomUUID());
    comment.setPostUUID(postUUID);
    CommentRepository.createComment(comment);
    bus.asyncSend(CommentEvent.buildCommentCreated(comment));
    return Response.created(URI.create(uriInfo.getPath() + comment.getUuid())).entity(comment)
        .build();
  }
}