package com.example.womensafetyshestrong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
       private static int SPLASH_SCREEN=2200;
    //variables
    Animation tOPAnim,bottomAnim;
    ImageView logo;
    TextView  appName,TagLine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Animations
        tOPAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        // hooks
         logo=findViewById(R.id.logo);
         appName=findViewById(R.id.SHESTRONG);
         TagLine=findViewById(R.id.tagline);

         logo.setAnimation(tOPAnim);
         appName.setAnimation(bottomAnim);
         TagLine.setAnimation(bottomAnim);


         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent intent= new Intent(MainActivity.this,dashboard.class);
                 startActivity(intent);
                 finish();

             }
         },SPLASH_SCREEN);

    }
}
