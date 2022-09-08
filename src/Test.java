import java.util.ArrayList;

public class Test
{
  public static void main(String[] args)
  {
    int szam = 3;

    System.out.println(szam);

    var list = new ArrayList<>();
    for (int i = 0; i < 10; i++)
    {
      list.add(i);
    }

    for (int i = 0; i < list.size(); i++)
    {
      System.out.println(list.get(i));
    }
  }
}
