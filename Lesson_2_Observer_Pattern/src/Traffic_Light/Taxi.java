package Traffic_Light;

public class Taxi implements LightObserver
{
  private int id;

  public Taxi(int id)
  {
    this.id = id;
  }

  @Override public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight))
      System.out.println("Car " + id + " drives");
    else if ("RED".equals(currentLight))
      System.out.println("Car " + id + " stops");
  }
}
