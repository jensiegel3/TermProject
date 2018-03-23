package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.EditText;

public class ContactUs extends Activity{

    private Button send;
    private EditText subject;
    private EditText text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        send = (Button) findViewById(R.id.send);
        subject = (EditText) findViewById(R.id.subject);
        subject.setHint("Subject");
        text = (EditText) findViewById(R.id.text);
        text.setHint("What do you need help with?");

        send.setOnClickListener(new OnClickListener() {
            public void onClick(View v){

                Intent msg = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
                msg.putExtra(Intent.EXTRA_EMAIL, "sustainability2@bentley.edu");
                msg.putExtra(Intent.EXTRA_TEXT, text.getText());
                msg.putExtra(Intent.EXTRA_SUBJECT, subject.getText());

                //check to be sure email is installed on handset
                if (msg.resolveActivity(getPackageManager()) != null) {
                    startActivity(msg);
                }

            }
        });

    }


}
