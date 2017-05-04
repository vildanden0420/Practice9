package com.example.vil.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by vil on 2017-05-04.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener {
    int imageno = 0;
    AutoCompleteTextView name;
    EditText price;
    ImageView img;
    Button b_next, b_add;
    //Boolean setAdd = true;


    public AddFruit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.fruitadd, this);
        name = (AutoCompleteTextView) findViewById(R.id.f_name);
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
            if(b_add.getText().toString().equals("ADD")){
                onAddListener.onAdd(name.getText().toString(), price.getText().toString(),Fruit.image[imageno]);
                b_add.setText("M");
            }else{
                onModifyListener.onModify(name.getText().toString(), price.getText().toString(),Fruit.image[imageno]);
                b_add.setText("ADD");
            }

        }else {
            if(imageno == Fruit.image.length-1) imageno =-1;
            img.setImageResource(Fruit.image[++imageno]);
        }

    }

    interface OnAddListener{
        void onAdd(String name, String price, int imgno);
    }

    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener){
        this.onAddListener = onAddListener;
    }

    interface OnModifyListener{
        void onModify(String name, String price, int imgno);
    }

    public OnModifyListener onModifyListener;

    public void setOnModifyListener(OnModifyListener onModifyListener) {
        this.onModifyListener = onModifyListener;
    }


}
