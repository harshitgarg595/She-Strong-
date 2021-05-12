package com.example.womensafetyshestrong;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class dashboard extends AppCompatActivity {

    private ImageView settings;
    private CardView send;
    private CardView SOS;
    private CardView siren;
    private CardView defence;
    private CardView location;
    private CardView photo;
    private Button instagram;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        send = findViewById(R.id.send_sms);
        instagram = findViewById(R.id.insta);
        siren =findViewById(R.id.ringsiren);
        settings =findViewById(R.id.settin);
        photo=findViewById(R.id.camera);
        SOS=findViewById(R.id.sos);
        location=findViewById(R.id.maps);
        defence=findViewById(R.id.save);



        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CategoryIntent = new Intent(dashboard.this, setting.class);
                startActivity(CategoryIntent);

            }
        });



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CategoryIntent = new Intent(dashboard.this, send_sms.class);
                startActivity(CategoryIntent);
            }
        });

        SOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CategoryIntent = new Intent(dashboard.this, SOS.class);
                startActivity(CategoryIntent);

            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CategoryIntent = new Intent(dashboard.this, Maps.class);
                startActivity(CategoryIntent);
                Toast.makeText(getApplicationContext(), "Sending Location", Toast.LENGTH_LONG).show();

            }
        });

        defence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CategoryIntent = new Intent(dashboard.this,Defence.class);
                startActivity(CategoryIntent);
            }
        });




        siren.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View v) {
                i++;
                if (mediaPlayer==null) {
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.siren);
                    mediaPlayer.start();
                    Toast.makeText(getApplicationContext(), "Siren On ", Toast.LENGTH_SHORT).show();
                }
                else if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer=null;
                    Toast.makeText(getApplicationContext(), "Siren Off", Toast.LENGTH_SHORT).show();
                }
            }});

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent=new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);


                }
                catch(Exception e){
                    e.printStackTrace();
                }


            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/harshitgarg595/");
            }
        });
    }


    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    int i = 0;

    @Override
    public void onBackPressed(){
        i++;
        if (i == 1) {
            Toast.makeText(getApplicationContext(), "press back button again to exit ", Toast.LENGTH_SHORT).show();

        }
        else if (i == 2)
            super.onBackPressed();
    }



}


