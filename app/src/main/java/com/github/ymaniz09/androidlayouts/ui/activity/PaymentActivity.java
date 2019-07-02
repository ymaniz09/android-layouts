package com.github.ymaniz09.androidlayouts.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.github.ymaniz09.androidlayouts.R;
import com.github.ymaniz09.androidlayouts.model.Trip;
import com.github.ymaniz09.androidlayouts.util.FormattingUtil;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        setTitle(R.string.activity_payment_title);

        Bundle extras = getIntent().getExtras();

        if (extras != null && extras.containsKey(ListTripsActivity.PACKAGE_EXTRA_TRIP)) {
            final Trip trip = extras.getParcelable(ListTripsActivity.PACKAGE_EXTRA_TRIP);

            if (trip != null) {
                setPrice(trip);
                setBuyItButtonOnClickListener(trip);
            }
        }
    }

    private void setBuyItButtonOnClickListener(final Trip trip) {
        Button buyItButton = findViewById(R.id.activity_payment_confirm_payment_button);
        buyItButton.setOnClickListener(v -> {
            Intent launchIntent =
                    new Intent(PaymentActivity.this, PurchaseDetailsActivity.class);
            launchIntent.putExtra(ListTripsActivity.PACKAGE_EXTRA_TRIP, trip);
            startActivity(launchIntent);
        });
    }

    private void setPrice(Trip trip) {
        TextView price = findViewById(R.id.activity_payment_total_value);
        price.setText(FormattingUtil.formatBigDecimalToUSCurrency(trip.getValue()));
    }
}
