package com.example.analia.todonelist;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.speech.RecognitionListener;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.TypedValue;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.content.res.Resources;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.view.ViewGroup.PERSISTENT_ALL_CACHES;
import static android.widget.RelativeLayout.ALIGN_PARENT_LEFT;
import static android.widget.RelativeLayout.ALIGN_PARENT_RIGHT;
import static android.widget.RelativeLayout.ALIGN_PARENT_TOP;
import static android.widget.RelativeLayout.CENTER_HORIZONTAL;
import static android.widget.RelativeLayout.CENTER_VERTICAL;
import static android.widget.RelativeLayout.RIGHT_OF;


public class ToDoList extends AppCompatActivity {
    //private Button backButton = new Button(this);
    protected EditText entry;
    protected static TableLayout table;
    protected String input = "";
    protected int id = 10;
    private static final String TAG = "Message";

    /*
    ArrayList that holds all of the entries as strings
     */
    protected static ArrayList<String> doneEntries = new ArrayList<String>();

    protected static ArrayList<String> allEntries = new ArrayList<String>();

    /*
    Getter function for entries
    Just putting her just in case of how startActivityResult works
     */
    public ArrayList<String> getDoneEntries(){
        return doneEntries;
    }

    /**
     * Updates tableLayout
     * @param t current table in use
     * @return Updated Version of inputted table
     */
    private TableLayout updateTable(TableLayout t){
        TableRow.LayoutParams rowDetails = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        for(String s : allEntries){
            TableRow row = new TableRow(ToDoList.this);
            CheckBox box = new CheckBox(ToDoList.this);
            box.setText(s);
            row.addView(box, rowDetails);
            t.addView(row);
        }
        return t;
    }

    /**
     * Creating back button, addEntry button
     * @param px pixel width of button dependent on device screen size
     */
    public RelativeLayout addButtons(final RelativeLayout layout, int px){
        /* Creating the back button */
        final Button backButton = new Button(this);
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
                Intent intent = new Intent(ToDoList.this, DoneList.class);
                intent.putExtra("ToDoList", allEntries);
                finish();
            }
        });

        backButton.setWidth(px);
        layout.addView(backButton, b_buttonDetails);

        /* Creating Edit Text Field*/
        entry = new EditText(ToDoList.this);
        entry.setId(9);
        //entry.setText("Add Entry Here");
        entry.setInputType(InputType.TYPE_CLASS_TEXT);

        table = new TableLayout(this);
        final RelativeLayout.LayoutParams tableDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        tableDetails.setMargins(10, 10, 10, 0);
        tableDetails.addRule(ALIGN_PARENT_LEFT);
        //tableDetails.addRule(CENTER_VERTICAL);
        //tableDetails.addRule(CENTER_HORIZONTAL);
        tableDetails.addRule(RelativeLayout.BELOW, entry.getId());

        /* Adding Edit Text Field */
        RelativeLayout.LayoutParams entryDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        entryDetails.addRule(ALIGN_PARENT_LEFT);
        entryDetails.addRule(RelativeLayout.BELOW, backButton.getId());
        entryDetails.setMargins(25, 25, 20, 0);
        layout.addView(entry, entryDetails);

        layout.addView(table, tableDetails); // Must be here

        entry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Log.i(TAG, "NOTE: I'm in the EditView Method");
                    input = v.getText().toString();
                    entry.setText(null);
                    allEntries.add(input);
                    String message = "NOTE: Entries Size: " + allEntries.size() + "";
                    Log.i(TAG, message);

                    InputMethodManager imm = (InputMethodManager) getSystemService(ToDoList.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    //TableRow row = new TableRow(ToDoList.this);
                    final CheckBox newItem = new CheckBox(ToDoList.this);
                    newItem.setText(input); //Not really necessary but meh
                    //newItem.setClickable(true);
                    newItem.setChecked(false);
                    newItem.isClickable();

                    newItem.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.i(TAG, "NOTE: I've been clicked!");
                        }
                    });


                    newItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            Log.i(TAG, "NOTE: I'm in the method!"); //Just messages to tell me where code is
                            if(buttonView.isChecked()) {
                                Log.i(TAG, "NOTE: I'M CHECKED!"); //Just message
                                doneEntries.add(newItem.getText().toString());
                                allEntries.remove(newItem.getText().toString());
                                table.removeAllViews();
                                table = updateTable(table);
                                layout.addView(table);
                                setContentView(layout); //Need to update layout now?
                            }
                        }
                    }); //End of CheckBox onCheckedChanged method

                    table.removeAllViews();
                    table = updateTable(table);
                    setContentView(layout);

                    return true;
                }
                return false;
            }// End of onEditorAction
        });//End of setOnEditorActionListener

        /* Adding Plus Button */
        /*Button addEntry = new Button(this);
        addEntry.setText(R.string.AddEntry);
        addEntry.setTextSize(20);

        RelativeLayout.LayoutParams addEntryDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        addEntryDetails.addRule(ALIGN_PARENT_RIGHT);
        addEntryDetails.setMargins(0, 25, 25, 0);
        addEntryDetails.addRule(RelativeLayout.RIGHT_OF, entry.getId());

        addEntry.setWidth(px);

        layout.addView(addEntry, addEntryDetails); //AddEntry Button*/

        /*String date = getDateAsString();
        TextView dateDisplay = new TextView(null);
        dateDisplay.setText(date);

        RelativeLayout.LayoutParams d_display = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        d_display.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        d_display.addRule(RelativeLayout.BELOW, backButton.getId());
        d_display.setMargins(25, 25, 0, 0);
        layout.addView(dateDisplay, d_display);*/

        return layout;
    } //End of AddButtons

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
        final Calendar c = Calendar.getInstance();
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

        setContentView(layout);
        /*setContentView(R.layout.activity_to_do_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

    }

}
