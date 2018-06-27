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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eisat_000 on 5/7/2017.
 */

public class GroceryListActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private View mEmptyStateTextView;
    private RecipeAdapter mExpandableRecipeAdapter;
    private ArrayList<Recipe> listDataHeader;
    private HashMap<String, ArrayList<Recipe>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.list_grocery);

        mEmptyStateTextView =  findViewById(R.id.list_grocery_empty_view);
        listView.setEmptyView(mEmptyStateTextView);

        prepareListData();

        mExpandableRecipeAdapter = new RecipeAdapter(this, listDataHeader, listDataChild);

        listView.setAdapter(mExpandableRecipeAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.grocery_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.action_menu)
        {
            View browseView = findViewById(R.id.list_menu_placement);
            PopupMenu popupMenu = new PopupMenu(this, browseView);
            popupMenu.inflate(R.menu.list_actions);
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
            case R.id.menu_save:
                Intent homeIntent = new Intent (GroceryListActivity.this, BrowseActivity.class);
                Bundle data = new Bundle();
                data.putBoolean("list saved", true);
                homeIntent.putExtras(data);
                startActivity(homeIntent);
                return true;
            case R.id.menu_share:
                Intent shareIntent = new Intent (GroceryListActivity.this, ShareActivity.class);
                startActivity(shareIntent);
                return true;
            case R.id.menu_edit:
                Intent editIntent = new Intent (GroceryListActivity.this, ChooseRecipesActivity.class);
                startActivity(editIntent);
                return true;
            case R.id.menu_delete:
                Intent browseIntent = new Intent (GroceryListActivity.this, BrowseActivity.class);
                Bundle browseData = new Bundle();
                browseData.putBoolean("list deleted", true);
                browseIntent.putExtras(browseData);
                startActivity(browseIntent);
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
        categoryOne.add(new Recipe("2 cups from Chocolate Cake", "Sugar"));

        ArrayList<Recipe> categoryTwo = new ArrayList<Recipe>();
        categoryTwo.add(new Recipe("1 3/4 cups from Chocolate Cake", "All-Purpose Flour"));

        ArrayList<Recipe> categoryThree = new ArrayList<Recipe>();
        categoryThree.add(new Recipe("3/4 cup from Chocolate Cake", "Cocoa"));

        ArrayList<Recipe> categoryFour = new ArrayList<Recipe>();
        categoryFour.add(new Recipe("1 1/2 teaspoons from Chocolate Cake", "Baking Powder"));

        ArrayList<Recipe> categoryFive = new ArrayList<Recipe>();
        categoryFive.add(new Recipe("1 1/2 teaspoons from Chocolate Cake", "Baking Soda"));

        ArrayList<Recipe> categorySix = new ArrayList<Recipe>();
        categorySix.add(new Recipe("1 teaspoon from Chocolate Cake", "Salt"));
        categorySix.add(new Recipe("1 teaspoon from Chili", "Salt"));

        ArrayList<Recipe> categorySeven = new ArrayList<Recipe>();
        categorySeven.add(new Recipe("2 from Chocolate Cake", "Eggs"));

        ArrayList<Recipe> categoryEight = new ArrayList<Recipe>();
        categoryEight.add(new Recipe("1 cup from Chocolate Cake", "Milk"));

        ArrayList<Recipe> categoryNine = new ArrayList<Recipe>();
        categoryNine.add(new Recipe("1/2 cup from Chocolate Cake", "Vegetable Oil"));

        ArrayList<Recipe> categoryTen = new ArrayList<Recipe>();
        categoryTen.add(new Recipe("2 teaspoons from Chocolate Cake", "Vanilla Extract"));

        ArrayList<Recipe> categoryEleven = new ArrayList<Recipe>();
        categoryEleven.add(new Recipe("1 cup from Chocolate Cake", "Water"));

        ArrayList<Recipe> categoryTwelve = new ArrayList<Recipe>();
        categoryTwelve.add(new Recipe("2 pounds from Chili", "Ground Beef"));

        ArrayList<Recipe> categoryThirteen = new ArrayList<Recipe>();
        categoryThirteen.add(new Recipe("2 cloves from Chili", "Garlic"));

        ArrayList<Recipe> categoryFourteen = new ArrayList<Recipe>();
        categoryFourteen.add(new Recipe("1 8oz can from Chili", "Tomato Sauce"));

        ArrayList<Recipe> categoryFifteen = new ArrayList<Recipe>();
        categoryFifteen.add(new Recipe("1 teaspoon from Chili", "Ground Oregano"));

        ArrayList<Recipe> categorySixteen = new ArrayList<Recipe>();
        categorySixteen.add(new Recipe("1/4 teaspoon from Chili", "Cayenne Pepper"));

        ArrayList<Recipe> categorySeventeen = new ArrayList<Recipe>();
        categorySeventeen.add(new Recipe("1/4 cup from Chili", "Corn Flour"));

        ArrayList<Recipe> categoryEighteen = new ArrayList<Recipe>();
        categoryEighteen.add(new Recipe("1 15oz can from Chili", "Kidney Beans"));

        ArrayList<Recipe> categoryNineteen = new ArrayList<Recipe>();
        categoryNineteen.add(new Recipe("1 15oz can from Chili", "Pinto Beans"));


        listDataHeader.add(categoryOne.get(0));
        listDataHeader.add(categoryTwo.get(0));
        listDataHeader.add(categoryThree.get(0));
        listDataHeader.add(categoryFour.get(0));
        listDataHeader.add(categoryFive.get(0));
        listDataHeader.add(categorySix.get(0));
        listDataHeader.add(categorySeven.get(0));
        listDataHeader.add(categoryEight.get(0));
        listDataHeader.add(categoryNine.get(0));
        listDataHeader.add(categoryTen.get(0));
        listDataHeader.add(categoryEleven.get(0));
        listDataHeader.add(categoryTwelve.get(0));
        listDataHeader.add(categoryThirteen.get(0));
        listDataHeader.add(categoryFourteen.get(0));
        listDataHeader.add(categoryFifteen.get(0));
        listDataHeader.add(categorySixteen.get(0));
        listDataHeader.add(categorySeventeen.get(0));
        listDataHeader.add(categoryEighteen.get(0));
        listDataHeader.add(categoryNineteen.get(0));

        listDataChild.put(listDataHeader.get(0).getCategoryName(), categoryOne);
        listDataChild.put(listDataHeader.get(1).getCategoryName(), categoryTwo);
        listDataChild.put(listDataHeader.get(2).getCategoryName(), categoryThree);
        listDataChild.put(listDataHeader.get(3).getCategoryName(), categoryFour);
        listDataChild.put(listDataHeader.get(4).getCategoryName(), categoryFive);
        listDataChild.put(listDataHeader.get(5).getCategoryName(), categorySix);
        listDataChild.put(listDataHeader.get(6).getCategoryName(), categorySeven);
        listDataChild.put(listDataHeader.get(7).getCategoryName(), categoryEight);
        listDataChild.put(listDataHeader.get(8).getCategoryName(), categoryNine);
        listDataChild.put(listDataHeader.get(9).getCategoryName(), categoryTen);
        listDataChild.put(listDataHeader.get(10).getCategoryName(), categoryEleven);
        listDataChild.put(listDataHeader.get(11).getCategoryName(), categoryTwelve);
        listDataChild.put(listDataHeader.get(12).getCategoryName(), categoryThirteen);
        listDataChild.put(listDataHeader.get(13).getCategoryName(), categoryFourteen);
        listDataChild.put(listDataHeader.get(14).getCategoryName(), categoryFifteen);
        listDataChild.put(listDataHeader.get(15).getCategoryName(), categorySixteen);
        listDataChild.put(listDataHeader.get(16).getCategoryName(), categorySeventeen);
        listDataChild.put(listDataHeader.get(17).getCategoryName(), categoryEighteen);
        listDataChild.put(listDataHeader.get(18).getCategoryName(), categoryNineteen);

    }
}
