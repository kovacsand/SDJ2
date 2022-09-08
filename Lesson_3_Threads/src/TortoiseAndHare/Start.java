package TortoiseAndHare;

public class Start
{
  public static void main(String[] args)
  {
    Tortoise tortoise = new Tortoise();
    Hare hare = new Hare(tortoise);
    new Thread(tortoise).start();
    new Thread(hare).start();
  }
}
