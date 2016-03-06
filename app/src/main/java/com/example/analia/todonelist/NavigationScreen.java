package com.example.analia.todonelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.content.res.Resources;

import static android.widget.RelativeLayout.*;

public class NavigationScreen extends AppCompatActivity {

    /* On creation Method
    * Creating Buttons & positioning them
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout layout = new RelativeLayout(this);
        Resources r = getResources();

        Button listButton = new Button(this);
        Button doneButton = new Button(this);
        Button alarmsButton = new Button(this);
        Button settingsButton = new Button(this);

        //Getting screen pixels to allow concrete formatting between different screen sizes
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());

        //Button Ids - Gets Angry But Probably Works
        listButton.setId(1);
        doneButton.setId(2);
        alarmsButton.setId(3);
        settingsButton.setId(4);

        /*
        Button Text
         */
        listButton.setText(R.string.ListButton);
        doneButton.setText(R.string.DoneText);
        alarmsButton.setText(R.string.alarmButton);
        settingsButton.setText(R.string.settingsButton);

        /*
        Button Positioning
         */
        RelativeLayout.LayoutParams l_buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        l_buttonDetails.addRule(CENTER_HORIZONTAL);
        //l_buttonDetails.addRule(CENTER_VERTICAL);
        //l_buttonDetails.addRule(ALIGN_PARENT_TOP);
        l_buttonDetails.setMargins(0,px,0,0);

        listButton.setWidth(px);
        layout.addView(listButton, l_buttonDetails);

        /* Placing Done Button underneath Start Button */
        RelativeLayout.LayoutParams d_buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        d_buttonDetails.addRule(CENTER_HORIZONTAL);
        d_buttonDetails.addRule(CENTER_VERTICAL);
        d_buttonDetails.addRule(RelativeLayout.BELOW, listButton.getId());
        doneButton.setWidth(px);
        layout.addView(doneButton, d_buttonDetails);

        /* Placing Alarms Button underneath Done Button + Formatting */
        RelativeLayout.LayoutParams a_buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        a_buttonDetails.addRule(CENTER_HORIZONTAL);
        a_buttonDetails.addRule(CENTER_VERTICAL);
        a_buttonDetails.addRule(RelativeLayout.BELOW, doneButton.getId());
        alarmsButton.setWidth(px);
        layout.addView(alarmsButton, a_buttonDetails);

        /* Placing Settings Button Underneath Alarms Button + Formatting */
        RelativeLayout.LayoutParams s_buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        s_buttonDetails.addRule(CENTER_HORIZONTAL);
        s_buttonDetails.addRule(CENTER_VERTICAL);
        s_buttonDetails.addRule(RelativeLayout.BELOW, alarmsButton.getId());
        //s_buttonDetails.setMargins(0,0,0,px);
        settingsButton.setWidth(px);
        layout.addView(settingsButton, s_buttonDetails);

        /*
        * Setting Onclick Methods
        */
        listButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toListIntent = new Intent(NavigationScreen.this, ToDoList.class);
                startActivity(toListIntent);
            }
        });

        doneButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDoneListIntent = new Intent(NavigationScreen.this, DoneList.class);
                startActivity(toDoneListIntent);
            }
        });

        alarmsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAlarmIntent = new Intent(NavigationScreen.this, Alarm.class);
                startActivity(toAlarmIntent);
            }
        });

        settingsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSettingsIntent = new Intent(NavigationScreen.this, Settings.class);
                startActivity(toSettingsIntent);
            }
        });


        setContentView(layout);

    }

}
