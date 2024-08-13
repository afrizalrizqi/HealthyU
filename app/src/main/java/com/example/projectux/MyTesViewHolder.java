package com.example.projectux;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyTesViewHolder extends RecyclerView.ViewHolder {

    TextView namaTesView, lokasiTesView, tanggalTesView, waktuTesView, statusTesView;

    public MyTesViewHolder(@NonNull View itemView) {
        super(itemView);
        namaTesView = itemView.findViewById(R.id.nama_tes);
        lokasiTesView = itemView.findViewById(R.id.lokasi_tes);
        tanggalTesView = itemView.findViewById(R.id.tanggal_tes);
        waktuTesView = itemView.findViewById(R.id.waktu_tes);
        statusTesView = itemView.findViewById(R.id.status_tes);
    }
}
