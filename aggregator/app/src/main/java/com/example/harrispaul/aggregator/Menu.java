package com.example.harrispaul.aggregator;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

/**
 * Created by Harrispaul on 3/14/2016.
 */
public class Menu extends ListActivity {
    String classes[] = { "Deals" , "Search" , "Exit" , "Settings" , "Popuptest","Load"};
    public Intent ourIntent;
    public void onListItemClick(ListView l,View v,int position,long id) {
        super.onListItemClick(l, v, position, id);
        String cl = classes[position];

        try {
            switch (cl) {
                case "Deals":
//                    ourIntent = new Intent(Menu.this, Deals.class);
                    break;
                case "Search":
                    ourIntent = new Intent(Menu.this, MainActivity.class);
                    break;
                case "Exit":
                    ourIntent = new Intent(Menu.this, OpenApp.class);
                    break;
                case "Load":
                    ourIntent = new Intent(Menu.this, LoadImage.class);
                    break;
                case "Popuptest":
                    ourIntent = new Intent(Menu.this, TestPopupActivity.class);
                    break;
            }
            startActivity(ourIntent);
        } catch(Exception c) {
            c.printStackTrace();
        }
    }

    public void onCreate(Bundle savedinstances) {
        super.onCreate(savedinstances);
        setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));
    }
}
