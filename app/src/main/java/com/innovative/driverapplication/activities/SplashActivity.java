package com.innovative.driverapplication.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.innovative.driverapplication.R;
import com.innovative.driverapplication.config.RequestConstant;
import com.innovative.driverapplication.util.PermissionUtil;

import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    //Todo : Permission
    private String COARSE_LOCATION_PERMISSION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private String CAMERA_PERMISSION = Manifest.permission.CAMERA;
    private String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    private String CALL_PHONE_PERMISSION = Manifest.permission.CALL_PHONE;

    private String[] permissionsArray = new String[]{COARSE_LOCATION_PERMISSION, CAMERA_PERMISSION, WRITE_EXTERNAL_STORAGE,
            CALL_PHONE_PERMISSION};

    private SplashActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        activity = SplashActivity.this;
        ButterKnife.bind(this);

        initPermission();
    }

    private void initPermission() {
        if (!PermissionUtil.hasPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) ||
                !PermissionUtil.hasPermission(activity, Manifest.permission.CAMERA) ||
                !PermissionUtil.hasPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) ||
                !PermissionUtil.hasPermission(activity, Manifest.permission.CALL_PHONE)) {

            if (PermissionUtil.shouldShowRational(activity, Manifest.permission.ACCESS_COARSE_LOCATION) ||
                    PermissionUtil.shouldShowRational(activity, Manifest.permission.CAMERA) ||
                    PermissionUtil.shouldShowRational(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) ||
                    PermissionUtil.shouldShowRational(activity, Manifest.permission.CALL_PHONE)) {

                PermissionUtil.requestPermissions(activity, permissionsArray, RequestConstant.PERMISSION_SPLASH_REQUEST_CODE);
            } else {
                PermissionUtil.requestPermissions(activity, permissionsArray, RequestConstant.PERMISSION_SPLASH_REQUEST_CODE);
            }
        } else {
            init();
        }
    }

    private void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case RequestConstant.PERMISSION_SPLASH_REQUEST_CODE:
                if (grantResults.length > 0) {
                    boolean isLocationGranted = (grantResults[0] == PackageManager.PERMISSION_GRANTED);
                    boolean isCameraGranted = (grantResults[1] == PackageManager.PERMISSION_GRANTED);
                    boolean isStorageGranted = (grantResults[2] == PackageManager.PERMISSION_GRANTED);
                    boolean isPhoneCallGranted = (grantResults[3] == PackageManager.PERMISSION_GRANTED);

                    if (isLocationGranted && isCameraGranted && isStorageGranted && isPhoneCallGranted) {
                        //all granted
                        init();
                    } else {
                        init();
                    }
                }
                break;

            default:

                break;
        }
    }
}