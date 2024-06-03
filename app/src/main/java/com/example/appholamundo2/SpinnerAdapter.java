package com.example.appholamundo2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<ItemsDatos> {
    int groupId;
    Activity Context;
    ArrayList<ItemsDatos> list;
    LayoutInflater inflater;

    public SpinnerAdapter(Activity Context, int groupId, int id, ArrayList<ItemsDatos> list){
        super(Context, id, list);
        this.list = list;
        inflater = (LayoutInflater) Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupId = groupId;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        return createItemView(position, convertView, parent);
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent){
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.spinner_layout, parent, false);

        TextView txtCategoria = view.findViewById(R.id.lblCategorias);
        TextView txtDescripcion = view.findViewById(R.id.lblDescripcion);
        ImageView imgCategoria = view.findViewById(R.id.imgCategoria);

        ItemsDatos item = getItem(position);

        if(item != null){
            txtCategoria.setText(item.getTxtCategoria());
            txtDescripcion.setText(item.getTxtDescripcion());
            imgCategoria.setImageResource(item.getImageId());
        }

        return view;
    }
}

