package labs.codesynced.project0.weather;

import labs.codesynced.project0.weather.info.data.Astronomy;
import labs.codesynced.project0.weather.info.data.Atmosphere;
import labs.codesynced.project0.weather.info.data.Item;

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
        String readable = "The sun will rise at " + riseHour + ", " + riseMin + " a m. The sun will set at " + setHour + ", " + setMin + " pm.";
        return readable;
    }

    public static String readItem(Item item)
    {
        String condition = item.getCondition().getText() + " with a temperature of " + item.getCondition().getTemp() + " degrees";
        int high = item.getForecasts().get(0).getHigh();
        int low = item.getForecasts().get(0).getLow();
        String readable = "It is currently " + condition + " outside. The high today will be " + high + " degrees. The low today will be " + low + " degrees.";
        return readable;
    }

}
