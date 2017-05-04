package com.example.vil.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by vil on 2017-05-04.
 */

public class GridItem extends LinearLayout{
    ImageView image;
    TextView f_name, f_price;

    public GridItem(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.griditem, this);
        f_name = (TextView)view.findViewById(R.id.f_name);
        f_price = (TextView)view.findViewById(R.id.f_price);
        image = (ImageView)view.findViewById(R.id.f_image);
    }

    public void setData(Fruit one){
        f_name.setText(one.name);
        f_price.setText(one.price);
        image.setImageResource(one.imgno);
    }


}
