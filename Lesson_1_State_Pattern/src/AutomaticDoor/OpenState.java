package AutomaticDoor;

public class OpenState implements DoorState
{
  private static final String STATE = "open";

  @Override public void pressButton(Door door)
  {
    door.setDoorState(new ClosingState(door));
  }

  @Override public String getState(Door door)
  {
    return STATE;
  }
}
