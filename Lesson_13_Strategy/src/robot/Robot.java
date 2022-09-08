package robot;

import java.awt.*;
import java.awt.geom.Point2D;

public class Robot
{
  private String name;
  private Behaviour behaviourStrategy;
  private GameBoard board;

  public Robot(String name, GameBoard board)
  {
    this.name = name;
    this.board = board;
  }

  public Behaviour getBehaviourStrategy()
  {
    System.out.println("The behaviour is: " + behaviourStrategy.getClass());
    return behaviourStrategy;
  }

  public void setBehaviourStrategy(Behaviour behaviourStrategy)
  {
    this.behaviourStrategy = behaviourStrategy;
    System.out.println("The behaviour was changed to " + behaviourStrategy.getClass());
  }

  public void move()
  {
    behaviourStrategy.moveCommand(board, new Point(2,3));
  }
}
