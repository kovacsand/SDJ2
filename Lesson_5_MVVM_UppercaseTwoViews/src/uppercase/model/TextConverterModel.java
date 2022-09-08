package uppercase.model;

import java.util.ArrayList;

public class TextConverterModel implements TextConverter
{
  private ArrayList<String> list;

  public TextConverterModel()
  {
    list = new ArrayList<>();
  }

  @Override public String toUppercase(String text)
  {
    addLog(text);
    return text.toUpperCase();
  }

  @Override public void addLog(String log)
  {
    list.add(log);
  }

  public ArrayList<String> getLog()
  {
    return list;
  }

  public int getLogSize()
  {
    return list.size();
  }
}
