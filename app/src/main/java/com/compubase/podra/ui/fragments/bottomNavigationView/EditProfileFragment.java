package com.compubase.podra.ui.fragments.bottomNavigationView;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.compubase.podra.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditProfileFragment extends Fragment {


    @BindView(R.id.full_name_edit_profile)
    EditText fullNameEditProfile;
    @BindView(R.id.view10)
    View view10;
    @BindView(R.id.email_edit_profile)
    EditText emailEditProfile;
    @BindView(R.id.view20)
    View view20;
    @BindView(R.id.password_edit_profile)
    EditText passwordEditProfile;
    @BindView(R.id.view30)
    View view30;
    @BindView(R.id.phone_num_edit_profile)
    EditText phoneNumEditProfile;
    @BindView(R.id.view40)
    View view40;
    @BindView(R.id.radio_btn_one_edite_profile)
    RadioButton radioBtnOneEditeProfile;
    @BindView(R.id.radio_btn_two_edite_profile)
    RadioButton radioBtnTwoEditeProfile;
    @BindView(R.id.lin_one_edite_profile)
    RadioGroup linOneEditeProfile;
    @BindView(R.id.LIN_Radio_edit_profile)
    LinearLayout LINRadioEditProfile;
    @BindView(R.id.btn_save_edite_profile)
    Button btnSaveEditeProfile;
    @BindView(R.id.RV_OR)
    RelativeLayout RVOR;
    Unbinder unbinder;

    public EditProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_save_edite_profile)
    public void onViewClicked() {

        Dialog();
    }

    private void Dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog_edite_profile,null);
        Button button = mView.findViewById(R.id.BTN_edit_profile);

        builder.setView(mView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}
