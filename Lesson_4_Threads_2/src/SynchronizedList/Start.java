package SynchronizedList;

public class Start
{
  public static void main(String[] args)
  {
    ListContainer listContainer = new ListContainer();
    Thread thread1 = new Thread(new ContainerAdder(listContainer));
    Thread thread2 = new Thread(new ContainerAdder(listContainer));

    thread1.start();
    thread2.start();
  }
}
