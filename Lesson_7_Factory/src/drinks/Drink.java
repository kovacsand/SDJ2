package drinks;

public abstract class Drink
{
  private String name;
  private String description;

  public Drink(String name, String description)
  {
    this.name = name;
    this.description = description;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String toString()
  {
    return String.format("%s: %s", getName(), getDescription());
  }
}
