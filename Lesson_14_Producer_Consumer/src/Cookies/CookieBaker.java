package Cookies;

public class CookieBaker implements Runnable
{
  @Override public void run()
  {
        Test.cookieJar.startBaking();
        System.out.printf(
            "I have started baking, because the current number of cookies is %d\n",
            Test.cookieJar.getRemainingNumberOfCookies());


  }
}