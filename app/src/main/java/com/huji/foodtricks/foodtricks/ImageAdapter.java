package com.huji.foodtricks.foodtricks;

import android.content.Context;
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
            new Ingredient(R.drawable.apple, "apple")
    };
    // references to our images
    private static Integer[] ingredientIds = {
            R.drawable.apple, R.drawable.avocado,
            R.drawable.beans, R.drawable.broccoli,
            R.drawable.butter, R.drawable.carrot,
            R.drawable.cauliflower, R.drawable.cheese,
            R.drawable.chicken, R.drawable.chili,
            R.drawable.cucumber, R.drawable.eggs,
            R.drawable.fish, R.drawable.flour,
            R.drawable.garlic, R.drawable.grapes,
            R.drawable.lemon, R.drawable.lettuce,
            R.drawable.mushroom, R.drawable.olive_oil,
            R.drawable.onion, R.drawable.rice,
            R.drawable.beef, R.drawable.pasta,
            R.drawable.sausage, R.drawable.spinach,
            R.drawable.tomato, R.drawable.potatoes,
            R.drawable.bacon, R.drawable.bell_pepper,
            R.drawable.cabbage, R.drawable.ginger,
            R.drawable.leek
    };

    private static String[] ingredientNames = {
            "apple", "avocado", "beans", "broccoli",
            "butter", "carrot", "cauliflower", "cheese",
            "chicken", "chili", "cucumber", "eggs",
            "fish", "flour", "garlic", "grapes",
            "lemon", "lettuce", "mushroom", "olive_oil",
            "onion", "rice", "beef", "pasta",
            "sausage", "spinach", "tomato", "potatoes",
            "bacon", "bell_pepper", "cabbage", "ginger",
            "leek"
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
        customText.setText(ingredientNames[position]);
        customImage.setImageResource(ingredientIds[position]);

        return customView;
    }

    public String getIngredientName(int id) {
        return ingredientsConversionMap.get(id);
    }

    private void initializeConversionMap() {
        for (int i = 0; i < INGREDIENTS_AMOUNT; ++i) {
            ingredientsConversionMap.put(i, ingredients[i].getName());
        }
        ingredientsConversionMap.put(0, "apple");
        ingredientsConversionMap.put(1, "avocado");
        ingredientsConversionMap.put(2, "beans");
        ingredientsConversionMap.put(3, "broccoli");
        ingredientsConversionMap.put(4, "butter");
        ingredientsConversionMap.put(5, "carrot");
        ingredientsConversionMap.put(6, "cauliflower");
        ingredientsConversionMap.put(7, "cheese");
        ingredientsConversionMap.put(8, "chicken");
        ingredientsConversionMap.put(9, "chili");
        ingredientsConversionMap.put(10, "cucumber");
        ingredientsConversionMap.put(11, "eggs");
        ingredientsConversionMap.put(12, "fish");
        ingredientsConversionMap.put(13, "flour");
        ingredientsConversionMap.put(14, "garlic");
        ingredientsConversionMap.put(15, "grapes");
        ingredientsConversionMap.put(16, "lemon");
        ingredientsConversionMap.put(17, "lettuce");
        ingredientsConversionMap.put(18, "mushroom");
        ingredientsConversionMap.put(19, "olive oil");
        ingredientsConversionMap.put(20, "onion");
        ingredientsConversionMap.put(21, "rice");
        ingredientsConversionMap.put(22, "beef");
        ingredientsConversionMap.put(23, "pasta");
        ingredientsConversionMap.put(24, "sausage");
        ingredientsConversionMap.put(25, "spinach");
        ingredientsConversionMap.put(26, "tomato");
        ingredientsConversionMap.put(27, "potato");
        ingredientsConversionMap.put(28, "bacon");
        ingredientsConversionMap.put(29, "bell pepper");
        ingredientsConversionMap.put(30, "cabbage");
        ingredientsConversionMap.put(31, "ginger");
        ingredientsConversionMap.put(32, "leek");
    }

}
