package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class UbahAlamatActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UbahAlamatAdapter ubahAlamatAdapter;
    private List<Alamat> alamatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_alamat);

        recyclerView = findViewById(R.id.list_alamat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        alamatList = new ArrayList<>();
        alamatList.add(new Alamat("Rumah", "Jl. Pakuan No. 5"));
        alamatList.add(new Alamat("Kantor", "Jl. Sei Kera No. 77"));
        alamatList.add(new Alamat("Rumah Lama", "Jl. Tikus No. 10"));

        ubahAlamatAdapter = new UbahAlamatAdapter(alamatList);
        recyclerView.setAdapter(ubahAlamatAdapter);
    }
}