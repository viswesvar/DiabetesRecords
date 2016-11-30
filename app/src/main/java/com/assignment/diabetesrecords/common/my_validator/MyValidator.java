package com.assignment.diabetesrecords.common.my_validator;

/**
 * Created by Viswesvar on 11/24/16.
 */
public class MyValidator {

    public static  String getDateInddmmyyyy(String dateInyyyymmdd)
    {
        //output will be "2016-12-31"
        String result="";
        String sDay="", sMonth="", sYear="";
        String[] arrDate = dateInyyyymmdd.split("-");

        sDay = arrDate[2].toString();
        sMonth = arrDate[1].toString();
        sYear = arrDate[0].toString();

        if(sDay.length() == 1)
        {
            sDay = "0" +sDay;
        }

        if(sMonth.length() == 1)
        {
            sMonth = "0" +sMonth;
        }

        if(sYear.length() == 2)
        {
            sYear = "20" +sYear;
        }


        result =sDay + "-" + sMonth + "-" + sYear;
        return result;
    }

    //------
    public static  String getTimeInAMPMFormat(String timeIn24HoursFormat)
    {
        String result="";
        if(timeIn24HoursFormat.length() == 0)
        {
            return result;
        }

        String[] arrTime = timeIn24HoursFormat.split(":");


        String sAMPM= "", sHours="00", sMinutes="00";
        int iHours=0, iMinutes=0;

        iHours= Integer.valueOf(arrTime[0].toString());
        iMinutes= Integer.valueOf(arrTime[1].toString());

        if((iHours==0) && (iMinutes==0))
        {
            return "";
        }

        sMinutes = arrTime[1].toString();

        if(iHours > 12)
        {
            sAMPM= "PM";
            iHours = iHours - 12;
        }
        else
        {
            sAMPM= "AM";
        }



        sHours = String.valueOf(iHours);

        if(sHours.length() ==1)
        {
            sHours= "0"+sHours;
        }

        if(sMinutes.length() ==1)
        {
            sMinutes= "0"+sMinutes;
        }



        result =sHours + ":" + sMinutes + " " + sAMPM;
        return result;
    }
    //-----------------
    public static  String getDateInyyyymmdd(int day, int month, int year)
    {
        //output will be "2016-12-31"
        String result="";
        String sDay="", sMonth="", sYear="";
        sDay = String.valueOf(day);
        sMonth = String.valueOf(month);
        sYear = String.valueOf(year);

        if(sDay.length() == 1)
        {
            sDay = "0" +sDay;
        }

        if(sMonth.length() == 1)
        {
            sMonth = "0" +sMonth;
        }

        if(sYear.length() == 2)
        {
            sYear = "20" +sYear;
        }


        result =sYear + "-" + sMonth + "-" + sDay;
        return result;
    }
    //--------------------
    public static  String getTimeIn24HoursFormat(String timeInAMPMFormat)
    {
        String result="00:00:00";
        if(timeInAMPMFormat.length() == 0)
        {
            return result;
        }

        String sAMPM= "", sHours="00", sMinutes="00", sSeconds="00";
        int iHours=0;
        sAMPM = timeInAMPMFormat.substring(timeInAMPMFormat.length()-2, timeInAMPMFormat.length());
        iHours= Integer.valueOf(timeInAMPMFormat.substring(0,timeInAMPMFormat.indexOf(":")));
        sMinutes = timeInAMPMFormat.substring(timeInAMPMFormat.indexOf(":")+1,timeInAMPMFormat.indexOf(" "));
        if(sAMPM.equals("PM"))
        {
            iHours += 12;
        }

        sHours = String.valueOf(iHours);

        if(sHours.length() ==1)
        {
            sHours= "0"+sHours;
        }

        if(sMinutes.length() ==1)
        {
            sMinutes= "0"+sMinutes;
        }



        result =sHours + ":" + sMinutes + ":" + sSeconds;
        return result;
    }

    public static  String getDateInyyyymmdd(String dateInddmmyyyy)
    {
        //output will be "2016-12-31"
        String result="";
        String sDay="", sMonth="", sYear="";
        String[] arrDate = dateInddmmyyyy.split("-");

        sDay = arrDate[0].toString();
        sMonth = arrDate[1].toString();
        sYear = arrDate[2].toString();

        if(sDay.length() == 1)
        {
            sDay = "0" +sDay;
        }

        if(sMonth.length() == 1)
        {
            sMonth = "0" +sMonth;
        }

        if(sYear.length() == 2)
        {
            sYear = "20" +sYear;
        }


        result =sYear + "-" + sMonth + "-" + sDay;
        return result;
    }



}
