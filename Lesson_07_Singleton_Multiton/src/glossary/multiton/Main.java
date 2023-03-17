package glossary.multiton;

public class Main
{
  public static void main(String[] args)
  {
    Project project1 = new Project("Project 1", "dk");
    project1.addGlossaryItem("Client", "Theclient part of a TimeStamp.client/server application.");
    project1.addGlossaryItem("User","End user in form of a doctor or a nurse.");
    project1.addGlossaryItem("Account","A location on the server application storing username, password and phone number.");
    System.out.println("Project 1: Definition for Client: " + project1.getDefinition("Client"));
    System.out.println(project1);
  }
}
