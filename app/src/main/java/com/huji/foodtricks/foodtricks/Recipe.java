package com.huji.foodtricks.foodtricks;

import com.google.gson.JsonElement;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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

    public static void main(String[] args) throws IOException, JSONException {
        // this function is here only to test the validity and the format of the returned info
        String[] ingridients = {"cheese", "chicken"};
        String url = ChooseIngredients.buildUrl(ingridients);
        System.out.println(url);
        String result = ChooseIngredients.getRecipeStrings(url);
        System.out.println(result);
        JsonElement obj = ChooseIngredients.readJsonFromUrl(url);
    }

    public static String readFile()
            throws IOException
    {

        Scanner scanner = new Scanner( new File("C:\\Users\\idosa\\AndroidStudioProjects\\FoodTricks\\app\\src\\main\\java\\returnedRecipes") );
        String text = scanner.useDelimiter("\\A").next();
        scanner.close();
        return text;
    }

}
