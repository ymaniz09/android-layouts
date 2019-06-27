package com.github.ymaniz09.androidlayouts.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ymaniz09.androidlayouts.R;
import com.github.ymaniz09.androidlayouts.model.Trip;

import java.util.List;

public class ListTripAdapter extends BaseAdapter {

    private final List<Trip> mTripList;
    private Context mContext;

    public ListTripAdapter(List<Trip> tripList, Context context) {
        mTripList = tripList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mTripList.size();
    }

    @Override
    public Trip getItem(int position) {
        return mTripList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_travel, parent, false);

        Trip trip = mTripList.get(position);

        TextView place = view.findViewById(R.id.item_destination_name);
        place.setText(trip.getPlace());

        ImageView image = view.findViewById(R.id.item_destination_image);
        Resources resources = mContext.getResources();
        int drawableId = resources
                .getIdentifier(trip.getImage(), "drawable", mContext.getPackageName());

        image.setImageDrawable(mContext.getDrawable(drawableId));


        TextView days = view.findViewById(R.id.item_destination_days);
        days.setText(String.valueOf(trip.getDays()));

        TextView price = view.findViewById(R.id.item_price);
        price.setText(trip.getValue().toString());

        return view;
    }
}
