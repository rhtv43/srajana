package com.zebra.deliveryapp.parser;

/**
 * Created by CQJG67 on 8/25/2016.
 */
//--------------------------------------------------------
//Server - Data access...

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//------------------------------------------------------------


public class JSONParser {

    public JSONObject getJSONFromUrl(String urlString) {
        StringBuilder sRawJsonString = new StringBuilder();
        JSONObject sReturnJsonObject = null;
        HttpURLConnection urlConnection = null;
        try {
            //URL url = new URL("https://api.github.com/users/dmnugent80/repos");
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                sRawJsonString.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        try {
            sReturnJsonObject = new JSONObject(sRawJsonString.toString());
        } catch (JSONException e) {
            Log.e("Parser", "Error when parsing data " + e.toString());
        }

        //return json object
        return sReturnJsonObject;

    }

}
