package com.compubase.podra.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.compubase.podra.ui.activities.HomeActivity;
import com.compubase.podra.R;
import com.compubase.podra.ui.fragments.POD.PodFragment;
import com.compubase.podra.ui.fragments.delivery.DeliveryFragment;
import com.compubase.podra.ui.fragments.personnel.PersonnelFragment;
import com.compubase.podra.ui.fragments.product.ProductFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.img_pod)
    ImageView imgPod;
    @BindView(R.id.img_packaging)
    ImageView imgPackaging;
    @BindView(R.id.img_personnel)
    ImageView imgPersonnel;
    @BindView(R.id.img_delivery)
    ImageView imgDelivery;
    @BindView(R.id.txt_POD)
    TextView txtPOD;
    @BindView(R.id.txt_packaging)
    TextView txtPackaging;
    @BindView(R.id.txt_Personnel)
    TextView txtPersonnel;
    @BindView(R.id.txt_Delivery)
    TextView txtDelivery;
    Unbinder unbinder;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.img_pod, R.id.img_packaging, R.id.img_personnel, R.id.img_delivery})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_pod:
                HomeActivity homeActivity = (HomeActivity)getActivity();
                PodFragment podFragment = new PodFragment();
                homeActivity.displaySelectedFragment(podFragment);
                break;
            case R.id.img_packaging:
                HomeActivity homeActivity1 = (HomeActivity)getActivity();
                ProductFragment productFragment = new ProductFragment();
                homeActivity1.displaySelectedFragment(productFragment);
                break;
            case R.id.img_personnel:
                HomeActivity homeActivity2 = (HomeActivity)getActivity();
                PersonnelFragment personnelFragment = new PersonnelFragment();
                homeActivity2.displaySelectedFragment(personnelFragment);
                break;
            case R.id.img_delivery:
                HomeActivity homeActivity3 = (HomeActivity)getActivity();
                DeliveryFragment deliveryFragment = new DeliveryFragment();
                homeActivity3.displaySelectedFragment(deliveryFragment);
                break;
        }
    }
}
