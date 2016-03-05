package com.example.analia.todonelist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.content.res.Resources;

import static android.widget.RelativeLayout.*;

public class NavigationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout layout = new RelativeLayout(this);

        Button startButton = new Button(this);
        Button doneButton = new Button(this);
        Button alarmsButton = new Button(this);
        Button settingsButton = new Button(this);

        //Seems to be Getting Angry but just ignore
        startButton.setId(1);
        doneButton.setId(2);
        /*alarmsButton.setId(3);
        settingsButton.setId(4);*/

        RelativeLayout.LayoutParams s_buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        s_buttonDetails.addRule(CENTER_HORIZONTAL);

        s_buttonDetails.addRule(ALIGN_TOP);
        layout.addView(startButton, s_buttonDetails);

        //Placing Done Button underneath Start Button
        RelativeLayout.LayoutParams d_buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        d_buttonDetails.addRule(CENTER_HORIZONTAL);
        d_buttonDetails.addRule(RelativeLayout.BELOW, startButton.getId());
        layout.addView(doneButton, d_buttonDetails);

        setContentView(layout);
        /*setContentView(R.layout.activity_navigation_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
