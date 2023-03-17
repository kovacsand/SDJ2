package PhoneWithState;

public class TestPhone
{
  public static void main(String[] args)
  {
    Phone phone = new Phone();
    phone.receiveCall();
    System.out.println(phone.getVolume());
    phone.turnVolumeDown();
    System.out.println(phone.getVolume());
    phone.setState(new SilentState());
    phone.receiveMessage("Goodbye World");
    phone.receiveCall();
    phone.turnVolumeUp();
    System.out.println(phone.getVolume());
    phone.setState(new SoundState());
    phone.receiveCall();
  }
}
