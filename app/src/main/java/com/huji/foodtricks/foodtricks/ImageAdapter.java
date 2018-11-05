package com.huji.foodtricks.foodtricks;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * sets up an image grid
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    private static Ingredient[] ingredients = {
            new Ingredient(R.drawable.pasta, "pasta"),
            new Ingredient(R.drawable.rice, "rice"),
            new Ingredient(R.drawable.potatoes, "potatoes"),
            new Ingredient(R.drawable.flour, "flour"),
            new Ingredient(R.drawable.cheese, "cheese"),
            new Ingredient(R.drawable.beef, "beef"),
            new Ingredient(R.drawable.chicken, "chicken"),
            new Ingredient(R.drawable.fish, "fish"),
            new Ingredient(R.drawable.eggs, "eggs"),
            new Ingredient(R.drawable.beans, "beans"),
            new Ingredient(R.drawable.broccoli, "broccoli"),
            new Ingredient(R.drawable.carrot, "carrot"),
            new Ingredient(R.drawable.cauliflower, "cauliflower"),
            new Ingredient(R.drawable.leek, "leek"),
            new Ingredient(R.drawable.mushroom, "mushroom"),
            new Ingredient(R.drawable.sausage, "sausage"),
            new Ingredient(R.drawable.tomato, "tomato"),
            new Ingredient(R.drawable.avocado, "avocado"),
            new Ingredient(R.drawable.bell_pepper, "bell pepper"),
            new Ingredient(R.drawable.cabbage, "cabbage"),
            new Ingredient(R.drawable.lettuce, "lettuce"),
            new Ingredient(R.drawable.cucumber, "cucumber"),
            new Ingredient(R.drawable.spinach, "spinach"),
            new Ingredient(R.drawable.bacon, "bacon"),
            new Ingredient(R.drawable.butter, "butter"),
            new Ingredient(R.drawable.olive_oil, "olive oil"),
            new Ingredient(R.drawable.onion, "onion"),
            new Ingredient(R.drawable.garlic, "garlic"),
            new Ingredient(R.drawable.chili, "chili"),
            new Ingredient(R.drawable.lemon, "lemon"),
            new Ingredient(R.drawable.ginger, "ginger"),
            new Ingredient(R.drawable.grapes, "grapes"),
            new Ingredient(R.drawable.apple, "apple"),
    };



    static final int INGREDIENTS_AMOUNT = ingredients.length;

    private HashMap<Integer, String> ingredientsConversionMap = new HashMap<>();


    private boolean[] isPressed = new boolean[INGREDIENTS_AMOUNT];


    public ImageAdapter(Context c) {
        mContext = c;
        Arrays.fill(isPressed, Boolean.FALSE);
        initializeConversionMap();
    }

    public int getCount() {
        return ingredients.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public void setIsPressed(int id) {
        isPressed[id] = !isPressed[id];
    }
    public boolean getIsPressed(int id) {
        return isPressed[id];
    }
    // create a new ImageView for each item referenced by the Adapter

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(ingredients[position].getIcon());

        return imageView;
    }

    public String getIngredientName(int id) {
        return ingredientsConversionMap.get(id);
    }

    private void initializeConversionMap() {
        for (int i = 0; i < INGREDIENTS_AMOUNT; ++i){
            ingredientsConversionMap.put(i, ingredients[i].getName());
        }
    }

}
