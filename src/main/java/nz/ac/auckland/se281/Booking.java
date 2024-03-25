package nz.ac.auckland.se281;

public class Booking {
  private String bookingCode;
  private String requestedDate;
  private String email;
  private String attendees;
  private String reference;
  private String venueName;

  public Booking(String bookingCode, String requestedDate, String email, String attendees, String reference, String venuenName) {
    this.bookingCode = bookingCode;
    this.requestedDate = requestedDate;
    this.email = email;
    this.attendees = attendees;
    this.reference = reference;
    this.venueName = venuenName;
  }
  
  public String getBookingCode() {
    return bookingCode;
  }

  public String getRequestedDate() {
    return requestedDate;
  }

  public String getEmail() {
    return email;
  }

  public String getAttendees() {
    return attendees;
  }

  public String getReference() {
    return reference;
  }

  public String getVenueName() {
    return venueName;
  }
}
