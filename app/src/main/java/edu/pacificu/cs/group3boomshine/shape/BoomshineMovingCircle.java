package edu.pacificu.cs.group3boomshine.shape;

import edu.pacificu.cs.group3boomshine.animation.Direction;
import edu.pacificu.cs.group3boomshine.animation.Move;

/**
 * Creates a class of Moving Circles for Boomshine Game
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 4.24.2021
 */
public class BoomshineMovingCircle extends BoomshineCircle
{
  private final int xBound = 1080;
  private final int yBound = 1360;
  private int mXBound;
  private int mYBound;
  private Direction mDirection;
  /**
   * Constructor for BoomshineMovingCircle
   */
  public BoomshineMovingCircle (int x, int y)
  {
    super(x, y);
    mMovement = new Move ();
    mDirection = new Direction();
  }

  /**
   * Constructor for BoomshineMovingCircle
   *
   * @param x: x position
   * @param y: y position
   * @param radius: radius
   */
  public BoomshineMovingCircle(double x, double  y, double radius) {
    super(x, y);
    mDirection = new Direction();
    mMovement = new Move ();
    mRadius = radius;
    mMovement = new Move();
    mXBound = xBound;
    mYBound = yBound;
  }
  /**
   * determines if collision with ExpandingCircle has occurred
   *
   * @param cOther: Expanding Circle to check against
   */
  public boolean collide (BoomshineExpandingCircle cOther)
  {
    double thisX = super.getX ();
    double thisY = super.getY ();
    double thisRadius = super.getRadius ();

    double otherX = cOther.getX ();
    double otherY = cOther.getY ();
    double otherRadius = cOther.getRadius ();

    double distance = Math.sqrt (
            (thisX - otherX) * (thisX - otherX) + (thisY - otherY) * (thisY
                    - otherY));

    return distance <= thisRadius || distance <= otherRadius;

  }
  /**
   * bounces circle (reflects direction) if wall hit
   */
  public void bounce ()
  {
    if (super.getX () - mRadius <= 0 || super.getY () - mRadius <= 0
            || super.getX () + mRadius >= mXBound || super.getY () + mRadius >= mYBound)
    {
      mDirection.reflect ();
      if(super.getX () - mRadius <= 0 ){
        super.setPosition(1 + super.getX(), super.getY());
      }
      if(super.getY () - mRadius <= 0 ){
        super.setPosition(super.getX(), 1 + super.getY());
      }
      if(super.getX () + mRadius >= mXBound ){
        super.setPosition(mXBound - mRadius - 1, super.getY());
      }
      if(super.getY () + mRadius >= mYBound  ){
        super.setPosition(super.getX(), mYBound - mRadius - 1);
      }
      //animateCircle();
      //setPosition((int)mXBound - (int)mRadius - 1, (int)mYBound - (int)mRadius - 1);
    }
  }
  /**
   * gets Direction of circle
   *
   * @return mDirection
   */
  public Direction getDirection ()
  {
    return mDirection;
  }
  /**
   * sets bounding edges to bounce off of
   *
   * @param x: x bound
   * @param y: y bound
   */
  public void setBounds(int x, int y){
    mXBound = x;
    mYBound = y;
  }
}

