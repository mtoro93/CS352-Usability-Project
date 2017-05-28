package com.example.android.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by eisat_000 on 5/26/2017.
 */

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_categories);

        ArrayList<String> tags = new ArrayList<String>();
        tags.add("beef");
        tags.add("chili");
        tags.add("stew");

        tags.add("pasta");
        tags.add("cake");
        tags.add("dessert");

        tags.add("chocolate");
        tags.add("beans");
        tags.add("spicy");


        GridView gridView = (GridView) findViewById(R.id.test_grid_view);
        GridAdapter gridAdapter = new GridAdapter(this, tags);
        gridView.setAdapter(gridAdapter);


        Button finish = (Button) findViewById(R.id.dialog_category_finish_button);
        finish.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent homeActivity = new Intent (CategoryActivity.this, BrowseActivity.class);
                Bundle data = new Bundle();
                data.putBoolean("saved", true);
                homeActivity.putExtras(data);
                startActivity(homeActivity);
            }
        });
    }
}
