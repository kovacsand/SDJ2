package Cookies;

public class Test
{
  public static CookieJar cookieJar;

  public static void main(String[] args)
  {
    cookieJar = new CookieJar(20, 4, 12);

    new Thread(new CookieBaker()).start();
    new Thread(new CookieEater()).start();
  }
}
