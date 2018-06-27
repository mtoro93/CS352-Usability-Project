package com.example.android.cookbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
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

        ListView ingredientListView = (ListView) findViewById(R.id.display_ingredients);

        DisplayAdapter ingredientAdapter = new DisplayAdapter(this, ingredients);

        ingredientListView.setAdapter(ingredientAdapter);

        ListView directionListView = (ListView) findViewById(R.id.display_directions);

        DisplayAdapter directionAdapter = new DisplayAdapter(this, directions);

        directionListView.setAdapter(directionAdapter);


        directionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle data = new Bundle();
                data.putInt("position", position);
                if (position == 0)
                {
                    data.putInt("Step 1 Picture", R.drawable.step1);
                    data.putString("Step 1 Direction", "1. Preheat oven to 350 degrees F. Grease and flour two 9-inch round baking pans.");
                }

                else if (position == 1)
                {
                    data.putInt("Step 2 Picture", R.drawable.step2);
                    data.putString("Step 2 Direction", "2. In a large bowl, combine the sugar, flour, cocoa, baking powder, baking soda, and salt. Add eggs, milk, oil, and vanilla. Mix until smooth. Stir in boiling water (batter will be thin). Pour batter into prepared pans.");
                }

                else if (position == 2)
                {
                    data.putInt("Step 3 Picture", R.drawable.step3);
                    data.putString("Step 3 Direction", "3. Bake 30 to 35 minutes or until a toothpick inserted in the center comes out clean. Cool completely.");
                }


                Intent recipeStepActivity = new Intent (DisplayActivity.this, RecipeStepActivity.class);
                recipeStepActivity.putExtras(data);
                startActivity(recipeStepActivity);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.display_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_delete:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Delete this Recipe?");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener()
                {
                   @Override
                   public void onClick(DialogInterface dialog, int id)
                   {
                       Intent homeActivity = new Intent (DisplayActivity.this, BrowseActivity.class);
                       Bundle data = new Bundle();
                       data.putBoolean("delete", true);
                       homeActivity.putExtras(data);
                       startActivity(homeActivity);
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
                break;
            case R.id.action_share:
                Intent shareIntent = new Intent (DisplayActivity.this, ShareActivity.class);
                startActivity(shareIntent);
                break;
            case R.id.action_edit:
                Intent editIntent = new Intent (DisplayActivity.this, EditActivity.class);
                startActivity(editIntent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item)
    {
                return false;
    }
}
