package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;

// Dana's update to project
// Jen's update to project
// Anton's update to project
// Miles's update to project
public class HomePage extends BaseActivity implements OnClickListener {

    private Button recycleMaterials;
    private Button findABin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // set current activity name
        currentActivityName = "HomePage";

        // set up listeners for the buttons
        recycleMaterials = (Button) findViewById(R.id.materials);
        recycleMaterials.setOnClickListener(this);
        findABin = (Button) findViewById(R.id.findabin);
        findABin.setOnClickListener(this);

        TabHost tabs=(TabHost)findViewById(R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec;

        // Initialize a TabSpec for tab1 and add it to the TabHost
        spec=tabs.newTabSpec("tag1");	//create new tab specification
        spec.setContent(R.id.tab1);    //add tab view content
        spec.setIndicator("Recycling");    //put text on tab
        tabs.addTab(spec);             //put tab in TabHost container

        // Initialize a TabSpec for tab2 and add it to the TabHost
        spec=tabs.newTabSpec("tag2");		//create new tab specification
        spec.setContent(R.id.tab2);			//add view tab content
        spec.setIndicator("Trash");
        tabs.addTab(spec);					//put tab in TabHost container

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.materials:
                Intent iMaterials = new Intent(this, Materials.class);
                startActivity(iMaterials);
                break;

            case R.id.findabin:
                Intent iFindABin = new Intent(this, FindABin.class);
                startActivity(iFindABin);
                break;

            default:
                throw new RuntimeException("Wrong button");
        }
    }
}
