package Cookies;

import BlockingQueue.BlockingQueue;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class CookieJar
{
  private int cookieCountWhenToBake;
  private int numberOfCookiesInTheOven;
  private int cookiePlateSize;
  private BlockingQueue cookies;
  private final String[] types = {"Chocolate Chip", "Fortune", "Gingerbread", "Oatmeal", "Peanut Butter"};

  public CookieJar(int jarSize, int cookieCountWhenToBake, int cookiePlateSize)
  {
    this.cookiePlateSize = jarSize;
    this.cookies = new BlockingQueue(jarSize);
    this.cookieCountWhenToBake = cookieCountWhenToBake;
    this.numberOfCookiesInTheOven = cookiePlateSize;
  }

  public synchronized void startBaking()
  {
    try
    {
      wait();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    System.out.println("Started baking...");
    try
    {
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    finishedBaking();
  }

  public synchronized int finishedBaking()
  {
    for (int i = 0; i < numberOfCookiesInTheOven; i++)
      cookies.put(new Cookie(types[new Random().nextInt(5)]));
    System.out.printf("Finished baking. The current number of cookies is %d\n", cookies.size());
    notifyAll();
    return cookies.size();
  }

  public synchronized Cookie eat()
  {
    while (cookies.isEmpty())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    if (cookies.size() == cookieCountWhenToBake)
    {
      System.out.println("Oh no, not enough cookies! I must notify the baker!!");
      notifyAll();
    }
    return (Cookie) cookies.take();
  }

  public synchronized int getRemainingNumberOfCookies()
  {
    return cookies.size();
  }
}
