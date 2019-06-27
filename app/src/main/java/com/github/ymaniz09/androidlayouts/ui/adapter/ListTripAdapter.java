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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListTripAdapter extends BaseAdapter {

    private final List<Trip> mTripList;
    private final Context mContext;

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

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = vi.inflate(R.layout.item_travel_row, parent, false);
        }

        Trip trip = mTripList.get(position);

        setPlace(convertView, trip);

        setImage(convertView, trip);

        setDays(convertView, trip);

        setPrice(convertView, trip);

        return convertView;
    }

    private void setPrice(View view, Trip trip) {
        NumberFormat currencyInstance = DecimalFormat.getCurrencyInstance(
                new Locale("en", "US"));
        TextView price = view.findViewById(R.id.item_price);
        price.setText(currencyInstance.format(trip.getValue()).replace("$", "$ "));
    }

    private void setDays(View view, Trip trip) {
        Resources resources = mContext.getResources();
        int daysAmount = trip.getDays();
        TextView days = view.findViewById(R.id.item_destination_days);
        days.setText(resources.getQuantityString(R.plurals.numberOfDays, daysAmount, daysAmount));
    }

    private void setImage(View view, Trip trip) {
        ImageView image = view.findViewById(R.id.item_destination_image);
        Resources resources = mContext.getResources();
        int drawableId = resources
                .getIdentifier(trip.getImage(), "drawable", mContext.getPackageName());

        image.setImageDrawable(mContext.getDrawable(drawableId));
    }

    private void setPlace(View view, Trip trip) {
        TextView place = view.findViewById(R.id.item_destination_name);
        place.setText(trip.getPlace());
    }
}
