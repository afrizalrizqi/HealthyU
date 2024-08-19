package com.example.projectux;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RiwayatPasienActivity extends AppCompatActivity {
    MyAdapter myAdapter;

    List<Pasien> pasiens = new ArrayList<Pasien>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_pasien_layout);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        SearchView searchView = findViewById(R.id.search_pasien);

        pasiens = new ArrayList<>();
        pasiens.add(new Pasien("Advenia", "Perempuan", "2040-2444-1859" , "081231231331" , false));
        pasiens.add(new Pasien("Adriana Damayanti", "Perempuan", "2060-1234-5678", "081231231331" , false));
        pasiens.add(new Pasien("Eko Suryanto", "Laki-laki", "2055-9876-5432", "081231231331" , false));
        pasiens.add(new Pasien("Nadia Pratiwi", "Perempuan", "2050-2468-1357", "081231231331" , false));
        pasiens.add(new Pasien("Muhammad Amin", "Laki-laki", "2045-7890-1234", "081231231331" , false));
        pasiens.add(new Pasien("Siti Rahmawati", "Perempuan", "2040-3698-2587", "081231231331" , false));
        pasiens.add(new Pasien("Indra Gunawan", "Laki-laki", "2035-1357-9086", "081231231331" , false));
        pasiens.add(new Pasien("Aisha Putri", "Perempuan", "2030-2468-1234", "081231231331" , false));
        pasiens.add(new Pasien("Budi Santoso", "Laki-laki", "2025-6789-0123", "081231231331" , false));
        pasiens.add(new Pasien("Jennie Kim", "Perempuan", "2020-1234-5678", "081231231331" , false));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(getApplicationContext(), pasiens);
        recyclerView.setAdapter(myAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchPasien(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchPasien(newText);
                return false;
            }
        });


    }

    private void searchPasien(String text){
        List<Pasien> pasienSearchList = new ArrayList<>();
        for (Pasien pasien : pasiens){
            if (pasien.getNama().toLowerCase().contains(text.toLowerCase())){
                pasienSearchList.add(pasien);
            }
        }
        if (pasienSearchList.isEmpty()){
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        }else {
            myAdapter.setSearchList(pasienSearchList);
        }
    }
}
