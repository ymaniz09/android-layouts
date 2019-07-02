package com.github.ymaniz09.androidlayouts.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ymaniz09.androidlayouts.R;
import com.github.ymaniz09.androidlayouts.model.Trip;
import com.github.ymaniz09.androidlayouts.util.FormattingUtil;
import com.github.ymaniz09.androidlayouts.util.PluralUtil;
import com.github.ymaniz09.androidlayouts.util.ResourcesUtil;

import java.time.OffsetDateTime;

public class TripDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);

        setTitle(getString(R.string.activity_trip_details_title));

        Bundle extras = getIntent().getExtras();

        if (extras != null && extras.containsKey(ListTripsActivity.PACKAGE_EXTRA_TRIP)) {
            final Trip trip = extras.getParcelable(ListTripsActivity.PACKAGE_EXTRA_TRIP);

            if (trip != null) {
                setPlace(trip);
                setImage(trip);
                setDays(trip);
                setPrice(trip);
                setDates();
                setPaymentButtonOnClickListener(trip);
            }
        }
    }

    private void setPaymentButtonOnClickListener(final Trip trip) {
        Button paymentButton = findViewById(R.id.activity_trip_details_buy_it_button);
        paymentButton.setOnClickListener(v -> {
            Intent launchIntent =
                    new Intent(TripDetailsActivity.this, PaymentActivity.class);
            launchIntent.putExtra(ListTripsActivity.PACKAGE_EXTRA_TRIP, trip);
            startActivity(launchIntent);
        });
    }

    private void setDates() {
        TextView dates = findViewById(R.id.activity_trip_details_dates);
        OffsetDateTime now = OffsetDateTime.now();
        dates.setText(String.format("%s/%s/%s - %s/%s/%s",
                now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
                now.getYear(), now.getMonthValue(), now.plusDays(5).getDayOfMonth()));
    }

    private void setPrice(Trip trip) {
        TextView price = findViewById(R.id.activity_trip_details_price);
        price.setText(FormattingUtil.formatBigDecimalToUSCurrency(trip.getValue()));
    }

    private void setDays(Trip trip) {
        TextView days = findViewById(R.id.activity_trip_details_days);
        days.setText(PluralUtil.getPlural(this, trip.getDays(), R.plurals.numberOfDays));
    }

    private void setImage(Trip trip) {
        ImageView image = findViewById(R.id.activity_trip_details_image);
        image.setImageDrawable(ResourcesUtil.getDrawable(this, trip.getImage()));
    }

    private void setPlace(Trip trip) {
        TextView place = findViewById(R.id.activity_trip_details_destination);
        place.setText(trip.getPlace());
    }
}
