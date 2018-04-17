package xyz.wildapp.android.wildtrack.view.adapters;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.Iterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.wildapp.android.wildtrack.R;
import xyz.wildapp.android.wildtrack.api.ApiConstants;
import xyz.wildapp.android.wildtrack.api.ApiFactory;
import xyz.wildapp.android.wildtrack.api.model.Tracking;

/**
 * Created by vborisovskii on 4/4/18.
 */

public class TrackingAdapter extends BaseAdapter {
    private static final String TAG = "TrackingAdapter";
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
        TextView location = view.findViewById(R.id.tracklist_item_current);
        TextView time = view.findViewById(R.id.tracklist_item_current_time);
        if (tracking.getCheckpoints().size() > 0) {
            ViewGroup.LayoutParams params = location.getLayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            location.setLayoutParams(params);
            params = time.getLayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            time.setLayoutParams(params);

            location.setText(tracking.getCheckpoints().get(tracking.getCheckpoints().size() -1).getLocation());
            String checkpointTime = tracking.getCheckpoints().get(tracking.getCheckpoints().size() -1).getCheckpointTime();
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            try {
                time.setText(parser.parse(checkpointTime).toString());
                time.setText(new SimpleDateFormat("HH:mm - dd MMMM YYYY").format(parser.parse(checkpointTime)));
            } catch (ParseException e) {
                Log.e(TAG, "Parse failed", e);
            }
        } else {
            ViewGroup.LayoutParams params = location.getLayoutParams();
            params.height = 0;
            location.setLayoutParams(params);
            params = time.getLayoutParams();
            params.height = 0;
            time.setLayoutParams(params);
        }
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

        ImageButton menu = view.findViewById(R.id.tracklist_item_menu);
        menu.setOnClickListener(menuClick);
        menu.setTag(index);

//        CheckBox checkBox = view.findViewById(R.id.tracklist_item_check);
//        checkBox.setTag(index);
//        checkBox.setOnCheckedChangeListener(checkListener);
//        checkBox.setChecked(tracking.isChecked());
        return view;
    }

    private View.OnClickListener menuClick = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            PopupMenu popupMenu = new PopupMenu(context, v);
            popupMenu.inflate(R.menu.tracklist_item_menu);
            popupMenu.show();
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int id = item.getItemId();
                    final Tracking tracking = (Tracking) getItem((Integer) v.getTag());
                    switch (id) {
                        case R.id.menu_tracklist_copy:
                            ClipboardManager clipboardManager =
                                    (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                            ClipData clip = ClipData.newPlainText("label", tracking.getTrackingNumber());
                            clipboardManager.setPrimaryClip(clip);
                            Snackbar.make(v, "Copied", Snackbar.LENGTH_SHORT).show();
                            return true;
                        case R.id.menu_tracklist_edit:
                            notifyDataSetChanged();
                            return true;
                        case R.id.menu_tracklist_delete:
                            ApiFactory.getAfterShipApi().deleteTrack(tracking.getId()).enqueue(new Callback<Tracking>() {
                                @Override
                                public void onResponse(Call<Tracking> call, Response<Tracking> response) {
                                    if(response.code() == 200) {
                                        Log.i(TAG, "Tracking with id " + tracking.getId() + " was deleted");
                                        Snackbar.make(v, "Tracking " + tracking.getTitle()
                                                + " was deleted", Snackbar.LENGTH_LONG).show();
                                        trackList.remove(tracking);
                                        notifyDataSetChanged();
                                    }
                                }

                                @Override
                                public void onFailure(Call<Tracking> call, Throwable t) {
                                    Log.e(TAG, "Error while deleting tracking", t);
                                }
                            });
                            return true;
                        default:
                            return false;
                    }
                }
            });
        }
    };

    public void deleteSelectedItems() {
        final View view = ((Activity) context).findViewById(R.id.track_list);
        for (final Iterator<Tracking> iterator = trackList.iterator(); iterator.hasNext(); ) {
            Tracking tracking = iterator.next();
            if (tracking.isChecked()) {
                ApiFactory.getAfterShipApi().deleteTrack(tracking.getId()).enqueue(new Callback<Tracking>() {
                    @Override
                    public void onResponse(Call<Tracking> call, Response<Tracking> response) {
                        if (response.code() == 200) {
                            iterator.remove();
                            notifyDataSetChanged();
                            Snackbar.make(view, R.string.info_track_list_snack_deleted, Snackbar.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Tracking> call, Throwable t) {
                        Snackbar.make(view, R.string.error_track_delete, Snackbar.LENGTH_LONG).show();
                    }
                });
            }
        }
    }
}
