package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.widget.Toast;

import java.util.Locale;


public class Incentive extends BaseActivity implements OnClickListener, OnInitListener {

    // create variables for notification

    private NotificationManager mNotificationManager;
    private Notification notifyDetails;
    private int SIMPLE_NOTFICATION_ID;
    private String contentTitle = "Congratulations! You've earned 10 points!";
    private String contentText = "Click to redeem.";
    // where is the ticker text?
    private String tickerText = "New Alert, Click Me !!!";
    private TextToSpeech speaker;
    private static final String tag = "Incentive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set current activity name
        currentActivityName = "Incentive";

        setContentView(R.layout.activity_incentive);
        TextView learnMore = (TextView) findViewById(R.id.citation);
        learnMore.setOnClickListener(this);
        learnMore.setPaintFlags(learnMore.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        ImageView image = (ImageView) findViewById(R.id.turtleID);
        image.setImageResource(R.drawable.rounded_turtle);

        Intent notifyIntent = new Intent(this, Incentive.class);

        //create pending intent to wrap intent so that it
        //will fire when notification selected.
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //build notification object and set parameters
        notifyDetails =
                new Notification.Builder(this)
                        .setContentIntent(pendingIntent)

                        .setContentTitle(contentTitle)   //set Notification text and icon
                        .setContentText(contentText)
                        .setSmallIcon(R.drawable.ic_turtle_icon)

                        .setTicker(tickerText)            //set status bar text

                        .setWhen(System.currentTimeMillis())    //timestamp when event occurs

                        .setAutoCancel(true)     //cancel Notification after clicking on it

                        //set Android to vibrate when notified
                        //.setVibrate(new long[]{1000, 1000, 1000, 1000})

                        // flash LED (color, on in millisec, off)
                        //doesn't work for all handsets
                        // do we want flashing?
                        //.setLights(Integer.MAX_VALUE, 500, 500)

                        .build();

        // notify() in response to button click.
        // might decide to have the notification in the QR code activity, if points = X.
        // maybe in start up, if points = 10, have notification as well
        mNotificationManager.notify(SIMPLE_NOTFICATION_ID,
                notifyDetails);

        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(this, R.anim.turtle);

        // Start the animation
        image.startAnimation(an);

        // Initialize Text to Speech engine (context, listener object)
        speaker = new TextToSpeech(this, this);

    }

    // speaks the contents of output
    public void speak(String output) {
        speaker.speak(output, TextToSpeech.QUEUE_FLUSH, null);
    }

    // Implements TextToSpeech.OnInitListener.
    public void onInit(int status) {
        // status can be either TextToSpeech.SUCCESS or TextToSpeech.ERROR.
        if (status == TextToSpeech.SUCCESS) {
            // Set preferred language to US english.
            // If a language is not be available, the result will indicate it.
            int result = speaker.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Language data is missing or the language is not supported.
                Log.e(tag, "Language is not available.");
            }
        } else {
            // Initialization failed.
            Log.e(tag, "Could not initialize TextToSpeech.");
        }
    }

    public void onDestroy() {

        // shut down TTS engine
        if (speaker != null) {
            speaker.stop();
            speaker.shutdown();
        }
        super.onDestroy();
    }

    public void onClick(View v) {
        speak("Thanks for doing your part! You've made the sea turtles happy!");
        Uri uriUrl = Uri.parse("https://www.conserve-energy-future.com/various-recycling-facts.php");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
