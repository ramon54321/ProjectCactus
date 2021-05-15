package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {

  private Socket socket;

  Client(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    try {
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
        new InputStreamReader(socket.getInputStream())
      );

      out.println("Hello new client, how are you?");

      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        System.out.println("Client Says: " + inputLine);
      }
    } catch (Exception e) {
      System.out.println("Exception handled in Client");
      System.out.println(e);
    }
  }
}
