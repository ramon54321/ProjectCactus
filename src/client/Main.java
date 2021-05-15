package client;

import shared.Threading;

public class Main {

  public static void main(String[] args) {
    Client client = new Client();
    client.start();
    Threading.registerShutdownHook();
  }
}
