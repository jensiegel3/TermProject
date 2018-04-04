package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Materials extends Activity {
    private Spinner materialTypeSpinner;
    private TextView materialTextView;

    private final String[] recyclableCategories = {
            "Paper & CardBoard",
            "Plastic",
            "Metal",
            "Glass"
    };
    private final String paperItems =
            "White & Colored Paper\n" +
            "Shredded Paper\n" +
            "Paper Plates & Bowls (clean)\n" +
            "Wrapping Paper\n" +
            "Newspaper\n" +
            "Magazines & Catalogs\n" +
            "Mail & Cards\n" +
            "Folders\n" +
            "Coffee Cups\n" +
            "Cardboard Boxes\n" +
            "Pizza Boxes (without grease stains)\n" +
            "Milk/Cereal Containers\n" +
            "Other Unstained Paper";

    private final String plasticItems =
            "Plastic items (# 1-7)\n" +
            "Coffee Lids\n" +
            "Plastic Utensils\n" +
            "Plastic Containers\n" +
            "LaCava Clamshells\n" +
            "Rigid Plastics";


    private final String metalItems =
            "Aluminum\n" +
            "Cans\n" +
            "Tin\n" +
            "Foil";

    private final String glassItems =
            "Beverage Bottles\n" +
            "Food Jars\n" +
            "Other glass containers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);

        materialTypeSpinner = (Spinner) findViewById(R.id.materialtypespinner);
        materialTextView = (TextView) findViewById(R.id.materialtextview);

        // Create an ArrayAdapter for material type spinner and connect it to the spinner
        ArrayAdapter<String> recyclableCategoriesAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                recyclableCategories);
        recyclableCategoriesAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        materialTypeSpinner.setAdapter(recyclableCategoriesAdapter);
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
