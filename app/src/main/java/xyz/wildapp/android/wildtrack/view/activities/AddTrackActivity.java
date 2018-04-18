package xyz.wildapp.android.wildtrack.view.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.wildapp.android.wildtrack.R;
import xyz.wildapp.android.wildtrack.api.ApiFactory;
import xyz.wildapp.android.wildtrack.api.model.Courier;
import xyz.wildapp.android.wildtrack.api.model.Tracking;
import xyz.wildapp.android.wildtrack.view.adapters.CourierAdapter;

public class AddTrackActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AddTrackActivity";

    private EditText trackTitle;
    private EditText trackNumber;
    private Spinner trackCouriers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_track);
        getSupportActionBar().setTitle(getString(R.string.activity_title_addnewtrack));
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        trackTitle = findViewById(R.id.add_track_title);
        trackNumber = findViewById(R.id.add_track_number);
        trackCouriers = findViewById(R.id.add_couriers);
        Button addTrack = findViewById(R.id.add_track_number_btn);
        Button cancelAdd = findViewById(R.id.add_track_number_btn_cancel);
        addTrack.setOnClickListener(this);
        cancelAdd.setOnClickListener(this);
        printCouriers();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.add_track_number_btn) {
            Tracking tracking = new Tracking();
            if (!trackTitle.getText().toString().equals("") || !trackNumber.getText().toString().equals("")) {
                tracking.setTitle(trackTitle.getText().toString());
                tracking.setTrackingNumber(trackNumber.getText().toString());
                tracking.setSlug(((Courier) trackCouriers.getSelectedItem()).getSlug());
                ApiFactory.getAfterShipApi().createTrack(tracking).enqueue(
                        new Callback<Tracking>() {
                            @Override
                            public void onResponse(Call<Tracking> call, Response<Tracking> response) {
                                Log.i(TAG, "Create tracking status code: " + response.code());
                                Log.d(TAG, "onResponse: " + response.body());
                                finish();
                            }

                            @Override
                            public void onFailure(Call<Tracking> call, Throwable t) {
                                Log.e(TAG, "Unable to create tracking", t);
                            }
                        });
            } else {
                Snackbar.make(view, getString(R.string.error_track_add_empty_fields), Snackbar.LENGTH_LONG).show();
            }
        } else if (id == R.id.add_track_number_btn_cancel) {
            finish();
        }
    }

    private void printCouriers() {
        final List<Courier> couriers = new ArrayList<>();
        final CourierAdapter adapter = new CourierAdapter(this, couriers);
        trackCouriers.setAdapter(adapter);
        ApiFactory.getAfterShipApi().getCouriers().enqueue(new Callback<List<Courier>>() {
            @Override
            public void onResponse(Call<List<Courier>> call, Response<List<Courier>> response) {
                Log.i(TAG, "Fetched " + response.body().size() + " couriers");
                couriers.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Courier>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return false;
    }
}
