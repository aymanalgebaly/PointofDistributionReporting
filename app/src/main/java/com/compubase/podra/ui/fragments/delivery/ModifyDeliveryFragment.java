package com.compubase.podra.ui.fragments.delivery;


import android.app.AlertDialog;
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
import com.compubase.podra.ui.fragments.bottomNavigationView.EditProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModifyDeliveryFragment extends Fragment {


    @BindView(R.id.Delivery_modify_img)
    CircleImageView DeliveryModifyImg;
    @BindView(R.id.txt_modify_Del_name)
    TextView txtModifyDelName;
    @BindView(R.id.Del_modify_name)
    EditText DelModifyName;
    @BindView(R.id.txt_modify_Del_Car_type)
    TextView txtModifyDelCarType;
    @BindView(R.id.Del_modify_Car_Type)
    EditText DelModifyCarType;
    @BindView(R.id.txt_modify_Del_Delivery_time)
    TextView txtModifyDelDeliveryTime;
    @BindView(R.id.Del_modify_Delivery_time)
    Spinner DelModifyDeliveryTime;
    @BindView(R.id.txt_modify_Del_weight)
    TextView txtModifyDelWeight;
    @BindView(R.id.Del_modify_Weight)
    EditText DelModifyWeight;
    @BindView(R.id.txt_modify_Del_item_size)
    TextView txtModifyDelItemSize;
    @BindView(R.id.Del_modify_ItemSize)
    EditText DelModifyItemSize;
    @BindView(R.id.Del_txt_modify_from_location)
    TextView DelTxtModifyFromLocation;
    @BindView(R.id.Del_modify_FromLocation)
    Spinner DelModifyFromLocation;
    @BindView(R.id.Del_txt_modify_to_location)
    TextView DelTxtModifyToLocation;
    @BindView(R.id.Del_modify_ToLocation)
    Spinner DelModifyToLocation;
    @BindView(R.id.BTN_modify_Del_SUBMIT)
    Button BTNModifyDelSUBMIT;
    Unbinder unbinder;

    public ModifyDeliveryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modify_delivery, container, false);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.Delivery_modify_img, R.id.BTN_modify_Del_SUBMIT})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Delivery_modify_img:
                break;
            case R.id.BTN_modify_Del_SUBMIT:
                DialogModifyDelivery();
                break;
        }
    }

    private void DialogModifyDelivery() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog_edite_profile,null);
        builder.setView(mView);

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button button = mView.findViewById(R.id.BTN_edit_profile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.hide();
            }
        });
    }
}
