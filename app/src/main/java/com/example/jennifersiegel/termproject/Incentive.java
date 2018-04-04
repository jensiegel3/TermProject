package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Incentive extends Activity implements OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incentive);
        TextView learnMore = (TextView) findViewById(R.id.citation);
        learnMore.setOnClickListener(this);
        learnMore.setPaintFlags(learnMore.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        ImageView image = (ImageView) findViewById(R.id.turtleID);
        image.setImageResource(R.drawable.turtle);

        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(this, R.anim.turtle);
        // Register a listener, so we can disable and re-enable buttons
        //an.setAnimationListener(new MyAnimationListener());
        // Start the animation
        image.startAnimation(an);

    }

    public void onClick(View v) {
        Uri uriUrl = Uri.parse("https://www.conserve-energy-future.com/various-recycling-facts.php");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    // create back options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.backmenu, menu);
        return true;
    }

    // add functionality to menu buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.homeMenu:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
