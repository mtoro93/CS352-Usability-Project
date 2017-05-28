package com.example.android.cookbook;

/**
 * Created by eisat_000 on 5/27/2017.
 */

public class SocialMedia {

    private String mName;
    private int mResourceId;

    public SocialMedia(String name, int resourceId)
    {
        mName = name;
        mResourceId = resourceId;
    }

    public String getName()
    {
        return mName;
    }

    public int getResourceId()
    {
        return mResourceId;
    }
}
