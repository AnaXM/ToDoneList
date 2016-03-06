package com.example.analia.todonelist;

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

import java.lang.reflect.Type;

import static android.widget.RelativeLayout.ALIGN_PARENT_LEFT;
import static android.widget.RelativeLayout.ALIGN_PARENT_TOP;
import static android.widget.RelativeLayout.CENTER_HORIZONTAL;


public class ToDoList extends AppCompatActivity {

    /**
     * Creating a back button
     * @param px pixel width of button dependent on device screen size
     */
    public RelativeLayout addBackButton(RelativeLayout layout, int px){
        Button backButton = new Button(this);

        backButton.setText(R.string.BackButton);

        RelativeLayout.LayoutParams b_buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        b_buttonDetails.addRule(ALIGN_PARENT_TOP);
        b_buttonDetails.addRule(ALIGN_PARENT_LEFT);
        b_buttonDetails.setMargins(25, 25, 0, 0);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        backButton.setWidth(px);
        layout.addView(backButton, b_buttonDetails);
        return layout;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout layout = new RelativeLayout(this);
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 50, r.getDisplayMetrics());

        layout = addBackButton(layout, px);
        setContentView(layout);
        /*setContentView(R.layout.activity_to_do_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

    }

}
