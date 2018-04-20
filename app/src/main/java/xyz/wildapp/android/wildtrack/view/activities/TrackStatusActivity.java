package xyz.wildapp.android.wildtrack.view.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.wildapp.android.wildtrack.AppConstants;
import xyz.wildapp.android.wildtrack.R;
import xyz.wildapp.android.wildtrack.api.ApiConstants;
import xyz.wildapp.android.wildtrack.api.ApiFactory;
import xyz.wildapp.android.wildtrack.api.model.Tracking;
import xyz.wildapp.android.wildtrack.view.adapters.TrackStatusAdapter;

public class TrackStatusActivity extends AppCompatActivity {

    public static final String TAG = "TrackStatusActivity";

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_status_track_copy:
                ClipboardManager clipboardManager =
                        (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", tracking.getTrackingNumber());
                clipboardManager.setPrimaryClip(clip);
                Snackbar.make(listView, "Copied", Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.menu_status_track_edit:
                Snackbar.make(listView, "Not available at now", Snackbar.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();
                return true;
            case R.id.menu_status_track_delete:
                ApiFactory.getAfterShipApi().deleteTrack(tracking.getId()).enqueue(new Callback<Tracking>() {
                    @Override
                    public void onResponse(Call<Tracking> call, Response<Tracking> response) {
                        if (response.code() == 200) {
                            Log.i(TAG, "Tracking with id " + tracking.getId() + " was deleted");
                            Toast.makeText(getApplicationContext(), "Tracking " + tracking.getTitle()
                                    + " was deleted", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<Tracking> call, Throwable t) {
                        Log.e(TAG, "Error while deleting tracking", t);
                        Snackbar.make(
                                listView,
                                "Could not delete tracking '" + tracking.getTitle() + "'",
                                Snackbar.LENGTH_LONG);
                    }
                });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
