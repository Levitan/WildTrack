package xyz.wildapp.android.wildtrack.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import xyz.wildapp.android.wildtrack.R;
import xyz.wildapp.android.wildtrack.api.ApiConstants;
import xyz.wildapp.android.wildtrack.api.model.Tracking;

/**
 * Created by vborisovskii on 4/4/18.
 */

public class TrackingAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<Tracking> trackList;

    public TrackingAdapter(Context context, List<Tracking> trackList) {
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
        ImageView status = view.findViewById(R.id.tracklist_item_status);
        switch (tracking.getTag()) {
            case ApiConstants.STATUS_DELIVERED:
                status.setImageDrawable(context.getDrawable(R.drawable.status_delivered));
                break;
            case ApiConstants.STATUS_IN_TRANSIT:
                status.setImageDrawable(context.getDrawable(R.drawable.status_intransit));
                break;
            case ApiConstants.STATUS_PENDING:
                status.setImageDrawable(context.getDrawable(R.drawable.status_pending));
                break;
            default:
                status.setImageDrawable(context.getDrawable(R.drawable.status_not_info));
                break;
        }

        ImageView courierLogo = view.findViewById(R.id.tracklist_item_courier);
        switch (tracking.getSlug()) {
            case ApiConstants.COURIER_CHINA:
                courierLogo.setImageResource(R.mipmap.chinapost);
                break;
            case ApiConstants.COURIER_EPACKET:
                courierLogo.setImageResource(R.mipmap.epacket);
                break;
            case ApiConstants.COURIER_RUSSIAN_POST:
                courierLogo.setImageResource(R.mipmap.russian_post);
                break;
            case ApiConstants.COURIER_SINGPOST:
                courierLogo.setImageResource(R.mipmap.singpost);
                break;
            default:
                break;
        }
        return view;
    }
}
