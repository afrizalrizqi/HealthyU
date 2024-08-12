package com.example.projectux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Pasien> pasiens;

    public void setSearchList (List<Pasien> pasienSearchList){
        this.pasiens = pasienSearchList;
        notifyDataSetChanged();
    }

    public MyAdapter(Context context, List<Pasien> pasiens) {
        this.context = context;
        this.pasiens = pasiens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_riwayat_pasien, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.namaView.setText(pasiens.get(position).getNama());
        holder.jenisKelaminView.setText(pasiens.get(position).getJenisKelamin());
        holder.lihatTesBtn.setText("Lihat Tes");




    }

    @Override
    public int getItemCount() {
        return pasiens.size();
    }


}
