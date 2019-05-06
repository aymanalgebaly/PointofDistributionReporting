package com.compubase.podra.ui.fragments.POD;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPodFragment extends Fragment implements OnMapReadyCallback {


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

    private GoogleMap mMap;


    Unbinder unbinder;
    private SupportMapFragment mapFragment;

    public ViewPodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pod, container, false);

        mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.pod_view_map);
        if (mapFragment == null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            fragmentTransaction.replace(R.id.pod_view_map,mapFragment).commit();
        }
        mapFragment.getMapAsync(this);


        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    private void addMarker(LatLng latLng) {
        try {
            if (null != latLng) {
                BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp);
                MarkerOptions options = new MarkerOptions();
                options.position(latLng)
                        .icon(bitmapDescriptor);

                if (mMap != null) {
                    mMap.addMarker(options);
                    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 19f);
                    mMap.animateCamera(cameraUpdate);
                }

            }
        } catch (Exception e) {
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.BTN_Last_visits_pod_view)
    public void onViewClicked() {
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
}
