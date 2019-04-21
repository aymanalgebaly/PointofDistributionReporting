package com.compubase.podra.ui.fragments.POD;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
public class ModifyPodFragment extends Fragment {


    @BindView(R.id.img_Modify_POD)
    CircleImageView imgModifyPOD;
    @BindView(R.id.txt_Modify_POD_publication)
    TextView txtModifyPODPublication;
    @BindView(R.id.Puplication_Modify_POD)
    EditText PuplicationModifyPOD;
    @BindView(R.id.txt_Modify_POD_weight)
    TextView txtModifyPODWeight;
    @BindView(R.id.Weight_Modify_POD)
    EditText WeightModifyPOD;
    @BindView(R.id.txt_Modify_POD_quantity)
    TextView txtModifyPODQuantity;
    @BindView(R.id.Quantity_Modify_POD)
    EditText QuantityModifyPOD;
    @BindView(R.id.txt_Modify_POD_city)
    TextView txtModifyPODCity;
    @BindView(R.id.City_Modify_POD)
    EditText CityModifyPOD;
    @BindView(R.id.txt_Modify_POD_startDate)
    TextView txtModifyPODStartDate;
    @BindView(R.id.StartDate_Calendar_Modify_POD)
    TextView StartDateCalendarModifyPOD;
    @BindView(R.id.txt_Modify_POD_endDate)
    TextView txtModifyPODEndDate;
    @BindView(R.id.EndDate_Calendar_Modify_POD)
    TextView EndDateCalendarModifyPOD;
    @BindView(R.id.txt_Modify_POD_itemSize)
    TextView txtModifyPODItemSize;
    @BindView(R.id.itemSize_Modify_POD)
    EditText itemSizeModifyPOD;
    @BindView(R.id.BTN_Modify_POD_SAVE)
    Button BTNModifyPODSAVE;
    Unbinder unbinder;

    public ModifyPodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modify_pod, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.img_Modify_POD, R.id.BTN_Modify_POD_SAVE})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_Modify_POD:
                break;
            case R.id.BTN_Modify_POD_SAVE:
                DialogModifyPod();
                break;
        }
    }

    private void DialogModifyPod() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog_edite_profile,null);

        builder.setView(mView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button button = mView.findViewById(R.id.BTN_Modify_POD_SAVE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.hide();
            }
        });
    }
}
