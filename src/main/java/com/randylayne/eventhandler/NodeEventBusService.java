package com.randylayne.eventhandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NodeEventBusService implements EventBusService {
  private String URL = "http://localhost:4005/events";

  @Override
  public boolean send(Event event) {
    {
      try {
        URL url = new URL(URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setDoOutput(true);
        OutputStream outputStream = con.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(event.toString());
        writer.flush();
        writer.close();
        outputStream.close();
        con.connect();

        if (con.getResponseCode() > 299) {
          throw new IOException("Event failed to send with status " + con.getResponseCode());
        }
      } catch (MalformedURLException e) {
        throw new RuntimeException(e);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return false;
  }

  @Override
  public void asyncSend(Event event) {
    Thread thread = new Thread(() -> send(event));
    thread.start();
  }
}
