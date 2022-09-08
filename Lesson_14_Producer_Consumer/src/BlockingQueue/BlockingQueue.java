package BlockingQueue;

import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class BlockingQueue implements Buffer
{
  private QueueADT queue;


  public BlockingQueue(int capacity)
  {
    queue = new BoundedArrayQueue(capacity);
  }

  public String toString()
  {
    return String.format("There are %d element(s) in the queue. Maximum size is: %d\n%s", queue.size(), queue.capacity(),queue.toString());
  }

  @Override public synchronized void put(Object element)
  {
    if (element == null)
      throw new IllegalArgumentException();
    while (isFull())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    queue.enqueue(element);
    notifyAll();
  }

  @Override public synchronized Object take()
  {
    while (isEmpty())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    notifyAll();
    return queue.dequeue();
  }

  @Override public synchronized Object look()
  {
    if (isEmpty())
      return null;
    else
      return queue.first();
  }

  @Override synchronized public boolean isEmpty()
  {
    return queue.isEmpty();
  }

  @Override public synchronized boolean isFull()
  {
    return queue.isFull();
  }

  @Override public synchronized int size()
  {
    return queue.size();
  }
}