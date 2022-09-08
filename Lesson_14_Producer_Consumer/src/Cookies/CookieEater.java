package Cookies;

public class CookieEater implements Runnable
{
  @Override public void run()
  {
    while (true)
    {
      System.out.printf("What a yummy %s\nThere are %d cookies remaining\n", Test.cookieJar.eat(), Test.cookieJar.getRemainingNumberOfCookies());
      try
      {
        Thread.sleep(500);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
