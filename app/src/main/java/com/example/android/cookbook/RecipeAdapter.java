package com.example.android.cookbook;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eisat_000 on 5/6/2017.
 */

public class RecipeAdapter extends BaseExpandableListAdapter {


    private Context mContext;
    private ArrayList<Recipe> mListDataHeader;
    private HashMap<String, ArrayList<Recipe>> mListDataChild;

    public RecipeAdapter(Context context, ArrayList<Recipe> listDataHeader, HashMap<String, ArrayList<Recipe>> listChildData)
    {
        mContext = context;
        mListDataHeader = listDataHeader;
        mListDataChild = listChildData;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        //ArrayList<Recipe> recipe = (ArrayList<Recipe>) getChild(groupPosition, childPosition);
        Recipe recipe = (Recipe) getChild(groupPosition, childPosition);
        final String childText = recipe.getRecipeName();
       // final String childText = recipe.get(childPosition).getRecipeName();

        if (convertView  == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.recipe_list_item, null);
        }

        if (parent.getId() == R.id.choose_list)
        {
            CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.grocery_list_checkbox);
            checkbox.setVisibility(View.VISIBLE);
        }

        TextView recipeName = (TextView) convertView.findViewById(R.id.recipe_name);
        recipeName.setText(childText);
        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return mListDataChild.get(mListDataHeader.get(groupPosition).getCategoryName()).get(childPosition);
       // return mListDataChild.get(mListDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        //return mListDataChild.get(mListDataHeader.get(groupPosition).getCategoryName()).size();
        return mListDataChild.get(mListDataHeader.get(groupPosition).getCategoryName()).size();
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return mListDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount()
    {
        return mListDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        //ArrayList<Recipe> groupTitle = (ArrayList<Recipe>) getGroup(groupPosition);
        Recipe recipeCategory = (Recipe) getGroup(groupPosition);
        String headerTitle = recipeCategory.getCategoryName();
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.recipe_category_item, null);
        }

        TextView listHeader = (TextView) convertView.findViewById(R.id.recipe_category);
        listHeader.setTypeface(null, Typeface.BOLD);
        listHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }
}
