package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  //private ArrayList<Venue> venueList;
  ArrayList<Venue> venueList = new ArrayList<Venue>();

  public VenueHireSystem() {
    //ArrayList<Venue> venueList = new ArrayList<Venue>();
  }

  public void printVenues() {
    if(venueList.size() == 0){
        MessageCli.NO_VENUES.printMessage();
    }
    else if(venueList.size() == 1){
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(venue.getName(), venue.getCode(), venue.getCap(), venue.getFee());
      }
    }
    else if(venueList.size() == 2){
        MessageCli.NUMBER_VENUES.printMessage("are", "two", "s");
        for (Venue venue : venueList) {
          MessageCli.VENUE_ENTRY.printMessage(venue.getName(), venue.getCode(), venue.getCap(), venue.getFee());
      }
    }
    else if(venueList.size() == 3){
      MessageCli.NUMBER_VENUES.printMessage("are", "three", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(venue.getName(), venue.getCode(), venue.getCap(), venue.getFee());
      }
    }
      else if(venueList.size() == 4){
        MessageCli.NUMBER_VENUES.printMessage("are", "four", "s");
        for (Venue venue : venueList) {
          MessageCli.VENUE_ENTRY.printMessage(venue.getName(), venue.getCode(), venue.getCap(), venue.getFee());
      }
    }
      else if(venueList.size() == 5){
        MessageCli.NUMBER_VENUES.printMessage("are", "five", "s");
        for (Venue venue : venueList) {
          MessageCli.VENUE_ENTRY.printMessage(venue.getName(), venue.getCode(), venue.getCap(), venue.getFee());
      }
    }
      else if(venueList.size() == 6){
        MessageCli.NUMBER_VENUES.printMessage("are", "six", "s");
        for (Venue venue : venueList) {
          MessageCli.VENUE_ENTRY.printMessage(venue.getName(), venue.getCode(), venue.getCap(), venue.getFee());
      }
    }
      else if(venueList.size() == 7){
        MessageCli.NUMBER_VENUES.printMessage("are", "seven", "s");
        for (Venue venue : venueList) {
          MessageCli.VENUE_ENTRY.printMessage(venue.getName(), venue.getCode(), venue.getCap(), venue.getFee());
      }
    }
      else if(venueList.size() == 8){
        MessageCli.NUMBER_VENUES.printMessage("are", "eight", "s");
        for (Venue venue : venueList) {
          MessageCli.VENUE_ENTRY.printMessage(venue.getName(), venue.getCode(), venue.getCap(), venue.getFee());
      }
    }
      else if(venueList.size() == 9){
        MessageCli.NUMBER_VENUES.printMessage("are", "nine", "s");
        for (Venue venue : venueList) {
          MessageCli.VENUE_ENTRY.printMessage(venue.getName(), venue.getCode(), venue.getCap(), venue.getFee());
      }
    }
  }



  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
        Venue venue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
        if (venueValid(venue) == true){
          addVenue(venue);
          addVenueSuccess(venue);}
        else{
          addVenueFail(venue);
        }
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }

  //Adds Venue to Arraylist
  public void addVenue(Venue venue){
    venueList.add(venue);
  }

  //Venue success message
  public void addVenueSuccess(Venue venue){
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venue.getName(), venue.getCode());
  }

  public void addVenueFail(Venue venue){

  }

  //Checks if venue is valid
  public boolean venueValid(Venue venue){
    if (checkName(venue.getName()) == false){
      return false;
    }
    else if (checkCode(venue.getCode()) == false){
      return false;
    }
    else{
      return true;
    }
  }

  //Checks if name is valid
  public boolean checkName(String nameString){
    String cleanName = nameString.replaceAll("\\s+","");
    int nameLength = cleanName.length();
    if (nameLength == 0){
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return false;
    }
    else{
      return true;
    }
  }

  //Checks if code is valid
  public boolean checkCode(String codeString){

    for (Venue venue : venueList) {
      if (codeString.equals(venue.getCode()) == true){
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(codeString, venue.getName());
        return false;
      }
    }
    return true;
  }


}
