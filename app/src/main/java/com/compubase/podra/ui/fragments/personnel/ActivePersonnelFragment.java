package com.compubase.podra.ui.fragments.personnel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.compubase.podra.R;
import com.compubase.podra.adapter.DeliveryHistoryAdapter;
import com.compubase.podra.adapter.FirstPersonnelAdapter;
import com.compubase.podra.data.model.DeliveryHistoryModel;
import com.compubase.podra.data.model.FristPersonnelModel;
import com.compubase.podra.ui.activities.HomeActivity;
import com.compubase.podra.ui.fragments.delivery.ViewDeliveryFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivePersonnelFragment extends Fragment {


//    @BindView(R.id.RCV_Active_Personnel)
//    RecyclerView RCVActivePersonnel;
    Unbinder unbinder;
    private RecyclerView RCVActivePersonnel;
    private FirstPersonnelAdapter adapter;

    public ActivePersonnelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_active_personnel, container, false);

        RCVActivePersonnel = view.findViewById(R.id.RCV_Active_Personnel);

        setupRecycler();
        fetchData();
        onTouchAdapter();

        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RCVActivePersonnel.setLayoutManager(layoutManager);
        adapter = new FirstPersonnelAdapter(getActivity());
        RCVActivePersonnel.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    private void fetchData (){
        List<FristPersonnelModel> fristPersonnelModels = new ArrayList<>();

        String [] disc = {"bvifsbfsjnvsfjn","enkfkenf wklef","wklfnewjnfwnj","jenfoewno"};
        int [] img = {R.drawable.ic_add_circle_blue_24dp,R.drawable.ic_add_circle_blue_24dp,
                R.drawable.ic_add_circle_blue_24dp,R.drawable.ic_add_circle_blue_24dp};

        for (int i = 0; i <disc.length ; i++) {
            fristPersonnelModels.add(new FristPersonnelModel(disc[i],img[i]));
        }
        adapter.setData(fristPersonnelModels);
        adapter.notifyDataSetChanged();
    }
    private void onTouchAdapter() {
        adapter.onItemClickedListner(new FirstPersonnelAdapter.onItemClickListner() {
            @Override
            public void onClick(FristPersonnelModel fristPersonnelModel) {
                HomeActivity homeActivity = (HomeActivity)getActivity();
                ViewPersonnelFragment viewPersonnelFragment = new ViewPersonnelFragment();
                homeActivity.displaySelectedFragment(viewPersonnelFragment);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
