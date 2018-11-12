package com.huji.foodtricks.foodtricks;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * sets up an image grid
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private static int INGREDIENT_TEXT_SIZE = 14;

    private static Ingredient[] ingredients = {
            new Ingredient(R.drawable.pasta, "Pasta"),
            new Ingredient(R.drawable.rice, "Rice"),
            new Ingredient(R.drawable.potatoes, "Potatoes"),
            new Ingredient(R.drawable.flour, "Flour"),
            new Ingredient(R.drawable.cheese, "Cheese"),
            new Ingredient(R.drawable.beef, "Beef"),
            new Ingredient(R.drawable.chicken, "Chicken"),
            new Ingredient(R.drawable.fish, "Fish"),
            new Ingredient(R.drawable.eggs, "Eggs"),
            new Ingredient(R.drawable.beans, "Beans"),
            new Ingredient(R.drawable.broccoli, "Broccoli"),
            new Ingredient(R.drawable.carrot, "Carrot"),
            new Ingredient(R.drawable.cauliflower, "Cauliflower"),
            new Ingredient(R.drawable.leek, "Leek"),
            new Ingredient(R.drawable.mushroom, "Mushroom"),
            new Ingredient(R.drawable.sausage, "Sausage"),
            new Ingredient(R.drawable.tomato, "Tomato"),
            new Ingredient(R.drawable.avocado, "Avocado"),
            new Ingredient(R.drawable.bell_pepper, "Bell Pepper"),
            new Ingredient(R.drawable.cabbage, "Cabbage"),
            new Ingredient(R.drawable.lettuce, "Lettuce"),
            new Ingredient(R.drawable.cucumber, "Cucumber"),
            new Ingredient(R.drawable.spinach, "Spinach"),
            new Ingredient(R.drawable.bacon, "Bacon"),
            new Ingredient(R.drawable.butter, "Butter"),
            new Ingredient(R.drawable.olive_oil, "Olive Oil"),
            new Ingredient(R.drawable.onion, "Onion"),
            new Ingredient(R.drawable.garlic, "Garlic"),
            new Ingredient(R.drawable.chili, "Chili"),
            new Ingredient(R.drawable.lemon, "Lemon"),
            new Ingredient(R.drawable.ginger, "Ginger"),
            new Ingredient(R.drawable.grapes, "Grapes"),
            new Ingredient(R.drawable.apple, "Apple")
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
        View customView;
        LayoutInflater inflater = (LayoutInflater) mContext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView != null) {
            customView = (View) convertView;
            return customView;
        }
        // if it's not recycled, initialize some attributes
        customView = new View(mContext);

        customView = inflater.inflate(R.layout.imagetext_layout, null);
        TextView customText = (TextView) customView.findViewById(R.id.custom_text);
        ImageView customImage = (ImageView) customView.findViewById(R.id.custom_image);
        customText.setText(ingredients[position].getName());
        customText.setTextSize(INGREDIENT_TEXT_SIZE);
        customText.setTypeface(null, Typeface.BOLD);
        customImage.setImageResource(ingredients[position].getIcon());

        return customView;
    }

    public String getIngredientName(int id) {
        return ingredientsConversionMap.get(id);
    }

    private void initializeConversionMap() {
        for (int i = 0; i < INGREDIENTS_AMOUNT; ++i) {
            ingredientsConversionMap.put(i, ingredients[i].getName());
        }
    }

}
