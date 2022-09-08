package logging;

public class LogLevelController implements Logger
{
  public enum LogLevel
  {
    SPARSE, VERBOSE
  }

  private LogLevel level;
  private ConsoleLogger logger;

  public LogLevelController(LogLevel level)
  {
    logger = new ConsoleLogger();
    this.level = level;
  }

  @Override public void log(String txt)
  {
    switch (level)
    {
      case SPARSE:
        if (txt.toLowerCase().contains("error"))
          logger.log(txt);
        break;
      case VERBOSE:
        logger.log(txt);
        break;
    }
  }
}
