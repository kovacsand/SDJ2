package robot;

import java.awt.geom.Point2D;

public class NeutralBehaviour implements Behaviour
{
  @Override public int moveCommand(GameBoard board, Point2D robotLocation)
  {
    System.out.println("The robot is neutral");
    return 0;
  }
}
