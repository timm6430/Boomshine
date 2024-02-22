package edu.pacificu.cs.group3boomshine.shape;

/**
 * Creates a generic Shape class
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 4.24.2021
 */
public class Shape
{
  private double mXPos;
  private double mYPos;
  /**
   * Constructor for Shape
   *
   * @param x: x position
   * @param y: y position
   */
    public Shape(double x, double y) {
      mXPos = x;
      mYPos = y;
    }

    /**
   * gets y position
   *
   * @return x position of Shape
   */
  public double getX ()
  {
    return mXPos;
  }

  /**
   * gets x position
   *
   * @return y position of Shape
   */
  public double getY ()
  {
    return mYPos;
  }

  /**
   * sets new x, y position
   *
   * @param x: new x position
   * @param y: new y position
   */
  public void setPosition (double x, double y)
  {
    mXPos = x;
    mYPos = y;
  }
}
