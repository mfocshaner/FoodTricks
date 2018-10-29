package com.huji.foodtricks.foodtricks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        getJsonFromFile();
    }

    public static String readFile()
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get("returnedRecipes"));
        return new String(encoded,  StandardCharsets.ISO_8859_1);
    }

    public static String getJsonFromFile() throws IOException, JSONException {
//        JSONParser parser = new JSONParser();
//        JSONArray json_data = (JSONArray) parser.parse(new FileReader("returnedRecipes"));
//        for (Object o : json_data)
//        {
//            JSONObject recipe = (JSONObject) o;
//            System.out.println(recipe);
//        }
        JSONObject returned_query = new JSONObject(readFile());
//        String in;
//        JSONObject reader = new JSONObject(in);
        JSONArray recipe_hits = returned_query.getJSONArray("hits");
        int n = recipe_hits.length();

        for (int i = 0; i < n ; i++)
        {
            System.out.println(recipe_hits.getJSONObject(i));
        }
        return "None";
    }

}
