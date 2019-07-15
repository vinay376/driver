package com.innovative.driverapplication.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.innovative.driverapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.signin_container)
    public void onClickSignin() {
        finish();
    }

    @OnClick(R.id.btn_signup)
    public void onClickSignup() {
        Intent intent = new Intent(getApplicationContext(), OtpVerificationActivity.class);
        startActivity(intent);
    }



}