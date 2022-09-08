package AutomaticDoor;

public class ClosingState implements DoorState, Runnable
{
  private static final String STATE = "closing";
  private Thread thread;
  private Door door;

  public ClosingState(Door door)
  {
    this.door = door;
    thread = new Thread(this);
    thread.start();
  }

  @Override public void pressButton(Door door)
  {
    thread.interrupt();
    if (thread.isInterrupted())
      door.setDoorState(new OpeningState(door));
    System.out.println("we have interrupted the closing");
  }

  @Override public String getState(Door door)
  {
    return STATE;
  }

  @Override public void run()
  {
    try
    {
      Thread.sleep(3000);
      door.setDoorState(new ClosedState());
    }
    catch (InterruptedException e)
    {
      System.out.println("interruption was successful");
    }
  }
}
