package edu.pacificu.cs.group3boomshine.shape;

/**
 * Creates a class of Circles with position and radius
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 4.24.2021
 */
public class Circle extends Shape
{
  protected double mRadius;
  public Circle(double x, double y) {
    super(x, y);
  }
  /**
   * gets circle radius
   *
   * @return Circle radius
   */
  public double getRadius ()
  {
    return mRadius;
  }

  /**
   * sets new x, y position and radius
   *
   * @param x:      new x position
   * @param y:      new y position
   * @param radius: new radius
   */
  public void setPosition (double x, double y, double radius)
  {
    super.setPosition (x, y);
    mRadius = radius;
  }
}
