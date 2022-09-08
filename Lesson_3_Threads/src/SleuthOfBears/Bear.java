package SleuthOfBears;

public class Bear implements Runnable
{

  @Override public void run()
  {
    System.out.println("I'm a sleepy bear, I'm going to sleep...");

    try
    {
      Thread.sleep(3000);
      System.out.println("I'm well rested now.");
    }
    catch (InterruptedException e)
    {
      System.out.println("I'm very angry now! Grrr");
      for (int i = 0; i < Start.bearList.getSize(); i++)
      {
        Start.bearList.getBearThreads().get(i).interrupt();
      }
    }
  }
}
