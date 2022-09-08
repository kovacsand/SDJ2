package TortoiseAndHare;

import java.util.Random;

public class Hare implements Runnable
{
  private Tortoise tortoise;
  private int distance;

  public Hare(Tortoise tortoise)
  {
    this.tortoise = tortoise;
    distance = 0;
  }

  @Override public void run()
  {
    Random random = new Random();
    while (distance < 1000)
    {
      if (distance % 100 == 0)
        System.out.println("The hare has reached the " + distance + " m line");
      if (distance <= tortoise.getDistance())
        distance += 50;
      else
        try
        {
          int temp = random.nextInt(1000);
          System.out.println("The hare went to sleep for " + temp + " ms at the " + distance + " m line."
              + "The tortoise is currently at the " + tortoise.getDistance() + " m line.");
          Thread.sleep(temp);

        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
    }
    System.out.println("The hare has reached the finish line! "
        + "The tortoise is currently at the " + tortoise.getDistance() + " m line.");
  }
}
