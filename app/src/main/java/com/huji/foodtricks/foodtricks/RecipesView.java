package com.huji.foodtricks.foodtricks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class RecipesView extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_listview_layout);
        mListView = (ListView) findViewById(R.id.recipeListView);

        ArrayList<RecipeCard> list = new ArrayList<>();

        list.add(new RecipeCard("drawable://" + R.drawable.pasta, "Pasta"));
        list.add(new RecipeCard("drawable://" + R.drawable.chicken, "Chicken"));
        list.add(new RecipeCard("drawable://" + R.drawable.rice_recipe, "Rice"));
        list.add(new RecipeCard("drawable://" + R.drawable.quinoa, "Quinoa"));

        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.activity_recipes_view, list);
        mListView.setAdapter(adapter);
    }


}
