package com.compubase.podra.ui.fragments.product;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.compubase.podra.R;
import com.compubase.podra.adapter.FirstPersonnelAdapter;
import com.compubase.podra.adapter.PodHistoryAdapter;
import com.compubase.podra.adapter.ProductHistoryAdapter;
import com.compubase.podra.data.model.FristPersonnelModel;
import com.compubase.podra.data.model.PodHistoryModel;
import com.compubase.podra.data.model.ProductHistoryModel;
import com.compubase.podra.ui.activities.HomeActivity;
import com.compubase.podra.ui.fragments.personnel.InfoPersonnelFragment;

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
    private ProductHistoryAdapter adapter;
    private ProductHistoryFragment productHistoryFragment;

    public ProductHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_history, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        setupRecycler();
        fetshData();
        onTouchAdapter();
    }


    private void fetshData() {
        List<ProductHistoryModel>productHistoryModels = new ArrayList<>();

        String [] names = {"ayman","ahmed","hassan","hussein"};
        String [] num = {"100","200","300","400"};
        String [] startDate = {"20/10/2018","20/10/2018","20/10/2018","20/10/2018"};
        String [] endDate = {"20/11/2018","20/11/2018","20/11/2018","20/11/2018"};

        for (int i = 0; i <num.length ; i++) {
            productHistoryModels.add(new ProductHistoryModel(num[i],names[i],startDate[i],endDate[i]));
        }
        adapter.setData(productHistoryModels);
        adapter.notifyDataSetChanged();
    }

    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RCVHistoryProduct.setLayoutManager(layoutManager);
        adapter = new ProductHistoryAdapter(getActivity());
        RCVHistoryProduct.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void onTouchAdapter() {
        adapter.onItemClickedListner(new ProductHistoryAdapter.onItemClickListner() {
            @Override
            public void onClick(ProductHistoryModel productHistoryModel) {
                HomeActivity homeActivity = (HomeActivity)getActivity();
                ViewProductFragment viewProductFragment = new ViewProductFragment();
                homeActivity.displaySelectedFragment(viewProductFragment);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
