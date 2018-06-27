package com.example.android.cookbook;

/**
 * Created by eisat_000 on 5/6/2017.
 */

public class Recipe {

    String mRecipeName;
    String mCategoryName;

    public Recipe(String recipeName, String categoryName)
    {
        mRecipeName = recipeName;
        mCategoryName = categoryName;
    }

    public String getRecipeName()
    {
        return mRecipeName;
    }

    public void setCategoryName(String categoryName)
    {
        mCategoryName = categoryName;
    }

    public String getCategoryName()
    {
        return mCategoryName;
    }
}
