package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  //private ArrayList<Venue> venueList;
  private ArrayList<Venue> venueList = new ArrayList<Venue>();
  private Date currentDate;

  public VenueHireSystem() {
    //ArrayList<Venue> venueList = new ArrayList<Venue>();
  }

  //prints venue with different messages depending on the number of venues in the system currently
  public void printVenues() {
    if (venueList.size() == 0) {
      //Prints no venue message if the size of the venue arraylist is zero
      MessageCli.NO_VENUES.printMessage();
      //If there is only one venue, use the keywords "is" and "one"
    } else if (venueList.size() == 1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
          venue.getName(),
          venue.getCode(),
          venue.getCap(),
          venue.getFee()
        );
      }
      //For sizes 2-9, use the keywords "are" and "number of venues"
    } else if (venueList.size() == 2) {
      MessageCli.NUMBER_VENUES.printMessage("are", "two", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
          venue.getName(),
          venue.getCode(),
          venue.getCap(),
          venue.getFee()
        );
      }
      //Message for 3 venues
    } else if (venueList.size() == 3) {
      MessageCli.NUMBER_VENUES.printMessage("are", "three", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
          venue.getName(),
          venue.getCode(),
          venue.getCap(),
          venue.getFee()
        );
      }
      //Message for 4 venues
    } else if (venueList.size() == 4) {
      MessageCli.NUMBER_VENUES.printMessage("are", "four", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
          venue.getName(),
          venue.getCode(),
          venue.getCap(),
          venue.getFee()
        );
      }
      //Message for 5 venues
    } else if (venueList.size() == 5) {
      MessageCli.NUMBER_VENUES.printMessage("are", "five", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
          venue.getName(),
          venue.getCode(),
          venue.getCap(),
          venue.getFee()
        );
      }
      //Message for 6 venues
    } else if (venueList.size() == 6) {
      MessageCli.NUMBER_VENUES.printMessage("are", "six", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
          venue.getName(),
          venue.getCode(),
          venue.getCap(),
          venue.getFee()
        );
      }
      //Message for 7 venues
    } else if (venueList.size() == 7) {
      MessageCli.NUMBER_VENUES.printMessage("are", "seven", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
          venue.getName(),
          venue.getCode(),
          venue.getCap(),
          venue.getFee()
        );
      }
      //Message for 8 venues
    } else if (venueList.size() == 8) {
      MessageCli.NUMBER_VENUES.printMessage("are", "eight", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
          venue.getName(),
          venue.getCode(),
          venue.getCap(),
          venue.getFee()
        );
      }
      //Message for 9 venues
    } else if (venueList.size() == 9) {
      MessageCli.NUMBER_VENUES.printMessage("are", "nine", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
          venue.getName(),
          venue.getCode(),
          venue.getCap(),
          venue.getFee()
        );
      }
      //For venue sizes greater than 10, use digits instead of english words
    } else if (venueList.size() >= 10) {
      MessageCli.NUMBER_VENUES.printMessage(
        "are",
        Integer.toString(venueList.size()),
        "s"
      );
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
          venue.getName(),
          venue.getCode(),
          venue.getCap(),
          venue.getFee()
        );
      }
    }
  }

  //Creates venue with a name, code, capacity, and hire fee. Checks if the venue is valid, and puts it in an Arraylist
  public void createVenue(
    //Sets the name, code, capacity and hire fee as strings
    String venueName,
    String venueCode,
    String capacityInput,
    String hireFeeInput
  ) {
    Venue venue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    //Checks if the venue is valid 
    if (checkVenueValid(venue) == true) {
      addVenue(venue);
      addVenueSuccess(venue);
    } else {
    //Doesn't create the venue if it fails the checks
      addVenueFail(venue);
    }
  }

  public void setSystemDate(String dateInput) {
    String[] dateParts = dateInput.split("/");
    Date date = new Date(dateParts[0], dateParts[1], dateParts[2]);
    currentDate = date;
    MessageCli.DATE_SET.printMessage(dateInput);
  }

  public void printSystemDate() {
    if (currentDate == null){
      MessageCli.CURRENT_DATE.printMessage("not set");
    }
    else {
      MessageCli.CURRENT_DATE.printMessage(currentDate.getDate());
    }
    
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(
    String bookingReference,
    CateringType cateringType
  ) {
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
  public void addVenue(Venue venue) {
    venueList.add(venue);
  }

  //Venue success message
  public void addVenueSuccess(Venue venue) {
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(
      venue.getName(),
      venue.getCode()
    );
  }

  public void addVenueFail(Venue venue) {}

  //Checks if venue is valid by checking the name, code, capacity and hire fee inputs
  public boolean checkVenueValid(Venue venue) {
    if (checkName(venue.getName()) == false) {
      //returns false if the name is empty
      return false;
    } else if (checkCode(venue.getCode()) == false) {
      //returns false if the code is already used
      return false;
    } else if (checkCap(venue.getCap()) == false) {
      //returns false if capacity is not a positive number
      return false;
    } else if (checkHireFee(venue.getFee()) == false) {
      //returns false if hire fee is not a positive number
      return false;
    } else {
      return true;
    }
  }

  //Checks if name is valid by removing all whitespaces, and then checking the length of the trimmed string
  public boolean checkName(String nameString) {
    //Replaces all whitespaces with a blank
    String cleanName = nameString.replaceAll("\\s+", "");
    int nameLength = cleanName.length();
    if (nameLength == 0) {
      //Returns invalid if the name is empty
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return false;
    } else {
      //Returns true if name is valid
      return true;
    }
  }

  //Checks if code is valid
  public boolean checkCode(String codeString) {
    for (Venue venue : venueList) {
      if (codeString.equals(venue.getCode()) == true) {
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(
          codeString,
          venue.getName()
        );
        return false;
      }
    }
    return true;
  }

  //Checks if capacity is valid be trying to change from a string to an integer. Catches an exception if an error is returned
  public boolean checkCap(String capString) {
    try {
      //Tries to get the integer value of a string
      int num = Integer.valueOf(capString);
      if (num <= 0) {
        //If the integer value is valid, checks if it is positive
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage(
          "capacity",
          " positive"
        );
        return false;
      } else {
        return true;
      }
    } catch (Exception exception) {
      //Catches an expcetion if the an integer value cannot be gotten from the string
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return false;
    }
  }

  //Checks if the hire fee is valid using the same logic as checking the capacity
  public boolean checkHireFee(String feeString) {
    try {
      int num = Integer.valueOf(feeString);
      if (num <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage(
          "hire fee",
          " positive"
        );
        return false;
      } else {
        return true;
      }
    } catch (Exception exception) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return false;
    }
  }

  public int theDay(Date date){
    return date.getDay();
  }
}
