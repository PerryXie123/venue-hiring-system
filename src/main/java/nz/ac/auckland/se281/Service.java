package nz.ac.auckland.se281;

public abstract class Service {

  protected int cost;
  protected String bookingReference;
  protected String type;

  public Service(int cost, String bookingReference, String type) {
    this.cost = cost;
    this.bookingReference = bookingReference;
    this.type = type;
  }

  public abstract int getCost();

  public abstract String getReference();

  public abstract String getType();
}
