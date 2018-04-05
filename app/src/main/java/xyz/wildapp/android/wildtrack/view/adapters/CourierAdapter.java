package xyz.wildapp.android.wildtrack.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import xyz.wildapp.android.wildtrack.R;
import xyz.wildapp.android.wildtrack.api.model.Courier;

/**
 * Created by vborisovskii on 4/5/18.
 */

public class CourierAdapter extends BaseAdapter {

    private List<Courier> couriers;
    private LayoutInflater inflater;

    public CourierAdapter(Context context, List<Courier> couriers) {
        this.couriers = couriers;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return couriers.size();
    }

    @Override
    public Object getItem(int position) {
        return couriers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.courier_item, viewGroup, false);
        }
        TextView title = view.findViewById(R.id.select_courier_title);
        title.setText(couriers.get(position).getName());
        return view;
    }
}
