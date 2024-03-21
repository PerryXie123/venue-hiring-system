package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Venue {
  private String name;
  private String code;
  private String cap;
  private String fee;
  ArrayList<Venue> venueList = new ArrayList<Venue>();

  public Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput){
    name = venueName;
    code = venueCode;
    cap = capacityInput;
    fee = hireFeeInput;
  }

  public void addVenue(Venue venue){
    venueList.add(venue);
  }
  public void addVenueSuccess(Venue venue){
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(name, code);
  }

  public void addVenueFail(Venue venue){

  }
  public boolean venueValid(Venue venue){
    return venue.checkName(name);
  }

  public boolean checkName(String name){
    String cleanName = name.replaceAll("\\s+","");
    int nameLength = cleanName.length();
    if (nameLength == 0){
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return false;
    }
    else{
      return true;
    }
  }
}
