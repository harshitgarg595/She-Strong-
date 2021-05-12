package com.example.womensafetyshestrong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class send_sms extends AppCompatActivity {
    private EditText EditTextNumber;
    private EditText EditTextMessage;
    private Button pickNumber;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        ActivityCompat.requestPermissions(send_sms.this, new String[]
                {Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);
        EditTextNumber = findViewById(R.id.mobile);
        EditTextMessage = findViewById(R.id.text);
        pickNumber = findViewById(R.id.contacts);
        btn_send = findViewById(R.id.sent);


        btn_send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                {
                    String phoneNumber = EditTextNumber.getText().toString().trim();
                    String message = EditTextMessage.getText().toString();
                    SmsManager sc = SmsManager.getDefault();

                    sc.sendTextMessage(phoneNumber, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_SHORT).show();



                }
            }
        });
        pickNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_INSERT_OR_EDIT);
                i.setType(ContactsContract.Contacts.CONTENT_ITEM_TYPE);

                startActivityForResult(i, 111);
            }
        });




    }
}