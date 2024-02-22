package edu.pacificu.cs.group3boomshine.animation;

import edu.pacificu.cs.group3boomshine.shape.BoomshineCircle;
/**
 * Creates an expand class
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 4.24.2021
 */
public class Expand implements IMovement
{
  static final int SCALE = 2;
  /**
   * Expands the circle
   *
   * @param circle - a Circle object
   */
  public void move(BoomshineCircle circle)
  {
    double xCoord, yCoord;
    double radius;
    xCoord = circle.getX();
    yCoord = circle.getY();
    radius = circle.getRadius();
    circle.setPosition (xCoord, yCoord, (int) radius);
    radius += SCALE;
    circle.setPosition (xCoord, yCoord, (int) radius);
  }
}
