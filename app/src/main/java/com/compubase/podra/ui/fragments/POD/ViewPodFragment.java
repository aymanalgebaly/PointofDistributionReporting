package com.compubase.podra.ui.fragments.POD;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.compubase.podra.R;
import com.compubase.podra.ui.activities.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPodFragment extends Fragment {


    @BindView(R.id.RV_ViewPod)
    TextView RVViewPod;
    @BindView(R.id.txt_num_pod_view)
    TextView txtNumPodView;
    @BindView(R.id.num_pod_view)
    TextView numPodView;
    @BindView(R.id.txt_product_name_pod_view)
    TextView txtProductNamePodView;
    @BindView(R.id.product_name_pod_view)
    TextView productNamePodView;
    @BindView(R.id.txt_status_pod_view)
    TextView txtStatusPodView;
    @BindView(R.id.status_active_pod)
    TextView statusActivePod;
    @BindView(R.id.txt_distributor_name_pod_view)
    TextView txtDistributorNamePodView;
    @BindView(R.id.distributor_name_pod_view)
    TextView distributorNamePodView;
    @BindView(R.id.txt_distributed_pod_view)
    TextView txtDistributedPodView;
    @BindView(R.id.distributed_pod_view)
    TextView distributedPodView;
    @BindView(R.id.txt_finishing_dist_pod_view)
    TextView txtFinishingDistPodView;
    @BindView(R.id.finishing_dist_pod_view)
    TextView finishingDistPodView;
    @BindView(R.id.card_view_pod_view)
    CardView cardViewPodView;
    @BindView(R.id.BTN_Last_visits_pod_view)
    Button BTNLastVisitsPodView;
    @BindView(R.id.RV_View_pod_BTN)
    RelativeLayout RVViewPodBTN;
    @BindView(R.id.frame_map_pod_view)
    FrameLayout frameMapPodView;


    Unbinder unbinder;

    public ViewPodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pod, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.BTN_Last_visits_pod_view)
    public void onViewClicked() {
    }
}
