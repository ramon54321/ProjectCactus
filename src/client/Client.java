package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

  public void start() {
    try {
      Socket socket = new Socket("localhost", 4444);
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
        new InputStreamReader(socket.getInputStream())
      );

      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        System.out.println("Server Says: " + inputLine);
      }
      socket.close();
    } catch (Exception e) {
      System.out.println("Exception handled in Client");
      System.out.println(e);
    }
  }
}
