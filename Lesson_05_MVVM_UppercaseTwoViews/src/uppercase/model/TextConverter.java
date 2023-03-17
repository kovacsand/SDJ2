package uppercase.model;

import java.util.ArrayList;

public interface TextConverter
{
  String toUppercase(String text);

  void addLog(String log);
  ArrayList<String> getLog();
}
