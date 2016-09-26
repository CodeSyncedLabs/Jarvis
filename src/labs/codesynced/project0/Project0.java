package labs.codesynced.project0;

/**
 * Created by Wylan Shoemaker on 9/25/2016.
 */
public class Project0 implements Runnable
{

    @Override
    public void run()
    {
        try {
            Speak.begin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        (new Thread(new Project0())).start();
    }
}
