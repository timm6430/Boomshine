package edu.pacificu.cs.group3boomshine.animation;

import edu.pacificu.cs.group3boomshine.shape.BoomshineCircle;
import edu.pacificu.cs.group3boomshine.shape.BoomshineMovingCircle;
/**
 * Creates a move class
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 4.24.2021
 */
public class Move implements IMovement
{
  static final int SCALE = 5;
  final int HALF_CIRCLE = 180;
  /**
   * Moves the circle
   *
   * @param circle - a Circle object
   */
  public void move(BoomshineCircle circle)
  {
    double xCoord, yCoord;
    double radius;
    Direction direction;
    xCoord = circle.getX();
    yCoord = circle.getY();
    radius = circle.getRadius();
    circle.setPosition (xCoord, yCoord, (int) radius);
    direction = ((BoomshineMovingCircle) circle).getDirection ();
    double radians = direction.getDirection() * (Math.PI / HALF_CIRCLE);
    circle.setPosition(xCoord + Math.cos(radians) * SCALE,
            yCoord + Math.sin(radians) * SCALE);
    ((BoomshineMovingCircle) circle).bounce();
  }
}
