package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TambahPasienActivity extends BaseActivity {
    private EditText txt_nama;
    private EditText txt_nik;
    private EditText txt_no_telp;
    private RadioButton rd_laki;
    private RadioButton rd_perempuan;
    private Button btn_tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tambah_pasien);
        top_navbar();
        bottom_navbar();

        txt_nama = findViewById(R.id.txt_nama_lengkap);
        txt_nik = findViewById(R.id.txt_nik);
        txt_no_telp = findViewById(R.id.txt_nomor_telepon);
        rd_laki = findViewById(R.id.radio_laki);
        rd_perempuan = findViewById(R.id.radio_perempuan);
        btn_tambah = findViewById(R.id.btn_tambah);

        String returnTo = getIntent().getStringExtra("returnTo");

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = txt_nama.getText().toString();
                String nik = txt_nik.getText().toString();
                String no_telp = txt_no_telp.getText().toString();
                String gender = rd_laki.isChecked() ? "Laki-Laki" : "Perempuan";

                if(nama.isEmpty() || nik.isEmpty() || no_telp.isEmpty() || (!rd_laki.isChecked() && !rd_perempuan.isChecked())) {
                    Toast.makeText(TambahPasienActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Pasien newPasien = new Pasien(nama, gender, nik, no_telp, false);

                    Intent intent = new Intent(TambahPasienActivity.this, UbahInformasiPasienActivity.class);
                    intent.putExtra("newPasien", newPasien);
                    intent.putExtra("returnTo", returnTo);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });
    }
}