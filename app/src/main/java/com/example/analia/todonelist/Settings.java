package com.example.analia.todonelist;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import static android.widget.RelativeLayout.ALIGN_PARENT_LEFT;
import static android.widget.RelativeLayout.ALIGN_PARENT_RIGHT;
import static android.widget.RelativeLayout.ALIGN_PARENT_TOP;
import static android.widget.RelativeLayout.CENTER_HORIZONTAL;
import static android.widget.RelativeLayout.CENTER_VERTICAL;

public class Settings extends AppCompatActivity {


    /**
     * Creating a back button
     * @param px pixel width of button dependent on device screen size
     */
    public RelativeLayout addButtons(RelativeLayout layout, int px, int px2){
        Button backButton = new Button(this);

        backButton.setId(1);

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

        TextView title = new TextView(Settings.this);
        RelativeLayout.LayoutParams titleDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        //titleDetails.addRule(RelativeLayout.RIGHT_OF, backButton.getId());
        titleDetails.addRule(ALIGN_PARENT_RIGHT);
        titleDetails.addRule(ALIGN_PARENT_TOP);
        //titleDetails.setMargins(25, 25, 25, 0);
        title.setWidth(px);

        layout.addView(title, titleDetails);

        TextView wantNotifs = new TextView(Settings.this);
        wantNotifs.setId(2);
        wantNotifs.setText(R.string.Notifs);
        wantNotifs.setTextSize(30);

        RelativeLayout.LayoutParams notifDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        notifDetails.addRule(CENTER_HORIZONTAL);
        notifDetails.addRule(CENTER_VERTICAL);
        notifDetails.addRule(RelativeLayout.BELOW, backButton.getId());
        notifDetails.setMargins(25, 25, 22, 0);
        wantNotifs.setWidth(px2);

        layout.addView(wantNotifs, notifDetails);

        TimePicker timeSet = new TimePicker(this);
        timeSet.setScaleX(0.75f);
        timeSet.setScaleY(0.75f);
        timeSet.setId(3);

        RelativeLayout.LayoutParams timeDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        timeDetails.addRule(CENTER_HORIZONTAL);
        //timeDetails.addRule(CENTER_VERTICAL);
        timeDetails.setMargins(25, 10, 25, 0);
        timeDetails.addRule(RelativeLayout.BELOW, wantNotifs.getId());

        layout.addView(timeSet, timeDetails);

        RadioButton rButton = new RadioButton(this);
        RelativeLayout.LayoutParams rbDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        rbDetails.addRule(RelativeLayout.BELOW, timeSet.getId());
        rbDetails.addRule(CENTER_HORIZONTAL);

        layout.addView(rButton, rbDetails);

        return layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout layout = new RelativeLayout(this);
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 50, r.getDisplayMetrics());
        int px2 = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, r.getDisplayMetrics());

        layout = addButtons(layout, px, px2);

        setContentView(layout);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

    }

}
