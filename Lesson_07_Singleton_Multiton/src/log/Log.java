package log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Log
{
  //Singleton implementation
  //private static Log instance;

  //Multiton implementation
  private static Map<String, Log> map = new HashMap<>();
  private String key;

  private ArrayList<LogLine> logLines;
  private static ReentrantLock lock = new ReentrantLock();

  private Log(String key)
  {
    this.key = key;
    logLines = new ArrayList<>();
  }

  //  Singleton implementation
  //  public static Log getInstance()
  //  {
  //    if (instance == null)
  //      synchronized(lock)
  //      {
  //        if (instance == null)
  //          instance = new Log();
  //      }
  //    return instance;
  //  }

  //  Multiton implementation
  public static Log getInstance(String key)
  {
    Log instance = map.get(key);
    if (instance == null)
    {
      synchronized (lock)
      {
        instance = map.get(key);
        if (instance == null)
        {
          instance = new Log(key);
          map.put(key, instance);
        }
      }
    }
    return instance;
  }

  public void addLog(String text)
  {
    LogLine logLine = new LogLine(text);
    logLines.add(logLine);
    addToFile(logLine);
    System.out.println(logLine);
  }

  public String toString()
  {
    String str = "";
    for (int i = 0; i < logLines.size(); i++)
      str += "\n" + logLines.get(i);
    return str;
  }

  private void addToFile(LogLine log)
  {
    if (log == null)
    {
      return;
    }
    BufferedWriter out = null;
    try
    {
      //Singleton implementation
      //String filename = "Log-" + log.getDateTime().getSortableDate() + ".txt";
      String filename = key;
      out = new BufferedWriter(new FileWriter(filename, true));
      out.write(log + "\n");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}
