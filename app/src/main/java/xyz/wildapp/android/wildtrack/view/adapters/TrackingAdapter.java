package xyz.wildapp.android.wildtrack.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import xyz.wildapp.android.wildtrack.R;
import xyz.wildapp.android.wildtrack.api.model.Tracking;

/**
 * Created by vborisovskii on 4/4/18.
 */

public class TrackingAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Tracking> trackList;

    public TrackingAdapter(Context context, ArrayList<Tracking> trackList) {
        this.context = context;
        this.trackList = trackList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return trackList.size();
    }

    @Override
    public Object getItem(int index) {
        return trackList.get(index);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.track_list_item, viewGroup, false);
        }
        Tracking tracking = (Tracking) getItem(index);
        ((TextView) view.findViewById(R.id.tracklist_item_title)).setText(tracking.getTitle());
        ((TextView) view.findViewById(R.id.tracklist_item_number)).setText(tracking.getTrackingNumber());
        ((TextView) view.findViewById(R.id.tracklist_item_status)).setText(tracking.getTag());

        return view;
    }
}
