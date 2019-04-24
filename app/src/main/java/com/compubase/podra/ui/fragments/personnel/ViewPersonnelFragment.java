package com.compubase.podra.ui.fragments.personnel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.adapter.FirstPersonnelAdapter;
import com.compubase.podra.adapter.ViewPersonnelAdapter;
import com.compubase.podra.data.model.FristPersonnelModel;
import com.compubase.podra.data.model.ViewPersonnelModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPersonnelFragment extends Fragment {


    @BindView(R.id.txt_View_Presonnel)
    TextView txtViewPresonnel;
    @BindView(R.id.img_view_personnel)
    CircleImageView imgViewPersonnel;
    @BindView(R.id.txt_name_view_personnel)
    TextView txtNameViewPersonnel;
    @BindView(R.id.txt_phone_number_view_personnel)
    TextView txtPhoneNumberViewPersonnel;
    @BindView(R.id.name_view_personnel)
    TextView nameViewPersonnel;
    @BindView(R.id.phone_number_view_personnel)
    TextView phoneNumberViewPersonnel;
    @BindView(R.id.card_view_view_personnel)
    CardView cardViewViewPersonnel;
//    @BindView(R.id.RCV_view_personnel)
//    RecyclerView RCVViewPersonnel;
    @BindView(R.id.card_view_personnel_rcv)
    CardView cardViewPersonnelRcv;
    @BindView(R.id.RV_Button_Last_Visits)
    RelativeLayout RVButtonLastVisits;
    Unbinder unbinder;
    private RecyclerView RCVViewPersonnel;


    private ViewPersonnelAdapter adapter;

    public ViewPersonnelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_personnel, container, false);

        RCVViewPersonnel = view.findViewById(R.id.RCV_view_personnel);

        setupRecycler();
        fetchData();

        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RCVViewPersonnel.setLayoutManager(layoutManager);
        adapter = new ViewPersonnelAdapter(getActivity());
        RCVViewPersonnel.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    private void fetchData (){
        List<ViewPersonnelModel> viewPersonnelModels = new ArrayList<>();

        String [] num = {"1","2","3","4"};
        String [] name = {"ayman","amir","mohamed","ahmed"};
        String [] location = {"geddah","cairo","alex","usa"};
        String [] phone = {"21651651","51561651","51684651651","51651651651"};

        for (int i = 0; i <num.length ; i++) {
            viewPersonnelModels.add(new ViewPersonnelModel(num[i],name[i],location[i],phone[i]));
        }
        adapter.setData(viewPersonnelModels);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
