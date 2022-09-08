package Traffic_Light;

public class SleepyDriver implements LightObserver
{
  private String previousLight;
  private int id;

  public SleepyDriver(int id)
  {
    this.id = id;
  }

  @Override public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight))
      System.out.println("Car " + id + " starts engine and drives");
    else if ("YELLOW".equals(currentLight))
    {
      if ("RED".equals(previousLight))
        System.out.println("Car " + id + " doesn't do anything");
      else
        System.out.println("Car " + id + " slows down");
    }
    else if ("RED".equals(currentLight))
      System.out.println("Car " + id + " stops");
    previousLight = currentLight;
  }
}
