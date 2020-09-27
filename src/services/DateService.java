package services;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateService {
    private static final int MAX_DAYS = 14;
    public static String toString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return  df.format(date);
    }

    public static Date returnDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, MAX_DAYS);
        return new Date(cal.getTime().getTime());
    }
}
