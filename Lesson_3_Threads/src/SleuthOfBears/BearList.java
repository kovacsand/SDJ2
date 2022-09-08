package SleuthOfBears;

import java.util.ArrayList;

public class BearList
{
  private ArrayList<Thread> bearThreads;

  public BearList()
  {
    bearThreads = new ArrayList<>();
  }

  public void addBear(Bear bear)
  {
    bearThreads.add(new Thread(bear));
  }

  public ArrayList<Thread> getBearThreads()
  {
    return bearThreads;
  }

  public int getSize()
  {
    return bearThreads.size();
  }
}
