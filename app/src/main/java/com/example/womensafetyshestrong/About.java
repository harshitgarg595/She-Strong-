package com.example.womensafetyshestrong;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.timepicker.TimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class About extends AppCompatActivity {
    TextView textView,version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        version=findViewById(R.id.codeversion);
        textView=findViewById(R.id.date);

        version.setText(String.valueOf(BuildConfig.VERSION_NAME));

        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-mm-yyyy , hh:mm:ss.a");
        String dateTime=simpleDateFormat.format(calendar.getTime());
        textView.setText(dateTime);


    }
}
