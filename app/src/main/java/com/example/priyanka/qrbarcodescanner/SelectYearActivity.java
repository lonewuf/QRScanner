package com.example.priyanka.qrbarcodescanner;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SelectYearActivity extends AppCompatActivity {

    private static TextView yearText;
    private static TextView yearTextClick;
    private static Button btnNext;
    private static TextView mDisplayDate;
    private static DatePickerDialog.OnDateSetListener mDateSetListener;

    private static DatePicker picker;
    SharedPreferences sharedPreferences;
    private static final String myPreference = "myPref";
    private static final String savedYear = "saved_year";
    private static String yearValue;
    private static Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_year);

        sharedPreferences = getSharedPreferences(myPreference, Context.MODE_PRIVATE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.report_toolbar_admin);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SSS Village");

        init();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {

            case R.id.action_admin:
                intent = new Intent(SelectYearActivity.this, SelectYearActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_about:
                intent = new Intent(SelectYearActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void init(){
        mDisplayDate = (TextView) findViewById(R.id.change_year);
        yearText = (TextView) findViewById(R.id.year);
        btnNext = (Button) findViewById(R.id.btn_next);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearValue = yearText.getText().toString();
                if('Y' == yearValue.charAt(0)) {
                    Toast.makeText(SelectYearActivity.this, "Please Choose Year  " + yearValue, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SelectYearActivity.this, "SSS-"+yearValue, Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(savedYear, yearValue);
                    editor.commit();
                    myIntent = new Intent(SelectYearActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }
            }
        });

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        SelectYearActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                String date = year + "/" + month + "/" + day;
                String myYearText = String.valueOf(year);
                yearText.setText(myYearText);
            }
        };
    }
}
