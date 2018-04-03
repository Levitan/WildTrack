package xyz.wildapp.android.wildtrack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class TrackingFragment extends Fragment implements View.OnClickListener {

    Button button;

    public TrackingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tracking, container, false);
        button = view.findViewById(R.id.fragment_btn);
        Log.d("", "onCreateView: FRAGMEEEEENT!!!!");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("FRAGMENT", "onClick: HAHAHA! LOCAL!");
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        Log.d("FRAGMENT", "onClick: HAHAHA!");
    }
}
