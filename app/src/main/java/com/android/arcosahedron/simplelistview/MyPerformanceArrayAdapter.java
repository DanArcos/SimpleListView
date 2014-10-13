package com.android.arcosahedron.simplelistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyPerformanceArrayAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] names;

    static class ViewHolder{
        public TextView text;
        public ImageView image;
    }

    public MyPerformanceArrayAdapter(Activity context, String[] names){
        super(context, R.layout.activity_main, names);
        this.context = context;
        this.names = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if(rowView == null){
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.activity_main,null);

            //Configure View Holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.label);
            viewHolder.image =(ImageView)rowView.findViewById(R.id.icon);
            rowView.setTag(viewHolder);
        }

        //Fill Data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        String s = names[position];
        holder.text.setText(s);

        return rowView;
    }
}
