package com.compubase.podra.ui.fragments.product;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.compubase.podra.R;
import com.compubase.podra.adapter.PodHistoryAdapter;
import com.compubase.podra.data.model.PodHistoryModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductHistoryFragment extends Fragment {


    @BindView(R.id.RCV_History_Product)
    RecyclerView RCVHistoryProduct;
    Unbinder unbinder;
    private PodHistoryAdapter adapter;

    public ProductHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_history, container, false);
        unbinder = ButterKnife.bind(this, view);
        setupRecycler();


        List<PodHistoryModel> podHistoryModelList = new ArrayList<>();
        podHistoryModelList.add(new PodHistoryModel("ayman","100","21/10/2018","21/11/2018"));
        podHistoryModelList.add(new PodHistoryModel("ahmed","200","21/10/2017","21/11/2017"));
        podHistoryModelList.add(new PodHistoryModel("hassan","300","21/10/2016","21/11/2016"));
        podHistoryModelList.add(new PodHistoryModel("hussein","400","21/10/2015","21/11/2015"));
        podHistoryModelList.add(new PodHistoryModel("fatma","500","21/10/2014","21/11/2014"));
        podHistoryModelList.add(new PodHistoryModel("amir","600","21/10/2013","21/11/2013"));
        podHistoryModelList.add(new PodHistoryModel("fathy","700","21/10/2012","21/11/2012"));
        podHistoryModelList.add(new PodHistoryModel("morgan","800","21/10/2011","21/11/2011"));
        podHistoryModelList.add(new PodHistoryModel("naglaa","900","21/10/2010","21/11/2010"));
        return view;
    }

    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RCVHistoryProduct.setLayoutManager(layoutManager);
        adapter = new PodHistoryAdapter(getActivity());
        RCVHistoryProduct.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
