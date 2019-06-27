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

public class TripDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);

        Trip trip = new Trip("São Paulo", "sao_paulo_sp",
                2, new BigDecimal("243.99"));

        TextView place = findViewById(R.id.trip_details_destination);
        place.setText(trip.getPlace());

        ImageView image = findViewById(R.id.trip_details_image);

        image.setImageDrawable(ResourcesUtil.getDrawable(this, trip.getImage()));

        TextView days = findViewById(R.id.trip_details_days);
        days.setText(PluralUtil.getPlural(this, trip.getDays(), R.plurals.numberOfDays));

        TextView price = findViewById(R.id.trip_details_price);
        price.setText(FormattingUtil.formatBigDecimalToUSCurrency(trip.getValue()));
        
    }
}
