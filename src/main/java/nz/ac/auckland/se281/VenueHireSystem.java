package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // private ArrayList<Venue> venueList;
  private ArrayList<Venue> venueList = new ArrayList<Venue>();
  private ArrayList<Booking> bookingList = new ArrayList<Booking>();
  private ArrayList<Service> serviceList = new ArrayList<Service>();
  private Date currentDate;

  public VenueHireSystem() {}

  // prints venue with different messages depending on the number of venues in the system currently
  public void printVenues() {
    Date tempDate = new Date("00", "00", "00");
    // Loops through the list of venues before printing venues to update next available
    for (int i = 0; i < 10; i++) {
      for (Venue venue : venueList) {
        for (Booking booking : bookingList) {
          if (venue.getCode().equals(booking.getBookingCode())) {
            if (venue.getNextAvailable().getDate().equals(booking.getRequestedDate())) {
              // If the booking date and next available date equals, increments and sets new date
              tempDate = venue.getNextAvailable().incrementDate();
              venue.setNextAvailable(tempDate);
            }
          }
        }
      }
    }

    if (venueList.size() == 0) {
      // Prints no venue message if the size of the venue arraylist is zero
      MessageCli.NO_VENUES.printMessage();
      // If there is only one venue, use the keywords "is" and "one"
    } else if (venueList.size() == 1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getName(),
            venue.getCode(),
            venue.getCap(),
            venue.getFee(),
            venue.getNextAvailable().getDate());
      }
      // For sizes 2-9, use the keywords "are" and "number of venues"
    } else if (venueList.size() == 2) {
      MessageCli.NUMBER_VENUES.printMessage("are", "two", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getName(),
            venue.getCode(),
            venue.getCap(),
            venue.getFee(),
            venue.getNextAvailable().getDate());
      }
      // Message for 3 venues
    } else if (venueList.size() == 3) {
      MessageCli.NUMBER_VENUES.printMessage("are", "three", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getName(),
            venue.getCode(),
            venue.getCap(),
            venue.getFee(),
            venue.getNextAvailable().getDate());
      }
      // Message for 4 venues
    } else if (venueList.size() == 4) {
      MessageCli.NUMBER_VENUES.printMessage("are", "four", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getName(),
            venue.getCode(),
            venue.getCap(),
            venue.getFee(),
            venue.getNextAvailable().getDate());
      }
      // Message for 5 venues
    } else if (venueList.size() == 5) {
      MessageCli.NUMBER_VENUES.printMessage("are", "five", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getName(),
            venue.getCode(),
            venue.getCap(),
            venue.getFee(),
            venue.getNextAvailable().getDate());
      }
      // Message for 6 venues
    } else if (venueList.size() == 6) {
      MessageCli.NUMBER_VENUES.printMessage("are", "six", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getName(),
            venue.getCode(),
            venue.getCap(),
            venue.getFee(),
            venue.getNextAvailable().getDate());
      }
      // Message for 7 venues
    } else if (venueList.size() == 7) {
      MessageCli.NUMBER_VENUES.printMessage("are", "seven", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getName(),
            venue.getCode(),
            venue.getCap(),
            venue.getFee(),
            venue.getNextAvailable().getDate());
      }
      // Message for 8 venues
    } else if (venueList.size() == 8) {
      MessageCli.NUMBER_VENUES.printMessage("are", "eight", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getName(),
            venue.getCode(),
            venue.getCap(),
            venue.getFee(),
            venue.getNextAvailable().getDate());
      }
      // Message for 9 venues
    } else if (venueList.size() == 9) {
      MessageCli.NUMBER_VENUES.printMessage("are", "nine", "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getName(),
            venue.getCode(),
            venue.getCap(),
            venue.getFee(),
            venue.getNextAvailable().getDate());
      }
      // For venue sizes greater than 10, use digits instead of english words
    } else if (venueList.size() >= 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(venueList.size()), "s");
      for (Venue venue : venueList) {
        MessageCli.VENUE_ENTRY.printMessage(
            venue.getName(),
            venue.getCode(),
            venue.getCap(),
            venue.getFee(),
            venue.getNextAvailable().getDate());
      }
    }
  }

  // Creates venue with a name, code, capacity, and hire fee. Checks if the venue is valid, and puts
  // it in an Arraylist
  public void createVenue(
      // Sets the name, code, capacity and hire fee as strings
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // Checks if there is a next available date set
    Date nextAvailable;
    if (currentDate == null) {
      nextAvailable = new Date("00", "00", "00");
    } else {
      nextAvailable = currentDate;
    }
    Venue venue = new Venue(venueName, venueCode, capacityInput, hireFeeInput, nextAvailable);
    // Checks if the venue is valid
    if (checkVenueValid(venue) == true) {
      addVenue(venue);
      addVenueSuccess(venue);
    } else {
      // Doesn't create the venue if it fails the checks
      addVenueFail(venue);
    }
  }

  // Sets the system date
  public void setSystemDate(String dateInput) {
    // Splits the date input into day, month, and year
    String[] dateParts = dateInput.split("/");
    // Creates a new date instance using these new parts
    Date date = new Date(dateParts[0], dateParts[1], dateParts[2]);
    currentDate = date;
    // Prints the set date message
    MessageCli.DATE_SET.printMessage(dateInput);
    // Updates all venues to have the current date as their next available
    for (Venue venue : venueList) {
      venue.setNextAvailable(date);
    }
    date.setTheDate();
  }

  // Prints the system date
  public void printSystemDate() {
    // Checks if date is set, if yes, then prints it
    if (currentDate == null) {
      MessageCli.CURRENT_DATE.printMessage("not set");
    } else {
      MessageCli.CURRENT_DATE.printMessage(currentDate.getDate());
    }
  }

  // Makes a booking
  public void makeBooking(String[] options) {
    // Splits the input date into day, month, and year
    // Initialises all needed variable used in a booking
    String[] bookingDateParts = options[1].split("/");
    int codeCompare = 0;
    int venueCompare = 0;
    boolean bookingValid = true;
    int venueCapacity = 0;
    String venueName = "null";
    String alreadyBookedVenue = "null";
    String bookedDate = "null";
    // Creates a new date instance using the input date
    Date bookingdate = new Date(bookingDateParts[0], bookingDateParts[1], bookingDateParts[2]);
    // Checks if the venue is created, increments a counter
    for (Booking booking : bookingList) {
      if (options[0].equals(booking.getBookingCode())
          && options[1].equals(booking.getRequestedDate())) {
        venueCompare++;
        alreadyBookedVenue = booking.getVenueName();
        bookedDate = booking.getRequestedDate();
      }
    }
    // Checks if the venue code is valid
    for (Venue venue : venueList) {
      if (options[0].equals(venue.getCode())) {
        codeCompare++;
        venueCapacity = Integer.parseInt(venue.getCap());
        venueName = venue.getName();
      }
    }

    // Error message if there is no current date set
    if (currentDate == null) {
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      bookingValid = false;
      // Error is there are no venues created
    } else if (venueList.size() == 0) {
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      bookingValid = false;
      // Error if the booking code doesn't exist
    } else if (codeCompare == 0) {
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
      bookingValid = false;
      // Error if the boooking date is before the current date
    } else if (bookingdate.isAfter(currentDate) == false
        && bookingdate.isSameAs(currentDate) == false) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], (theDay(currentDate)));
      bookingValid = false;
      // Error if venue is already booked on the same date
    } else if (venueCompare != 0) {
      MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(alreadyBookedVenue, bookedDate);
      bookingValid = false;
    }
    // If all prior cases are false, then booking validity is true
    if (bookingValid == true) {
      // Sets the lower and upper limits for number of attendees
      // If the attendees is greater than the capacity
      if (Integer.parseInt(options[3]) > venueCapacity) {
        int newAttendees = venueCapacity;
        String oldAttendees = options[3];
        options[3] = Integer.toString(newAttendees);
        MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
            oldAttendees, Integer.toString(newAttendees), Integer.toString(venueCapacity));
        // If the attendees is lower than a quarter of the capacity
      } else if (Integer.parseInt(options[3]) < venueCapacity / 4) {
        int newAttendees = venueCapacity / 4;
        String oldAttendees = options[3];
        options[3] = Integer.toString(newAttendees);
        MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
            oldAttendees, Integer.toString(newAttendees), Integer.toString(venueCapacity));
      }

      // Creates a new instance of a booking with all the given inputs
      String bookingReference = BookingReferenceGenerator.generateBookingReference();
      Booking booking =
          new Booking(
              options[0],
              options[1],
              options[2],
              options[3],
              bookingReference,
              venueName,
              currentDate.getDate());
      // Adds the booking to the list of bookings
      bookingList.add(booking);
      MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
          bookingReference, venueName, options[1], options[3]);
    }
  }

  // Prints all the bookings
  public void printBookings(String venueCode) {
    // Initialises the needed variables
    int venueCount = 0;
    String venueName = "";
    int bookingsCount = 0;
    // Loops through all the venues with the same code
    for (Venue venue : venueList) {
      if (venueCode.equals(venue.getCode())) {
        venueCount++;
        venueName = venue.getName();
      }
    }
    for (Booking booking : bookingList) {
      if (venueCode.equals(booking.getBookingCode())) {
        bookingsCount++;
      }
    }
    // Error if there are no venues, no bookings, eg
    if (venueCount == 0) {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
    } else if (bookingsCount == 0 && venueCount > 0) {
      MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venueName);
      MessageCli.PRINT_BOOKINGS_NONE.printMessage(venueName);
      // If everything is valid, prints the booking
    } else if (bookingsCount > 0 && venueCount > 0) {
      MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venueName);
      for (Booking booking : bookingList) {
        if (venueCode.equals(booking.getBookingCode())) {
          MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(
              booking.getReference(), booking.getRequestedDate());
        }
      }
    }
  }

  // Adds catering service
  public void addCateringService(
      // Initialises variables for the method
      String bookingReference, CateringType cateringType) {
    // Checks if the booking reference exists
    int referenceCheck = 0;
    for (Booking booking : bookingList) {
      if (booking.getReference().equals(bookingReference)) {
        referenceCheck++;
      }
    }
    // If the booking reference doesn't exist, gives an error
    if (referenceCheck == 0) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
      // If the booking reference does exist, adds the needed catering
    } else if (referenceCheck > 0) {
      Catering catering =
          new Catering(cateringType.getCostPerPerson(), bookingReference, cateringType.getName());
      // adds catering to the list
      serviceList.add(catering);
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(
          "Catering (" + cateringType.getName() + ")", bookingReference);
    }
  }

  // Adds the music service
  public void addServiceMusic(String bookingReference) {
    // Initialises the reference checker
    int referenceCheck = 0;
    for (Booking booking : bookingList) {
      if (booking.getReference().equals(bookingReference)) {
        referenceCheck++;
      }
    }

    // If the reference doesn't exists, gives an error message
    if (referenceCheck == 0) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
      // If the reference exists, adds the music service
    } else if (referenceCheck > 0) {
      // Adds the service to the service list
      Music music = new Music(500, bookingReference, "null");
      serviceList.add(music);
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Music", bookingReference);
    }
  }

  // Adds the floral service
  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // Initialises the reference checker
    int referenceCheck = 0;
    for (Booking booking : bookingList) {
      if (booking.getReference().equals(bookingReference)) {
        referenceCheck++;
      }
    }
    // Error if the reference doesn't exist
    if (referenceCheck == 0) {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Floral", bookingReference);
      // If the reference exists, adds the floral depending on the user input
    } else if (referenceCheck > 0) {
      FloralService floral = new FloralService(floralType.getCost(), bookingReference, floralType.getName());
      // Adds the service instance to a list
      serviceList.add(floral);
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(
          "Floral (" + floralType.getName() + ")", bookingReference);
    }
  }

  // Views the invoices with the current booking reference
  public void viewInvoice(String bookingReference) {
    // Initialises all possible values which are used in the invoice
    String email = "";
    String dateBooking = "";
    String dateParty = "";
    int attendees = 0;
    String venue = "";
    String hireFee = "";
    String catering = "";
    int cateringFee = 0;
    int musicFee = 0;
    String floral = "";
    int floralFee = 0;
    int total = 0;
    // Initialses booleans to check if services and references are valid
    boolean cateringCheck = false;
    boolean musicCheck = false;
    boolean floralCheck = false;
    boolean bookingRefCheck = false;

    // Looks through the list of bookings, gets information about the booking
    for (Booking booking : bookingList) {
      if (booking.getReference().equals(bookingReference)) {
        bookingRefCheck = true;
        email = booking.getEmail();
        dateBooking = booking.getDateOfBooking();
        dateParty = booking.getRequestedDate();
        attendees = Integer.parseInt(booking.getAttendees());
        venue = booking.getVenueName();
        // Looks through the venues list to get the venue hire fee
        for (Venue venues : venueList) {
          if (venues.getCode().equals(booking.getBookingCode())) {
            hireFee = venues.getFee();
          }
        }
        for (Service service : serviceList) {
          if (service.getReference().equals(bookingReference)) {
            // Checks if there is a catering service, gets service type and calculates price
            if (service instanceof Catering) {
              cateringCheck = true;
              catering = service.getType();
              cateringFee = service.getCost() * attendees;
              // Checks if there is a music service, sets the price
            } else if (service instanceof Music) {
              musicCheck = true;
              musicFee = 500;
              // Checks if there is a floral service, gets service type and cost
            } else if (service instanceof FloralService) {
              floralCheck = true;
              floral = service.getType();
              floralFee = service.getCost();
            }
          }
        }
      }
    }
    // Prints error if booking reference is invalid
    if (bookingRefCheck == false) {
      MessageCli.VIEW_INVOICE_BOOKING_NOT_FOUND.printMessage(bookingReference);
      // Otherwise, prints the top half of the invoice
    } else if (bookingRefCheck == true) {
      total = Integer.parseInt(hireFee) + cateringFee + musicFee + floralFee;

      MessageCli.INVOICE_CONTENT_TOP_HALF.printMessage(
          bookingReference, email, dateBooking, dateParty, Integer.toString(attendees), venue);
      // Prints the venue and service fees depending on which ones are added
      MessageCli.INVOICE_CONTENT_VENUE_FEE.printMessage(hireFee);
      if (cateringCheck == true) {
        MessageCli.INVOICE_CONTENT_CATERING_ENTRY.printMessage(
            catering, Integer.toString(cateringFee));
      }
      if (musicCheck == true) {
        MessageCli.INVOICE_CONTENT_MUSIC_ENTRY.printMessage("500");
      }
      if (floralCheck == true) {
        MessageCli.INVOICE_CONTENT_FLORAL_ENTRY.printMessage(floral, Integer.toString(floralFee));
      }
      // Prints the bottom half of the invoice with the total price
      MessageCli.INVOICE_CONTENT_BOTTOM_HALF.printMessage(Integer.toString(total));
    }
  }

  // Adds Venue to Arraylist
  public void addVenue(Venue venue) {
    venueList.add(venue);
  }

  // Venue success message
  public void addVenueSuccess(Venue venue) {
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venue.getName(), venue.getCode());
  }

  public void addVenueFail(Venue venue) {}

  // Checks if venue is valid by checking the name, code, capacity and hire fee inputs
  public boolean checkVenueValid(Venue venue) {
    if (checkName(venue.getName()) == false) {
      // returns false if the name is empty
      return false;
    } else if (checkCode(venue.getCode()) == false) {
      // returns false if the code is already used
      return false;
    } else if (checkCap(venue.getCap()) == false) {
      // returns false if capacity is not a positive number
      return false;
    } else if (checkHireFee(venue.getFee()) == false) {
      // returns false if hire fee is not a positive number
      return false;
    } else {
      return true;
    }
  }

  // Checks if name is valid by removing all whitespaces, and then checking the length of the
  // trimmed string
  public boolean checkName(String nameString) {
    // Replaces all whitespaces with a blank
    String cleanName = nameString.replaceAll("\\s+", "");
    int nameLength = cleanName.length();
    if (nameLength == 0) {
      // Returns invalid if the name is empty
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return false;
    } else {
      // Returns true if name is valid
      return true;
    }
  }

  // Checks if code is valid
  public boolean checkCode(String codeString) {
    // Checks all the venues in the list of venues
    for (Venue venue : venueList) {
      if (codeString.equals(venue.getCode()) == true) {
        MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(
            codeString,
            // Gets the name of the venue
            venue.getName());
        return false;
      }
    }
    return true;
  }

  // Checks if capacity is valid be trying to change from a string to an integer
  public boolean checkCap(String capString) {
    try {
      // Tries to get the integer value of a string
      int num = Integer.valueOf(capString);
      if (num <= 0) {
        // If the integer value is valid, checks if it is positive
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
        return false;
      } else {
        return true;
      }
    } catch (Exception exception) {
      // Catches an expcetion if the an integer value cannot be gotten from the string
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return false;
    }
  }

  // Checks if the hire fee is valid using the same logic as checking the capacity
  public boolean checkHireFee(String feeString) {
    try {
      // Trys to get the integer value of the fee from a string
      int num = Integer.valueOf(feeString);
      // If there isn't an error, and it is a positive number, returns a boolean true
      if (num <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
        return false;
      } else {
        return true;
      }
      // If there is an error, return a boolean false that the hire fee is valid
    } catch (Exception exception) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return false;
    }
  }

  public String theDay(Date date) {
    return date.getDate();
  }
}
