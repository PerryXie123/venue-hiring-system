package nz.ac.auckland.se281;

public class Date {
  private String day;
  private String month;
  private String year;

  public Date (String day, String month, String year){
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public int getDay(){
    int theDay = Integer.valueOf(day);
    return theDay;
  }

  public int getMonth(){
    int theMonth = Integer.valueOf(month);
    return theMonth;
  }

  public int getYear(){
    int theYear = Integer.valueOf(year);
    return theYear;
  }

  public String getDate(){
    if(getDay() <= 9){
      return("0" + getDay() + "/" + getMonth() + "/" + getYear());
    }
    else if(getMonth() <= 9){
      return(getDay() + "/0" + getMonth() + "/" + getYear());
    }
    else if(getDay() <= 9 && getMonth() <= 9){
      return("0" + getDay() + "/0" + getMonth() + "/" + getYear());
    }
    else{
      return(getDay() + "/" + getMonth() + "/" + getYear());
    }
  }
}
