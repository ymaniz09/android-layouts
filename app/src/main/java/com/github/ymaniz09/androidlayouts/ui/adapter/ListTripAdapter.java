package com.github.ymaniz09.androidlayouts.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ymaniz09.androidlayouts.R;
import com.github.ymaniz09.androidlayouts.model.Trip;
import com.github.ymaniz09.androidlayouts.util.FormattingUtil;
import com.github.ymaniz09.androidlayouts.util.PluralUtil;
import com.github.ymaniz09.androidlayouts.util.ResourcesUtil;

import java.util.List;

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
        TextView price = view.findViewById(R.id.item_price);
        price.setText(FormattingUtil.formatBigDecimalToUSCurrency(trip.getValue()));
    }

    private void setDays(View view, Trip trip) {
        TextView days = view.findViewById(R.id.item_destination_days);
        days.setText(PluralUtil.getPlural(mContext, trip.getDays(), R.plurals.numberOfDays));
    }

    private void setImage(View view, Trip trip) {
        ImageView image = view.findViewById(R.id.item_destination_image);
        image.setImageDrawable(ResourcesUtil.getDrawable(mContext, trip.getImage()));
    }

    private void setPlace(View view, Trip trip) {
        TextView place = view.findViewById(R.id.item_destination_name);
        place.setText(trip.getPlace());
    }
}
