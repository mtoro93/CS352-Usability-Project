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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eisat on 4/19/2017.
 */

public class BrowseActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private View mEmptyStateTextView;
    private RecipeAdapter mExpandableRecipeAdapter;
    private ArrayList<Recipe> listDataHeader;
    private HashMap<String, ArrayList<Recipe>> listDataChild;
    boolean deletedRecipe = false;
    boolean savedRecipe = false;
    boolean savedList = false;
    boolean deletedList = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        Bundle data = getIntent().getExtras();

        if (data != null)
        {
            deletedRecipe = data.getBoolean("delete", false);
            savedRecipe = data.getBoolean("saved", false);
            savedList = data.getBoolean("list saved", false);
            deletedList = data.getBoolean("list deleted", false);
        }

        if (deletedRecipe)
            Toast.makeText(this, "Recipe Deleted", Toast.LENGTH_SHORT).show();
        if (savedRecipe)
            Toast.makeText(this, "Recipe Saved", Toast.LENGTH_SHORT).show();
        if (savedList)
            Toast.makeText(this, "Grocery List Saved", Toast.LENGTH_SHORT).show();
        if (deletedList)
            Toast.makeText(this, "Grocery List Deleted", Toast.LENGTH_SHORT).show();

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.browse_expandable_list);

        mEmptyStateTextView =  findViewById(R.id.empty_recipe_view);
        listView.setEmptyView(mEmptyStateTextView);

        prepareListData();

        mExpandableRecipeAdapter = new RecipeAdapter(this, listDataHeader, listDataChild);

        listView.setAdapter(mExpandableRecipeAdapter);


        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent displayActivity = new Intent(BrowseActivity.this, DisplayActivity.class);
                startActivity(displayActivity);
                return true;
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
            View browseView = findViewById(R.id.menu_placement);
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
            case R.id.menu_create_grocery_list:
                Intent createGroceryListIntent = new Intent (BrowseActivity.this, ChooseRecipesActivity.class);
                startActivity(createGroceryListIntent);
                return true;
            case R.id.menu_view_grocery_list:
                Intent viewGroceryListIntent = new Intent (BrowseActivity.this, GroceryListActivity.class);
                startActivity(viewGroceryListIntent);
                return true;
            case R.id.menu_manage_categories:
                Intent manageIntent = new Intent(BrowseActivity.this, ManageCategoriesActivity.class);
                startActivity(manageIntent);
                return true;
            case R.id.menu_help:
                Intent helpIntent = new Intent (BrowseActivity.this, HelpActivity.class);
                startActivity(helpIntent);
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
