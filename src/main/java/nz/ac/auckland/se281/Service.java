package nz.ac.auckland.se281;

public abstract class Service {

  protected int cost;
  protected String bookingReference;  

  public Service(int cost, String bookingReference){
    this.cost = cost;
    this.bookingReference = bookingReference;
  }
}
