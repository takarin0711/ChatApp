package com.example.takay_000.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by takay_000 on 2016/11/04.
 */

public class CustomAdapter extends ArrayAdapter<CustomData> {
    private LayoutInflater layoutInflater_;

    public CustomAdapter(Context context, int textViewResourceId, List<CustomData> objects) {
        super(context, textViewResourceId, objects);
        layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 特定の行(position)のデータを得る
        CustomData item = (CustomData)getItem(position);

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = layoutInflater_.inflate(R.layout.list, null);
        }

        if(position % 2==0){
            convertView = layoutInflater_.inflate(R.layout.list, null);
            ImageView imageView;
            imageView = (ImageView)convertView.findViewById(R.id.imageView);
            imageView.setImageBitmap(item.getImageData());

            TextView textView, name;
            textView = (TextView) convertView.findViewById(R.id.textView);
            textView.setText(item.getTextData());

            name= (TextView) convertView.findViewById(R.id.Name1);
            name.setText(item.getNameData());
        }else{
            convertView = layoutInflater_.inflate(R.layout.list2, null);
            ImageView imageView;
            imageView = (ImageView)convertView.findViewById(R.id.imageView2);
            imageView.setImageBitmap(item.getImageData());

            TextView textView, name;
            textView = (TextView) convertView.findViewById(R.id.textView2);
            textView.setText(item.getTextData());
            name= (TextView) convertView.findViewById(R.id.Name2);
            name.setText(item.getNameData());
        }

        // CustomDataのデータをViewの各Widgetにセットする
        /* ImageView imageView;
        imageView = (ImageView)convertView.findViewById(R.id.imageView);
        imageView.setImageBitmap(item.getImageData());

        TextView textView;
        textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(item.getTextData()); */

        return convertView;
    }
}