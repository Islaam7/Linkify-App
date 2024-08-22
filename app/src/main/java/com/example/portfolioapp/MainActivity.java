package com.example.portfolioapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] titles = getResources().getStringArray(R.array.titles);
        String[] urls = getResources().getStringArray(R.array.urls);
        int[] icons = {
                R.drawable.instagram,
                R.drawable.linkedin,
                R.drawable.facebook,
                R.drawable.github,
                R.drawable.wordpress,
                R.drawable.twitter,
                R.drawable.whatsapp
        };

        ArrayList<DataHub> items = new ArrayList<>();
        for (int i = 0; i < titles.length; i++){
            items.add(new DataHub(titles[i], icons[i]));
        }

        Adapter adapter = new Adapter(this, items);
        ListView lv_itemslist = findViewById(R.id.lv_itemslist);
        lv_itemslist.setAdapter(adapter);

        lv_itemslist.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, WebActivity.class);
            intent.putExtra("url", urls[position]);
            startActivity(intent);
        });

        }
    }
