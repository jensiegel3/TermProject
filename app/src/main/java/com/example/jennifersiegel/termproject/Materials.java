package com.example.jennifersiegel.termproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Materials extends Activity implements AdapterView.OnItemSelectedListener {
    private Spinner materialTypeSpinner;
    private TextView materialTextView;

    private final String[] recyclableCategories = {
            "<Select item material type>",
            "Paper & CardBoard",
            "Plastic",
            "Metal",
            "Glass"
    };
    private final String itemListPrompt = "Recyclable items in this category are:\n\n";

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

    private final String plasticItems =
            "- Plastic items (# 1-7)\n" +
            "- Coffee Lids\n" +
            "- Plastic Utensils\n" +
            "- Plastic Containers\n" +
            "- LaCava Clamshells\n" +
            "- Rigid Plastics";


    private final String metalItems =
            "- Aluminum\n" +
            "- Cans\n" +
            "- Tin\n" +
            "- Foil";

    private final String glassItems =
            "- Beverage Bottles\n" +
            "- Food Jars\n" +
            "- Other glass containers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);

        materialTypeSpinner = (Spinner) findViewById(R.id.materialtypespinner);
        materialTypeSpinner.setOnItemSelectedListener(this);   //set item click listener
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
        }

    }
    public void onNothingSelected(AdapterView<?> parent) {
        materialTextView.setText("");
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

    ////////////////////////////////////////////////////////
    // QR Code scanning methods
    ////////////////////////////////////////////////////////

    public void scanBarcode(View view) {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("Please scan the QR code on the recycling bin!");
        integrator.setOrientationLocked(false);
        integrator.setBeepEnabled(true);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
