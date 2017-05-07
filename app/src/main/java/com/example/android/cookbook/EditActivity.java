package com.example.android.cookbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
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
        ingredients.add("Ingredient 1");
        ingredients.add("Ingredient 2");
        ingredients.add("Ingredient 3");

        ArrayList<String> directions = new ArrayList<>();
        directions.add("1. Step 1");
        directions.add("2. Step 2");
        directions.add("3. Step 3");

        ListView ingredientListView = (ListView) findViewById(R.id.edit_list_ingredients);

        DisplayAdapter ingredientAdapter = new DisplayAdapter(this, ingredients);

        ingredientListView.setAdapter(ingredientAdapter);

        ListView directionListView = (ListView) findViewById(R.id.edit_list_directions);

        DisplayAdapter directionAdapter = new DisplayAdapter(this, directions);

        directionListView.setAdapter(directionAdapter);


        GridView tagGridView = (GridView) findViewById(R.id.edit_tag_grid);

    }
}
