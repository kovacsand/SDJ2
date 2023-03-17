package IncrementDecrement;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
  private long value, max, min;
  private Lock lock;

  public Counter(long min, long max)
  {
    this.value = 0;
    this.min = min;
    this.max = max;
    this.lock = new ReentrantLock();
  }

  public void increment() throws InterruptedException
  {
    if (lock.tryLock())
    {
      if (value >= max)
        wait();
      value++;
      System.out.println(value + ": " + Thread.currentThread().getName());
      lock.unlock();
      notifyAll();
    }
    else
    {
      //Lock is used
    }
  }

  public void decrement() throws InterruptedException
  {
    if (lock.tryLock())
    {
      if (value <= min)
        wait();
      value--;
      System.out.println(value + ": " + Thread.currentThread().getName());
      lock.unlock();
      notifyAll();
    }
    else
    {
      //Lock is used
    }
  }

  public synchronized long getValue()
  {
    return value;
  }
}
