package com.example.android.cookbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eisat on 4/19/2017.
 */

public class BrowseActivity extends AppCompatActivity {

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
        /*recipes.add(new Recipe("Recipe 1"));
        recipes.add(new Recipe("Recipe 2"));
        recipes.add(new Recipe("Recipe 3"));*/

        mAdapter = new RecipeAdapter(this,recipes);

        recipeListView.setAdapter(mAdapter);


    }
}
