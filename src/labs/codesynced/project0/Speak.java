package labs.codesynced.project0;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import labs.codesynced.project0.checker.DateChecker;
import labs.codesynced.project0.weather.MakeReadableWeather;
import labs.codesynced.project0.weather.Weather;
import labs.codesynced.project0.weather.info.YahooWeatherService;
import labs.codesynced.project0.weather.info.data.Channel;
import labs.codesynced.project0.weather.info.data.unit.DegreeUnit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Wylan Shoemaker on 9/25/2016.
 */
public class Speak
{

    private static final String VOICE_NAME = "kevin16";
    private static String date;
    private static Weather weather;
    private static final String NAME = System.getProperty("user.name");

    public static void begin() throws Exception
    {
        weather = new Weather();
        obtainDate();

        String text = build();
        
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICE_NAME);
        voice.allocate();
        try {
            Scanner scanner = new Scanner(System.in);
            if(scanner.next().toString().equalsIgnoreCase("start"))
            {
                voice.speak(text);
                System.out.println(text);
            }
        } catch(Exception e) {}

        System.err.println("Terminated.");
    }

    private static String build() throws Exception
    {
        YahooWeatherService service = new YahooWeatherService();
        Channel channel = service.getForecast("2504627", DegreeUnit.FAHRENHEIT);

        StringBuilder builder = new StringBuilder();
        builder.append("Good " + refractorTime() + ", " + NAME.split("\\s+")[0] + ". ");
        builder.append("It is currently " + date + ". \n");
        builder.append(MakeReadableWeather.readItem(channel.getItem()) + "\n");
        builder.append(MakeReadableWeather.readAstronomy(channel.getAstronomy()) + "\n");
        builder.append(MakeReadableWeather.readAtmosphere(channel.getAtmosphere()));
        //System.out.println(builder.toString());
        return builder.toString();
    }

    private static String refractorTime()
    {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("k, mm a"); //k = 1-23
        int hour = Integer.parseInt(format.format(date).split(",")[0]);

        if(hour <= 11)
        {
            return "Morning";
        } else if(hour <= 16)
        {
            return "Afternoon";
        } else if(hour <= 19)
        {
            return "Evening";
        } else return "Night";
    }

    private static void obtainDate()
    {
        date = DateChecker.getDate() + " " + DateChecker.getTime();
    }

}
