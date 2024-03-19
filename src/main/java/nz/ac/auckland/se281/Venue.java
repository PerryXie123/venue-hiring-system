package nz.ac.auckland.se281;

public class Venue {
  private String name;
  private String code;
  private String cap;
  private String fee;

  public Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput){
    name = venueName;
    code = venueCode;
    cap = capacityInput;
    fee = hireFeeInput;
  }
}
