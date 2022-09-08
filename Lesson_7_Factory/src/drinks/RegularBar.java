package drinks;

public class RegularBar extends Bar
{
  private String[] drinkTypes = {"Tuborg", "Kobanyai", "Chateau Margaux", "Liebfraumilch", "Lovasi"};

  @Override protected Drink makeDrink(String name)
  {
    switch (name)
    {
      case "Tuborg":
      case "Kobanyai":
        return new Beer(name);
      case "Chateau Margaux":
        return new Wine("Chateau Margaux", "red");
      case "Liebfraumilch":
        return new Wine("Liebfraumilch", "white");
      case "Lovasi":
        return new Wine("Lovasi", "rose");
      default:
        return null;
    }

  }

  @Override public String[] getDrinkTypes()
  {
    return drinkTypes;
  }
}
