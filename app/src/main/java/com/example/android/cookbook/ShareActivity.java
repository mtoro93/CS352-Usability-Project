package com.example.android.cookbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by eisat_000 on 5/27/2017.
 */

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_share);

        ListView socialMediaList = (ListView) findViewById(R.id.share_list);

        ArrayList<SocialMedia> mediaList = new ArrayList<SocialMedia>();
        mediaList.add(new SocialMedia("SMS", R.drawable.sms_48));
        mediaList.add(new SocialMedia("Email", R.drawable.gmail_48));
        mediaList.add(new SocialMedia("Facebook", R.drawable.facebook_48));
        mediaList.add(new SocialMedia("Pinterest", R.drawable.pinterest_48));
        mediaList.add(new SocialMedia("Instagram", R.drawable.instagram_48));
        SocialMediaAdapter socialMediaAdapter = new SocialMediaAdapter(this, mediaList);

        socialMediaList.setAdapter(socialMediaAdapter);
    }
}
