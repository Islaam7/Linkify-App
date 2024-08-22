package com.example.portfolioapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private  Context context;
    private  ArrayList<DataHub> items;



    public Adapter(Context context, ArrayList<DataHub> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.items_list, null, false);
        }

        TextView text = convertView.findViewById(R.id.tv_itemtext);
        ImageView icon = convertView.findViewById(R.id.iv_itemimage);

        text.setText(items.get(position).getTitle());
        icon.setImageResource(items.get(position).getIcon());
        return convertView;
    }
}
