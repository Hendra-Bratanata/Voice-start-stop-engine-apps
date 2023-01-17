package com.yesh.gps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class DaftarActivity extends AppCompatActivity {
    Button btnDaftar;
    ProgressBar loadingDaftar;
    EditText edtEmail;
    EditText edtPass;
    EditText edtRePass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        edtEmail = findViewById(R.id.edtDaftarEmail);
        edtPass = findViewById(R.id.edtDaftarPass);
        edtRePass = findViewById(R.id.edtRePasswordDaftar);
        loadingDaftar = findViewById(R.id.loadingDaftar);
        loadingDaftar.setVisibility(View.INVISIBLE);
        btnDaftar = findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(view -> {

        });
    }
}