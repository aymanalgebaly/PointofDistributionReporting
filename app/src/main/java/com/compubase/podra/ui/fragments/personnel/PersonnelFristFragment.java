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
public class PersonnelFristFragment extends Fragment {


    public PersonnelFristFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personnel_frist, container, false);

        return view;
    }

}
