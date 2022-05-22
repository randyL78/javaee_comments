package com.randylayne.eventhandler;

public interface EventBusService {
  public boolean send(Event event);

  void asyncSend(Event event);
}
