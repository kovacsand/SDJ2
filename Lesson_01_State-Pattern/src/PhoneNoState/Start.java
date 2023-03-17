package PhoneNoState;

public class Start
{
  public Start() {
  }

  public static void main(String[] args) {
    Phone phone = new Phone();
    phone.volumeUpButton();
    phone.receiveCall();
    phone.volumeDownButton();
    phone.receiveCall();
    phone.volumeDownButton();
    phone.receiveCall();
    phone.goToVibrate();
    phone.receiveCall();
  }
}
