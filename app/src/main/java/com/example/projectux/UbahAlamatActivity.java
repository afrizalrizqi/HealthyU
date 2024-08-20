package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UbahAlamatActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private UbahAlamatAdapter ubahAlamatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_ubah_alamat);

        top_navbar();
        bottom_navbar();

        recyclerView = findViewById(R.id.list_alamat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Initialize the ArrayList


        String nama_alamat = getIntent().getStringExtra("nama_alamat");
        String alamat_lengkap = getIntent().getStringExtra("alamat_lengkap");

        if (nama_alamat != null && alamat_lengkap != null) {
            alamatList.add(new Alamat(nama_alamat, alamat_lengkap));
        }

        findViewById(R.id.tambah_alamat).setOnClickListener(v -> {
            Intent intent = new Intent(UbahAlamatActivity.this, TambahAlamatActivity.class);
            startActivity(intent);
        });

        Button btn_pilih = findViewById(R.id.btn_pilih);

        btn_pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ubahAlamatAdapter.getLastSelectedPosition() != -1) {
                    Intent intent = new Intent(UbahAlamatActivity.this, konfirmasi_jadwal_home_service.class);
                    SelectedAlamat = alamatList.get(ubahAlamatAdapter.getLastSelectedPosition());
//                    intent.putExtra("selectedAlamat", (Serializable) alamatList.get(ubahAlamatAdapter.getLastSelectedPosition()));
                    startActivity(intent);
                } else {
                    Toast.makeText(UbahAlamatActivity.this, "Pilih alamat terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ubahAlamatAdapter = new UbahAlamatAdapter(alamatList);
        recyclerView.setAdapter(ubahAlamatAdapter);




    }
}