package SharedCounter;

public class Start
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    Thread thread = new Thread(new CounterIncrementer(counter));
    Thread thread1 = new Thread(new CounterIncrementer(counter));

    thread.start();
    thread1.start();
  }
}
