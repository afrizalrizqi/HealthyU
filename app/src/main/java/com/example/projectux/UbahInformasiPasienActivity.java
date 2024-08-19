package com.example.projectux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UbahInformasiPasienActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private UbahInformasiPasienAdapter ubahInformasiPasienAdapter;
//    private static List<Pasien> pasienList = new ArrayList<>();
    private Pasien selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_ubah_informasi_pasien);
        top_navbar();
        bottom_navbar();

        LinearLayout tambahPasien = findViewById(R.id.tambahPasien);

        String returnTo = getIntent().getStringExtra("returnTo");

        tambahPasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UbahInformasiPasienActivity.this, TambahPasienActivity.class);
                intent.putExtra("returnTo", returnTo);

                startActivity(intent);
            }
        });

        Button btn_pilih = findViewById(R.id.btn_pilih);
        btn_pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ubahInformasiPasienAdapter.getLastSelectedPosition() != -1) {
                    // display position of selected item
//                    Toast.makeText(UbahInformasiPasienActivity.this, "Selected Pasien: " + ubahInformasiPasienAdapter.getLastSelectedPosition(), Toast.LENGTH_SHORT).show();
                    int position = ubahInformasiPasienAdapter.getLastSelectedPosition();
                    Pasien selectedPasien = pasienList.get(position);
                    Intent intent = new Intent();

                    if ("konfirmasi_jadwal_home_service".equals(returnTo)) {
                        intent = new Intent(UbahInformasiPasienActivity.this, konfirmasi_jadwal_home_service.class);
                    } else if ("konfirmasi_jadwal_tes_langsung".equals(returnTo)) {
                        intent = new Intent(UbahInformasiPasienActivity.this, konfirmasi_jadwal_tes_langsung.class);
                    }
                    intent.putExtra("selectedPasien", selectedPasien);
                    startActivity(intent);
                }else {
                    Toast.makeText(UbahInformasiPasienActivity.this, "Pilih pasien terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });






        Pasien newPasien = (Pasien) getIntent().getSerializableExtra("newPasien");
        if (newPasien != null) {
            pasienList.add(newPasien);
        }

        recyclerView = findViewById(R.id.list_pasien);
        ubahInformasiPasienAdapter = new UbahInformasiPasienAdapter(pasienList);
        recyclerView.setAdapter(ubahInformasiPasienAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (newPasien != null) {
            ubahInformasiPasienAdapter.notifyDataSetChanged();
        }


    }


}