package TwoCounters;

public class CounterIncrementer implements Runnable
{
  private Counter counter;
  private String whichCount;

  public CounterIncrementer(Counter counter, String whichCount)
  {
    this.counter = counter;
    this.whichCount = whichCount;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000000; i++)
      if (whichCount.contains("Dooku"))
        counter.incrementCountDooku();
      else
        counter.incrementCountDracula();
    if (whichCount.contains("Dooku"))
      System.out.println(counter.getCountDooku());
    else
      System.out.println(counter.getCountDracula());
  }
}
