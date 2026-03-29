package com.example.pz19valovpr23101;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.ref.Cleaner;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView timePick;
    Button btnTime, btnDate;
    Calendar dateAndTime = Calendar.getInstance();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePick = findViewById(R.id.tvDate);
        btnDate = findViewById(R.id.show_date_1);
        btnTime = findViewById(R.id.show_date_2);

        setInitialDateTime();
    }
    private void setInitialDateTime(){
        timePick.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                    | DateUtils.FORMAT_SHOW_TIME));
    }
    public void onClick(View view){
        int id = view.getId();
        if (id == R.id.show_date_1) {
            new DatePickerDialog(MainActivity.this, d,
                    dateAndTime.get(Calendar.YEAR),
                    dateAndTime.get(Calendar.MONTH),
                    dateAndTime.get(Calendar.DAY_OF_MONTH))
                    .show();
        } else if (id == R.id.show_date_2) {
            new TimePickerDialog(MainActivity.this, t,
                    dateAndTime.get(Calendar.HOUR_OF_DAY),
                    dateAndTime.get(Calendar.MINUTE), true)
                    .show();
        }
    }
    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }
    };
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener(){
      @Override
      public void onDateSet(DatePicker view, int year, int mouthOfYear, int dayOFMonth){
        dateAndTime.set(Calendar.YEAR, year);
        dateAndTime.set(Calendar.MONTH, mouthOfYear);
        dateAndTime.set(Calendar.DAY_OF_MONTH, dayOFMonth);
        setInitialDateTime();
      }
    };
}