package com.zebra.deliveryapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import com.zebra.deliveryapp.database.DBContracts;
import com.zebra.deliveryapp.database.DBHelper;
import com.zebra.deliveryapp.database.Product;
import com.zebra.deliveryapp.parser.JSONParser;

/**
 * Created by VMD763 on 9/8/2016.
 */
public class WelcomeScreen extends Activity {

    private Button startBtn;
    private ProgressBar mProgressBar;
    private Context mContext;
    private String url = "https://api.myjson.com/bins/1hgz3";
    public static ArrayList<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        startBtn = (Button) findViewById(R.id.btn);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DataAsyncTask().execute(url);

            }
        });
    }

    public class DataAsyncTask extends AsyncTask<String, Void, JSONObject> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);
            mProgressBar.setVisibility(View.INVISIBLE);
            Intent mIntent = new Intent(WelcomeScreen.this, MainActivity.class);
            startActivity(mIntent);
        }

        @Override
        protected JSONObject doInBackground(String... params) {
            Log.d("santosh" , "doinbackground");
            try {
                String url = params[0];
                JSONParser jParser = new JSONParser();
                // get JSON data from URL
                Log.d("santosh" , "before getJSONFromUrl");
                JSONObject json = jParser.getJSONFromUrl(url);
                Log.d("santosh" , "after getJSONFromUrl");
                if(json == null) {
                    return null;
                }
                JSONArray jArray = json.getJSONArray("list");
                DBHelper db = DBHelper.getInstance(mContext);
                for (int i = 0; i < jArray.length(); i++) {
                    Log.d("santosh" , "looping " + jArray.length());
                    JSONObject c = jArray.getJSONObject(i);
                    String pid = c.getString(DBContracts.KEY_PRODUCT_ID);
                    String pName = c.getString(DBContracts.KEY_PRODUCT_PRODUCT_NAME);
                    String pAddress = c.getString(DBContracts.KEY_PRODUCT_ADDRESS);
                    String pMobile = c.getString(DBContracts.KEY_PRODUCT_MOBILE);
                    String pBTaddress = c.getString(DBContracts.KEY_PRODUCT_BT_ADDRESS);
                    String pshipment = c.getString(DBContracts.KEY_PRODUCT_SHIPMENT);
                    //db.addProduct(new Product(pid, pName, pAddress, pMobile, pBTaddress, pshipment));
                    productList.add(new Product(pid, pName, pAddress, pMobile, pBTaddress, pshipment));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
