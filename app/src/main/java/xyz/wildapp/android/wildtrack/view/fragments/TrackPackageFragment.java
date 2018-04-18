package xyz.wildapp.android.wildtrack.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.wildapp.android.wildtrack.MainActivity;
import xyz.wildapp.android.wildtrack.R;

/**
 * Created by levitan on 05.04.2018.
 */

public class TrackPackageFragment extends Fragment {

    public TrackPackageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.app_name));
        return view;
    }
}
