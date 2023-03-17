package drinks;

public class Wine extends Drink
{
  public static final String RED = "red";
  public static final String WHITE = "white";
  public static final String ROSE = "rose";

  private String type;

  private static String getWineDescription(String type)
  {
    return (type == RED) ? "Fruity taste, good with meats" :
        (type == WHITE) ? "You have to trust your friends" : "For summer";
  }

  public Wine(String name, String type)
  {
    super(name, Wine.getWineDescription(type));
    this.type = type;
  }
}
