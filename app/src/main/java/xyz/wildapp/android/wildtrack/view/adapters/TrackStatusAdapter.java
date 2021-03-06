package xyz.wildapp.android.wildtrack.view.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import xyz.wildapp.android.wildtrack.R;
import xyz.wildapp.android.wildtrack.api.model.Tracking;

/**
 * Created by vborisovskii on 4/18/18.
 */

public class TrackStatusAdapter extends BaseAdapter {

    private static final String TAG = "TrackStatusAdapter";

    private Tracking track;
    private Context context;
    private LayoutInflater inflater;

    public TrackStatusAdapter(Tracking track, Context context) {
        this.track = track;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return track.getCheckpoints().size();
    }

    @Override
    public Object getItem(int position) {
        return track.getCheckpoints().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.track_status_item, viewGroup, false);
        }
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        TextView date = view.findViewById(R.id.track_status_item_date);
        TextView time = view.findViewById(R.id.track_status_item_time);
        try {
            date.setText(new SimpleDateFormat("MM/dd/yyyy").format(parser.parse(track.getCheckpoints().get(position).getCheckpointTime())));
            time.setText(new SimpleDateFormat("HH:mm").format(parser.parse(track.getCheckpoints().get(position).getCheckpointTime())));
        } catch (ParseException e) {
            Log.e(TAG, "Unable to parse date", e);
        }

        TextView message = view.findViewById(R.id.track_status_item_message);
        message.setText(track.getCheckpoints().get(position).getMessage());
        if (position == 0) {
            view.findViewById(R.id.track_line_top).setVisibility(View.INVISIBLE);
            ((ImageView) view.findViewById(R.id.track_pointer)).setImageDrawable(context.getDrawable(R.drawable.track_status_current));
        }
        if (position == getCount() - 1) {
            view.findViewById(R.id.track_line_bottom).setVisibility(View.INVISIBLE);
            view.findViewById(R.id.track_line_next).setVisibility(View.INVISIBLE);
        }
        return view;
    }
}
