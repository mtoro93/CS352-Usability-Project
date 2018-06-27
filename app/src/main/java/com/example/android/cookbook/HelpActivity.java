package com.example.android.cookbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by eisat_000 on 5/26/2017.
 */

public class HelpActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


        final Boolean writeDescription = false;
        Boolean uploadDescription =false;
        Boolean displayDescription= false;
        Boolean organizeDescription = false;
        Boolean groceryDescription = false;

        TextView writeView = (TextView) findViewById(R.id.help_write_new);
        TextView uploadView = (TextView) findViewById(R.id.help_upload);
        TextView displayView = (TextView) findViewById(R.id.help_display);
        TextView organizeView = (TextView) findViewById(R.id.help_organization);
        TextView groceryView = (TextView) findViewById(R.id.help_grocery);

        final TextView writeViewDescription = (TextView) findViewById(R.id.help_write_new_description);
        final TextView uploadViewDescription = (TextView) findViewById(R.id.help_upload_description);
        final TextView displayViewDescription  = (TextView) findViewById(R.id.help_display_description);
        final TextView organizeViewDescription  = (TextView) findViewById(R.id.help_organization_description);
        final TextView groceryViewDescription = (TextView) findViewById(R.id.help_grocery_description);

        writeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (writeViewDescription.getVisibility() == View.GONE)
                    writeViewDescription.setVisibility(View.VISIBLE);
                else
                    writeViewDescription.setVisibility(View.GONE);
            }
        });


        uploadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uploadViewDescription.getVisibility() == View.GONE)
                    uploadViewDescription.setVisibility(View.VISIBLE);
                else
                    uploadViewDescription.setVisibility(View.GONE);
            }
        });


        displayView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (displayViewDescription.getVisibility() == View.GONE)
                    displayViewDescription.setVisibility(View.VISIBLE);
                else
                    displayViewDescription.setVisibility(View.GONE);
            }
        });


        organizeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (organizeViewDescription.getVisibility() == View.GONE)
                    organizeViewDescription.setVisibility(View.VISIBLE);
                else
                    organizeViewDescription.setVisibility(View.GONE);
            }
        });


        groceryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (groceryViewDescription.getVisibility() == View.GONE)
                    groceryViewDescription.setVisibility(View.VISIBLE);
                else
                    groceryViewDescription.setVisibility(View.GONE);
            }
        });
    }
}
