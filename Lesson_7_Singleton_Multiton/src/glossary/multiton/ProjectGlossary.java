package glossary.multiton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ProjectGlossary
{
  private static Map<String, ProjectGlossary> map = new HashMap<>();
  private String key;
  private List<GlossaryItem> items;
  private static ReentrantLock lock = new ReentrantLock();

  private ProjectGlossary(String key)
  {
    this.key = key;
    this.items = new ArrayList<>();
  }

  public static ProjectGlossary getInstance(String key)
  {
    ProjectGlossary instance = map.get(key);
    if (instance == null)
      synchronized (lock)
      {
        instance = map.get(key);
        if (instance == null)
        {
          instance = new ProjectGlossary(key);
          map.put(key, instance);
        }
      }
    return instance;
  }

  public int size()
  {
    return items.size();
  }

  public GlossaryItem[] getAll()
  {
    GlossaryItem[] array = new GlossaryItem[items.size()];
    return items.toArray(array);
  }

  public String getDefinition(String phrase)
  {
    for (GlossaryItem item : items)
    {
      if (item.getPhrase().equalsIgnoreCase(phrase))
      {
        return item.getDefinition();
      }
    }
    return null;
  }

  public void addItem(String phrase, String definition)
  {
    if (getDefinition(phrase) != null)
    {
      throw new IllegalStateException(
          "Glossary phrase already exist: " + phrase);
    }
    items.add(new GlossaryItem(phrase, definition));
  }

  public void removeItem(String phrase)
  {
    items.remove(new GlossaryItem(phrase, getDefinition(phrase)));
  }

  public String toString()
  {
    String s = "";
    if (items.size() == 0)
    {
      s += "[Empty]";
    }
    for (int i = 0; i < items.size(); i++)
    {
      s += "-" + items.get(i);
      if (i < items.size() - 1)
      {
        s += "\n";
      }
    }
    return s;
  }
}
