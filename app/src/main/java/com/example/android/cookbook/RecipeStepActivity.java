package com.example.android.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by eisat_000 on 4/24/2017.
 */

public class RecipeStepActivity extends AppCompatActivity {

    int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_step);

        Bundle data = getIntent().getExtras();

        TextView textView = (TextView) findViewById(R.id.recipe_step_directions);
        ImageView imageView = (ImageView) findViewById(R.id.recipe_step_picture);

        mPosition = data.getInt("position");

        String currentText = "";
        int currentImage = R.drawable.tacos;
        if (data.getInt("position") == 0)
        {
            currentImage = data.getInt("Step 1 Picture");
            currentText = data.getString("Step 1 Direction");
        }

        else if (data.getInt("position") == 1)
        {
            currentImage = data.getInt("Step 2 Picture");
            currentText = data.getString("Step 2 Direction");
        }

        else if (data.getInt("position") == 2)
        {
            currentImage = data.getInt("Step 3 Picture");
            currentText = data.getString("Step 3 Direction");
        }

        textView.setText(currentText);
        imageView.setImageResource(currentImage);


        ImageButton left = (ImageButton) findViewById(R.id.recipe_step_left);
        ImageButton right = (ImageButton) findViewById(R.id.recipe_step_right);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(mPosition)
                {
                    case 0:
                        Intent recipeActivity = new Intent(RecipeStepActivity.this, DisplayActivity.class);
                        startActivity(recipeActivity);
                        break;
                    case 1:
                        Intent step1Intent = new Intent(RecipeStepActivity.this, RecipeStepActivity.class);
                        Bundle step1Data = new Bundle();
                        step1Data.putInt("position", 0);
                        step1Data.putInt("Step 1 Picture", R.drawable.step1);
                        step1Data.putString("Step 1 Direction", "1. Preheat oven to 350 degrees F. Grease and flour two 9-inch round baking pans.");
                        step1Intent.putExtras(step1Data);
                        startActivity(step1Intent);
                        break;
                    case 2:
                        Intent step2Intent = new Intent(RecipeStepActivity.this, RecipeStepActivity.class);
                        Bundle step2Data = new Bundle();
                        step2Data.putInt("position", 1);
                        step2Data.putInt("Step 2 Picture", R.drawable.step2);
                        step2Data.putString("Step 2 Direction", "2. In a large bowl, combine the sugar, flour, cocoa, baking powder, baking soda, and salt. Add eggs, milk, oil, and vanilla. Mix until smooth. Stir in boiling water (batter will be thin). Pour batter into prepared pans.");
                        step2Intent.putExtras(step2Data);
                        startActivity(step2Intent);
                        break;
                }

            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(mPosition)
                {
                    case 0:
                        Intent step2Intent = new Intent(RecipeStepActivity.this, RecipeStepActivity.class);
                        Bundle step2Data = new Bundle();
                        step2Data.putInt("position", 1);
                        step2Data.putInt("Step 2 Picture", R.drawable.step2);
                        step2Data.putString("Step 2 Direction", "2. In a large bowl, combine the sugar, flour, cocoa, baking powder, baking soda, and salt. Add eggs, milk, oil, and vanilla. Mix until smooth. Stir in boiling water (batter will be thin). Pour batter into prepared pans.");
                        step2Intent.putExtras(step2Data);
                        startActivity(step2Intent);

                        break;
                    case 1:
                        Intent step3Intent = new Intent(RecipeStepActivity.this, RecipeStepActivity.class);
                        Bundle step3Data = new Bundle();
                        step3Data.putInt("position", 2);
                        step3Data.putInt("Step 3 Picture", R.drawable.step3);
                        step3Data.putString("Step 3 Direction", "3. Bake 30 to 35 minutes or until a toothpick inserted in the center comes out clean. Cool completely.");
                        step3Intent.putExtras(step3Data);
                        startActivity(step3Intent);
                        break;
                    case 2:
                        Intent recipeActivity = new Intent(RecipeStepActivity.this, DisplayActivity.class);
                        startActivity(recipeActivity);
                        break;
                }
            }
        });

    }
}
