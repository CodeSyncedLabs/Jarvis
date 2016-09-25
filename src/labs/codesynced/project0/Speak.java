package labs.codesynced.project0;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import labs.codesynced.project0.checker.DateChecker;
import labs.codesynced.project0.weather.MakeReadableWeather;
import labs.codesynced.project0.weather.Weather;
import labs.codesynced.project0.weather.info.YahooWeatherService;
import labs.codesynced.project0.weather.info.data.Channel;
import labs.codesynced.project0.weather.info.data.unit.DegreeUnit;

/**
 * Created by Wylan Shoemaker on 9/25/2016.
 */
public class Speak
{

    private static final String VOICE_NAME = "kevin16";
    private static String date;
    private static Weather weather;

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
            voice.speak(text);
        } catch(Exception e) {}
    }

    private static String build() throws Exception
    {
        YahooWeatherService service = new YahooWeatherService();
        Channel channel = service.getForecast("2504627", DegreeUnit.FAHRENHEIT);

        StringBuilder builder = new StringBuilder();
        builder.append("Good Morning, " + System.getProperty("user.name").toString().split("\\s+")[0] + ". ");
        builder.append("It is currently " + date + ". \n");
        builder.append(MakeReadableWeather.readItem(channel.getItem()) + "\n");
        builder.append(MakeReadableWeather.readAstronomy(channel.getAstronomy()) + "\n");
        builder.append(MakeReadableWeather.readAtmosphere(channel.getAtmosphere()));
        System.out.println(builder.toString());
        return builder.toString();
    }

    private static void obtainDate()
    {
        date = DateChecker.getDate() + " " + DateChecker.getTime();
    }

}
