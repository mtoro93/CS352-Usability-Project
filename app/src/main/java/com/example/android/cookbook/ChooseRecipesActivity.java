package com.example.android.cookbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by eisat_000 on 5/6/2017.
 */

public class ChooseRecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_recipes);

        ListView recipeListView = (ListView) findViewById(R.id.choose_list);



        /*final ArrayList<Recipe> recipes  = new ArrayList<Recipe>();
        recipes.add(new Recipe("Recipe 1"));
        recipes.add(new Recipe("Recipe 2"));
        recipes.add(new Recipe("Recipe 3"));

       RecipeAdapter mAdapter = new RecipeAdapter(this,recipes);

        recipeListView.setAdapter(mAdapter);*/
    }
}
