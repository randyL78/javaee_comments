package com.randylayne.comments;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.randylayne.eventhandler.Event;
import com.randylayne.eventhandler.EventBusService;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NodeEventBusService implements EventBusService {
  private String URL = "http://localhost:4005/events";



  @Override
  public boolean sendEvent(Event event) {
    {
      ObjectMapper mapper = new ObjectMapper();

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
        writer.write(mapper.writeValueAsString(event));
        writer.flush();
        writer.close();
        outputStream.close();
        con.connect();

        if(con.getResponseCode() > 299) {
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
}