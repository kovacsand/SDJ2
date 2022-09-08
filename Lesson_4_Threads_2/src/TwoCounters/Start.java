package TwoCounters;

public class Start
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    Thread thread1 = new Thread(new CounterIncrementer(counter, "Dooku"));
    Thread thread2 = new Thread(new CounterIncrementer(counter, "Dracula"));
    Thread thread3 = new Thread(new CounterIncrementer(counter, "Dooku"));

    thread1.start();
    thread2.start();
    thread3.start();
  }
}
