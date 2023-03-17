package AutomaticDoor;

public interface DoorState
{
  void pressButton(Door door);

  String getState(Door door);
}
