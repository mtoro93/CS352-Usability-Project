package com.example.android.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eisat on 4/19/2017.
 */

public class BrowseActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private TextView mEmptyStateTextView;
    private RecipeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);


        ListView recipeListView = (ListView) findViewById(R.id.browse_list);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_recipe_view);
        recipeListView.setEmptyView(mEmptyStateTextView);

        final ArrayList<Recipe> recipes  = new ArrayList<Recipe>();
        recipes.add(new Recipe("Recipe 1"));
        recipes.add(new Recipe("Recipe 2"));
        recipes.add(new Recipe("Recipe 3"));

        mAdapter = new RecipeAdapter(this,recipes);

        recipeListView.setAdapter(mAdapter);


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
            View browseView = findViewById(R.id.browse_list);
            PopupMenu popupMenu = new PopupMenu(this, browseView);
            popupMenu.inflate(R.menu.browse_actions);
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
            case R.id.menu_write:
                Intent writeIntent = new Intent (BrowseActivity.this, WriteActivity.class);
                startActivity(writeIntent);
                return true;
            case R.id.menu_upload:
                Intent uploadIntent = new Intent (BrowseActivity.this, UploadActivity.class);
                startActivity(uploadIntent);
                return true;
            case R.id.menu_grocery_list:
                Intent groceryListIntent = new Intent (BrowseActivity.this, ChooseRecipesActivity.class);
                startActivity(groceryListIntent);
                return true;
            default:
                return false;
        }
    }
}
