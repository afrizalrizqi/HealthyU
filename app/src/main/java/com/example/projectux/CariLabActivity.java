package com.example.projectux;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CariLabActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LabCardAdapter adapter;
    private List<LabCard> labCardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cari_lab);

        // Step 1: Create a list of LabCard objects
        labCardList = new ArrayList<>();
        labCardList.add(new LabCard("PT. Syslab", "Sentul City Plaza Amsterdam, Bogor Utara, Indonesia, Konoha",
                "08:00 - 17:00", "(021) 87962155", R.drawable.imagelab));
        labCardList.add(new LabCard("Lab CITO Bogor", "Jl. Raya Pajajaran No.145, Bogor Utara, Indonesia, Konoha",
                "06:00 - 21:00", "081363471847", R.drawable.imagelab));

        // Step 2: Find the RecyclerView in your layout
        recyclerView = findViewById(R.id.recyclerViewLab);

        // Step 3: Create an instance of LabCardAdapter
        adapter = new LabCardAdapter(labCardList);

        // Step 4: Set the adapter for the RecyclerView
        recyclerView.setAdapter(adapter);
    }
}