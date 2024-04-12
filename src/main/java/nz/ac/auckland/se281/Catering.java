package nz.ac.auckland.se281;

public class Catering extends Service {

  public Catering(int cost, String bookingReference, String type) {
    super(cost, bookingReference, type);
  }

  public int getCost() {
    return cost;
  }

  public String getReference() {
    return bookingReference;
  }

  public String getType() {
    return type;
  }
}
