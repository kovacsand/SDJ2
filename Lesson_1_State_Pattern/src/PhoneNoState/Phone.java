package PhoneNoState;

public class Phone
{
  private boolean isOnSilent;
  private boolean isOnVibrate;
  private boolean isOnSound = true;
  private int currentVolume;

  public Phone() {
    this.goToSound();
    this.currentVolume = 1;
  }

  public int getVolume() {
    return this.currentVolume;
  }

  public void receiveMessage(String txt) {
    if (!this.isOnSilent) {
      if (this.isOnSound) {
        this.beepBeep();
      } else if (this.isOnVibrate) {
        this.vibrate();
      }
    }

    System.out.println("Message received:");
    System.out.println(txt);
  }

  public void receiveCall() {
    if (this.isOnSilent) {
      this.lightUpScreen();
    } else if (this.isOnSound) {
      this.playRingTone();
    } else if (this.isOnVibrate) {
      this.vibrate();
    }

  }

  public void volumeUpButton() {
    if (this.isOnSound) {
      this.turnVolumeUp();
    } else if (this.isOnVibrate) {
      this.isOnSound = true;
      this.isOnVibrate = false;
    } else if (this.isOnSilent) {
      this.isOnSilent = false;
      this.isOnSound = true;
    }

  }

  public void volumeDownButton() {
    if (this.isOnSound) {
      this.turnVolumeDown();
      if (this.currentVolume == 0) {
        this.isOnSilent = true;
        this.isOnSound = false;
      }
    } else if (this.isOnVibrate) {
      this.isOnSound = true;
      this.isOnVibrate = false;
    } else if (this.isOnSilent) {
      this.isOnSilent = false;
      this.isOnSound = true;
    }

  }

  public void goToVibrate() {
    this.isOnVibrate = true;
    this.isOnSound = false;
    this.isOnSilent = false;
  }

  public void goToSound() {
    this.isOnSilent = false;
    this.isOnSound = true;
    this.isOnVibrate = false;
  }

  public void goToSilent() {
    this.isOnSilent = true;
    this.isOnSound = false;
    this.isOnVibrate = false;
  }

  private void playRingTone() {
    System.out.println("Ring tone");
  }

  private void vibrate() {
    System.out.println("vibrate");
  }

  private void beepBeep() {
    System.out.println("Beep beep");
  }

  private void lightUpScreen() {
    System.out.println("Light up screen");
  }

  private void turnVolumeUp() {
    ++this.currentVolume;
    System.out.println("Volume up");
  }

  private void turnVolumeDown() {
    --this.currentVolume;
    System.out.println("Volume down");
  }
}
