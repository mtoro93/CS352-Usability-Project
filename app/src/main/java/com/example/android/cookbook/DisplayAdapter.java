package com.example.android.cookbook;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eisat_000 on 5/7/2017.
 */

public class DisplayAdapter extends ArrayAdapter<String> {


    public DisplayAdapter(Activity context, ArrayList<String> strings)
    {
        super(context, 0, strings);
    }


    @NonNull
    @Override
    public View getView (int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        String currentString;
        TextView wordTextView;
        EditText editTextView;



        switch(parent.getId())
        {
            case R.id.display_ingredients:
                if (listItemView == null)
                {
                    listItemView = LayoutInflater.from(getContext()).inflate(R.layout.display_ingredient_item_list, parent, false);
                }

                currentString = getItem(position);

                wordTextView = (TextView) listItemView.findViewById(R.id.display_ingredient_item);
                wordTextView.setText(currentString);
                break;
            case R.id.display_directions:
                if (listItemView == null)
                {
                    listItemView = LayoutInflater.from(getContext()).inflate(R.layout.display_direction_item_list, parent, false);
                }

                currentString = getItem(position);

                wordTextView = (TextView) listItemView.findViewById(R.id.display_direction_item);
                wordTextView.setText(currentString);
                break;
            case R.id.write_list_ingredients:
                if (listItemView == null)
                {
                    listItemView = LayoutInflater.from(getContext()).inflate(R.layout.write_ingredients_item_list, parent, false);
                }

                currentString = getItem(position);
                editTextView = (EditText) listItemView.findViewById(R.id.write_ingredient_item);
                editTextView.setText(currentString);
                break;
            case R.id.write_list_directions:
                if (listItemView == null)
                {
                    listItemView = LayoutInflater.from(getContext()).inflate(R.layout.write_directions_item_list, parent, false);
                }

                currentString = getItem(position);
                editTextView = (EditText) listItemView.findViewById(R.id.write_direction_item);
                editTextView.setText(currentString);
                break;
            case R.id.edit_list_ingredients:
                if (listItemView == null)
                {
                    listItemView = LayoutInflater.from(getContext()).inflate(R.layout.edit_ingredient_item_list, parent, false);
                }

                currentString = getItem(position);
                editTextView = (EditText) listItemView.findViewById(R.id.edit_ingredient_item);
                editTextView.setText(currentString);
                break;
            case R.id.edit_list_directions:
                if (listItemView == null)
                {
                    listItemView = LayoutInflater.from(getContext()).inflate(R.layout.edit_directions_item_list, parent, false);
                }

                currentString = getItem(position);
                editTextView = (EditText) listItemView.findViewById(R.id.edit_direction_item);
                editTextView.setText(currentString);
                break;
            case R.id.list_grocery:
                if (listItemView == null)
                {
                    listItemView = LayoutInflater.from(getContext()).inflate(R.layout.grocery_list_item, parent, false);
                }

                currentString = getItem(position);

                wordTextView = (TextView) listItemView.findViewById(R.id.grocery_list_text);
                wordTextView.setText(currentString);
                break;

        }



        /*if(parent.getId() == R.id.ingredients)
        {
            if (listItemView == null)
            {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.edit_ingredient_item_list, parent, false);
            }

            currentString = getItem(position);

            TextView wordTextView = (TextView) listItemView.findViewById(ingredient_item);
            wordTextView.setText(currentString);
        }
        else if (parent.getId() == R.id.list_grocery)
        {
            if (listItemView == null)
            {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.grocery_list_item, parent, false);
            }

            currentString = getItem(position);

            TextView wordTextView = (TextView) listItemView.findViewById(R.id.grocery_list_text);
            wordTextView.setText(currentString);
        }
        else if (parent.getId() == R.id.list_ingredients)
        {
            if (listItemView == null)
            {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.edit_ingredient_item_list, parent, false);
            }

            currentString = getItem(position);

            EditText wordTextView = (EditText) listItemView.findViewById(R.id.edit_ingredient_item);
            wordTextView.setText(currentString);
        }
        else if (parent.getId() == R.id.list_directions)
        {
            if (listItemView == null)
            {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.edit_directions_item_list, parent, false);
            }

            currentString = getItem(position);

            EditText wordTextView = (EditText) listItemView.findViewById(R.id.edit_direction_item);
            wordTextView.setText(currentString);

        }
        else
        {
            if (listItemView == null)
            {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.edit_directions_item_list, parent, false);
            }

            currentString = getItem(position);

            TextView wordTextView = (TextView) listItemView.findViewById(R.id.direction_item);
            wordTextView.setText(currentString);
        }*/

        return listItemView;
    }
}
