package edu.pacificu.cs.group3boomshine.boomshine;
/**
 * Creates Boomshine game logic
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 5.7.2021
 */
public class Boomshine {
    private final int MAXLEVELATTEMPTS = 3;
    private int mLevel;
    private int mScore;
    private int mLevelScore;
    private int mLevelAttempts;

    /**
     * Constructor for Boomshine
     */
    public Boomshine() {
        mLevel = 1;
        mScore = 0;
        mLevelScore = 0;
        mLevelAttempts = 0;
    }

    /**
     * Checks to see if player passed the level
     *
     * @return - true if the player passed the level;
     * otherwise return false
     */
    public boolean passLevel() {
        if (mLevelScore >= mLevel) {
            mScore += mLevelScore;
            mLevel++;
            mLevelAttempts = 0;
            return true;
        }
        mLevelScore = 0;
        mLevelAttempts++;
        if (mLevelAttempts == MAXLEVELATTEMPTS) {
            mLevel = 1;
            mScore = 0;
        }
        return false;
    }

    /**
     * Get the level
     *
     * @return - the level
     */
    public int getLevel() {
        return mLevel;
    }

    /**
     * Get the score
     *
     * @return - the score
     */
    public int getScore() {
        return mScore;
    }

    /**
     * Get the level score
     *
     * @return - current level score
     */
    public int getLevelScore() {
        return mLevelScore;
    }

    /**
     * sets level score
     */
    public void setLevelScore(int levelScore) {
        mLevelScore = levelScore;
    }
}
