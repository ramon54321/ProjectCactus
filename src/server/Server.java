package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  private ServerSocket serverSocket;

  Server() {}

  public void start() {
    try {
      this.serverSocket = new ServerSocket(4444);

      Socket clientSocket = serverSocket.accept();
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream())
      );

      out.println("Hello new client, how are you?");

      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        System.out.println("Client Says: " + inputLine);
      }
    } catch (Exception e) {
      System.out.println("Exception handled in Server");
      System.out.println(e);
    }
  }

  public void shutdown() {
    try {
      this.serverSocket.close();
    } catch (Exception e) {
      System.out.println("Exception on shutdown");
      System.out.println(e);
    }
  }
}
