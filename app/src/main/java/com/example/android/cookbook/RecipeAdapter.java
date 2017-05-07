package com.example.android.cookbook;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eisat_000 on 5/6/2017.
 */

public class RecipeAdapter extends ArrayAdapter<Recipe> {

    public RecipeAdapter (Activity context, ArrayList<Recipe> recipes)
    {
        super(context, 0, recipes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        Recipe currentRecipe;
        TextView nameTextView;
        switch(parent.getId())
        {
            case R.id.choose_list:
                if (listItemView == null)
                {
                    listItemView = LayoutInflater.from(getContext()).inflate(R.layout.recipe_list_item, parent, false);
                }

                currentRecipe = getItem(position);

                nameTextView = (TextView) listItemView.findViewById(R.id.recipe_name);
                nameTextView.setText(currentRecipe.getRecipeName());

                View checkbox = listItemView.findViewById(R.id.grocery_list_checkbox);
                checkbox.setVisibility(View.VISIBLE);

                break;
            default:

                if (listItemView == null)
                {
                    listItemView = LayoutInflater.from(getContext()).inflate(R.layout.recipe_list_item, parent, false);
                }

                currentRecipe = getItem(position);

                nameTextView = (TextView) listItemView.findViewById(R.id.recipe_name);
                nameTextView.setText(currentRecipe.getRecipeName());
                break;
        }






        return listItemView;
    }
}
