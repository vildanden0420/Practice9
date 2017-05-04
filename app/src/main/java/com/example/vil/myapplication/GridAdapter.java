package com.example.vil.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vil on 2017-05-04.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList<Fruit> fruit;
    Boolean priceVisible = false;

    public GridAdapter(Context context, ArrayList<Fruit> fruit){
        this.context = context;
        this.fruit = fruit;
    }

    @Override
    public int getCount() {
        return fruit.size();
    }

    @Override
    public Object getItem(int position) {
        return fruit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView = new GridItem(context);
        ((GridItem)convertView).setData(fruit.get(position));

        TextView price = (TextView)convertView.findViewById(R.id.f_price);

        if(priceVisible){
            price.setVisibility(View.VISIBLE);
        }else {
            price.setVisibility(View.GONE);
        }

        return convertView;
    }

    public void setVisible(Boolean checked){
        priceVisible = checked;
        notifyDataSetChanged();
    }
}
