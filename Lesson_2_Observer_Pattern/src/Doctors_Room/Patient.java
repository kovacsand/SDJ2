package Doctors_Room;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static Doctors_Room.Main.waitingRoom;

public class Patient implements PropertyChangeListener
{
  private int ticketNumber;

  public Patient(int ticketNum)
  {
    ticketNumber = ticketNum;
    System.out.println("Patient " + ticketNum + " enters waiting room");
    waitingRoom.addPropertyChangeListener(this);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    checkNumber(evt);
  }

  private void checkNumber(PropertyChangeEvent evt)
  {
    System.out.println("Patient " + ticketNumber + " looks up");
    if ((int) evt.getNewValue() == (ticketNumber))
    {
      System.out.println("Patient " + ticketNumber + " goes to the doctor's room");
      //Should it be removed from the list like this
      //Making the waitingRoom static in main
      waitingRoom.removePropertyChangeListener(this);
    }
    else
      System.out.println("Patient " + ticketNumber + " goes back to looking at phone");

  }
}
