
public abstract class Event {
  private long date;

  Event(long date) {
    this.date = date;
  }

  public long getDate() {
    return date;
  }

  public abstract void execute();
}
