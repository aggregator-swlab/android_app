package com.example.harrispaul.aggregator;

import android.graphics.Bitmap;

/**
 * Created by Harrispaul on 4/4/2016.
 */
public class ImageId {
    private Bitmap bitmap;
    private Integer position;
    public ImageId(Bitmap bm,Integer id){
        this.bitmap=bm;
        this.position=id;
    }
    public Bitmap getBm(Integer id){
        return bitmap;
    }
}
