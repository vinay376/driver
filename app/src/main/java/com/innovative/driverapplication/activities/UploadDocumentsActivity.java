package com.innovative.driverapplication.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.innovative.driverapplication.R;

public class UploadDocumentsActivity extends AppCompatActivity {

    Button btnGet;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_documents);


        textView =findViewById(R.id.textView1);
        btnGet=findViewById(R.id.button1);




        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder= new AlertDialog.Builder(UploadDocumentsActivity.this);
                View view = LayoutInflater.from(UploadDocumentsActivity.this).inflate(R.layout.dialog_date_picker_layout,null);
                builder.setView(view);
                AlertDialog dialog = builder.create();
                DatePicker datePicker = view.findViewById(R.id.date_picker);

                Button done = view.findViewById(R.id.done);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();

                        int day = datePicker.getDayOfMonth();
                        int month = datePicker.getMonth()+1;
                        int year = datePicker.getYear();
                        textView.setText(day+"/"+month+"/"+year);
                    }
                });

                dialog.show();

            }

        });


    }
    }

