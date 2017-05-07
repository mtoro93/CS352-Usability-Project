package com.example.android.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button browseButton = (Button) findViewById(R.id.button_browse);
        browseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                Intent browseIntent =  new Intent(MainActivity.this, BrowseActivity.class);
                startActivity(browseIntent);
            }
        });
    }

    protected void write(Button button)
    {
        Intent writeIntent = new Intent(MainActivity.this, WriteActivity.class);
        startActivity(writeIntent);
    }

    protected void edit (Button button)
    {

    }

}
