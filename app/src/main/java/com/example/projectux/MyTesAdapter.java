package com.example.projectux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyTesAdapter extends RecyclerView.Adapter<MyTesViewHolder> {

    Context context;
    List<TesPasien> tesList;

    public void setSearchTesList(List<TesPasien> tesSearchList){
        this.tesList = tesSearchList;
        notifyDataSetChanged();
    }
    public MyTesAdapter(Context context, List<TesPasien> tesList) {
        this.context = context;
        this.tesList = tesList;
    }

    @NonNull
    @Override
    public MyTesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyTesViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_riwayat_tes, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyTesViewHolder holder, int position) {
        holder.namaTesView.setText(tesList.get(position).getNamaTes());
        holder.lokasiTesView.setText(tesList.get(position).getLokasi());
        holder.tanggalTesView.setText(tesList.get(position).getTanggal());
        holder.waktuTesView.setText(tesList.get(position).getWaktu());
        holder.statusTesView.setText(tesList.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return tesList.size();
    }
}
