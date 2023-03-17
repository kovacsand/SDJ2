package ComputerSimulation;

public class MailBox implements Runnable
{
  private int count;
  private final long RUNTIME = 10000;

  public MailBox(int count)
  {
    this.count = count;
  }

  @Override public void run()
  {
    for (int i = 0; i < count; i++)
    {
      System.out.println("New mail in your mailbox...");
      try
      {
        Thread.sleep(RUNTIME / count);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
