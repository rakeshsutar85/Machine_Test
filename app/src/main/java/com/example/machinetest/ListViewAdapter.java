package com.example.machinetest;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<GalleryModel> {
    private List<GalleryModel> galleryModelList;
    private Context context;
    public ListViewAdapter(List<GalleryModel> heroList, Context context) {
        super(context, R.layout.list_items, heroList);
        this.galleryModelList = heroList;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View listViewItem = inflater.inflate(R.layout.list_items, null, true);
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        ImageView textViewImageUrl = listViewItem.findViewById(R.id.textViewImageUrl);
        GalleryModel galleryModel = galleryModelList.get(position);
        textViewName.setText(galleryModel.getName());
            Glide
                .with(context)
                .load(galleryModel.getProfile())
                .centerCrop()
                .into(textViewImageUrl);
        return listViewItem;
    }
}
