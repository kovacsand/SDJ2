package logging;

public class Main
{
  public static void main(String[] args)
  {
    LogLevelController logLevelController = new LogLevelController(LogLevelController.LogLevel.SPARSE);
    logLevelController.log("No error");
    logLevelController.log("This does not contain the special word");

    LogLevelController logLevelController1 = new LogLevelController(LogLevelController.LogLevel.VERBOSE);
    logLevelController1.log("No error");
    logLevelController1.log("This does not contain the special word");
  }
}