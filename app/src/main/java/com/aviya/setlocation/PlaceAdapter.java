package com.aviya.setlocation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlaceAdapter extends ArrayAdapter<Place> {

    private Context mContext;
    private List<Place> moviesList = new ArrayList<>();

    public PlaceAdapter(Context context, ArrayList<Place> list) {
        super(context, 0 , list);
        mContext = context;
        moviesList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.row_for_place,parent,false);

        Place currentPlace = moviesList.get(position);

//        ImageView image = (ImageView)listItem.findViewById(R.id.imageView_poster);
//        image.setImageResource(currentPlace.getmImageDrawable());

        TextView name = (TextView) listItem.findViewById(R.id.txvPlaceNameID);
        name.setText(currentPlace.getName());

        TextView release = (TextView) listItem.findViewById(R.id.txvLocationID);
        release.setText(currentPlace.getLng()+","+currentPlace.getLat());

        return listItem;
    }
}
