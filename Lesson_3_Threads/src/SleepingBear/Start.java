package SleepingBear;

public class Start
{
  public static void main(String[] args)
  {
    Thread bearThread = new Thread(new Bear());
    PokingMan pokingMan = new PokingMan(bearThread);
    Thread pokingManThread = new Thread(pokingMan);

    bearThread.start();
    pokingManThread.start();
  }
}
