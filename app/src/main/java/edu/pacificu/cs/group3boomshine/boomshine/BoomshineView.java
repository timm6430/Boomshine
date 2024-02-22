package edu.pacificu.cs.group3boomshine.boomshine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

import edu.pacificu.cs.group3boomshine.MainActivity;
import edu.pacificu.cs.group3boomshine.audiovisual.Sound;
import edu.pacificu.cs.group3boomshine.shape.BoomshineExpandingCircle;
import edu.pacificu.cs.group3boomshine.shape.BoomshineMovingCircle;
/**
 * Creates a view for Boomshine game
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 5.7.2021
 */
public class BoomshineView extends View {
  private final int DOUBLE = 2;
  private final int CIRCLE_RADIUS = 30;
  private final int EXPANDING_RADIUS = 250;
  private final int MULTIPLER = 10;
  private final int BOUND = 1000;
  private final double LEVEL_DIFFICULTY_INCREASER = 0.2;
  private final int FONT_SIZE = 44;
  private final int RIGHT_SIDE_SCREEN = 1450;
  private final int GAME_BAR_SIZE = 200;
  private final int LEVEL_DIFFICULTY = 3;

  private MainActivity mMainActivity;
  private Boomshine mBoomshine;
  private Sound mSound;

  private boolean mbPlayed = false;
  private boolean mbSetLevelCircles = false;
  private double mDifficultyLevel = 1;
  private int mNumLevelCircles = 0;
  private int mLevelScore = 0;

  private ArrayList<BoomshineMovingCircle> macMoving =
          new ArrayList<BoomshineMovingCircle> ();
  private ArrayList<BoomshineExpandingCircle> macExpanding =
          new ArrayList<BoomshineExpandingCircle> ();

  private Paint mBackground = new Paint ();
  private Paint mStatBar = new Paint ();
  private Paint mStatText = new Paint ();

  /**
   * Constructor for BoomshineView
   *
   * @param context - mainActivity context
   *
   */
  public BoomshineView (Context context) {
    super (context);
    setFocusable (true);
    this.mMainActivity = (MainActivity) context;
    mBoomshine = new Boomshine ();
    mSound = new Sound (context);
    mNumLevelCircles = mBoomshine.getLevel () * DOUBLE;
  }

  /**
   * Draws the game
   *
   * @param canvas - canvas to render
   */
  @Override
  protected void onDraw (Canvas canvas) {
    if (!mbSetLevelCircles) {
      setLevelMovingCircles (mNumLevelCircles);
      mbSetLevelCircles = true;
    }
    drawGameBar (canvas, mNumLevelCircles);


    mBackground.setStyle (Paint.Style.FILL);
    mBackground.setColor (Color.CYAN);

    for (int i = 0; i < macMoving.size (); i++) {
      mBackground.setColor (macMoving.get(i).getColor());
      macMoving.get (i).animateCircle ();
      canvas.drawCircle ((float)macMoving.get (i).getX (), (float)macMoving.get (i).getY (),
              (float) macMoving.get (i).getRadius (), mBackground);
      invalidate ();
    }
    if (macExpanding.size () > 0) {
      for (int i = 0; i < macMoving.size (); i++) {
        for (int j = 0; j < macExpanding.size (); j++) {
          if (macMoving.get (i).collide (macExpanding.get (j))) {
            mLevelScore++;
            BoomshineExpandingCircle newExpand = new BoomshineExpandingCircle
                    (macMoving.get (i).getX (), macMoving.get (i).getY (),
                            macMoving.get (i).getRadius ());
            macExpanding.add (newExpand);
            macMoving.remove (i);
            if (mSound.isPlaying()) {
              mSound.replaySound ();
            }
            mSound.playSound ();
            if (i > 0) {
              i--;
            }
            break;
          }
        }
      }
    }
    else if (mbPlayed) {
      mBoomshine.setLevelScore (mLevelScore);
      mBoomshine.passLevel ();
      mNumLevelCircles = mBoomshine.getLevel () * DOUBLE;
      setLevelMovingCircles (mNumLevelCircles);
      //setBounds(this.getWidth(), this.getHeight ());
      increaseDifficulty ();
      invalidate ();
      mbPlayed = false;
      mLevelScore = 0;
    }

    for(int j = 0; j < macExpanding.size(); j++) {
      macExpanding.get(j).animateCircle();
      canvas.drawCircle((float)macExpanding.get(j).getX(), (float)macExpanding.get(j).getY(),
              (float) macExpanding.get(j).getRadius(), mBackground);
      invalidate ();
      if (macExpanding.get(j).getRadius () > (EXPANDING_RADIUS -
              mBoomshine.getLevel() * MULTIPLER)) { macExpanding.get(j).setShrink();
      }
      if(macExpanding.get(j).getRadius() <= 0) {
        macExpanding.remove(j);
      }
    }
  }

