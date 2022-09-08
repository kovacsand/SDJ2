package robot;

public class Main
{
  public static void main(String[] args)
  {
    GameBoard gameBoard = new GameBoard();
    Robot robot = new Robot("BB8", gameBoard);
    robot.setBehaviourStrategy(new NeutralBehaviour());
    robot.move();
    robot.setBehaviourStrategy(new AggressiveBehaviour());
    robot.move();
    robot.setBehaviourStrategy(new DefensiveBehaviour());
    robot.move();
  }
}
