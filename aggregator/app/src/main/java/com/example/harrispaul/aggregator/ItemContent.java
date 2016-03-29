package com.example.harrispaul.aggregator;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by Harrispaul on 3/25/2016.
 */
public class ItemContent implements Serializable {
    private String title = "";
    private String imgid = "";
    private String description = "";
    private double price = .0;

    public void setPrice(String price ) {
        this.price =Double.parseDouble(price);
        Log.i("price","price is" + this.price);
    }

    public double getPrice() {
        return price;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }

    public String getImgid() {
        return imgid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}



