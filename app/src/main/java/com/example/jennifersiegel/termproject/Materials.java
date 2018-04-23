package com.example.jennifersiegel.termproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Materials extends BaseActivity implements AdapterView.OnItemSelectedListener {
    private Spinner materialTypeSpinner;
    private TextView materialTextView;

    // possible categories of recyclable materials
    private final String[] recyclableCategories = {
            "<Select item material type>",
            "Paper & CardBoard",
            "Plastic",
            "Metal",
            "Glass",
            "Electronics"
    };
    private final String itemListPrompt = "Recyclable items in this category are:\n\n";

    // paper recyclable materials
    private final String paperItems =
            "- White & Colored Paper\n" +
            "- Shredded Paper\n" +
            "- Paper Plates & Bowls (clean)\n" +
            "- Wrapping Paper\n" +
            "- Newspaper\n" +
            "- Magazines & Catalogs\n" +
            "- Mail & Cards\n" +
            "- Folders\n" +
            "- Coffee Cups\n" +
            "- Cardboard Boxes\n" +
            "- Pizza Boxes (without grease stains)\n" +
            "- Milk/Cereal Containers\n" +
            "- Other Unstained Paper";

    // plastic recyclable materials
    private final String plasticItems =
            "- Plastic items (# 1-7)\n" +
            "- Coffee Lids\n" +
            "- Plastic Utensils\n" +
            "- Plastic Containers\n" +
            "- LaCava Clamshells\n" +
            "- Rigid Plastics";

    // metal recyclable materials
    private final String metalItems =
            "- Aluminum\n" +
            "- Cans\n" +
            "- Tin\n" +
            "- Foil";

    // glass recyclable materials
    private final String glassItems =
            "- Beverage Bottles\n" +
            "- Food Jars\n" +
            "- Other glass containers";

    // electronics recyclable materials
    private final String electronicsItems =
            "- Batteries\n" +
            "- Cell Phones\n" +
            "- Hand-held Electronics\n" +
            "- Inkjet Cartridges";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);

        // set current activity name
        currentActivityName = "Materials";

        // spinner view for material categories
        materialTypeSpinner = (Spinner) findViewById(R.id.materialtypespinner);
        //set item click listener to this
        materialTypeSpinner.setOnItemSelectedListener(this);
        // material text view showing recyclable items in the selected category
        materialTextView = (TextView) findViewById(R.id.materialtextview);

        // Create an ArrayAdapter for material type spinner and connect it to the spinner
        ArrayAdapter<String> recyclableCategoriesAdapter = new ArrayAdapter<String>(
                this,
                R.layout.spinner_style,
                recyclableCategories);
        recyclableCategoriesAdapter.setDropDownViewResource(
                R.layout.spinner_style_dropdown);
        materialTypeSpinner.setAdapter(recyclableCategoriesAdapter);
    }

    // listener methods for spinner selection callbacks
    public void onItemSelected(AdapterView<?> parent, View v, int position,
                               long id) {
        switch (position) {
            case 1:
                materialTextView.setText(itemListPrompt + paperItems);
                break;
            case 2:
                materialTextView.setText(itemListPrompt + plasticItems);
                break;
            case 3:
                materialTextView.setText(itemListPrompt + metalItems);
                break;
            case 4:
                materialTextView.setText(itemListPrompt + glassItems);
                break;
            case 5:
                materialTextView.setText(itemListPrompt + electronicsItems);
                break;
        }

    }
    public void onNothingSelected(AdapterView<?> parent) {
        materialTextView.setText("");
    }

}
