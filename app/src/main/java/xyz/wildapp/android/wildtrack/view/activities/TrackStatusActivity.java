package xyz.wildapp.android.wildtrack.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;

import xyz.wildapp.android.wildtrack.AppConstants;
import xyz.wildapp.android.wildtrack.R;
import xyz.wildapp.android.wildtrack.api.ApiConstants;
import xyz.wildapp.android.wildtrack.api.model.Tracking;
import xyz.wildapp.android.wildtrack.view.adapters.TrackStatusAdapter;

public class TrackStatusActivity extends AppCompatActivity {

    private ListView listView;
    private TrackStatusAdapter adapter;
    private Tracking tracking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        tracking = (Tracking) intent.getSerializableExtra(AppConstants.INTENT_TRACKING);
        Collections.reverse(tracking.getCheckpoints());
        setContentView(R.layout.activity_track_status);
        Toolbar toolbar = findViewById(R.id.status_toolbar);
        toolbar.setTitle(tracking.getTitle());
        toolbar.setElevation(0);
        toolbar.setBackgroundColor(getColor(R.color.light_background));
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.track_status_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ((TextView) findViewById(R.id.track_number)).setText(tracking.getTrackingNumber());
        ((TextView) findViewById(R.id.delivery_status)).setText(ApiConstants.DELIVERY_STATUS.get(tracking.getTag()));

        listView = findViewById(R.id.track_status_list);
        listView.setDivider(null);
        adapter = new TrackStatusAdapter(tracking, this);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tracklist_status_item_menu, menu);
        return true;
    }
}
