package NumberSequence;

public class Start
{
  public static void main(String[] args) throws InterruptedException
  {
    Thread printer1 = new Thread(new Numbers(0, 25000));
    Thread printer2 = new Thread(new Numbers(25000, 50000, printer1));
    Thread printer3 = new Thread(new Numbers(50000, 75000, printer2));
    Thread printer4 = new Thread(new Numbers(75000, 100000, printer3));

    printer1.start();
    printer2.start();
    printer3.start();
    printer4.start();
  }
}
