package com.example.android.cookbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by eisat_000 on 5/7/2017.
 */

public class GroceryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView) findViewById(R.id.list_grocery);

        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("Ingredient 1");
        ingredients.add("Ingredient 2");
        ingredients.add("Ingredient 3");
        ingredients.add("Ingredient 4");
        ingredients.add("Ingredient 5");
        ingredients.add("Ingredient 6");

        DisplayAdapter adapter = new DisplayAdapter(this, ingredients);

        listView.setAdapter(adapter);
    }
}
