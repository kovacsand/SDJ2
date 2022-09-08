package RadiatorExercise;

public interface RadiatorState
{
  void turnUp(Radiator radiator);

  void turnDown(Radiator radiator);

  int getPower();
}
