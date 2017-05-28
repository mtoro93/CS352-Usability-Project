package com.example.android.cookbook;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tooltip.Tooltip;

/**
 * Created by eisat_000 on 4/24/2017.
 */

public class UploadActivity extends AppCompatActivity{

    boolean successful = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);


        final String fileTooltip =  this.getString(R.string.file_upload_tooltip);
        final String emailTooltip = this.getString(R.string.email_upload_tooltip);
        final String urlTooltip = this.getString(R.string.url_upload_tooltip);

        ImageView fileUploadInfo = (ImageView) findViewById(R.id.file_upload_info);
        fileUploadInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showTooltip(view, Gravity.BOTTOM, fileTooltip);
            }
        });

        ImageView urlUploadInfo = (ImageView) findViewById(R.id.url_upload_info);
        urlUploadInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showTooltip(view, Gravity.BOTTOM, urlTooltip);
            }
        });

        ImageView emailUploadInfo = (ImageView) findViewById(R.id.email_upload_info);
        emailUploadInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showTooltip(view, Gravity.BOTTOM, emailTooltip);
            }
        });


        final ImageButton submitEmail = (ImageButton) findViewById(R.id.button_submit_email);
        submitEmail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                submitEmail.setVisibility(View.INVISIBLE);
                ProgressBar progress = (ProgressBar) findViewById(R.id.email_loading_indicator);
                progress.setVisibility(View.VISIBLE);
                if (successful)
                {
                    submitEmail.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                    Intent categoryIntent = new Intent(UploadActivity.this, CategoryActivity.class);
                    startActivity(categoryIntent);
                }
                else {
                    Toast.makeText(getBaseContext(), "The submission failed. Please double check the directions.", Toast.LENGTH_LONG).show();
                    submitEmail.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                }
            }
        });


        final ImageButton submitURL = (ImageButton) findViewById(R.id.button_submit_url);
        submitURL.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                submitURL.setVisibility(View.INVISIBLE);
                ProgressBar progress = (ProgressBar) findViewById(R.id.url_loading_indicator);
                progress.setVisibility(View.VISIBLE);
                if (successful)
                {
                    submitURL.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                    Intent categoryIntent = new Intent(UploadActivity.this, CategoryActivity.class);
                    startActivity(categoryIntent);
                }
                else {
                    Toast.makeText(getBaseContext(), "The submission failed. Please double check the directions.", Toast.LENGTH_LONG).show();
                    submitURL.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                }
            }
        });

        final ImageButton submitFile = (ImageButton) findViewById(R.id.button_submit_file);
        submitFile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                submitFile.setVisibility(View.INVISIBLE);
                ProgressBar progress = (ProgressBar) findViewById(R.id.file_loading_indicator);
                progress.setVisibility(View.VISIBLE);
                if (successful)
                {
                    submitFile.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                    Intent categoryIntent = new Intent(UploadActivity.this, CategoryActivity.class);
                    startActivity(categoryIntent);
                }
                else {
                    Toast.makeText(getBaseContext(), "The submission failed. Please double check the directions.", Toast.LENGTH_LONG).show();
                    submitFile.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void showTooltip(View view, int gravity, String text)
    {
        ImageView img = (ImageView) view;
        Tooltip tooltip = new Tooltip.Builder(view)
                .setText(text)
                .setBackgroundColor(Color.BLACK)
                .setTextColor(Color.WHITE)
                .setGravity(gravity)
                .setCornerRadius(8f)
                .setDismissOnClick(true)
                .setCancelable(true)
                .show();
    }
}
