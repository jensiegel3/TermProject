package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Materials extends Activity {
    private TextView nonRecyclableWarning;
    private Spinner materialTypeSpinner;
    private String nonRecyclableWarningContent =
            "Please remember - the following items are trash:";

    private final String[] recyclableCategories = {
            "Paper & CardBoard",
            "Plastic",
            "Metal",
            "Glass"
    };
    private final String[] paperItems = {
            "White & Colored Paper",
            "Shredded Paper",
            "Paper Plates & Bowls (clean)",
            "Wrapping Paper",
            "Newspaper",
            "Magazines & Catalogs",
            "Mail & Cards",
            "Folders",
            "Coffee Cups",
            "Cardboard Boxes",
            "Pizza Boxes (without grease stains)",
            "Milk/Cereal Containers",
            "Other Unstained Paper"
    };
    private final String[] plasticItems = {
            "Plastic items (# 1-7)",
            "Coffee Lids",
            "Plastic Utensils",
            "Plastic Containers",
            "LaCava Clamshells",
            "Rigid Plastics"
    };
    private final String[] metalItems = {
            "Aluminum",
            "Cans",
            "Tin",
            "Foil"
    };
    private final String[] glassItems = {
            "Beverage Bottles",
            "Food Jars",
            "Other glass containers"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);

        nonRecyclableWarning = (TextView) findViewById(R.id.nonrecyclablewarning);
        nonRecyclableWarning.setText(nonRecyclableWarningContent);

        materialTypeSpinner = (Spinner) findViewById(R.id.materialtypespinner);

        // Create an ArrayAdapter for material type spinner and connect it to the spinner
        ArrayAdapter<String> recyclableCategoriesAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                recyclableCategories);
        recyclableCategoriesAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        materialTypeSpinner.setAdapter(recyclableCategoriesAdapter);
    }

    // create options menu
    // does this have to go on every page?
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
