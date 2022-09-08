package AutomaticDoor;

public class Door
{
  private DoorState currentState;

  public Door()
  {
    setDoorState(new ClosedState());
  }

  public void pressButton()
  {
    currentState.pressButton(this);
  }

  void setDoorState(DoorState state)
  {
    currentState = state;
  }

  public String getState()
  {
    return String.format("The door is %s.", currentState.getState(this));
  }
}