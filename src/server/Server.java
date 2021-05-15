package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

  private Thread listenerThread;
  private ServerSocket serverSocket;

  private List<Client> clients = new ArrayList<>();

  Server() {}

  public void start() {
    Server self = this;
    this.listenerThread = new Thread() {
      public void run() {
        try {
          self.serverSocket = new ServerSocket(4444);
          while (true) {
            self.waitForClient();
          }
        } catch (Exception e) {
          System.out.println("Exception handled in Server");
          System.out.println(e);
        }
      }
    };
    this.listenerThread.start();
  }

  private void waitForClient() throws IOException {
    Socket socket = serverSocket.accept();
    Client client = new Client(socket);
    client.start();
    this.clients.add(client);
  }

  public void shutdown() {
    try {
      this.listenerThread.interrupt();
      this.clients.forEach(client -> client.interrupt());
      this.serverSocket.close();
    } catch (Exception e) {
      System.out.println("Exception on shutdown");
      System.out.println(e);
    }
  }
}
