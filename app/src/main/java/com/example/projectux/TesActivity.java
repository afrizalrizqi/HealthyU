package com.example.projectux;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectux.R;
import com.example.projectux.TestAdapter;
import com.example.projectux.TestItem;

import java.util.ArrayList;
import java.util.List;

public class TesActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private TestAdapter adapter;
    private List<TestItem> testItemList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.cari_tes);

        top_navbar();
        bottom_navbar();

        recyclerView = findViewById(R.id.recyclerViewCariTes);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        testItemList = new ArrayList<>();
        testItemList.add(new TestItem("Tes Urine", R.drawable.ic_urine));
        testItemList.add(new TestItem("Tes Darah", R.drawable.ic_darah));
        testItemList.add(new TestItem("Tes Alergi", R.drawable.ic_alergi));
        testItemList.add(new TestItem("Tes Feses", R.drawable.ic_feses));
        testItemList.add(new TestItem("Tes Tulang", R.drawable.ic_tulang));
        testItemList.add(new TestItem("Tes Tumor", R.drawable.ic_tumor));
        testItemList.add(new TestItem("Tes Paru", R.drawable.ic_paru));

        adapter = new TestAdapter(this, testItemList);
        recyclerView.setAdapter(adapter);

    }

}
