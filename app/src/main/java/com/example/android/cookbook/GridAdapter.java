package com.example.android.cookbook;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eisat_000 on 5/26/2017.
 */

public class GridAdapter extends BaseAdapter {

    ArrayList<String> mTags;
    Context mContext;

    public GridAdapter(Context context, ArrayList<String> tags)
    {
        mTags = tags;
        mContext = context;
    }

    public int getCount()
    {
        return mTags.size();
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {

        View listItemView = convertView;
        String currentTag;
        TextView tag;
        ImageView imageButton;
        CheckBox checkBox;

        switch(parent.getId())
        {
            case R.id.test_grid_view:
                if (listItemView == null)
                {
                    listItemView = LayoutInflater.from(mContext).inflate(R.layout.grid_tag_list, parent, false);
                }

                currentTag = getItem(position);
                tag = (TextView) listItemView.findViewById(R.id.tag);
                tag.setText(currentTag);
                imageButton = (ImageView) listItemView.findViewById(R.id.tag_delete);
                imageButton.setVisibility(View.GONE);
                checkBox = (CheckBox) listItemView.findViewById(R.id.tag_checkbox);
                checkBox.setVisibility(View.VISIBLE);
                break;
            case R.id.manage_grid_view:
                if (listItemView == null)
                {
                    listItemView = LayoutInflater.from(mContext).inflate(R.layout.grid_tag_list, parent, false);
                }

                currentTag = getItem(position);
                tag = (TextView) listItemView.findViewById(R.id.tag);
                tag.setText(currentTag);
                imageButton = (ImageView) listItemView.findViewById(R.id.tag_delete);
                imageButton.setVisibility(View.VISIBLE);
                checkBox = (CheckBox) listItemView.findViewById(R.id.tag_checkbox);
                checkBox.setVisibility(View.GONE);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Delete this Tag?");
                        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.cancel();
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
        }

        return listItemView;
    }

    public String getItem(int position)
    {
        return mTags.get(position);
    }

    public long getItemId(int position)
    {
        return 0;
    }
}
