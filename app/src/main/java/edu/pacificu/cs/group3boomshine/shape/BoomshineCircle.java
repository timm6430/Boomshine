package edu.pacificu.cs.group3boomshine.shape;

import edu.pacificu.cs.group3boomshine.animation.IMovement;
import edu.pacificu.cs.group3boomshine.audiovisual.Sound;

/**
 * Creates a class of Boomshine Circles to add movement and animation for
 * Boomshine game
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 4.24.2021
 */
public class BoomshineCircle extends Circle {
    protected IMovement mMovement;
    private Sound mcSound;
    private int mColor;

    /**
     * BoomshineCircle constructor
     *
     * @param x: x position
     * @param y: y position
     */
    public BoomshineCircle(double x, double y) {
        super(x, y);
        mColor = ((int) (Math.random() * 16777215)) | (0xFF << 24);
    }

    /**
     * moves or expands circle based on mMovement
     */
    public void animateCircle() {
        mMovement.move(this);
    }

    /**
     * gets Circle's color
     *
     * @return mcColor
     */
    public int getColor() {
        return mColor;
    }
}
