package com.example.jennifersiegel.termproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;


public class Incentive extends BaseActivity implements OnClickListener, OnInitListener {

    // create variables for notification
    private NotificationManager mNotificationManager;
    private Notification notifyDetails;
    private int SIMPLE_NOTFICATION_ID;
    private String contentTitle = "Congratulations! You've earned 10 points!";
    private String contentText = "Click to redeem.";
    private String tickerText = "New Alert, Click Me !!!";
    private TextToSpeech speaker;
    private static final String tag = "Incentive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set current activity name
        currentActivityName = "Incentive";

        setContentView(R.layout.activity_incentive);

        // Add text with listener that will open web browser
        TextView learnMore = (TextView) findViewById(R.id.citation);
        learnMore.setOnClickListener(this);

        // underline text
        learnMore.setPaintFlags(learnMore.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // set up notification manager
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // set animated image view on the page
        ImageView image = (ImageView) findViewById(R.id.turtleID);
        image.setImageResource(R.drawable.rounded_turtle);

        // create Intent for notification
        Intent notifyIntent = new Intent(this, Incentive.class);

        // create pending intent to wrap intent so that it
        // will fire when notification selected.
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // build notification object and set parameters
        notifyDetails =
                new Notification.Builder(this)
                        .setContentIntent(pendingIntent)

                        .setContentTitle(contentTitle)   //set Notification text and icon
                        .setContentText(contentText)
                        .setSmallIcon(R.drawable.ic_turtle_icon) // set icon for notification

                        .setTicker(tickerText)            // set status bar text

                        .setWhen(System.currentTimeMillis())    // timestamp when event occurs

                        .setAutoCancel(true)     // cancel Notification after clicking on it

                        .build();

        // notification happens when this activity starts
        mNotificationManager.notify(SIMPLE_NOTFICATION_ID,
                notifyDetails);

        // Load the animation
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

    // when the text is selected, web browser opens and text to speech occurs
    public void onClick(View v) {
        speak("Thanks for doing your part! You've made the sea turtles happy!");
        Uri uriUrl = Uri.parse("https://www.conserve-energy-future.com/various-recycling-facts.php");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
