package log;

public class Main
{
  public static void main(String[] args)
  {
    Log.getInstance("filename").addLog("This is my first log");
    Log.getInstance("filenameee").addLog("Can i have a second message mommyyyyy");
    Log.getInstance("filename").addLog("I cannot forgive you");
  }
}
