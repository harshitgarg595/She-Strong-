package com.example.womensafetyshestrong;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Defence extends AppCompatActivity {

    TextView defence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.defence);

        defence=findViewById(R.id.txt);
        defence.setPaintFlags(defence.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);

    }
}
