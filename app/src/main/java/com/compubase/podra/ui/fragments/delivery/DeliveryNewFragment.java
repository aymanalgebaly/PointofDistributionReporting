package com.compubase.podra.ui.fragments.delivery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.compubase.podra.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryNewFragment extends Fragment {


    @BindView(R.id.Delivery_img)
    CircleImageView DeliveryImg;
    @BindView(R.id.txt_Del_name)
    TextView txtDelName;
    @BindView(R.id.Del_name)
    EditText DelName;
    @BindView(R.id.txt_Del_Car_type)
    TextView txtDelCarType;
    @BindView(R.id.Del_Car_Type)
    EditText DelCarType;
    @BindView(R.id.txt_Del_Delivery_time)
    TextView txtDelDeliveryTime;
    @BindView(R.id.Del_Delivery_time)
    Spinner DelDeliveryTime;
    @BindView(R.id.txt_Del_weight)
    TextView txtDelWeight;
    @BindView(R.id.Del_Weight)
    EditText DelWeight;
    @BindView(R.id.txt_Del_item_size)
    TextView txtDelItemSize;
    @BindView(R.id.Del_ItemSize)
    EditText DelItemSize;
    @BindView(R.id.Del_txt_from_location)
    TextView DelTxtFromLocation;
    @BindView(R.id.Del_FromLocation)
    Spinner DelFromLocation;
    @BindView(R.id.Del_txt_to_location)
    TextView DelTxtToLocation;
    @BindView(R.id.Del_ToLocation)
    Spinner DelToLocation;
    @BindView(R.id.BTN_Del_SUBMIT)
    Button BTNDelSUBMIT;
    Unbinder unbinder;

    public DeliveryNewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery_new, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.Delivery_img, R.id.BTN_Del_SUBMIT})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Delivery_img:
                break;
            case R.id.BTN_Del_SUBMIT:
                break;
        }
    }
}
