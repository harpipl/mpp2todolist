package pl.harpi.mpp2todolist.utils;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateHelper {
    public static final String MIN_DATE = "1899-12-30";
    public static final String DATE_FORMAT_STR = "yyyy-MM-dd";
    public static final String DATE_WITH_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_STR = "HH:mm:ss";

    public static String toNum(Date date) {
        if (date == null) {
            return null;
        }

        DateTime dt1 = DateTime.parse(MIN_DATE);
        DateTime dt2 = DateTime.parse(toString(date, DATE_FORMAT_STR));
        int days = Days.daysBetween(dt1, dt2).getDays();

        return days + ".00000000";
    }

    public static Date addSeconds(Date date, int seconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, seconds); //minus number would decrement the days
        return cal.getTime();
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static Date toDate(Integer date) {
        try {
            return new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(date.toString());
        } catch (ParseException e) {
        }

        return null;
    }

    public static String toString(Date value, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        if (value != null) {
            return dateFormat.format(value);
        } else {
            return null;
        }
    }

    public static Integer toInteger(Date date) {
        String str = toString(date, "yyyyMMdd");
        return new Integer(str);
    }

    public static Date toDate(String value, String format) {
        try {
            return new SimpleDateFormat(format, Locale.ENGLISH).parse(value);
        } catch (ParseException e) {
            //FIXME obsługa
        }

        return null;
    }

    public static Integer addDays(Integer date, int days) {
        Date d = toDate(date);
        d = addDays(d, days);
        return toInteger(d);
    }

    public static boolean between(Date date, Date from, Date to) {
        if (date == null) return false;

        return !(date.before(from) || date.after(to));
    }

    public static Date min(Date date1, Date date2) {
        return (date1.compareTo(date2) < 0) ? date1 : date2;
    }

    public static Date max(Date date1, Date date2) {
        return (date1.compareTo(date2) > 0) ? date1 : date2;
    }
}
