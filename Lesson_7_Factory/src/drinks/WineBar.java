package drinks;

public class WineBar extends Bar
{
  private String[] drinkTypes = {"Chateau Margaux", "Liebfraumilch", "Lovasi", "Irsai Oliver", "Szombat"};

  @Override protected Drink makeDrink(String name)
  {
    switch (name)
    {
      case "Chateau Margaux":
        return new Wine("Chateau Margaux", "red");
      case "Liebfraumilch":
        return new Wine("Liebfraumilch", "white");
      case "Lovasi":
        return new Wine("Lovasi", "rose");
      case "Irsai Oliver":
        return new Wine("Irsai Oliver", "white");
      case "Szombat":
        return new Wine("Szombat", "rose");
      default:
        return null;
    }
  }

  @Override public String[] getDrinkTypes()
  {
    return drinkTypes;
  }
}
