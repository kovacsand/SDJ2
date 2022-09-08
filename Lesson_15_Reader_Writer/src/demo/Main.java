package demo;

public class Main
{
  public static void main(String[] args)
  {
    ReadersWriters lock = new WriterPreference();

    new Thread(new Reader(lock)).start();
    new Thread(new Reader(lock)).start();
    new Thread(new Reader(lock)).start();

    new Thread(new Writer(lock)).start();
    new Thread(new Writer(lock)).start();
  }
}
