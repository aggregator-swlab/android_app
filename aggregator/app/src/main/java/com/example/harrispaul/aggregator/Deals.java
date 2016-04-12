package com.example.harrispaul.aggregator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Harrispaul on 3/30/2016.
 */
public class Deals extends Activity {

    ListView list;
    String jsonStr;
    ArrayList<ItemContent> array = new ArrayList<ItemContent>();
    ImageButton enter;
    EditText search;
//    ProgressBar progressBar;
    SingleProductCustomBaseAdapter adapter;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_product);
        adapter = new SingleProductCustomBaseAdapter(this, array);

        list = (ListView) findViewById(R.id.single_product_list);

        search = (EditText) findViewById(R.id.search_text);

        enter = (ImageButton) findViewById(R.id.button);

//        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        list.setAdapter(adapter);
        new AsyncTask<Void, Void, ArrayList<ItemContent>>() {
            String jsonStr1;

            @Override
            protected ArrayList<ItemContent> doInBackground(Void... params) {
                Log.v("before", "size of the array is" + array.size());

                jsonStr1 = fetch("https://aggregator-scripts-azharullah.c9users.io/deals.php");
                Log.i("string",jsonStr1);
                try {
                    if (jsonStr1.length() == 0) {
                        Log.v("String", "zero lengthed string");
                        onBackPressed();

                    } else
                        getDataFromJson(jsonStr1);
//                        getDataFromJson(jsonStr1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.v("final", "size of the array is" + array.size());
                return array;
            }

            @Override
            protected void onPostExecute(ArrayList<ItemContent> result) {

                Log.v("result", "size of the array is" + result.size());
                adapter.notifyDataSetChanged();
                return;
            }


        }.execute();
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


            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Object o = list.getItemAtPosition(position);

                ItemContent fullObject = (ItemContent) o;
                Context context = getApplicationContext();
                Toast.makeText(context, "You have chosen: " + " " + fullObject.getDescription(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(fullObject.getId()));
                startActivity(i);

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

    private void getDataFromJson(String FetchedJsonStr)
            throws JSONException {
        JSONObject forecastJson = new JSONObject(FetchedJsonStr);
        JSONArray listWise = forecastJson.getJSONArray("dotdList");

        for (int i = 0; i <listWise.length(); i++) {

            JSONObject productObject = listWise.getJSONObject(i);
            ItemContent it = new ItemContent();
            it.setTitle(productObject.getString("title"));
            it.setImgid(productObject.getJSONArray("imageUrls").getJSONObject(2).getString("url"));
            it.setDescription(productObject.getString("description"));
            it.setMaxPrice(productObject.getString("title"));
            it.setId(productObject.getString("url"));
            array.add(it);
        }

        return;
    }



}

