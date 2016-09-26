package labs.codesynced.project0.weather;

import labs.codesynced.project0.weather.info.data.Astronomy;
import labs.codesynced.project0.weather.info.data.Atmosphere;
import labs.codesynced.project0.weather.info.data.Item;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Wylan Shoemaker on 9/25/2016.
 */
public class MakeReadableWeather
{

    public static String readAtmosphere(Atmosphere atmosphere)
    {
        int humidity = atmosphere.getHumidity();
        float pressure = atmosphere.getPressure();
        float visibility = atmosphere.getVisibility();
        String readable = "The humidity today is " + humidity + " percent, the pressure is " + pressure + " millibars, and visibility is " + visibility + " miles.";
        return readable;
    }

    public static String readAstronomy(Astronomy astronomy)
    {
        int riseHour = astronomy.getSunrise().getHours();
        int riseMin = astronomy.getSunrise().getMinutes();
        int setHour = astronomy.getSunset().getHours();
        int setMin = astronomy.getSunset().getMinutes();
        String[] hours = correctTense(riseHour, setHour);

        String readable = "The sun " + hours[0] + " at " + riseHour + ", " + riseMin + " a-m. The sun " + hours[1] + " at " + setHour + ", " + setMin + " pm.";
        return readable;
    }

    public static String readItem(Item item)
    {
        String condition = item.getCondition().getText() + " with a temperature of " + item.getCondition().getTemp() + " degrees";
        int high = item.getForecasts().get(0).getHigh();
        int low = item.getForecasts().get(0).getLow();

        //System.out.println(item.getCondition().getDate().getTime());

        String readable = "It is currently " + condition + " outside. The high will be" + /*pastTenseWas() +*/" " + high + " degrees. The low will be " + low + " degrees.";
        return readable;
    }

    private static String[] correctTense(int riseHour, int setHour)
    {
        String[] hours = new String[2];
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("k, mm a"); //k = 1-23
        int hour = Integer.parseInt(format.format(date).split(",")[0]);

        hours[0] = riseHour > hour ? "will rise" : "rose";
        hours[1] = setHour < hour ? "had set" : "will set";
        return hours;
    }

    private static String pastTenseWas(int time)
    {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("k, mm a"); //k = 1-23
        int hour = Integer.parseInt(format.format(date).split(",")[0]);
        return time > hour ? "was" : "will be";
    }

}
