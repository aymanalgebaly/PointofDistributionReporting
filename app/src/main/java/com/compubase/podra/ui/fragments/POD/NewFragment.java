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
public class NewFragment extends Fragment {


    @BindView(R.id.POD_img)
    CircleImageView PODImg;
    @BindView(R.id.txt_pod_publication)
    TextView txtPodPublication;
    @BindView(R.id.POD_Publication)
    EditText PODPublication;
    @BindView(R.id.txt_pod_weight)
    TextView txtPodWeight;
    @BindView(R.id.POD_Weight)
    EditText PODWeight;
    @BindView(R.id.txt_pod_quantity)
    TextView txtPodQuantity;
    @BindView(R.id.POD_Quantity)
    EditText PODQuantity;
    @BindView(R.id.txt_pod_city)
    TextView txtPodCity;
    @BindView(R.id.POD_City)
    EditText PODCity;
    @BindView(R.id.txt_pod_startdate)
    TextView txtPodStartdate;
    @BindView(R.id.POD_StartDate_Calendar)
    TextView PODStartDateCalendar;
    @BindView(R.id.txt_pod_end_date)
    TextView txtPodEndDate;
    @BindView(R.id.POD_EndDate_Calendar)
    TextView PODEndDateCalendar;
    @BindView(R.id.pod_txt_itemsize)
    TextView podTxtItemsize;
    @BindView(R.id.POD_itemSize)
    EditText PODItemSize;
    @BindView(R.id.BTN_Pod_SUBMIT)
    Button BTNPodSUBMIT;
    Unbinder unbinder;

    public NewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.POD_img, R.id.BTN_Pod_SUBMIT})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.POD_img:
                break;
            case R.id.BTN_Pod_SUBMIT:
                DialogNewPod();
                break;
        }
    }

    private void DialogNewPod() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog_new_delivery,null);

        builder.setView(mView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button button = mView.findViewById(R.id.BTN_Pod_SUBMIT);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.hide();
            }
        });
    }
}
