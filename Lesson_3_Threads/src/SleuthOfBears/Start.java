package SleuthOfBears;

public class Start
{
  public static BearList bearList;

  public static void main(String[] args)
  {
    bearList = new BearList();
    for (int i = 0; i < 7; i++)
    {
      Bear bear = new Bear();
      bearList.addBear(bear);
      bearList.getBearThreads().get(bearList.getSize()-1).start();
    }
    PokingMan pokingMan = new PokingMan(bearList.getBearThreads().get(6));
    Thread pokingManThread = new Thread(pokingMan);

    pokingManThread.start();
  }
}
