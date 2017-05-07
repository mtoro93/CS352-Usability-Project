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
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.recipe_list_item, parent, false);
        }

        Recipe currentRecipe = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.recipe_name);
        nameTextView.setText(currentRecipe.getRecipeName());

        return listItemView;
    }
}
