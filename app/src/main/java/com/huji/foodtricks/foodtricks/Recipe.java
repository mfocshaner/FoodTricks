package com.huji.foodtricks.foodtricks;

public class Recipe {

    String _name;
    String _pic_url;
    int _duration; // Cooking time in minutes

    public Recipe(String jsonInfo) {

    }

    public String get_name() {
        return _name;
    }

    public String get_pic_url() {
        return _pic_url;
    }

    public int get_duration() {
        return _duration;
    }
}
