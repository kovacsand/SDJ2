package drinks;

import com.sun.security.jgss.GSSUtil;

public class BarSimulation
{
  public static void main(String[] args)
  {
    RegularBar regularBar = new RegularBar();
    System.out.println(regularBar.getDrinkTypes().length);
    System.out.println(regularBar.orderDrink(regularBar.getDrinkTypes()[0]));
    System.out.println(regularBar.orderDrink(regularBar.getDrinkTypes()[2]));
    System.out.println(regularBar.orderDrink(regularBar.getDrinkTypes()[4]));
    System.out.println(regularBar.orderDrink("Cider"));

    WineBar wineBar = new WineBar();
    System.out.println(wineBar.getDrinkTypes().length);
    System.out.println(wineBar.orderDrink("Szombat"));
    System.out.println(wineBar.orderDrink("Tuborg"));
    System.out.println(wineBar.orderDrink("Strongbow"));

  }
}
