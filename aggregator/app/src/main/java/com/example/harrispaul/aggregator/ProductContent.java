package com.example.harrispaul.aggregator;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Harrispaul on 3/28/2016.
 */
public class ProductContent extends Activity {

    ImageView img;
    Bitmap bitmap;
    ProgressBar pDialog;
    Object o;
    ItemContent o1 = (ItemContent) o;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_product);
        pDialog = (ProgressBar) findViewById(R.id.progressBar2);
        img = (ImageView) findViewById(R.id.icon2);
        o = getIntent().getSerializableExtra("product");
        o1 = (ItemContent)o;
        new LoadImage().execute(o1.getImgid());



    }

    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Context context = getApplicationContext();
            pDialog = new ProgressBar(context);
//            pDialog.setMessage("Loading Image ....");
//            pDialog.show();

        }

        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap image) {

            if (image != null) {
                img.setImageBitmap(image);
//                pDialog.dismiss();

            } else {

//                pDialog.dismiss();
//                Toast.makeText(LoadImage.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();

            }
        }
    }

}
