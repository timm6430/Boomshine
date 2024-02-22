package edu.pacificu.cs.group3boomshine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.pacificu.cs.group3boomshine.boomshine.BoomshineView;
/**
 * Defines functionality for Main Activity
 *
 * @author Julia Crumb & Michael Timmerman
 * @version 1.0
 * @since 5.7.2021
 */
public class MainActivity extends AppCompatActivity {

    private BoomshineView mBoomshineView;
    private Button mButtonPlay;
    private Button mButtonAbout;

    /**
     * Creates the loading screen to play the game or to go the about page
     *
     * @param savedInstanceState - bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonPlay = findViewById (R.id.Play);
        mButtonAbout = findViewById (R.id.About);
    }

    /**
     * Sets BoomshineView as the contextView when the play
     * button is pressed
     *
     * @param view - bundle object
     */
    public void onPlay (View view) {
        mBoomshineView = new BoomshineView (this);
        setContentView (mBoomshineView);
    }

    /**
     * Goes to the about page when the about button is clicked
     *
     * @param view - bundle object
     */
    public void onAbout (View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}