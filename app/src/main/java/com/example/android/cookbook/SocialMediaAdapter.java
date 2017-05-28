package com.example.android.cookbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eisat_000 on 5/27/2017.
 */

public class SocialMediaAdapter extends ArrayAdapter<SocialMedia> {

    public SocialMediaAdapter(Context context, ArrayList<SocialMedia> media)
    {
        super(context, 0, media);
    }

    @NonNull
    @Override
    public View getView (int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        SocialMedia current;
        TextView wordTextView;
        ImageView imageView;

        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.share_list_item, parent, false);
        }

        current = getItem(position);

        imageView = (ImageView) listItemView.findViewById(R.id.social_media_image);
        imageView.setImageResource(current.getResourceId());

        wordTextView = (TextView) listItemView.findViewById(R.id.social_media_text);
        wordTextView.setText(current.getName());

        return listItemView;
    }
}
