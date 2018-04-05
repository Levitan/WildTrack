package xyz.wildapp.android.wildtrack.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.wildapp.android.wildtrack.MainActivity;
import xyz.wildapp.android.wildtrack.R;
import xyz.wildapp.android.wildtrack.api.ApiFactory;
import xyz.wildapp.android.wildtrack.api.model.Tracking;
import xyz.wildapp.android.wildtrack.view.activities.AddTrackActivity;
import xyz.wildapp.android.wildtrack.view.adapters.TrackingAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class TrackingListFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "TrackingListFragment";

    private FloatingActionButton fab;
    private ListView trackList;
    private LinearLayout waiting;

    public TrackingListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tracking, container, false);
        fab = getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
        fab.setOnClickListener(this);
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.draw_track_list));
        waiting = view.findViewById(R.id.track_list_waiting);
        trackList = view.findViewById(R.id.track_list);
        trackList.setDivider(null);
        return view;
    }

    @Override
    public void onResume() {
        trackList.setVisibility(View.INVISIBLE);
        waiting.setVisibility(View.VISIBLE);
        super.onResume();
        paintTrackList();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.fab:
                Intent intent = new Intent(getContext(), AddTrackActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void paintTrackList() {
        final List<Tracking> tracks = new ArrayList<>();
        final TrackingAdapter adapter = new TrackingAdapter(getContext(), tracks);
        Log.i(TAG, "Fetching list of tracks");
        ApiFactory.getAfterShipApi().getAllTrackings().enqueue(new Callback<List<Tracking>>() {
            @Override
            public void onResponse(Call<List<Tracking>> call, Response<List<Tracking>> response) {
                Log.i(TAG, "Fetched " + response.body().size() + " tracks");
                tracks.addAll(response.body());
                adapter.notifyDataSetChanged();
                waiting.setVisibility(View.INVISIBLE);
                trackList.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<List<Tracking>> call, Throwable t) {
                Log.e(TAG, "Error while receiving track list", t);
            }
        });
        trackList.setAdapter(adapter);
    }
}
