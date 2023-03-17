package IncrementDecrement;

public class Start
{
  public static void main(String[] args)
  {
    Counter counter = new Counter(-100, 100);
    CounterIncrementer counterIncrementer1 = new CounterIncrementer(counter, 200);
    CounterIncrementer counterIncrementer2 = new CounterIncrementer(counter, 200);
    CounterDecrementer counterDecrementer1 = new CounterDecrementer(counter, 200);
    CounterDecrementer counterDecrementer2 = new CounterDecrementer(counter, 200);

    Thread thread1 = new Thread(counterIncrementer1);
    Thread thread2 = new Thread(counterIncrementer2);
    Thread thread3 = new Thread(counterDecrementer1);
    Thread thread4 = new Thread(counterDecrementer2);

    thread1.setName("First incrementer");
    thread2.setName("Second decrementer");
    thread3.setName("First incrementer");
    thread4.setName("Second decrementer");

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
  }
}
