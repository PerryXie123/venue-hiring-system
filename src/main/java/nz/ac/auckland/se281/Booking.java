package nz.ac.auckland.se281;

public class Booking {
  private String bookingCode;
  private String requestedDate;
  private String email;
  private String attendees;
  private String reference;

  public Booking(String bookingCode, String requestedDate, String email, String attendees, String reference) {
    this.bookingCode = bookingCode;
    this.requestedDate = requestedDate;
    this.email = email;
    this.attendees = attendees;
    this.reference = reference;
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
}
