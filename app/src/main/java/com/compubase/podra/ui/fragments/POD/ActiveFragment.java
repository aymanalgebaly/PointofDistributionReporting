package com.compubase.podra.ui.fragments.POD;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.adapter.FirstPersonnelAdapter;
import com.compubase.podra.adapter.PodModifyAdapter;
import com.compubase.podra.data.model.FristPersonnelModel;
import com.compubase.podra.data.model.PodModifyModel;
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
public class ActiveFragment extends Fragment {


    @BindView(R.id.txt_pod_active)
    TextView txtPodActive;
//    @BindView(R.id.RV_list_active_pod)
//    RecyclerView RVListActivePod;
    Unbinder unbinder;
    private RecyclerView RVListActivePod;
    private PodModifyAdapter adapter;

    public ActiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_active, container, false);

        RVListActivePod = view.findViewById(R.id.RV_list_active_pod);

        unbinder = ButterKnife.bind(this, view);

        setupRecycler();
        fetchData();

        return view;
    }
    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RVListActivePod.setLayoutManager(layoutManager);
        adapter = new PodModifyAdapter(getActivity());
        RVListActivePod.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    private void fetchData (){
        List<PodModifyModel> podModifyModels = new ArrayList<>();

        String [] num = {"1","2","3","4","5","6","7"};
        String [] name = {"ayman","ahmed","hany","ibrahim","hady","alaa","ali"};
        String [] status = {"online","offline","offline","online","online","online","online"};


        for (int i = 0; i <num.length ; i++) {
            podModifyModels.add(new PodModifyModel(num[i],name[i],status[i]));
        }
        adapter.setData(podModifyModels);
        adapter.notifyDataSetChanged();
    }
    private void onTouchAdapter() {
        adapter.onItemClickedListner(new PodModifyAdapter.onItemClickListner() {
            @Override
            public void onClick(PodModifyModel podModifyModel) {


                HomeActivity homeActivity = (HomeActivity) getActivity();
                InfoPersonnelFragment infoPersonnelFragment = new InfoPersonnelFragment();
                homeActivity.displaySelectedFragment(infoPersonnelFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
