package robot;

import java.awt.geom.Point2D;

public interface Behaviour
{
  public int moveCommand(GameBoard board, Point2D robotLocation);
}
