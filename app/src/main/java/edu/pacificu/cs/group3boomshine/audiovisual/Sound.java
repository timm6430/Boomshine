package edu.pacificu.cs.group3boomshine.audiovisual;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;

import edu.pacificu.cs.group3boomshine.R;

/**
 * Creates a Sound class
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 4.24.2021
 */
public class Sound
{
  private MediaPlayer mMediaPlayer;

  /**
   * Constructor for Sound
   *
   * @param context - file of the sound to be played
   */
  public Sound (Context context) {
    mMediaPlayer = MediaPlayer.create (context, R.raw.explosion);
  }
  /**
   * Plays the sound
   */
  public void playSound () {
    if (mMediaPlayer != null) {
      mMediaPlayer.start ();
    }
  }

  /**
   * Stops the sound
   */
  public void replaySound () {
    if (mMediaPlayer != null) {
      mMediaPlayer.seekTo (0);
    }
  }
  /**
   * Replays the sound
   */
  public boolean isPlaying () {
    boolean isPlaying = false;
    if (mMediaPlayer.isPlaying ())
    {
      isPlaying = true;
    }
    return isPlaying;
  }
}
