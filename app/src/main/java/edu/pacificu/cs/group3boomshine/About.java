package edu.pacificu.cs.group3boomshine;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
/**
 * Creates a view for About Activity
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 5.7.2021
 */
public class About extends AppCompatActivity {
  /**
   * Loads the About page
   *
   * @param savedInstanceState - bundle object
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_about);

  }
}
