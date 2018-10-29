package com.huji.foodtricks.foodtricks;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.net.URL;
import java.net.*;
import java.io.*;


public class ChooseIngredients extends AppCompatActivity {

    private static final String RECIPE_BASE_URL = "https://api.edamam.com/search?q=";
    private static final String SPACE_CHAR = "%20";
    private static final String API_CREDENTIALS = "&app_id=1b816ee9&app_key=fd31256c4657f51aa2d1edcfb85375fd";
    private static final String LIMIT_RECIPES = "&to=";
    private static final int MAX_RECIPES = 3;
    private static final String INGREDIENTS = "Ingredients";

    private IngredientsList ingredientsList;

    protected static String buildUrl(String[] ingridients) {
        StringBuilder url = new StringBuilder(RECIPE_BASE_URL);
        for (String ingridient : ingridients) {
            url.append(ingridient).append(SPACE_CHAR);
        }
        url.append(API_CREDENTIALS).append(LIMIT_RECIPES).append(MAX_RECIPES);
        System.out.println(url.toString());
        return url.toString();
    }

    protected static String getRecipeStrings(String url) throws IOException {
        // store the information for the matching url query from Adamame API
        try (Scanner scanner = new Scanner(new URL(url).openStream(),
                StandardCharsets.UTF_8.toString())) {
            scanner.useDelimiter("\\A"); // tokenize the entire string - NEEDED
            return scanner.hasNext() ? scanner.next() : ""; // return query or null
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_choose_ingredients);
        setupGridView();

        ingredientsList = new IngredientsList();
    }

    public void setupGridView(){
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                ImageAdapter adapter = (ImageAdapter) gridview.getAdapter();
                adapter.setIsPressed(position);
                if (adapter.getIsPressed(position)) {
                    ImageView imageView = (ImageView) v;
                    imageView.setImageAlpha(100);
                } else {
                    ImageView imageView = (ImageView) v;
                    imageView.setImageAlpha(255);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_ingredients, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void feedMe(View view) {
        Intent feedIntent = new Intent(this, SecondActivity.class);
        feedIntent.putExtra(INGREDIENTS, ingredientsList);

        startActivity(feedIntent);
    }

}
