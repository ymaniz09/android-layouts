package com.github.ymaniz09.androidlayouts.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.ymaniz09.androidlayouts.R;
import com.github.ymaniz09.androidlayouts.model.Trip;
import com.github.ymaniz09.androidlayouts.util.FormattingUtil;

import java.math.BigDecimal;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        setTitle(R.string.activity_payment_title);

        Trip trip = new Trip("São Paulo", "sap_paulo_sp", 2, new BigDecimal(243.99));

        setPrice(trip);

    }

    private void setPrice(Trip trip) {
        TextView price = findViewById(R.id.payment_total_value);
        price.setText(FormattingUtil.formatBigDecimalToUSCurrency(trip.getValue()));
    }
}
