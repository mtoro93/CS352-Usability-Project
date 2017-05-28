package com.example.android.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eisat_000 on 5/6/2017.
 */

public class ChooseRecipesActivity extends AppCompatActivity {

    private TextView mEmptyStateTextView;
    private RecipeAdapter mExpandableRecipeAdapter;
    private ArrayList<Recipe> listDataHeader;
    private HashMap<String, ArrayList<Recipe>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_recipes);


        ExpandableListView listView = (ExpandableListView) findViewById(R.id.choose_list);

        /*mEmptyStateTextView = (TextView) findViewById(R.id.empty_recipe_view);
        listView.setEmptyView(mEmptyStateTextView);*/

        prepareListData();

        mExpandableRecipeAdapter = new RecipeAdapter(this, listDataHeader, listDataChild);

        listView.setAdapter(mExpandableRecipeAdapter);


        Button createListButton = (Button) findViewById(R.id.button_create_list);
        createListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent groceryListIntent = new Intent (ChooseRecipesActivity.this, GroceryListActivity.class);
                startActivity(groceryListIntent);
            }
        });
    }


    private void prepareListData()
    {
        listDataHeader = new ArrayList<Recipe>();
        listDataChild = new HashMap<String, ArrayList<Recipe>>();


        ArrayList<Recipe> categoryOne = new ArrayList<Recipe>();
        categoryOne.add(new Recipe("Chili", "Beef"));



        ArrayList<Recipe> categoryTwo = new ArrayList<Recipe>();
        categoryTwo.add(new Recipe("Spaghetti with Meatballs", "Pasta"));


        ArrayList<Recipe> categoryThree = new ArrayList<Recipe>();
        categoryThree.add(new Recipe("Chocolate Cake", "Dessert"));


        listDataHeader.add(categoryOne.get(0));
        listDataHeader.add(categoryTwo.get(0));
        listDataHeader.add(categoryThree.get(0));

        listDataChild.put(listDataHeader.get(0).getCategoryName(), categoryOne);
        listDataChild.put(listDataHeader.get(1).getCategoryName(), categoryTwo);
        listDataChild.put(listDataHeader.get(2).getCategoryName(), categoryThree);

    }




}
