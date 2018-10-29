package com.huji.foodtricks.foodtricks;

import com.google.gson.JsonObject;

import org.json.JSONException;

import java.io.IOException;
public class Recipe {


    String _name;
    String _pic_url;
    String _url;
    int _duration; // Cooking time in minutes

    public Recipe(JsonObject recipe_json) {
        JsonObject recipe_elem = (JsonObject) recipe_json.get("recipe");
        this._name = recipe_elem.get("label").getAsString();
        this._url= recipe_elem.get("url").getAsString();
        this._duration= recipe_elem.get("totalTime").getAsInt();
        this._pic_url= recipe_elem.get("image").getAsString();

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

    public String get_url() {
        return _url;
    }

    public static void main(String[] args) throws IOException, JSONException {
        // this function is here only to test the validity and the format of the returned info
        String[] ingridients = {"cheese", "chicken"};
        String url = ChooseIngredients.buildUrl(ingridients);
        RecipesFactory.getRecipes(url);
    }


}
