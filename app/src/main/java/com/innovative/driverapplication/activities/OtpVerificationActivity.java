package com.innovative.driverapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.innovative.driverapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;

public class OtpVerificationActivity extends AppCompatActivity {

   /* @BindView(R.id.et_otp_1)
    EditText etOtp_1;
    @BindView(R.id.et_otp_2)
    EditText etOtp_2;
    @BindView(R.id.et_otp_3)
    EditText etOtp_3;
    @BindView(R.id.et_otp_4)
    EditText etOtp_4;*/

    String otp_1,otp_2,otp_3,otp_4;

    private EditText[] editTexts;

    private OtpTextView otpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        ButterKnife.bind(this);



        otpTextView = findViewById(R.id.otp_view);
        otpTextView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {
                // fired when user types something in the Otpbox
            }
            @Override
            public void onOTPComplete(String otp) {
                // fired when user has entered the OTP fully.
                Toast.makeText(OtpVerificationActivity.this, "The OTP is " + otp,  Toast.LENGTH_SHORT).show();
            }
        });


        //todo test case 1
        /*editTexts = new EditText[]{etOtp_1, etOtp_2, etOtp_3, etOtp_4};
        etOtp_1.addTextChangedListener(new generalTextWatcher(0));
        etOtp_2.addTextChangedListener(new generalTextWatcher(1));
        etOtp_3.addTextChangedListener(new generalTextWatcher(2));
        etOtp_4.addTextChangedListener(new generalTextWatcher(3));

        etOtp_1.setOnKeyListener(new PinOnKeyListener(0));
        etOtp_2.setOnKeyListener(new PinOnKeyListener(1));
        etOtp_3.setOnKeyListener(new PinOnKeyListener(2));
        etOtp_4.setOnKeyListener(new PinOnKeyListener(3));*/



        //todo test case 2
       /* etOtp_1.addTextChangedListener(generalTextWatcher);
        etOtp_2.addTextChangedListener(generalTextWatcher);
        etOtp_3.addTextChangedListener(generalTextWatcher);
        etOtp_4.addTextChangedListener(generalTextWatcher);*/




    }


    //todo test case 1 start here
    public class generalTextWatcher implements TextWatcher {

        private int currentIndex;
        private boolean isFirst = false, isLast = false;
        private String newTypedString = "";

        generalTextWatcher(int currentIndex) {
            this.currentIndex = currentIndex;

            if (currentIndex == 0)
                this.isFirst = true;
            else if (currentIndex == editTexts.length - 1)
                this.isLast = true;
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            newTypedString = s.subSequence(start, start + count).toString().trim();
        }

        @Override
        public void afterTextChanged(Editable editable) {


            String text = newTypedString;

            /* Detect paste event and set first char */
            if (text.length() > 1)
                text = String.valueOf(text.charAt(0)); // TODO: We can fill out other EditTexts

            editTexts[currentIndex].removeTextChangedListener(this);
            editTexts[currentIndex].setText(text);
            editTexts[currentIndex].setSelection(text.length());
            editTexts[currentIndex].addTextChangedListener(this);

            if (text.length() == 1)
                moveToNext();
            else if (text.length() == 0)
                moveToPrevious();

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }


        private void moveToNext() {
            if (!isLast)
                editTexts[currentIndex + 1].requestFocus();

            if (isAllEditTextsFilled() && isLast) { // isLast is optional
                editTexts[currentIndex].clearFocus();
                hideKeyboard();
            }
        }

        private void moveToPrevious() {
            if (!isFirst)
                editTexts[currentIndex - 1].requestFocus();
        }

        private boolean isAllEditTextsFilled() {
            for (EditText editText : editTexts)
                if (editText.getText().toString().trim().length() == 0)
                    return false;
            return true;
        }

        private void hideKeyboard() {
            if (getCurrentFocus() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }
    }




    public class PinOnKeyListener implements View.OnKeyListener {

        private int currentIndex;

        PinOnKeyListener(int currentIndex) {
            this.currentIndex = currentIndex;
        }

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                if (editTexts[currentIndex].getText().toString().isEmpty() && currentIndex != 0)
                    editTexts[currentIndex - 1].requestFocus();
            }
            return false;
        }

    }//todo test case 1 end here







    //todo test case 2 start here
    public  void requestFocus(EditText editText){
        editText.requestFocus();
    }

     private TextWatcher generalTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
           /* if (etOtp_1.getText().hashCode() == editable.hashCode()) {
                 otp_1 = etOtp_1.getText().toString().trim();
                if(!otp_1.equals("")){
                    requestFocus(etOtp_2);
                }

            } else if (etOtp_2.getText().hashCode() == editable.hashCode()) {
                 otp_2 = etOtp_2.getText().toString().trim();
                if(!otp_2.equals("")){
                    requestFocus(etOtp_3);
                } else {
                    requestFocus(etOtp_1);
                }
            }else if (etOtp_3.getText().hashCode() == editable.hashCode()) {
                 otp_3 = etOtp_3.getText().toString().trim();
                if(!otp_3.equals("")){
                    requestFocus(etOtp_4);
                }else {
                    requestFocus(etOtp_2);
                }
            }else if (etOtp_3.getText().hashCode() == editable.hashCode()) {
                 otp_4 = etOtp_4.getText().toString().trim();
                if(!otp_4.equals("")){

                }else {
                    requestFocus(etOtp_3);

                }
            }*/
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

    };//todo test case 2 end here




}
