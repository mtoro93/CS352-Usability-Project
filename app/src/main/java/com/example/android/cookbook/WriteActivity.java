package com.example.android.cookbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    }

    protected void saveRecipe(Button button)
    {

    }
}
