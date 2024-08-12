package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.RecoverySystem;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
//    RecyclerView recyclerView;
//    LinearLayoutManager linearLayoutManager;
//    AdapterData adapterData;
//    List<String> listData;

    private RecyclerView rvNotification;
    private AdapterData adapterData;
    private ArrayList<Reminder> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        rvNotification = findViewById(R.id.notificationRv);

        rvNotification.setHasFixedSize(true);

        list.addAll(NotificationData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvNotification.setLayoutManager(new LinearLayoutManager(this));
        adapterData = new AdapterData(list);
        rvNotification.setAdapter(adapterData);
    }




}