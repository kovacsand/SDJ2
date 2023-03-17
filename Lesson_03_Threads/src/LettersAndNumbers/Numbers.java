package LettersAndNumbers;

public class Numbers implements Runnable
{
  private int n;

  public Numbers(int n)
  {
    this.n = n;
  }

  @Override public void run()
  {
    for (int i = 0; i < n; i++)
    {
      System.out.println(i);
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