  /**
   * Handles click event from user. Creates an expanding circle
   *
   * @param event - mouse click from user
   */
  public boolean onTouchEvent (MotionEvent event) {
    if (event.getAction () != MotionEvent.ACTION_DOWN) {
      return super.onTouchEvent (event);
    }
    int xCoordinate = (int) event.getX ();
    int yCoordinate = (int) event.getY ();
    macExpanding.add(new BoomshineExpandingCircle(xCoordinate, yCoordinate, CIRCLE_RADIUS));
    mbPlayed = true;
    return true;
  }

  /**
   * Sets the number of moving circles for that level
   *
   * @param numOfCircles - number of circles
   */
  private void setLevelMovingCircles (int numOfCircles) {
    Random random = new Random ();
    macMoving.clear ();
    if (numOfCircles != macMoving.size ()) {
      for (int i = 0; i < numOfCircles; ++i) {
        int x = CIRCLE_RADIUS - mBoomshine.getLevel() + random.nextInt (BOUND);
        int y = CIRCLE_RADIUS - mBoomshine.getLevel() + random.nextInt (BOUND);
        macMoving.add (new BoomshineMovingCircle (x, y,
                CIRCLE_RADIUS - mBoomshine.getLevel()));
      }
    }
  }

  /**
   * Draws the game stats at the bottom of the screen
   *
   * @param canvas       - canvas to render
   * @param numOfCircles - number of circles
   */
  private void drawGameBar (Canvas canvas, int numOfCircles) {
    mStatBar.setStyle (Paint.Style.FILL);
    mStatBar.setColor (Color.BLACK);
    canvas.drawRect (0, this.getBottom() - GAME_BAR_SIZE, RIGHT_SIDE_SCREEN,
            this.getBottom(), mStatBar);
    mStatText.setStyle (Paint.Style.FILL);
    mStatText.setColor (Color.WHITE);
    mStatText.setTextSize (FONT_SIZE);

    mStatText.setTextAlign (Paint.Align.LEFT);

    canvas.drawText (" Catch " + mBoomshine.getLevel () + " of " + numOfCircles
            + " Balls " + "\t\t You Got: " + mLevelScore  +
            "\t\t Level: " + mBoomshine.getLevel () + "\t\t Score: " +
            mBoomshine.getScore (), 0, RIGHT_SIDE_SCREEN, mStatText);
  }

  /**
   * Increases the difficulty by decreasing the expanding circle
   * radius every 3 level
   *
   */
  private void increaseDifficulty () {
    if (mBoomshine.getLevel () % LEVEL_DIFFICULTY == 0)
    {
      mDifficultyLevel += LEVEL_DIFFICULTY_INCREASER;
    }
  }
  /**
   * Handles when the phone gets rotated. Keeps rectangle proportional.
   *
   * @param viewWidth     - new screen width size
   * @param viewHeight    - new screen height size
   * @param oldViewWidth  - old screen width size
   * @param oldViewHeight - old screen height size
   */
  @Override
  protected void onSizeChanged(int viewWidth, int viewHeight,int oldViewWidth, int oldViewHeight) {
    super.onSizeChanged(viewWidth, viewHeight,oldViewWidth, oldViewHeight);
    for(int i = 0; i < macMoving.size(); ++i) {
      setBounds(viewWidth, viewHeight);
    }
  }

  /**
   * Set the the width and height bounds
   *
   * @param x - width of the board
   * @param y - height of the board
   */
  private void setBounds(int x, int y){
    for(int i = 0; i < macMoving.size(); ++i){
      macMoving.get(i).setBounds(x, y - 300);
    }
  }
}


