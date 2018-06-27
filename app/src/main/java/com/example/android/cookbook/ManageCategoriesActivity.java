package com.example.android.cookbook;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;

/**
 * Created by eisat_000 on 5/26/2017.
 */

public class ManageCategoriesActivity extends AppCompatActivity {


    ImageButton button1;
    ImageButton button2;
    ImageButton button3;

        @Override
        protected  void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_manage);

            ArrayList<String> tags = new ArrayList<String>();
            tags.add("beef");
            tags.add("chili");
            tags.add("stew");

            tags.add("pasta");
            tags.add("cake");
            tags.add("dessert");

            tags.add("chocolate");
            tags.add("beans");
            tags.add("spicy");


            GridView gridView = (GridView) findViewById(R.id.manage_grid_view);
            GridAdapter gridAdapter = new GridAdapter(this, tags);
            gridView.setAdapter(gridAdapter);

            button1 = (ImageButton) findViewById(R.id.delete_button_1);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setMessage("Delete this Category?");
                    builder.setPositiveButton("Delete", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int id)
                        {
                            dialog.cancel();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int id)
                        {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });

        }
}
