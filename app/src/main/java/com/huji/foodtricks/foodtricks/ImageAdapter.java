package com.huji.foodtricks.foodtricks;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.HashMap;

/**
 * sets up an image grid
 */
public class ImageAdapter extends BaseAdapter {
    private static final int INGREDIENTS_AMOUNT = 23;

    private Context mContext;
    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.apple, R.drawable.avocado,
            R.drawable.beans, R.drawable.broccoli,
            R.drawable.butter, R.drawable.carrot,
            R.drawable.cauliflower, R.drawable.cheese,
            R.drawable.chicken_icon, R.drawable.chili,
            R.drawable.cucumber, R.drawable.eggs,
            R.drawable.fish, R.drawable.flour,
            R.drawable.garlic, R.drawable.grapes,
            R.drawable.lemon, R.drawable.lettuce,
            R.drawable.mushroom, R.drawable.olive_oil,
            R.drawable.onion, R.drawable.rice,
            R.drawable.steak
    };
    private HashMap<Integer, String> ingredientsConversionMap = new HashMap<>();


    private boolean[] isPressed = new boolean[INGREDIENTS_AMOUNT];


    public ImageAdapter(Context c) {
        mContext = c;
        Arrays.fill(isPressed, Boolean.FALSE);
        initializeConversionMap();
    }

    public int getCount() {
        return mThumbIds.length;
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
        imageView.setImageResource(mThumbIds[position]);

        return imageView;
    }

    public String getIngredientName(int id){
        return ingredientsConversionMap.get(id);
    }

    private void initializeConversionMap(){
        ingredientsConversionMap.put(0,"apple");
        ingredientsConversionMap.put(1,"avocado");
        ingredientsConversionMap.put(2,"beans");
        ingredientsConversionMap.put(3,"broccoli");
        ingredientsConversionMap.put(4,"butter");
        ingredientsConversionMap.put(5,"carrot");
        ingredientsConversionMap.put(6,"cauliflower");
        ingredientsConversionMap.put(7,"cheese");
        ingredientsConversionMap.put(8,"chicken");
        ingredientsConversionMap.put(9,"chili");
        ingredientsConversionMap.put(10,"cucumber");
        ingredientsConversionMap.put(11,"eggs");
        ingredientsConversionMap.put(12,"fish");
        ingredientsConversionMap.put(13,"flour");
        ingredientsConversionMap.put(14,"garlic");
        ingredientsConversionMap.put(15,"grapes");
        ingredientsConversionMap.put(16,"lemon");
        ingredientsConversionMap.put(17,"lettuce");
        ingredientsConversionMap.put(18,"mushroom");
        ingredientsConversionMap.put(19,"olive oil");
        ingredientsConversionMap.put(20,"onion");
        ingredientsConversionMap.put(21,"rice");
        ingredientsConversionMap.put(22,"steak");
    }

}
