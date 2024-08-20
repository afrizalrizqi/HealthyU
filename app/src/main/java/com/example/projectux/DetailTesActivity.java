package com.example.projectux;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DetailTesActivity extends BaseActivity {

    TextView namaTextView, nikTextView;
    RecyclerView recyclerViewTes;
    MyTesAdapter tesAdapter;
    List<TesPasien> tesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        Remove Action Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_riwayat_tes_layout);

//        Navbar Functionalities
//        simplified_top_navbar();
        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailTesActivity.this, RiwayatPasienActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navbar);
        bottomNavigationView.setSelectedItemId(R.id.menu_riwayat);
        bottom_navbar();

        SearchView searchViewTes = findViewById(R.id.search_tes);

        namaTextView = findViewById(R.id.nama_pasien);
        nikTextView = findViewById(R.id.nik_pasien);
        recyclerViewTes = findViewById(R.id.recycler_view_tes);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            namaTextView.setText(bundle.getString("nama_pasien"));
            nikTextView.setText(bundle.getString("nik_pasien"));
        }

        // Daftar tes pasien
        tesList = new ArrayList<>();
        tesList.add(new TesPasien("Tes Urine", "Surabaya", "20th December 2050", "10.00 - 20.00 WIB", "Dibatalkan"));
        tesList.add(new TesPasien("Tes Darah", "Jakarta", "15th January 2051", "08.00 - 12.00 WIB", "Selesai"));
        tesList.add(new TesPasien("Tes Mata", "Bandung", "5th February 2051", "09.00 - 11.00 WIB", "Dalam Proses"));
        tesList.add(new TesPasien("Tes Pendengaran", "Yogyakarta", "12th March 2051", "13.00 - 15.00 WIB", "Dibatalkan"));
        tesList.add(new TesPasien("Tes Paru-paru", "Malang", "22nd April 2051", "14.00 - 16.00 WIB", "Selesai"));

        recyclerViewTes.setLayoutManager(new LinearLayoutManager(this));
        tesAdapter = new MyTesAdapter(getApplicationContext(), tesList);
        recyclerViewTes.setAdapter(tesAdapter);

        searchViewTes.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchTes(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void searchTes(String text){
        List<TesPasien> tesSearchList = new ArrayList<>();
        for (TesPasien tes : tesList){
            if (tes.getNamaTes().toLowerCase().contains(text.toLowerCase())){
                tesSearchList.add(tes);
            }
        }
        if (tesSearchList.isEmpty()){
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        }else{
            tesAdapter.setSearchTesList(tesSearchList);
        }
    }
}
