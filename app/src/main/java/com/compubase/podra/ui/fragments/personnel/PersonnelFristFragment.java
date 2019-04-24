package com.compubase.podra.ui.fragments.personnel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.compubase.podra.R;
import com.compubase.podra.adapter.DeliveryActiveAdapter;
import com.compubase.podra.adapter.FirstPersonnelAdapter;
import com.compubase.podra.data.model.DeliveryActiveModel;
import com.compubase.podra.data.model.FristPersonnelModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonnelFristFragment extends Fragment {


    //    @BindView(R.id.RCV_Personnel_Frist)
//    RecyclerView RCVPersonnelFrist;
    Unbinder unbinder;
    private RecyclerView RCVPersonnelFrist;
    private FirstPersonnelAdapter adapter;

    public PersonnelFristFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personnel_frist, container, false);

        RCVPersonnelFrist = view.findViewById(R.id.RCV_Personnel_Frist);

        setupRecycler();
        fetchData();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RCVPersonnelFrist.setLayoutManager(layoutManager);
        adapter = new FirstPersonnelAdapter(getActivity());
        RCVPersonnelFrist.setAdapter(adapter);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
