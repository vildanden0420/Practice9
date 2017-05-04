package com.example.vil.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Fruit> data = new ArrayList<>();
    GridView gridView;
    GridAdapter adapter;

    int imageList[] = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry,
            R.drawable.cranberry, R.drawable.grape, R.drawable.kiwi,
            R.drawable.orange, R.drawable.watermelon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("What is your favorite fruit?");
        init();
    }

    public void init(){
        gridView = (GridView)findViewById(R.id.gridView);

        data.add(new Fruit("아보카도","2000", imageList[0]));
        data.add(new Fruit("바나나", "3000",imageList[1]));
        data.add(new Fruit("체리", "4000" ,imageList[2]));
        data.add(new Fruit("크랜베리", "5000",imageList[3]));

        adapter = new GridAdapter(this, data);
        gridView.setAdapter(adapter);

    }
}
