package com.compubase.podra.ui.fragments.personnel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.compubase.podra.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryPersonnelFragment extends Fragment {


    public HistoryPersonnelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_personnel, container, false);
    }

}
