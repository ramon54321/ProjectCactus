package shared;

public class Threading {

  public static void registerShutdownHook() {
    Runtime
      .getRuntime()
      .addShutdownHook(
        new Thread() {
          public void run() {
            Thread
              .getAllStackTraces()
              .keySet()
              .forEach(
                thread -> {
                  thread.interrupt();
                }
              );
          }
        }
      );
  }
}
