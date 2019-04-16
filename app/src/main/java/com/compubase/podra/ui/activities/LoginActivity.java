package com.compubase.podra.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.compubase.podra.HomeActivity;
import com.compubase.podra.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.BTN_signIn_login)
    Button BTNSignInLogin;
    @BindView(R.id.text_forgot_pass)
    TextView textForgotPass;
    @BindView(R.id.mail_login)
    EditText mailLogin;
    @BindView(R.id.view5)
    View view5;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.RV_LOGIN)
    RelativeLayout RVLOGIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.BTN_signIn_login, R.id.text_forgot_pass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.BTN_signIn_login:
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                break;
            case R.id.text_forgot_pass:
                startActivity(new Intent(LoginActivity.this,ForgotPassActivity.class));
                break;
        }
    }
}
