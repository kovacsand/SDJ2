package RadiatorExercise;

public class Start
{
  public static void main(String[] args) throws InterruptedException
  {
    Radiator radiator = new Radiator();

    System.out.println(radiator.getPower());
    radiator.turnUp();
    System.out.println(radiator.getPower());
    radiator.turnUp();
    System.out.println(radiator.getPower());
    radiator.turnUp();
    System.out.println(radiator.getPower());
    radiator.turnUp();
    System.out.println(radiator.getPower());
    Thread.sleep(500);
    radiator.turnDown();
    radiator.turnUp();
    Thread.sleep(500);
    System.out.println(radiator.getPower());
    Thread.sleep(1000);
    System.out.println(radiator.getPower());
  }
}
