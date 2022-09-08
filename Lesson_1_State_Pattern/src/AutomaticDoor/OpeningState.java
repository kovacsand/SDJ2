package AutomaticDoor;

public class OpeningState implements DoorState, Runnable
{
  private static final String STATE = "opening";
  private Thread thread;
  private Door door;

  public OpeningState(Door door)
  {
    this.door = door;
    thread = new Thread(this);
    thread.start();
  }

  @Override public void pressButton(Door door)
  {
    //What should it do here?
    //I think nothing
  }

  @Override public String getState(Door door)
  {
    return STATE;
  }

  @Override public void run()
  {
    try
    {
      thread.sleep(3000);
      door.setDoorState(new OpenState());
    }
    catch (InterruptedException e)
    {
      //Should it do anything here
    }
  }
}