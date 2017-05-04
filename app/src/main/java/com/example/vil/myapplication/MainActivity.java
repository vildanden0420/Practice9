package com.example.vil.myapplication;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Fruit> data = new ArrayList<>();
    GridView gridView;
    GridAdapter adapter;
    CheckBox checkBox;
    Button cart_b, button;
    AutoCompleteTextView name;
    EditText price;
    ImageView image;
    AddFruit addFruit;
    int pos;


    int imageList[] = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry,
            R.drawable.cranberry, R.drawable.grape, R.drawable.kiwi,
            R.drawable.orange, R.drawable.watermelon};
    final static String[] nameList = {"아보카도", "바나나", "체리","크랜베리",
            "포도", "키위", "오렌지", "수박"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("What is your favorite fruit?");
        init();
    }

    public void init(){
        gridView = (GridView)findViewById(R.id.gridView);
        button = (Button)findViewById(R.id.button1);
        checkBox = (CheckBox)findViewById(R.id.checkBox1);
        name = (AutoCompleteTextView)findViewById(R.id.f_name);
        price = (EditText)findViewById(R.id.f_price);
        image = (ImageView)findViewById(R.id.image1);
        button = (Button)findViewById(R.id.b_add);
        addFruit = (AddFruit)findViewById(R.id.add);

        data.add(new Fruit("아보카도","2000", Fruit.image[0]));
        data.add(new Fruit("바나나", "3000",Fruit.image[1]));
        data.add(new Fruit("체리", "4000" ,Fruit.image[2]));
        data.add(new Fruit("크랜베리", "5000",Fruit.image[3]));

        adapter = new GridAdapter(this, data);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fruit fruitItem = (Fruit)adapter.getItem(position);
                name.setText(fruitItem.name);
                price.setText(fruitItem.price);
                image.setImageResource(fruitItem.imgno);
                button.setText("M");
                pos = position;

            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                adapter.setVisible(isChecked);
            }
        });

        name.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, nameList));

        addFruit.setOnAddListener(new AddFruit.OnAddListener() {
            @Override
            public void onAdd(String name, String price, int imgno) {
                data.add(new Fruit(name,price,imgno));
                addFruit.buttonSetting();
                adapter.notifyDataSetChanged();
            }
        });

        addFruit.setOnModifyListener(new AddFruit.OnModifyListener() {
            @Override
            public void onModify(String name, String price, int imgno) {
                data.set(pos, new Fruit(name, price, imgno));
                addFruit.buttonSetting();
                adapter.notifyDataSetChanged();
            }
        });

    }
}
