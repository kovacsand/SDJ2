package AutomaticDoor;

public class ClosedState implements DoorState
{
  private static final String STATE = "closed";

  @Override public void pressButton(Door door)
  {
    door.setDoorState(new OpeningState(door));
  }

  @Override public String getState(Door door)
  {
    return STATE;
  }
}
