package Carrots.v2;

import Carrots.Carrot;

public class Test
{
  public static void main(String[] args)
  {
    Monitor bq = new Monitor(20);

    //Peeling
    new Thread(() -> {
      while (true)
      {
        try
        {
          bq.peel();
          Thread.sleep(300);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }).start();


    //Eating
    new Thread(() -> {
      while (true)
      {
        bq.eat();
        try
        {
          Thread.sleep(600);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }).start();

    //Printing out
    new Thread(() ->
    {
      while (true)
      {
        System.out.println(bq);
        try
        {
          Thread.sleep(400);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }).start();
  }
}
