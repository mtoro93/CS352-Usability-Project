package com.example.android.cookbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by eisat_000 on 4/24/2017.
 */

public class UploadActivity extends AppCompatActivity {

    boolean successful;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);


        Button submitEmail = (Button) findViewById(R.id.button_submit_email);
        submitEmail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (successful)
                    Toast.makeText(getBaseContext(), "The submission was successful.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getBaseContext(), "The submission failed. Please double check the directions.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
