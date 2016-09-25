package labs.codesynced.project0.checker;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Wylan Shoemaker on 9/25/2016.
 */
public class DateChecker
{

    public static String getDate()
    {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(" EEEE, MMMM ddd, yyy.");
        //System.out.println(format.format(date));
        return format.format(date);
    }

    public static String getTime()
    {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("h, mm a");
        //System.out.println(format.format(date));
        return "It is " + format.format(date);
    }

    public static String getAsLongDate(String date)
    {
        String s = date.split("/")[0];
        int i = Integer.parseInt(s);
        switch (i) {
            case 1: return getMonth(i);
            case 2: return getMonth(i);
            case 3: return getMonth(i);
            case 4: return getMonth(i);
            case 5: return getMonth(i);
            case 6: return getMonth(i);
            case 7: return getMonth(i);
            case 8: return getMonth(i);
            case 9: return getMonth(i);
            case 10: return getMonth(i);
            case 11: return getMonth(i);
            case 12: return getMonth(i);
            default: return null;
        }
    }

    public static String getMonth(int i)
    {
        String[] months = {"January", "February", "March", "April", "June", "July", "August", "September", "October", "November", "December"};
        return months[i - 1];
    }

}
