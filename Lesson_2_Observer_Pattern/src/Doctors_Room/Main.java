package Doctors_Room;

import java.util.ArrayList;

public class Main
{
  public static WaitingRoom waitingRoom;
  public static void main(String[] args)
  {
    waitingRoom = new WaitingRoom();
    ArrayList<Patient> patients = new ArrayList<>();

    for (int i = 0; i < 10; i++)
    {
      patients.add(new Patient(i));
    }

    new Thread(waitingRoom).start();
  }
}
