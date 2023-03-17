package TortoiseAndHare;

public class Tortoise implements Runnable
{
  private int distance;

  public Tortoise()
  {
    distance = 0;
  }

  @Override public void run()
  {
    while (distance < 1000)
    {
      if (distance % 100 == 0)
        System.out.println("The tortoise has reached the " + distance + " m line");
      distance++;
      try
      {
        Thread.sleep(10);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    System.out.println("The tortoise has reached the finish line!");
  }

  public int getDistance()
  {
    return distance;
  }
}
