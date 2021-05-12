package com.example.womensafetyshestrong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class setting extends AppCompatActivity {
    private Button feed,us;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        feed=findViewById(R.id.feedback);
        us=findViewById(R.id.about);

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CategoryIntent = new Intent(setting.this, feedback.class);
                startActivity(CategoryIntent);
            }
        });
        us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CategoryIntent = new Intent(setting.this, About.class);
                startActivity(CategoryIntent);

            }
        });


    }}