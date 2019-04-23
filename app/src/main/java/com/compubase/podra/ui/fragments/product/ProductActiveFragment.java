package com.compubase.podra.ui.fragments.product;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.adapter.ActiveProductAdapter;
import com.compubase.podra.adapter.PodHistoryAdapter;
import com.compubase.podra.data.model.ActiveProductModel;
import com.compubase.podra.data.model.PodHistoryModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductActiveFragment extends Fragment {


    @BindView(R.id.txt_product_active)
    TextView txtProductActive;
//    @BindView(R.id.RCV_Active_Product)
//    RecyclerView RCVActiveProduct;
    @BindView(R.id.BTN_Check_quantity_pro_active)
    Button BTNCheckQuantityProActive;
    Unbinder unbinder;
    private ActiveProductAdapter adapter;
    private RecyclerView RCVActiveProduct;

    public ProductActiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_active, container, false);

        RCVActiveProduct = view.findViewById(R.id.RCV_Active_Product);

        setupRecycler();
        fetchData();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RCVActiveProduct.setLayoutManager(layoutManager);
        adapter = new ActiveProductAdapter(getActivity());
        RCVActiveProduct.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    private void fetchData (){
        List<ActiveProductModel> activeProductModels = new ArrayList<>();

        String [] num = {"100","200","300","400"};
        String [] productName = {"nnnnn","mmmmm","gggg","tttt"};
        String [] quantity = {"1200","1000","1500","2500"};

        for (int i = 0; i <num.length ; i++) {
            activeProductModels.add(new ActiveProductModel(num[i],productName[i],quantity[i]));
        }
        adapter.setData(activeProductModels);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.BTN_Check_quantity_pro_active)
    public void onViewClicked() {
    }
}
