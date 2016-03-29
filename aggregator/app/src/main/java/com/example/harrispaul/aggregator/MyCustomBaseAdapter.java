package com.example.harrispaul.aggregator;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Harrispaul on 3/25/2016.
 */

public class MyCustomBaseAdapter extends BaseAdapter {

    private static ArrayList<ItemContent> searchArrayList;

    private LayoutInflater mInflater;

    public MyCustomBaseAdapter(Context context, ArrayList<ItemContent> results) {
        this.searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }
    public int getCount() {
        return searchArrayList.size();
    }

    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }
    public ImageView img;
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.mylist, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.item);
            holder.txtCityState = (TextView) convertView.findViewById(R.id.textView1);
            img = (ImageView) convertView.findViewById(R.id.icon);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(searchArrayList.get(position).getTitle());
        holder.txtCityState.setText(searchArrayList.get(position).getDescription());

        new LoadImage(img).execute(searchArrayList.get(position).getImgid());
        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtCityState;
    }
    private class LoadImage extends AsyncTask<String, String, Bitmap> {

        ImageView bmImage;
        ProgressDialog pDialog;
        Bitmap bitmap;

        public LoadImage(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());
//                Context context = getApplicationContext();
//                Toast.makeText(context, "You have chosen: " + " ", Toast.LENGTH_LONG).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap image) {

            if (image != null) {
                bmImage.setImageBitmap(image);

            }

        }
    }
}
