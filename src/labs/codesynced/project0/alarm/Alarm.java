package labs.codesynced.project0.alarm;

import labs.codesynced.project0.weather.info.data.unit.Time;
import labs.codesynced.project0.weather.info.data.unit.TimeConvention;

/**
 * Created by Wylan Shoemaker on 9/25/2016.
 */
public class Alarm
{

    private Time time;

    public Alarm(String title, int hour, int minute, boolean isAM)
    {
        this.time = new Time(hour, minute, (isAM ? TimeConvention.AM : TimeConvention.PM));
    }

    public Time getTime()
    {
        return time;
    }

    public int getHour()
    {
        return time.getHours();
    }

    public int getMinute()
    {
        return time.getMinutes();
    }

    public TimeConvention getTimeConventtion()
    {
        return time.getConvention();
    }

}
