package com.huji.foodtricks.foodtricks;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Scanner;

import static com.huji.foodtricks.foodtricks.R.color.dot_dark_screen1;
import static com.huji.foodtricks.foodtricks.R.color.dot_dark_screen2;
import static com.huji.foodtricks.foodtricks.R.color.dot_light_screen1;
import static com.huji.foodtricks.foodtricks.R.color.dot_light_screen2;
import static com.huji.foodtricks.foodtricks.R.color.dot_light_screen3;
import static com.huji.foodtricks.foodtricks.R.color.dot_light_screen4;
import static com.huji.foodtricks.foodtricks.R.color.dot_light_screen5;
import static com.huji.foodtricks.foodtricks.R.color.material_blue_grey_800;
import static com.huji.foodtricks.foodtricks.R.color.primary_dark_material_dark;


public class ChooseIngredients extends AppCompatActivity {

    private static final String RECIPE_BASE_URL = "https://api.edamam.com/search?q=";
    private static final String SPACE_CHAR = "%20";
    private static final String API_CREDENTIALS = "&app_id=1b816ee9&app_key=fd31256c4657f51aa2d1edcfb85375fd";
    private static final String LIMIT_RECIPES = "&to=";
    private static final int MAX_RECIPES = 10;
    static final String INGREDIENTS = "Ingredients";
    static final String COOKING_TIME = "CookingTime";
    static final Integer DEFAULT_BACKGROUND = 0;
    static final Integer NUM_OF_COLORS = 5;

    private IngredientsList ingredientsList;
    private Integer[] COLORS = new Integer[NUM_OF_COLORS];


    protected static String buildUrl(ArrayList<String> ingridients) {
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
        changeStatusBarColor();
        COLORS[0] = getResources().getColor(dot_light_screen1);
        COLORS[1] = getResources().getColor(dot_light_screen2);
        COLORS[2] = getResources().getColor(dot_light_screen3);
        COLORS[3] = getResources().getColor(dot_light_screen4);
        COLORS[4] = getResources().getColor(dot_light_screen5);

    }

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.DKGRAY);
        }
    }

    public void setupGridView() {
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));


        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                ImageAdapter adapter = (ImageAdapter) gridview.getAdapter();
                adapter.setIsPressed(position);
                if (position < ImageAdapter.INGREDIENTS_AMOUNT) {
                    if (adapter.getIsPressed(position)) {

                        v.setBackgroundColor(COLORS[position % NUM_OF_COLORS]);
                        ingredientsList.addIngredient(adapter.getIngredientName(position));

                    } else {
                        v.setBackgroundColor(DEFAULT_BACKGROUND);
                        ingredientsList.removeIngredient(adapter.getIngredientName(position));
                    }
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

    private void clearIngredients() {
        ingredientsList.removeAllIngredients();
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.clearChoices();
    }

    public void feedMe(View view) {
        if (ingredientsList.getIngredientsList().size() > 0) {
            Intent feedIntent = new Intent(this, RecipesView.class);
            feedIntent.putExtra(INGREDIENTS, ingredientsList);

            startActivity(feedIntent);
        }
    }

    public void excludeAllIngridients(View view) {
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.clearChoices();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        clearIngredients();
    }
}
