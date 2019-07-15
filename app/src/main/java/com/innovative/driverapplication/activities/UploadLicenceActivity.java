package com.innovative.driverapplication.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.innovative.driverapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class UploadLicenceActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private String CAMERA = Manifest.permission.CAMERA;
    private String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    private String[] cameraPermissions = new String[]{CAMERA, WRITE_EXTERNAL_STORAGE};
    private String[] galleryPermissions = new String[]{WRITE_EXTERNAL_STORAGE};
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_licence);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_doc)
    public void onClickDoc() {

    }

}