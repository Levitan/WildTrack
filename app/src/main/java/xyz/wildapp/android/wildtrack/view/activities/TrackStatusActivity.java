package xyz.wildapp.android.wildtrack.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import xyz.wildapp.android.wildtrack.R;

public class TrackStatusActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_status);
        getSupportActionBar().setTitle(getString(R.string.activity_title_trackstatus));
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.track_status_up);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.track_status_list);
        String[] names = {"Name", "Name", "Name", "Name", "Name", "Name", "Name", "Name", "Name", "Name", "Name", "Name", "Name", "Name", "Name", "Name", "Name", "Name", "Name"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return false;
    }
}
