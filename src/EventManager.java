import java.util.LinkedList;

public class EventManager {
  private long currentDate;
  private LinkedList<Event> listeEvent;

  EventManager() {
    currentDate = 0;
    listeEvent = new LinkedList<Event>();
  }

  public void addEvent(Event e) {
    listeEvent.add(e);
  }

  public void next() {
    currentDate++;
    for (Event event : listeEvent) {
      if (event.getDate() == currentDate) {
        event.execute();
      }
    }
  }

  public boolean isFinished() {
    for (Event event : listeEvent) {
      if (event.getDate() >= currentDate) {
        return false;
      }
    }
    return true;
  }

  public void restart() {
    currentDate = 0;
  }

}
