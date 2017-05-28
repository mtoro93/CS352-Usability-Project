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
 * Created by eisat_000 on 5/7/2017.
 */

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("2 cups sugar");
        ingredients.add("1 3/4 cups all-purpose flour");
        ingredients.add("3/4 cup cocoa");
        ingredients.add("1 1/2 teaspoons baking powder");
        ingredients.add("1 1/2 teaspoons baking soda");
        ingredients.add("1 teaspoon salt");
        ingredients.add("2 eggs");
        ingredients.add("1 cup milk");
        ingredients.add("1/2 cup vegetable oil");
        ingredients.add("2 teaspoons vanilla extract");
        ingredients.add("1 cup boiling water");

        ArrayList<String> directions = new ArrayList<>();
        directions.add("1. Preheat oven to 350 degrees F. Grease and flour two 9-inch round baking pans.");
        directions.add("2. In a large bowl, combine the sugar, flour, cocoa, baking powder, baking soda, and salt. Add eggs, milk, oil, and vanilla. Mix until smooth. Stir in boiling water (batter will be thin). Pour batter into prepared pans.");
        directions.add("3. Bake 30 to 35 minutes or until a toothpick inserted in the center comes out clean. Cool completely.");

        ListView ingredientListView = (ListView) findViewById(R.id.edit_list_ingredients);

        DisplayAdapter ingredientAdapter = new DisplayAdapter(this, ingredients);

        ingredientListView.setAdapter(ingredientAdapter);

        ListView directionListView = (ListView) findViewById(R.id.edit_list_directions);

        DisplayAdapter directionAdapter = new DisplayAdapter(this, directions);

        directionListView.setAdapter(directionAdapter);


        Button saveRecipe = (Button) findViewById(R.id.edit_save_recipe_button);
        saveRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent testIntent = new Intent(EditActivity.this, CategoryActivity.class);
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

        directionListView.setOnTouchListener(new ListView.OnTouchListener() {
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
