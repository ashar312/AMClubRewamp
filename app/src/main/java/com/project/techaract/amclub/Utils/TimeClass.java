package com.project.techaract.amclub.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeClass {

    public String addHour(String myTime, int number)
    {
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
            Date d = df.parse(myTime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            cal.add(Calendar.HOUR, number);
            String newTime = df.format(cal.getTime());
            return newTime;
        }
        catch(ParseException e)
        {
            System.out.println(" Parsing Exception");
        }
        return null;

    }

    public String getDay() {
        String DayOfWeek = "";
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.SUNDAY:
                DayOfWeek = "Sunday";
                break;
            case Calendar.MONDAY:
                DayOfWeek = "Monday";
                break;
            case Calendar.TUESDAY:
                DayOfWeek = "Tuesday";
                break;
            case Calendar.WEDNESDAY:
                DayOfWeek = "Wednesday";
                break;
            case Calendar.THURSDAY:
                DayOfWeek = "thursday";
                break;
            case Calendar.FRIDAY:
                DayOfWeek = "Friday";
                break;
            case Calendar.SATURDAY:
                DayOfWeek = "Saturday";
                break;
        }
        return DayOfWeek;
    }



    public boolean TimeliesBetween(String String1, String String2, String randomeTime){
        try {
           // String string1 = "20:11:13";
            Date time1 = new SimpleDateFormat("HH:mm").parse(String1);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);

            //String string2 = "14:49:00";
            Date time2 = new SimpleDateFormat("HH:mm").parse(String2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(time2);
            calendar2.add(Calendar.DATE, 1);

          //  String someRandomTime = "01:00:00";
            Date d = new SimpleDateFormat("HH:mm").parse(randomeTime);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(d);
            calendar3.add(Calendar.DATE, 1);

            Date x = calendar3.getTime();
            if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
                //checkes whether the current time is between 14:49:00 and 20:11:13.
                System.out.println(true);
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String str = dateFormat.format(date);
        return str;
    }

    public String getCurrentTime(){
        DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
        Date date = new Date();
        String str = dateFormat.format(date);
        return str;
    }

    public String T12toT24(String input){
        //Format of the date defined in the input String
        DateFormat df = new SimpleDateFormat("hh:mm aa");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("HH:mm");
        Date date = null;
        String output = null;
        try{
            //Converting the input String to Date
            date= df.parse(input);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            //Displaying the date
            return output;
        }catch(ParseException pe){
            return pe.getMessage();
        }
    }

    public String T24toT12(String input){
        //Date/time pattern of input date
        DateFormat df = new SimpleDateFormat("HH:mm");
        //Date/time pattern of desired output date
        DateFormat outputformat = new SimpleDateFormat("hh:mm aa");
        Date date = null;
        String output = null;
        try{
            //Conversion of input String to date
            date= df.parse(input);
            //old date format to new date format
            output = outputformat.format(date);
            return output;
        }catch(ParseException pe){
            return pe.getMessage();
        }
    }

    public float SubtractionOfTwoDates(String StartDate, String EndDate){
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");

        try {
            Date dateBefore = myFormat.parse(StartDate);
            Date dateAfter = myFormat.parse(EndDate);
            long difference = dateAfter.getTime() - dateBefore.getTime();
            float daysBetween = (difference / (1000*60*60*24));
            /* You can also convert the milliseconds to days using this method
             * float daysBetween =
             *         TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS)
             */
            return daysBetween;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
