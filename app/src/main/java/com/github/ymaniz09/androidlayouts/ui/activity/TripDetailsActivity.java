package com.github.ymaniz09.androidlayouts.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ymaniz09.androidlayouts.R;
import com.github.ymaniz09.androidlayouts.model.Trip;
import com.github.ymaniz09.androidlayouts.util.FormattingUtil;
import com.github.ymaniz09.androidlayouts.util.PluralUtil;
import com.github.ymaniz09.androidlayouts.util.ResourcesUtil;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class TripDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);

        setTitle(getString(R.string.trip_details_activity_title));

        Trip trip = new Trip("São Paulo", "sao_paulo_sp",
                2, new BigDecimal("243.99"));

        setPlace(trip);

        setImage(trip);

        setDays(trip);

        setPrice(trip);

        setDates();
    }

    private void setDates() {
        TextView dates = findViewById(R.id.trip_details_dates);
        OffsetDateTime now = OffsetDateTime.now();
        dates.setText(String.format("%s/%s/%s - %s/%s/%s",
                now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
                now.getYear(), now.getMonthValue(), now.plusDays(5).getDayOfMonth()));
    }

    private void setPrice(Trip trip) {
        TextView price = findViewById(R.id.trip_details_price);
        price.setText(FormattingUtil.formatBigDecimalToUSCurrency(trip.getValue()));
    }

    private void setDays(Trip trip) {
        TextView days = findViewById(R.id.trip_details_days);
        days.setText(PluralUtil.getPlural(this, trip.getDays(), R.plurals.numberOfDays));
    }

    private void setImage(Trip trip) {
        ImageView image = findViewById(R.id.trip_details_image);
        image.setImageDrawable(ResourcesUtil.getDrawable(this, trip.getImage()));
    }

    private void setPlace(Trip trip) {
        TextView place = findViewById(R.id.trip_details_destination);
        place.setText(trip.getPlace());
    }
}
