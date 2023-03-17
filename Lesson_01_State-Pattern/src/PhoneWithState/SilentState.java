package PhoneWithState;

public class SilentState implements PhoneState
{
  @Override public void onReceiveMessage(String txt, Phone phone)
  {
    System.out.println("Message received:");
    System.out.println(txt);
  }

  @Override public void onReceiveCall(Phone phone)
  {
    System.out.println("Light up screen");
  }

  @Override public void onVolumeButtonUp(Phone phone)
  {
    phone.turnVolumeUp();
    phone.setState(new SoundState());
  }

  @Override public void onVolumeButtonDown(Phone phone)
  {
    //This doesn't really make sense, but it is what was written in the NoState example
    //phone.setState(new SoundState());
    //This makes a lot more sense
    phone.setState(new SilentState());
  }
}
