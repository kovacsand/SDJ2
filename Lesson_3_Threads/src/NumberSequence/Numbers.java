package NumberSequence;

public class Numbers implements Runnable
{
  private int x, y;
  private Thread t;

  public Numbers(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public Numbers(int x, int y, Thread t)
  {
    this.x = x;
    this.y = y;
    this.t = t;
  }

  @Override public void run()
  {
    if (t != null)
    {
      try
      {
        t.join();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    for (int i = x; i < y; i++)
    {
      System.out.println(i);
    }
  }
}
