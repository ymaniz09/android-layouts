package com.github.ymaniz09.androidlayouts.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.github.ymaniz09.androidlayouts.R;
import com.github.ymaniz09.androidlayouts.dao.TripDAO;
import com.github.ymaniz09.androidlayouts.model.Trip;
import com.github.ymaniz09.androidlayouts.ui.adapter.ListTripAdapter;

import java.util.List;

public class ListTripsActivity extends AppCompatActivity {

    public static final String PACKAGE_EXTRA_TRIP = "trip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_trips);

        setTitle(getString(R.string.activity_list_trips_title));

        setupListView();
    }

    private void setupListView() {
        ListView listView = findViewById(R.id.activity_list_trips_list_view);

        final List<Trip> tripList = new TripDAO().getMock();

        listView.setAdapter(new ListTripAdapter(tripList, this));
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent launchIntent =
                    new Intent(ListTripsActivity.this, TripDetailsActivity.class);
            launchIntent.putExtra(PACKAGE_EXTRA_TRIP, tripList.get(position));
            startActivity(launchIntent);
        });
    }
}
