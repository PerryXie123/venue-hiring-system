package nz.ac.auckland.se281;

//import java.util.ArrayList;

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

  public String getName(){
    return name;
  }

  public String getCode(){
    return code;
  }

  public String getCap(){
    return cap;
  }

  public String getFee(){
    return fee;
  }

}
