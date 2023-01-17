package com.yesh.gps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    Button btnDaftar;
    EditText edtEmail;
    EditText edtPass;
    ProgressBar loadingLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        btnDaftar = findViewById(R.id.btnDaftar);
        edtPass = findViewById(R.id.edtLoginPass);
        edtEmail = findViewById(R.id.edtLoginEmail);
        loadingLogin = findViewById(R.id.loadingLogin);
        loadingLogin.setVisibility(View.INVISIBLE);

        btnLogin.setOnClickListener(view -> {
            // apapun saat diklik buntto login akan di exekusi disini
            if (TextUtils.isEmpty(edtEmail.getText())) {
                edtEmail.setError("Tidak Boleh Kosong");
            }
            if (TextUtils.isEmpty(edtPass.getText())) {
                edtPass.setError("Tidak Boleh Kosong");
            } else {
                loadingLogin.setVisibility(View.VISIBLE);
                String email = edtEmail.getText().toString();
                String pass = edtPass.getText().toString();
                cekData(email, pass);

            }


        });
        btnDaftar.setOnClickListener(view -> {
            // apapun saat diklik buntto login akan di exekusi disini
            Intent intent = new Intent(this, DaftarActivity.class);
            startActivity(intent);

        });
    }

    private void cekData(String email, String pass) {
        String url = "https://kiel.api88.link/motor/login.php";
        StringRequest koneksi = new StringRequest(Request.Method.GET, url,
                response -> {
            loadingLogin.setVisibility(View.INVISIBLE);
                    try {
                        JSONObject obj = new JSONObject(response);
                        JSONArray arr = obj.getJSONArray("data");
                        for(int i = 0; i < arr.length();i++){
                            JSONObject obj2 = arr.getJSONObject(i);
                            itemUser user = new itemUser(obj2);
                            if(email.equalsIgnoreCase(user.getNama())){
                                if (pass.equalsIgnoreCase(user.getPassword())){
                                    Log.d("TAG", "Login Berhasil ");
                                    Intent intent = new Intent(this, MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    Log.d("TAG", "password salah ");
                                }
                            }else {
                                Log.d("TAG", "email salah ");
                            }


                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {

        });
        RequestQueue volley = Volley.newRequestQueue(this);
        volley.add(koneksi);
    }
}