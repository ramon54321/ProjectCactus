package shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class Events {

  private HashMap<String, List<Consumer<Object>>> listeners = new HashMap<>();

  public void on(String event, Consumer<Object> listener) {
    if (this.listeners.get(event) == null) this.listeners.put(
        event,
        new ArrayList<>()
      );
    this.listeners.get(event).add(listener);
  }

  public void emit(String event, Object o) {
    this.listeners.get(event).forEach(listener -> listener.accept(o));
  }
}
