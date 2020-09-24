package services;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateService {
    public static String toString(Date date) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return  df.format(date);
    }
}
