package com.compubase.podra.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.compubase.podra.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationActivity extends AppCompatActivity {

    @BindView(R.id.full_name)
    EditText fullName;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.phone_num)
    EditText phoneNum;
    @BindView(R.id.view4)
    View view4;
    @BindView(R.id.lin_one)
    RadioGroup linOne;
    @BindView(R.id.RV_OR)
    RelativeLayout RVOR;
    @BindView(R.id.BTN_signUp_registar)
    Button BTNSignUpRegistar;
    @BindView(R.id.text_qs)
    TextView textQs;
    @BindView(R.id.text_login)
    TextView textLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.BTN_signUp_registar, R.id.text_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.BTN_signUp_registar:
                break;
            case R.id.text_login:
                startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                break;
        }
    }
}
