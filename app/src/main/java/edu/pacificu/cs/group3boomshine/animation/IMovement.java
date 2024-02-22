package edu.pacificu.cs.group3boomshine.animation;

import edu.pacificu.cs.group3boomshine.shape.BoomshineCircle;

/**
 * Interface for moving the circles
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 4.24.2021
 */
public interface IMovement
{
  /**
   * Moves the circle
   *
   * @param circle - a Circle object
   */
  public void move(BoomshineCircle circle);
}
