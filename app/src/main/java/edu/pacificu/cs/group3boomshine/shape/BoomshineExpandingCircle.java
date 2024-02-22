package edu.pacificu.cs.group3boomshine.shape;

import edu.pacificu.cs.group3boomshine.animation.Expand;
import edu.pacificu.cs.group3boomshine.animation.Shrink;

/**
 * Creates a class of Expading Circles for Boomshine game
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 4.24.2021
 */
public class BoomshineExpandingCircle extends BoomshineCircle
{
  /**
   * Constructor for BoomshineExpandingCircle
   */
  public BoomshineExpandingCircle(double x, double y) {
    super(x, y);
    mMovement = new Expand ();
  }
  /**
   * BoomshineExpandingCircle constructor
   *
   * @param x: x position
   * @param y: y position
   * @param radius: radius
   */
  public BoomshineExpandingCircle(double x, double y, double radius) {
    super(x, y);
    mRadius = radius;
    mMovement = new Expand ();
  }
  /**
   * Sets movement to shrink
   */
  public void setShrink() {
    mMovement = new Shrink();
  }
}
