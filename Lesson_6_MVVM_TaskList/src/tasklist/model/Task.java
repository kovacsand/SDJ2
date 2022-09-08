package tasklist.model;

public class Task
{
  private String creator;
  private String description;
  private String dateCreated;

  public Task(String creator, String description, String dateCreated)
  {
    this.creator = creator;
    this.description = description;
    this.dateCreated = dateCreated;
  }

  public String getCreator()
  {
    return creator;
  }

  public String getDescription()
  {
    return description;
  }

  public String getDateCreated()
  {
    return dateCreated;
  }
}
