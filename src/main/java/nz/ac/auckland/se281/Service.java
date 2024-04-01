package nz.ac.auckland.se281;

public abstract class Service {

  protected int cost;
  protected String bookingReference;  
  protected String type;

  public Service(int cost, String bookingReference, String type){
    this.cost = cost;
    this.bookingReference = bookingReference;
    this.type = type;
  }

  abstract public int getCost();

  abstract public String getReference();

  abstract public String getType();
}
