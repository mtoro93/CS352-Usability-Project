package com.example.android.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eisat on 4/19/2017.
 */

public class BrowseActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private TextView mEmptyStateTextView;
    private RecipeAdapter mExpandableRecipeAdapter;
    private ArrayList<Recipe> listDataHeader;
    HashMap<String, ArrayList<Recipe>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);


        //ListView recipeListView = (ListView) findViewById(R.id.browse_list);

        /*mEmptyStateTextView = (TextView) findViewById(R.id.empty_recipe_view);
        recipeListView.setEmptyView(mEmptyStateTextView);*/


        ExpandableListView listView = (ExpandableListView) findViewById(R.id.browse_expandable_list);

        prepareListData();

        mExpandableRecipeAdapter = new RecipeAdapter(this, listDataHeader, listDataChild);

        listView.setAdapter(mExpandableRecipeAdapter);


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
            View browseView = findViewById(R.id.browse_expandable_list);
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

    private void prepareListData()
    {
        listDataHeader = new ArrayList<Recipe>();
        listDataChild = new HashMap<String, ArrayList<Recipe>>();


        ArrayList<Recipe> categoryOne = new ArrayList<Recipe>();
        categoryOne.add(new Recipe("Recipe 1", "Category 1"));
        categoryOne.add(new Recipe("Recipe 2", "Category 1"));
        categoryOne.add(new Recipe("Recipe 3", "Category 1"));


        ArrayList<Recipe> categoryTwo = new ArrayList<Recipe>();
        categoryTwo.add(new Recipe("Recipe 4", "Category 2"));
        categoryTwo.add(new Recipe("Recipe 5", "Category 2"));
        categoryTwo.add(new Recipe("Recipe 6", "Category 2"));

        ArrayList<Recipe> categoryThree = new ArrayList<Recipe>();
        categoryThree.add(new Recipe("Recipe 7", "Category 3"));
        categoryThree.add(new Recipe("Recipe 8", "Category 3"));
        categoryThree.add(new Recipe("Recipe 9", "Category 3"));

        listDataHeader.add(categoryOne.get(0));
        listDataHeader.add(categoryTwo.get(0));
        listDataHeader.add(categoryThree.get(0));

        listDataChild.put(listDataHeader.get(0).getCategoryName(), categoryOne);
        listDataChild.put(listDataHeader.get(1).getCategoryName(), categoryTwo);
        listDataChild.put(listDataHeader.get(2).getCategoryName(), categoryThree);

    }
}
