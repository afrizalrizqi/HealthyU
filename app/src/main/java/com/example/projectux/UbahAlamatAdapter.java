package com.example.projectux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class UbahAlamatAdapter extends RecyclerView.Adapter<UbahAlamatAdapter.AlamatViewHolder>
{
    private List<Alamat> alamatList;
    private int lastSelectedPosition = -1;

    public UbahAlamatAdapter(List<Alamat> alamatList) {
        this.alamatList = alamatList;
    }

    @NonNull
    @Override
    public AlamatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ubah_alamat_list_view, parent, false);
        return new AlamatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlamatViewHolder holder, int position) {
        Alamat alamat = alamatList.get(position);

        holder.txt_nama_alamat.setText(alamat.getNama_alamat());
        holder.txt_alamat_lengkap.setText(alamat.getAlamat_lengkap());

        holder.itemView.setOnClickListener(v -> {
            lastSelectedPosition = holder.getAdapterPosition();
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return alamatList.size();
    }

    public class AlamatViewHolder extends RecyclerView.ViewHolder
    {
        private TextView txt_nama_alamat;
        private TextView txt_alamat_lengkap;

        public AlamatViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_nama_alamat = itemView.findViewById(R.id.txt_nama_alamat);
            txt_alamat_lengkap = itemView.findViewById(R.id.txt_alamat_lengkap);
        }
    }
}
