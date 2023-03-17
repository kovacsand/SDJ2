package LettersAndNumbers;

public class Start
{
  public static void main(String[] args)
  {
    Thread numberPrinter = new Thread(new Numbers(57));
    Thread letterPrinter = new Thread(new Letters(33));

    numberPrinter.start();
    //letterPrinter.start();

    final int n = 20;
    new Thread(() ->
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
    }).start();
  }
}
