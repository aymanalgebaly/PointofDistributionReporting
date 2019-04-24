package com.compubase.podra.ui.fragments.delivery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.compubase.podra.R;
import com.compubase.podra.adapter.ActiveProductAdapter;
import com.compubase.podra.adapter.DeliveryActiveAdapter;
import com.compubase.podra.data.model.ActiveProductModel;
import com.compubase.podra.data.model.DeliveryActiveModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryActiveFragment extends Fragment {


//    @BindView(R.id.RCV_DEL_Active)
//    RecyclerView RCVDELActive;
    Unbinder unbinder;
    private RecyclerView RCVDELActive;
    private DeliveryActiveAdapter adapter;

    public DeliveryActiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery_active, container, false);

        RCVDELActive = view.findViewById(R.id.RCV_DEL_Active);

        setupRecycler();
        fetchData();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RCVDELActive.setLayoutManager(layoutManager);
        adapter = new DeliveryActiveAdapter(getActivity());
        RCVDELActive.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    private void fetchData (){
        List<DeliveryActiveModel> deliveryActiveModels = new ArrayList<>();

        String [] num = {"100","200","300","400"};
        String [] productName = {"nnnnn","mmmmm","gggg","tttt"};
        String [] status = {"online","offline","offline","online"};

        for (int i = 0; i <num.length ; i++) {
            deliveryActiveModels.add(new DeliveryActiveModel(num[i],productName[i],status[i]));
        }
        adapter.setData(deliveryActiveModels);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
