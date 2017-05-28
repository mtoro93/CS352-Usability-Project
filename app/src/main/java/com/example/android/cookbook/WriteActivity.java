package com.example.android.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by eisat on 4/19/2017.
 */

public class WriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        ListView ingredientListView = (ListView) findViewById(R.id.write_list_ingredients);

        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("First Ingredient Here");


        ListView directionsListView = (ListView) findViewById(R.id.write_list_directions);

        ArrayList<String> directions = new ArrayList<String>();
        directions.add("First Direction Here");


        DisplayAdapter ingredientAdapter = new DisplayAdapter(this, ingredients);
        DisplayAdapter directionAdapter = new DisplayAdapter(this, directions);


        ingredientListView.setAdapter(ingredientAdapter);
        directionsListView.setAdapter(directionAdapter);


        Button saveRecipe = (Button) findViewById(R.id.write_save_recipe);
        saveRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent testIntent = new Intent(WriteActivity.this, CategoryActivity.class);
                startActivity(testIntent);
            }
        });


        ingredientListView.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });

        directionsListView.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });



    }

}
