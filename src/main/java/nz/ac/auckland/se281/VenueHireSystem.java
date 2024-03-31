package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;


public class VenueHireSystem {

  //private ArrayList<Venue> venueList;
  private ArrayList<Venue> venueList = new ArrayList<Venue>();
  private ArrayList<Booking> bookingList = new ArrayList<Booking>();
  private Date currentDate;

  public VenueHireSystem() {
  }

  //prints venue with different messages depending on the number of venues in the system currently
  public void printVenues() {
    Date tempDate = new Date("00", "00", "00");
    for (Venue venue :venueList) {
      for (Booking booking : bookingList) {
        if(venue.getCode().equals(booking.getBookingCode())){
          while(venue.getNextAvailable().getDate().equals(booking.getRequestedDate())){
            tempDate = venue.getNextAvailable().incrementDate();
            venue.setNextAvailable(tempDate);
          }
        }
      }
    }
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
          venue.getFee(),
          venue.getNextAvailable().getDate()
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
          venue.getFee(),
          venue.getNextAvailable().getDate()
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
          venue.getFee(),
          venue.getNextAvailable().getDate()
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
          venue.getFee(),
          venue.getNextAvailable().getDate()
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
          venue.getFee(),
          venue.getNextAvailable().getDate()
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
          venue.getFee(),
          venue.getNextAvailable().getDate()
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
          venue.getFee(),
          venue.getNextAvailable().getDate()
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
          venue.getFee(),
          venue.getNextAvailable().getDate()
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
          venue.getFee(),
          venue.getNextAvailable().getDate()
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
          venue.getFee(),
          venue.getNextAvailable().getDate()
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
    Date nextAvailable;
    if (currentDate == null){
      nextAvailable = new Date("00", "00", "00");
    }
    else{
      nextAvailable = currentDate;
    }
    Venue venue = new Venue(venueName, venueCode, capacityInput, hireFeeInput, nextAvailable);
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
    for (Venue venue : venueList) {
      venue.setNextAvailable(date);
      
    }
    date.setTheDate();
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
    String[] bookingDateParts = options[1].split("/");
    int codeCompare = 0;
    int venueCompare = 0;
    boolean bookingValid = true;
    int VenueCapacity = 0;
    String VenueName = "null";
    String alreadyBookedVenue = "null";
    String bookedDate = "null";
    for (Booking booking : bookingList) {
      if(options[0].equals(booking.getBookingCode()) && options[1].equals(booking.getRequestedDate()))
      venueCompare++;
      alreadyBookedVenue = booking.getVenueName();
      bookedDate = booking.getRequestedDate();
    }

    for (Venue venue : venueList) {
      if(options[0].equals(venue.getCode())){
        codeCompare++;
        VenueCapacity = Integer.parseInt(venue.getCap());
        VenueName = venue.getName();
      }
    }
    if (currentDate == null){
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      bookingValid = false;
    }
    else if (venueList.size() == 0){
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      bookingValid = false;
    }
    else if (codeCompare == 0){
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
      bookingValid = false;
    }
    else if (dateAfterCheck(bookingDateParts) == false){
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], (theDay(currentDate)));
      bookingValid = false;
    }
    else if (venueCompare != 0){
      MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(alreadyBookedVenue, bookedDate);
      bookingValid = false;
    }

    if (bookingValid == true){
      if (Integer.parseInt(options[3]) > VenueCapacity){
        int newAttendees = VenueCapacity;
        String oldAttendees = options[3];
        options[3] = Integer.toString(newAttendees);
        MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(oldAttendees, Integer.toString(newAttendees), Integer.toString(VenueCapacity));
      }
      else if (Integer.parseInt(options[3]) < VenueCapacity/4){
        int newAttendees = VenueCapacity/4;
        String oldAttendees = options[3];
        options[3] = Integer.toString(newAttendees);
        MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(oldAttendees, Integer.toString(newAttendees), Integer.toString(VenueCapacity));
      }
      
      String bookingReference = BookingReferenceGenerator.generateBookingReference();
      Booking booking = new Booking(options[0], options[1], options[2], options[3], bookingReference, VenueName);
      bookingList.add(booking);
      MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(bookingReference, VenueName, options[1], options[3]);
    }    
  }
  

  public void printBookings(String venueCode) {
    int venueCount = 0;
    String venueName = "";

    for (Venue venue : venueList) {
      if (venueCode.equals(venue.getCode())){
        venueCount++;
        venueName = venue.getName();
      }
    }
    if(venueCount == 0){
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
    }
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

  public String theDay(Date date){
    return date.getDate();
  }

  public boolean dateAfterCheck(String[] bookingDate){
    if(Integer.parseInt(bookingDate[2]) >= currentDate.getYear()){
      return true;
    }
    else if(Integer.parseInt(bookingDate[1]) >= currentDate.getMonth()){
      return true;
    }
    else if(Integer.parseInt(bookingDate[0]) >= currentDate.getDay()){
      return true;
    }
    else{
      return false;
    }
  }
}
