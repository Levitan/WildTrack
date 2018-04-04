package xyz.wildapp.android.wildtrack.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import xyz.wildapp.android.wildtrack.view.adapters.TrackingAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class TrackingListFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "TrackingListFragment";

    private FloatingActionButton fab;

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

        ListView trackList = view.findViewById(R.id.track_list);
        final ArrayList<Tracking> trackings = new ArrayList<>();
        ApiFactory.getAfterShipApi().getAllTrackings().enqueue(new Callback<List<Tracking>>() {
            @Override
            public void onResponse(Call<List<Tracking>> call, Response<List<Tracking>> response) {
                trackings.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Tracking>> call, Throwable t) {

            }
        });

        TrackingAdapter adapter = new TrackingAdapter(getContext(), trackings);

        trackList.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.fab:
                Snackbar.make(view, "Fragment", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            default:
                break;
        }
    }
}
