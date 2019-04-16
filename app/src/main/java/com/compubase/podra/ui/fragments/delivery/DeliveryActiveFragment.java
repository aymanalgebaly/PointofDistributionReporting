package com.compubase.podra.ui.fragments.delivery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.compubase.podra.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryActiveFragment extends Fragment {


    public DeliveryActiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delivery_active, container, false);
    }

}
