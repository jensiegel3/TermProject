package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.EditText;

public class ContactUs extends Activity{

    private Button send;
    private Button call1;
    private Button call2;
    private EditText subject;
    private EditText text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        send = (Button) findViewById(R.id.send);
        call1 = (Button) findViewById(R.id.call1);
        call2 = (Button) findViewById(R.id.call2);
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

        call1.setOnClickListener(new OnClickListener() {
            public void onClick(View v){

                Intent dial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7818912252"));

                //check to be sure email is installed on handset
                if (dial.resolveActivity(getPackageManager()) != null) {
                    startActivity(dial);
                }

            }
        });

        call2.setOnClickListener(new OnClickListener() {
            public void onClick(View v){

                Intent dial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7818912295"));

                //check to be sure email is installed on handset
                if (dial.resolveActivity(getPackageManager()) != null) {
                    startActivity(dial);
                }

            }
        });

    }
    // create options menu
    // does this have to go on every page?
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // add functionality to menu buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.profileMenu:
                Intent iProfile = new Intent(this, Profile.class);
                startActivity(iProfile);
                return true;

            case R.id.materialsMenu:
                // can I use the same name?
                Intent iMaterials = new Intent(this, Materials.class);
                startActivity(iMaterials);
                return true;

            case R.id.incentiveMenu:
                // can I use the same name?
                Intent iIncentive = new Intent(this, Incentive.class);
                startActivity(iIncentive);
                return true;

            case R.id.contactMenu:
                // can I use the same name?
                Intent iContact = new Intent(this, ContactUs.class);
                startActivity(iContact);
                return true;

            case R.id.exit:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
