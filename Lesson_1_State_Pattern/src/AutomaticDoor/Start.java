package AutomaticDoor;

public class Start
{
  public static void main(String[] args)
  {
    Door door = new Door();

    //The door is closed when created
    System.out.println(door.getState());

    door.pressButton();
    //Now it's opening
    System.out.println(door.getState());
    door.pressButton();
    System.out.println(door.getState());

    //Now we wait
    try
    {
      Thread.sleep(5000);
      //It should be open now
      System.out.println(door.getState());
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    //Let's start closing it
    door.pressButton();
    System.out.println(door.getState());

    //Let's press the button while it's opening
    //door.pressButton();
    //System.out.println(door.getState() + " we want it to start opening halfway");

    //Wait for it to close
    try
    {
      Thread.sleep(5000);
      System.out.println(door.getState());
      //Is it closed now?
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

  }
}
