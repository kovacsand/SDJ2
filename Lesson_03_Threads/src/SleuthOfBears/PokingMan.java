package SleuthOfBears;

public class PokingMan implements Runnable
{
  private Thread bearThread;

  public PokingMan(Thread bearThread)
  {
    this.bearThread = bearThread;
  }

  @Override public void run()
  {
    System.out.println("Ohh a shiny bear!");
    bearThread.interrupt();
    System.out.println("Aaaaaaaa");
  }
}
