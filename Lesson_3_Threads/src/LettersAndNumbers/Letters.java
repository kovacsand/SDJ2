package LettersAndNumbers;

public class Letters implements Runnable
{
  private int n;

  public Letters(int n)
  {
    this.n = n;
  }

  @Override public void run()
  {
    for (int i = 0; i < n; i++)
    {
      System.out.println((char) (65 + i));
    }
  }
}
