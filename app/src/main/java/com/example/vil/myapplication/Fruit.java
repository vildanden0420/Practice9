package com.example.vil.myapplication;

/**
 * Created by vil on 2017-05-04.
 */

public class Fruit {
    String name, price;
    int imgno;

    final static int image[] = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry,
            R.drawable.cranberry, R.drawable.grape, R.drawable.kiwi,
            R.drawable.orange, R.drawable.watermelon};

    public Fruit(String name, String price, int imgno){
        this.name = name;
        this.price = price;
        this.imgno = imgno;
    }
}
