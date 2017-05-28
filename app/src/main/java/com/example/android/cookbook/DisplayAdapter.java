package com.example.android.cookbook;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
        ImageButton imageButtonView;



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

                imageButtonView = (ImageButton) listItemView.findViewById(R.id.write_direction_attach);
                imageButtonView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Attach File");
                        builder.setItems(R.array.file_attachments, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.cancel();
                                Toast.makeText(getContext(),"File Attached", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.cancel();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                });

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

                imageButtonView = (ImageButton) listItemView.findViewById(R.id.edit_direction_attach);
                imageButtonView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Attach File");
                        builder.setItems(R.array.file_attachments, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.cancel();
                                Toast.makeText(getContext(),"File Attached", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.cancel();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                });

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
            case R.id.share_list:
                if (listItemView == null)
                {
                    listItemView = LayoutInflater.from(getContext()).inflate(R.layout.share_list_item, parent, false);
                }

                currentString = getItem(position);

                wordTextView = (TextView) listItemView.findViewById(R.id.social_media_text);
                wordTextView.setText(currentString);
                break;

        }

        return listItemView;
    }
}
