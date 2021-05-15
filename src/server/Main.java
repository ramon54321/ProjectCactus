package server;

import shared.Threading;

public class Main {

  public static void main(String[] args) {
    Server server = new Server();
    server.start();
    Threading.registerShutdownHook();
  }
}
