package com.example.pharmacydesign.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pharmacydesign.R;
import com.example.pharmacydesign.Signup2;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
    }

    public void login(View view) {
        Intent intent =new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    public void signu_btn(View view) {
        Intent intent = new Intent(SignUpActivity.this, Signup2.class);
        startActivity(intent);
    }
}