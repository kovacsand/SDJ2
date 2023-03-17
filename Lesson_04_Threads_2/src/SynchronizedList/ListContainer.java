package SynchronizedList;

import java.util.ArrayList;

public class ListContainer
{
  private ArrayList<Integer> list = new ArrayList<>();

  public synchronized void add(int i)
  {
    list.add(i);
  }

  public synchronized int getLength()
  {
    return list.size();
  }
}
