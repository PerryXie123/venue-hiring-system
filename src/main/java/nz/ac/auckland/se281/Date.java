package nz.ac.auckland.se281;
import java.time.LocalDate;

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
    if(getDay() <= 9 && getMonth() > 9){
      return("0" + getDay() + "/" + getMonth() + "/" + getYear());
    }
    else if(getMonth() <= 9 && getDay() > 9){
      return(getDay() + "/0" + getMonth() + "/" + getYear());
    }
    else if(getDay() <= 9 && getMonth() <= 9){
      return("0" + getDay() + "/0" + getMonth() + "/" + getYear());
    }
    else{
      return(getDay() + "/" + getMonth() + "/" + getYear());
    }
  }

  public void setTheDate(){
    LocalDate.of(Integer.valueOf(getYear()), Integer.valueOf(getMonth()), Integer.valueOf(getDay()));
  }

  public boolean isAfter(Date dateToCheck){
    if(getYear() > dateToCheck.getYear()){
      return true;
    }
    else if (getYear() == dateToCheck.getYear() && getMonth() > dateToCheck.getMonth()){
      return true;
    }
    else if (getYear() == dateToCheck.getYear() && getMonth() == dateToCheck.getMonth() && getDay() > dateToCheck.getDay()){
      return true;
    }
    else {
      return false;
    }
  }

  public boolean isSameAs(Date dateToCheck){
    if(getYear() != dateToCheck.getYear() || getMonth() != dateToCheck.getMonth() || getDay() != dateToCheck.getDay())
    return false;
    else{
      return true;
    }
  }

  public Date incrementDate(){
    int newDay = 0;
    int newMonth = 0;
    int newYear = 0;
    if(getMonth() == 1 || getMonth() == 3 || getMonth() == 5 || getMonth() == 7 || getMonth() == 8 || getMonth() == 10 || getMonth() == 12){
      if (getDay() <= 30){
        newDay = getDay() + 1;
        newMonth = getMonth();
        newYear = getYear();
      }
      else if (getDay() == 31){
        if (getMonth() != 12){
          newMonth = getMonth() + 1;
          newDay = 1;
          newYear = getYear();
        }
        else if (getMonth() == 12){
          newMonth = 1;
          newYear = getYear() + 1;
          newDay = 1;
        }
      }
    }
    else if (getMonth() == 4 || getMonth() == 6 || getMonth() == 9 || getMonth() == 11){
      if (getDay() <= 29){
        newDay = getDay() + 1;
        newMonth = getMonth();
        newYear = getYear();
      }
      else if (getDay() == 30){
        newDay = 1;
        newMonth = getMonth() + 1;
        newYear = getYear();
      }
    }
    else if(getMonth() == 2 && getYear()%4 != 0){
      if(getDay() <= 27){
        newDay = getDay() + 1;
        newMonth = getMonth();
        newYear = getYear();
      }
      else if(getDay() == 28){
        newDay = 1;
        newMonth = getMonth() + 1;
        newYear = getYear();
      }
    }
    else if(getMonth() == 2 && getYear()%4 == 0){
      if(getDay() <= 28){
        newDay = getDay() + 1;
        newMonth = getMonth();
        newYear = getYear();
      }
      else if(getDay() == 29){
        newDay = 1;
        newMonth = getMonth() + 1;
        newYear = getYear();
      }
    }
    return new Date(Integer.toString(newDay), Integer.toString(newMonth), Integer.toString(newYear));
    // if(newDay <= 9 && newMonth > 9){
    //   return("0" + newDay + "/" + newMonth + "/" + newYear);
    // }
    // else if(newMonth <= 9 && newDay > 9){
    //   return(newDay + "/0" + newMonth + "/" + newYear);
    // }
    // else if(newDay <= 9 && newMonth <= 9){
    //   return("0" + newDay + "/0" + newMonth + "/" + newYear);
    // }
    // else{
    //   return(newDay + "/" + newMonth + "/" + newYear);
    // }
  }
}
