package xyz.wildapp.android.wildtrack.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import xyz.wildapp.android.wildtrack.R;
import xyz.wildapp.android.wildtrack.view.activities.TrackStatusActivity;

/**
 * Created by levitan on 05.04.2018.
 */

public class TrackPackageFragment extends Fragment {

    public TrackPackageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);

        Button btn = view.findViewById(R.id.clickme);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TrackStatusActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
