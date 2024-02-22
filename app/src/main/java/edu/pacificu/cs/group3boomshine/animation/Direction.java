package edu.pacificu.cs.group3boomshine.animation;

import java.util.Random;

/**
 * Creates a Direction class for the circles
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 4.24.2021
 */
public class Direction {
    private final double CIRCLE = 360;
    private final int RIGHT_ANGLE = 90;
    private final int RANDOM_INT = 120;
    private Random RANDOM = new Random(System.currentTimeMillis());
    private double mDegree;

    /**
     * Constructor for Direction
     */
    public Direction() {
        mDegree = RANDOM.nextInt(359);
    }

    /**
     * Constructor for Direction
     *
     * @param degree - direction of teh circle
     */
    public Direction(double degree) {
        mDegree = degree;
    }

    /**
     * Flip the direction 180 degrees
     */
    public void reflect() {
        Random random = new Random(System.currentTimeMillis());
        double reflect = RIGHT_ANGLE + random.nextInt(RANDOM_INT);
        mDegree += reflect;
        mDegree = mDegree % CIRCLE;
    }

    /**
     * Get the direction
     *
     * @return - the direction
     */
    public double getDirection() {
        return mDegree;
    }
}
