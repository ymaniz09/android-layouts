package com.github.ymaniz09.androidlayouts.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ymaniz09.androidlayouts.R;
import com.github.ymaniz09.androidlayouts.model.Trip;
import com.github.ymaniz09.androidlayouts.util.FormattingUtil;
import com.github.ymaniz09.androidlayouts.util.ResourcesUtil;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class PurchaseDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_details);

        setTitle(R.string.activity_purchase_details_title);

        Trip trip = new Trip("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        setPlace(trip);

        setImage(trip);

        setDates();

        setPrice(trip);
    }

    private void setPlace(Trip trip) {
        TextView place = findViewById(R.id.purchase_details_trip_destination);
        place.setText(trip.getPlace());
    }

    private void setImage(Trip trip) {
        ImageView image = findViewById(R.id.purchase_details_trip_image);
        image.setImageDrawable(ResourcesUtil.getDrawable(this, trip.getImage()));
    }

    private void setDates() {
        TextView dates = findViewById(R.id.purchase_details_trip_dates);
        OffsetDateTime now = OffsetDateTime.now();
        dates.setText(String.format("%s/%s/%s - %s/%s/%s",
                now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
                now.getYear(), now.getMonthValue(), now.plusDays(5).getDayOfMonth()));
    }

    private void setPrice(Trip trip) {
        TextView price = findViewById(R.id.purchase_details_trip_price);
        price.setText(FormattingUtil.formatBigDecimalToUSCurrency(trip.getValue()));
    }
}
