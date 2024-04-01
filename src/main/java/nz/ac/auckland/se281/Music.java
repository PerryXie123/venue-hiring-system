package nz.ac.auckland.se281;

public class Music extends Service{


  public Music(int cost, String bookingReference, String type){
    super(cost, bookingReference, type);
  }
  
  public int getCost(){
    return cost;
  }

  public String getReference(){
    return bookingReference;
  }

  public String getType(){
    return type;
  }
}
