package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class UbahInformasiPasienActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UbahInformasiPasienAdapter ubahInformasiPasienAdapter;
    private List<Pasien> pasienList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_informasi_pasien);

        recyclerView = findViewById(R.id.list_pasien);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pasienList = new ArrayList<>();
        pasienList.add(new Pasien("Jeremy", "12312313131", "081231231331", "Laki-Laki", false));
        pasienList.add(new Pasien("Advenia", "12312313131", "081231231331", "Laki-Laki", false));
        pasienList.add(new Pasien("Louwis", "12312313131", "081231231331", "Laki-Laki", false));

        ubahInformasiPasienAdapter = new UbahInformasiPasienAdapter(pasienList);
        recyclerView.setAdapter(ubahInformasiPasienAdapter);
    }
}