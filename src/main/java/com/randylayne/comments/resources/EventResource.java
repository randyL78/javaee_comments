package com.randylayne.comments.resources;

import com.randylayne.eventhandler.Event;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("events")
public class EventResource {
  @POST
  public Response receiveEvent(Event event) {
    return Response.ok().build();
  }
}
