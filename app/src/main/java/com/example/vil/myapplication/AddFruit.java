package com.example.vil.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by vil on 2017-05-04.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener {
    int imageno = 0;
    EditText name, price;
    ImageView img;
    Button b_next, b_add;


    public AddFruit(Context context) {
        super(context);
        init(context);
    }

    void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.fruitadd, this);
        name = (EditText)findViewById(R.id.f_name);
        price = (EditText)findViewById(R.id.f_price);
        img = (ImageView)findViewById(R.id.image1);
        b_next = (Button)findViewById(R.id.b_next);
        b_add = (Button)findViewById(R.id.b_add);
        b_next.setOnClickListener(this);
        b_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==b_add){

        }
    }

    interface OnAddListener{
        void onAdd(String name, String price, int imgno);
    }

    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener){
        this.onAddListener = onAddListener;
    }
}
