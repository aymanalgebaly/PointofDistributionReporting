package com.compubase.podra.ui.fragments.delivery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.adapter.ActiveProductAdapter;
import com.compubase.podra.adapter.DeliveryActiveAdapter;
import com.compubase.podra.adapter.DeliveryHistoryAdapter;
import com.compubase.podra.data.model.ActiveProductModel;
import com.compubase.podra.data.model.DeliveryHistoryModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryHistoryFragment extends Fragment {


    @BindView(R.id.txt_Delivery_history)
    TextView txtDeliveryHistory;
//    @BindView(R.id.RCV_DEL_History)
//    RecyclerView RCVDELHistory;
    Unbinder unbinder;
    private DeliveryHistoryAdapter adapter;
    private RecyclerView RCVDELHistory;

    public DeliveryHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery_history, container, false);

        RCVDELHistory = view.findViewById(R.id.RCV_DEL_History);

        setupRecycler();
        fetchData();

        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RCVDELHistory.setLayoutManager(layoutManager);
        adapter = new DeliveryHistoryAdapter(getActivity());
        RCVDELHistory.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    private void fetchData (){
        List<DeliveryHistoryModel> deliveryHistoryModels = new ArrayList<>();

        String [] name = {"hhhhh","mmmm","uuuu","kkkk"};
        String [] date = {"21/10/2015","21/10/2015","21/10/2015","21/10/2015"};

        for (int i = 0; i <name.length ; i++) {
            deliveryHistoryModels.add(new DeliveryHistoryModel(name[i],date[i]));
        }
        adapter.setData(deliveryHistoryModels);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
