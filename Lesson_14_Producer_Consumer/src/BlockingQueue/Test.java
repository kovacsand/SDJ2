package BlockingQueue;

public class Test
{
  public static void main(String[] args) throws InterruptedException
  {
    BlockingQueue bq = new BlockingQueue(3);
    System.out.println("At start: " + bq);

    for (int i = 0; i < 5; i++)
    {
      int element = i;
      new Thread(() -> bq.put(element)).start();
      Thread.sleep(100);
      System.out.println(bq);
    }

    for (int i = 0; i < 4; i++)
    {
      new Thread(() -> bq.take()).start();
      Thread.sleep(100);
      System.out.println(bq);
    }

    System.out.println("In the end: " + bq);
  }
}
