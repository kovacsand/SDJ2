package SynchronizedList;

public class ContainerAdder implements Runnable
{
  private ListContainer listContainer;

  public ContainerAdder(ListContainer listContainer)
  {
    this.listContainer = listContainer;
  }

  @Override public void run()
  {
    for (int i = 0; i < 100000; i++)
      listContainer.add(i);
    System.out.println(listContainer.getLength());
  }
}
