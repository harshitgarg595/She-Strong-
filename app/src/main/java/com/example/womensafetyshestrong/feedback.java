package com.example.womensafetyshestrong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class feedback extends AppCompatActivity {
    private EditText name,email,data;
    public Button send;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root=db.getReference().child("users");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        name=findViewById(R.id.name1);
        email=findViewById(R.id.email1);
        data=findViewById(R.id.data1);
        send=findViewById(R.id.sent);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "SEND", Toast.LENGTH_SHORT).show();
                String name1=name.getText().toString();
                String email1=email.getText().toString();
                String data1=data.getText().toString();


                HashMap< String , String > useMap=new HashMap<>();
                useMap.put("name",name1);
                useMap.put("email",email1);
                useMap.put("data",data1);
                root.push().setValue(useMap);

            }
        });





    }
}
