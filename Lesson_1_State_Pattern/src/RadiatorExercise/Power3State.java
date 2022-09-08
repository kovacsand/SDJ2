package RadiatorExercise;

public class Power3State implements RadiatorState
{
  private static final int POWER = 3;

  Power3State(Radiator radiator)
  {
    new Thread(() -> {
      try
      {
        Thread.sleep(2000);
        turnDown(radiator);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }).start();
  }

  @Override public void turnUp(Radiator radiator)
  {
    //DO NOTHING
  }

  @Override public void turnDown(Radiator radiator)
  {
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
