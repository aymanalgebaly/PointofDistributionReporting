package com.compubase.podra.ui.fragments.bottomNavigationView;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class HelpFragment extends Fragment {


    @BindView(R.id.full_name)
    EditText fullName;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.txt_Message)
    TextView txtMessage;
    @BindView(R.id.Edit_Message)
    EditText EditMessage;
    @BindView(R.id.BTN_SUBMIT_HELP)
    Button BTNSUBMITHELP;
    Unbinder unbinder;

    public HelpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_help, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.BTN_SUBMIT_HELP)
    public void onViewClicked() {
        DialogHelp();
    }

    private void DialogHelp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog_help,null);

        builder.setView(mView);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button button = mView.findViewById(R.id.BTN_help);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.hide();
            }
        });
    }
}
