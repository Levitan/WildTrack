package xyz.wildapp.android.wildtrack.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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
    final List<Tracking> tracks = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView trackListError;

    public TrackingListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tracking, container, false);
        fab = getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
        fab.setOnClickListener(this);
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.fragment_title_tracklist));
        waiting = view.findViewById(R.id.track_list_waiting);
        trackListError = view.findViewById(R.id.track_list_error);
        trackList = view.findViewById(R.id.track_list);
        trackList.setDivider(null);

        swipeRefreshLayout = view.findViewById(R.id.track_list_refresh);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.google_green,
                R.color.google_yellow,
                R.color.google_red,
                R.color.google_blue);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                paintTrackList();
            }
        });
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
        tracks.clear();
        final TrackingAdapter adapter = new TrackingAdapter(getActivity(), tracks);
        Log.i(TAG, "Fetching list of tracks");
        ApiFactory.getAfterShipApi().getAllTrackings().enqueue(new Callback<List<Tracking>>() {
            @Override
            public void onResponse(Call<List<Tracking>> call, Response<List<Tracking>> response) {
                Log.i(TAG, "Fetched " + response.body().size() + " tracks");
                tracks.addAll(response.body());
                adapter.notifyDataSetChanged();
                trackListError.setVisibility(View.INVISIBLE);
                waiting.setVisibility(View.INVISIBLE);
                trackList.setVisibility(View.VISIBLE);
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Tracking>> call, Throwable t) {
                Log.e(TAG, "Error while receiving track list", t);
                adapter.notifyDataSetChanged();
                waiting.setVisibility(View.INVISIBLE);
                trackList.setVisibility(View.INVISIBLE);
                trackListError.setVisibility(View.VISIBLE);
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        trackList.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.tracklist_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_action_delete:
                ((TrackingAdapter) trackList.getAdapter()).deleteSelectedItems();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
