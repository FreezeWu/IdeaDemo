package com.wkc.rookie;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        Date timestamp = new Date(System.currentTimeMillis());
        System.out.println(date.toString());
        System.out.println(System.currentTimeMillis());
        System.out.println(timestamp);

        if(date.getTime() == timestamp.getTime()){
            System.out.println(true);
        }

        System.out.println(date.compareTo(timestamp));

        System.out.println(new Date(111).before(new Date(222)));

        System.out.println("------------------------------------------");

        SimpleDateFormat fDefault = new SimpleDateFormat();
        SimpleDateFormat fCustom = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println(fDefault.format(date));
        System.out.println("休眠3秒...");
        long start = System.currentTimeMillis();
        //Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000 + "s");
        System.out.println(fCustom.format(date));

        System.out.println("------------------------------------------");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 3, 21 );
        calendar.set(2020, 3, 1 );



        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);

        System.out.println(year + "-" + month + "-" + day);

        System.out.println("------------------------------------------");

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setGregorianChange(date);

        int year2 = gregorianCalendar.get(Calendar.YEAR);

        System.out.println(year2 + " is leapyear = " + gregorianCalendar.isLeapYear(year2));






    }
}
