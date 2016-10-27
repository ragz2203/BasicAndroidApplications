package com.ragz.benchmarkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.provider.Telephony.Sms;

public class MessageActivity extends AppCompatActivity {

    private EditText etPhone;
    private EditText etMessage;
    private Button sendButton;

    SmsManager smsMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        etPhone=(EditText)findViewById(R.id.etPhone);
        etMessage=(EditText)findViewById(R.id.etContent);
        sendButton=(Button)findViewById(R.id.btnSend);



        sendButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                sendMessage();
            }
        });

    }


    public void sendMessage(){
        String phone = etPhone.getText().toString();
        String message= etMessage.getText().toString();

        try{
            smsMgr=SmsManager.getDefault();
            smsMgr.sendTextMessage(phone,null,message,null,null);
            Toast.makeText(getBaseContext(),"Message Sent!",Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(getBaseContext(),"Message Sending Failed",Toast.LENGTH_SHORT).show();
        }

    }


}
