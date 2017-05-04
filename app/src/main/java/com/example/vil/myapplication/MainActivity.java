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

        data.add(new Fruit("아보카도","2000", Fruit.image[0]));
        data.add(new Fruit("바나나", "3000",imageList[1]));
        data.add(new Fruit("체리", "4000" ,imageList[2]));
        data.add(new Fruit("크랜베리", "5000",imageList[3]));

        adapter = new GridAdapter(this, data);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                name.setText(data.get(position).name);
                price.setText(data.get(position).price);
                image.setImageResource(Fruit.image[data.get(position).imgno]);
                button.setText("M");

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

    }
}
