package com.android.arcosahedron.simplelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MySimpleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.activity_main,values);
        this.context = context;
        this.values = values;
    }

    //Inflate the layout, then work on UI elements
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_main, parent, false);

        //INITIALIZE UI ELEMENTS
        TextView textView = (TextView)rowView.findViewById(R.id.label);
        textView.setText(values[position]);

        ImageView imageView = (ImageView)rowView.findViewById(R.id.icon);
        imageView.setImageResource(android.R.drawable.ic_lock_idle_low_battery);

        return rowView;
    }
}
