package labs.codesynced.project0.weather;

/**
 * Created by Wylan Shoemaker on 9/25/2016.
 */
public class CantFindWeatherException extends Exception
{
    public CantFindWeatherException()
    {
    }

    public CantFindWeatherException(String message)
    {
        super(message);
    }

    public CantFindWeatherException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CantFindWeatherException(Throwable cause)
    {
        super(cause);
    }
}
