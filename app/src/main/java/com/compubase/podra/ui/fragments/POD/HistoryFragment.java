package com.compubase.podra.ui.fragments.POD;


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
public class HistoryFragment extends Fragment {


//    @BindView(R.id.RV_POD_History)
//    RecyclerView RVPODHistory;
    Unbinder unbinder;
    private PodHistoryAdapter adapter;
    private RecyclerView recyclerView;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = view.findViewById(R.id.RV_POD_History);

        setupRecycler();
        fetchData();


        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PodHistoryAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    private void fetchData (){
        List<PodHistoryModel> podHistoryModelList = new ArrayList<>();

        String [] names = {"ayman","ahmed","hassan","hussein"};
        String [] num = {"100","200","300","400"};
        String [] startDate = {"20/10/2018","20/10/2018","20/10/2018","20/10/2018"};
        String [] endDate = {"20/11/2018","20/11/2018","20/11/2018","20/11/2018"};

        for (int i = 0; i <names.length ; i++) {
            podHistoryModelList.add(new PodHistoryModel(names[i],num[i],startDate[i],endDate[i]));
        }
        adapter.setData(podHistoryModelList);
        adapter.notifyDataSetChanged();
    }
}
