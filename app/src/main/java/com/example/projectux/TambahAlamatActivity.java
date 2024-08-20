package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class TambahAlamatActivity extends BaseActivity {
    Button btn_submit;
    EditText txt_nama_alamat;
    EditText txt_alamat_lengkap;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_tambah_alamat);

        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TambahAlamatActivity.this, UbahAlamatActivity.class);
                startActivity(intent);
            }
        });

        txt_nama_alamat = findViewById(R.id.txt_nama_alamat);
        txt_alamat_lengkap = findViewById(R.id.txt_alamat_lengkap);
        btn_submit = findViewById(R.id.buttonselanjutnya);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_nama_alamat.getText().toString().equals(""))
                {
                    Toast.makeText(TambahAlamatActivity.this, "Masukkan nama alamat!", Toast.LENGTH_SHORT).show();
                } else if (txt_alamat_lengkap.getText().toString().equals("")) {
                    Toast.makeText(TambahAlamatActivity.this, "Masukkan alamat lengkap!", Toast.LENGTH_SHORT).show();
                } else {
                    new Alamat(txt_nama_alamat.getText().toString(), txt_alamat_lengkap.getText().toString());
                    Toast.makeText(TambahAlamatActivity.this, "Alamat berhasil ditambahkan!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(TambahAlamatActivity.this, UbahAlamatActivity.class);
                    intent.putExtra("nama_alamat", txt_nama_alamat.getText().toString());
                    intent.putExtra("alamat_lengkap", txt_alamat_lengkap.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}