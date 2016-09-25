package labs.codesynced.project0;

public class Project0 implements Runnable
{

    @Override
    public void run()
    {
        try {
            Speak.begin();
        } catch (Exception e) {}
    }

    public static void main(String[] args)
    {
        (new Thread(new Project0())).start();
    }
}
