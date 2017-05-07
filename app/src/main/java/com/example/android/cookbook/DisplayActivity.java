package com.example.android.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by eisat_000 on 4/23/2017.
 */

public class DisplayActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("Ingredient 1");
        ingredients.add("Ingredient 2");
        ingredients.add("Ingredient 3");

        ArrayList<String> directions = new ArrayList<>();
        directions.add("1. Step 1");
        directions.add("2. Step 2");
        directions.add("3. Step 3");

        ListView ingredientListView = (ListView) findViewById(R.id.display_ingredients);

        DisplayAdapter ingredientAdapter = new DisplayAdapter(this, ingredients);

        ingredientListView.setAdapter(ingredientAdapter);

        ListView directionListView = (ListView) findViewById(R.id.display_directions);

        DisplayAdapter directionAdapter = new DisplayAdapter(this, directions);

        directionListView.setAdapter(directionAdapter);


        directionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent recipeStepActivity = new Intent (DisplayActivity.this, RecipeStepActivity.class);
                startActivity(recipeStepActivity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            View anchorView = findViewById(R.id.ingredients_line);
            PopupMenu popupMenu = new PopupMenu(this, anchorView);
            popupMenu.inflate(R.menu.display_actions);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_edit:
                Intent editIntent = new Intent (DisplayActivity.this, EditActivity.class);
                startActivity(editIntent);
                return true;
            case R.id.menu_share:
                return true;
            default:
                return false;
        }
    }
}
