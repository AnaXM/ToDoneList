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
import android.widget.TextView;

import org.w3c.dom.Text;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

import static android.widget.RelativeLayout.ALIGN_PARENT_LEFT;
import static android.widget.RelativeLayout.ALIGN_PARENT_RIGHT;
import static android.widget.RelativeLayout.ALIGN_PARENT_TOP;
import static android.widget.RelativeLayout.CENTER_HORIZONTAL;
import static android.widget.RelativeLayout.RIGHT_OF;


public class ToDoList extends AppCompatActivity {
    //private Button backButton = new Button(this);

    /**
     * Creating a back button
     * @param px pixel width of button dependent on device screen size
     */
    public RelativeLayout addButtons(RelativeLayout layout, int px){
        /* Creating the back button */
        Button backButton = new Button(this);
        backButton.setText(R.string.BackButton);

        //Ignore red squigglies
        backButton.setId(10);

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

        /* Adding Plus Button */
        Button addEntry = new Button(this);
        addEntry.setText(R.string.AddEntry);
        addEntry.setTextSize(20);

        RelativeLayout.LayoutParams entryDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        //entryDetails.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, backButton.getId());
        //entryDetails.addRule(ALIGN_PARENT_LEFT);
        entryDetails.addRule(ALIGN_PARENT_TOP);
        entryDetails.addRule(ALIGN_PARENT_RIGHT);
        entryDetails.setMargins(0, 25, 25, 0);
        //entryDetails.addRule(RelativeLayout.RIGHT_OF, backButton.getId());

        addEntry.setWidth(px);

        /*addEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add Checkable Entries
            }
        });*/


        layout.addView(addEntry, entryDetails);

        return layout;
    }

    private String monthToString(int month){
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December"};
        return months[month - 1];
    }

    private String dayToString(int day){
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday",
                                "Thursday", "Friday", "Saturday"};
        return daysOfWeek[day];
    }

    private String getDateAsString(){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int dayOMth = c.get(Calendar.DAY_OF_MONTH);
        int dayOWk = c.get(Calendar.DAY_OF_WEEK);
        String monthStr = monthToString(month);
        String dayOfWeek = dayToString(dayOWk);

        return (dayOfWeek + ", " + monthStr + dayOMth + ", " + year);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout layout = new RelativeLayout(this);
        //RelativeLayout layout = (RelativeLayout)findViewById(R.id.todoListLayout);

        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 50, r.getDisplayMetrics());

        layout = addButtons(layout, px);


        /*String date = getDateAsString();
        TextView dateDisplay = new TextView(null);
        dateDisplay.setText(date);

        RelativeLayout.LayoutParams d_display = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        d_display.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        d_display.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        d_display.setMargins(0, 25, 25, 0);
        layout.addView(dateDisplay, d_display);*/

        setContentView(layout);
        /*setContentView(R.layout.activity_to_do_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

    }

}
