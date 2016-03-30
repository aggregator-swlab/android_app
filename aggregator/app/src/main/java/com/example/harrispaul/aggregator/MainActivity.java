package com.example.harrispaul.aggregator;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Harrispaul on 3/14/2016.
 */

public class MainActivity  extends Activity implements AdapterView.OnItemSelectedListener {

    ListView list;
    String jsonStr;
    ArrayList<ItemContent> array = new ArrayList<ItemContent>();
    ImageButton enter;
    EditText search;
    ProgressBar progressBar;
    MyCustomBaseAdapter adapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinnerSort = (Spinner) findViewById(R.id.sort);
        ArrayAdapter<CharSequence> adapterSort = ArrayAdapter.createFromResource(this, R.array.sorts_array, android.R.layout.simple_spinner_item);
        adapterSort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSort.setAdapter(adapterSort);

        Spinner spinnerFilter = (Spinner) findViewById(R.id.filter);
        ArrayAdapter<CharSequence> adapterFilter = ArrayAdapter.createFromResource(this, R.array.filters_array, android.R.layout.simple_spinner_item);
        adapterFilter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFilter.setAdapter(adapterFilter);

        spinnerFilter.setOnItemSelectedListener(this);
        spinnerSort.setOnItemSelectedListener(this);



        adapter = new MyCustomBaseAdapter(this, array);

        list = (ListView) findViewById(R.id.list_view_product);

        search = (EditText) findViewById(R.id.search_text);

        enter = (ImageButton) findViewById(R.id.button);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        list.setAdapter(adapter);

        final String[] searchString = new String[1];
        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                searchString[0] = search.getText().toString();
                Context context = getApplicationContext();

                int duration = Toast.LENGTH_SHORT;
                String[] temp = search.getText().toString().split(" ");

                searchString[0] = temp[0];
                for (int i = 1; i < temp.length; i++) {
                    searchString[0] += "+" + temp[i];
                }


//                Context context = getApplicationContext();
                Toast.makeText(context, searchString[0], Toast.LENGTH_SHORT).show();
                new AsyncTask<Void, Void, ArrayList<ItemContent>>() {
                    String jsonStr1;
                    @Override
                    protected ArrayList<ItemContent> doInBackground(Void... params) {
                        Log.v("before","size of the array is" + array.size());
                        array.clear();
                        Log.v("middle", "size of the array is" + array.size());
                        jsonStr1 = fetch("https://aggregator-scripts-azharullah.c9users.io/flipkart.php?query=" + searchString[0]);
                        try {
                            if (jsonStr1.length() == 0) {
                                Log.v("String", "zero lengthed string");
                            }
                            else
                                getDataFromJson(jsonStr1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.v("final","size of the array is" + array.size());
                        return array;
                    }

                    @Override
                    protected void onPostExecute(ArrayList<ItemContent> result) {

                        Log.v("result", "size of the array is" + result.size());
                        adapter.notifyDataSetChanged();
                        return;
                    }


                }.execute();

            }
        });


//        try {
//            while (jsonStr.length() == 0) {
//                Log.v("String", "zero lengthed string");
//            }
//            getDataFromJson(jsonStr);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Object o = list.getItemAtPosition(position);
                Intent ourIntent;
                ItemContent fullObject = (ItemContent) o;
                Context context = getApplicationContext();
                Toast.makeText(context, "You have chosen: " + " " + fullObject.getTitle(), Toast.LENGTH_SHORT).show();
                ourIntent = new Intent(MainActivity.this, ProductContent.class);

                ourIntent.putExtra("product", fullObject);
                startActivity(ourIntent);

            }
        });


    }

    String fetch(String addr) {
        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL(addr);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            String txt;
            txt = dis.readLine();
            sb.append(txt);
            while (txt != null) {
                Log.d("A", txt);
                txt = dis.readLine();
                sb.append(txt);
            }

        } catch (Exception e) {
            Log.e("Error connection", e.getMessage());
        }

        return sb.toString();
    }

    private void getDataFromJson(String forecastJsonStr)
            throws JSONException {
        JSONObject forecastJson = new JSONObject(forecastJsonStr);
        JSONArray weatherArray = forecastJson.getJSONArray("productInfoList");


        for (int i = 0; i < weatherArray.length(); i++) {

            JSONObject productObject = weatherArray.getJSONObject(i);
            ItemContent it = new ItemContent();
            it.setTitle(productObject.getJSONObject("productBaseInfo").getJSONObject("productAttributes").getString("title"));
            it.setImgid(productObject.getJSONObject("productBaseInfo").getJSONObject("productAttributes").getJSONObject("imageUrls").getString("200x200"));
            it.setDescription(productObject.getJSONObject("productBaseInfo").getJSONObject("productAttributes").getString("title"));
            it.setMaxPrice(productObject.getJSONObject("productBaseInfo").getJSONObject("productAttributes").getJSONObject("maximumRetailPrice").getString("amount"));
            it.setSellingPrice(productObject.getJSONObject("productBaseInfo").getJSONObject("productAttributes").getJSONObject("sellingPrice").getString("amount"));
            it.setId(productObject.getJSONObject("productBaseInfo").getJSONObject("productIdentifier").getString("productId"));
            Log.i("id",it.getId() + "hkdshahkds" + i);
            array.add(it);
        }

        return;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"haii there",Toast.LENGTH_SHORT);
        switch(parent.getItemAtPosition(position).toString()) {
            case "Price-Ascending":
                array.clear();
                break;

        }
            //price ascending;


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}