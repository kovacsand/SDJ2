package HelloGoodbye;

public class Start
{
  public static void main(String[] args)
  {
    Thread helloPrinter = new Thread(new Hello());
    Thread goodbyePrinter = new Thread(new Goodbye());
    helloPrinter.start();
    goodbyePrinter.start();

//    Hello hello = new Hello();
//    Goodbye goodbye = new Goodbye();
//    hello.run();
//    goodbye.run();
  }
}
