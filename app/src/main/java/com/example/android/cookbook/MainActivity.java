package com.example.android.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void write(Button button)
    {
        Intent writeIntent = new Intent(MainActivity.this, WriteActivity.class);
        startActivity(writeIntent);
    }

    protected void edit (Button button)
    {

    }

    protected void browse (Button button)
    {
        Intent browseIntent =  new Intent(MainActivity.this, BrowseActivity.class);
        startActivity(browseIntent);
    }
}
