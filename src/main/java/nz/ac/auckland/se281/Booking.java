package nz.ac.auckland.se281;

public class Booking {
  private String bookingCode;
  private String requestedDate;
  private String email;
  private String attendees;

  public Booking(String bookingCode, String requestedDate, String email, String attendees) {
    this.bookingCode = bookingCode;
    this.requestedDate = requestedDate;
    this.email = email;
    this.attendees = attendees;
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
}
