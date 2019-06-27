package com.github.ymaniz09.androidlayouts.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.github.ymaniz09.androidlayouts.R;
import com.github.ymaniz09.androidlayouts.dao.TripDAO;
import com.github.ymaniz09.androidlayouts.ui.adapter.ListTripAdapter;

public class ListTripsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_trips);

        setTitle(getString(R.string.list_trips_activity_title));

        setupListView();

        startActivity(new Intent(this, TripDetailsActivity.class));
    }

    private void setupListView() {
        ListView listView = findViewById(R.id.list_trips_list_view);

        listView.setAdapter(new ListTripAdapter(new TripDAO().getMock(), this));
    }
}
