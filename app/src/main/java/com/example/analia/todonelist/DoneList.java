package com.example.analia.todonelist;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.widget.RelativeLayout.ALIGN_PARENT_LEFT;
import static android.widget.RelativeLayout.ALIGN_PARENT_TOP;
import static android.widget.RelativeLayout.CENTER_HORIZONTAL;

public class DoneList extends AppCompatActivity {

    /**
     * Creating a back button
     * @param px pixel width of button dependent on device screen size
     */
    public RelativeLayout addBackButton(RelativeLayout layout, int px){
        Button backButton = new Button(this);
        backButton.setId(0);
        backButton.setText(R.string.BackButton);

        RelativeLayout.LayoutParams b_buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        b_buttonDetails.addRule(ALIGN_PARENT_TOP);
        b_buttonDetails.addRule(ALIGN_PARENT_LEFT);

        b_buttonDetails.setMargins(25, 25, 0, 20);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        backButton.setWidth(px);
        layout.addView(backButton, b_buttonDetails);

        TextView titles = new TextView(this);
        titles.setId(11);
        titles.setText("March 6, 2016\n - Participated Brick Hacks \n - Learned More About Android Studio");
        titles.setTextSize(25);

        RelativeLayout.LayoutParams tDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        tDetails.addRule(RelativeLayout.BELOW, backButton.getId());
        tDetails.addRule(ALIGN_PARENT_LEFT);
        tDetails.setMargins(25, 250, 0, 0);
        layout.addView(titles, tDetails);

        TextView titles2 = new TextView(this);
        titles2.setId(12);
        titles2.setText("March 5, 2016\n - Learned How to Completely \nCode an Activity in Java");
        titles2.setTextSize(25);

        RelativeLayout.LayoutParams t2Details = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        t2Details.addRule(RelativeLayout.BELOW, titles.getId());
        t2Details.addRule(ALIGN_PARENT_LEFT);
        t2Details.setMargins(25, 300, 0, 0);
        layout.addView(titles2, t2Details);

        return layout;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout layout = new RelativeLayout(this);
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 50, r.getDisplayMetrics());

        //Bundle extra = getIntent().getExtras();

        layout = addBackButton(layout, px);


        //ListView doneItems = new ListView(null); //Need to change null into something else
        // Need to look into getting infor from ToDoList Activity to display
        // The entries completed



        setContentView(layout);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

    }

}
