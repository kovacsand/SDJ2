package Traffic_Light;

public class Pedestrian implements LightObserver
{
  private String previousLight;
  private int id;

  public Pedestrian(int id)
  {
    this.id = id;
  }

  @Override public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight))
      System.out.println("Car (Pedestrian) " + id + " waits");
    else if ("YELLOW".equals(currentLight))
    {
      //These two should be the other way around, but it was like this in the exercise
      if ("RED".equals(previousLight))
        System.out.println("Car (Pedestrian) " + id + " gets ready to cross");
      else
        System.out.println("Car (Pedestrian) " + id + " runs faster across the road");
    }
    else if ("RED".equals(currentLight))
      System.out.println("Car (Pedestrian) " + id + " crosses the road");
    previousLight = currentLight;
  }
}
