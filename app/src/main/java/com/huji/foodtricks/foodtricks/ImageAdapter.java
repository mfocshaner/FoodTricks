package com.huji.foodtricks.foodtricks;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.Arrays;

/**
 * sets up an image grid
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.apple, R.drawable.avocado,
            R.drawable.broccoli, R.drawable.carrot,
            R.drawable.cheese, R.drawable.chili,
            R.drawable.fish, R.drawable.flour,
            R.drawable.lemon, R.drawable.meat,
            R.drawable.mushroom, R.drawable.onion,
            R.drawable.beans, R.drawable.butter,
            R.drawable.cauliflower, R.drawable.cucumber,
            R.drawable.eggs, R.drawable.garlic,
            R.drawable.rice_recipe, R.drawable.steak,
            R.drawable.olive, R.drawable.grapes,
    };

    private boolean[] isPressed = new boolean[22];


    public ImageAdapter(Context c) {
        mContext = c;
        Arrays.fill(isPressed, Boolean.FALSE);
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

}
