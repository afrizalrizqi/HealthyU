package com.example.projectux;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
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

        if(tesList.get(position).getStatus().equals("Dibatalkan"))
        {
            holder.statusTesView.setTextColor(Color.parseColor("#E60000"));
        } else if (tesList.get(position).getStatus().equals("Selesai")) {
            holder.statusTesView.setTextColor(Color.parseColor("#08A045"));
        } else if (tesList.get(position).getStatus().equals("Dalam Proses")) {
            holder.statusTesView.setTextColor(Color.parseColor("#FCA510"));
        }

//        if(tesList.get(position).getStatus().equals("Dibatalkan"))
//        {
//            holder.icon_status.setImageResource(R.drawable.status_cancel);
//        } else if (tesList.get(position).getStatus().equals("Selesai")) {
//            holder.icon_status.setImageResource(R.drawable.status_success);
//        } else if (tesList.get(position).getStatus().equals("Dalam Proses")) {
//            holder.icon_status.setImageResource(R.drawable.baseline_note_alt_24);
//        }
    }

    @Override
    public int getItemCount() {
        return tesList.size();
    }
}
