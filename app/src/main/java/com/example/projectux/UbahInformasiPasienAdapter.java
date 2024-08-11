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

public class UbahInformasiPasienAdapter extends RecyclerView.Adapter<UbahInformasiPasienAdapter.PasienViewHolder>
{
    private List<Pasien> pasienList;
    private int lastSelectedPosition = -1;

    public UbahInformasiPasienAdapter(List<Pasien> pasienList) {
        this.pasienList = pasienList;
    }

    @NonNull
    @Override
    public PasienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ubah_pasien_list_view, parent, false);
        return new PasienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PasienViewHolder holder, int position) {
        Pasien pasien = pasienList.get(position);

        holder.radioButton.setChecked(pasien.isSelected());
        holder.nama_pasien.setText(pasien.getNama());
        holder.nik.setText(pasien.getNIK());
        holder.nomor_telepon.setText(pasien.getNo_telp());
        holder.gender.setText(pasien.getGender());

        holder.radioButton.setOnClickListener(v -> {
            lastSelectedPosition = holder.getAdapterPosition();
            notifyDataSetChanged();
        });

        holder.itemView.setOnClickListener(v -> {
            lastSelectedPosition = holder.getAdapterPosition();
            notifyDataSetChanged();
        });

        holder.radioButton.setChecked(lastSelectedPosition == position);
    }

    @Override
    public int getItemCount() {
        return pasienList.size();
    }

    public class PasienViewHolder extends RecyclerView.ViewHolder
    {
        private RadioButton radioButton;
        private TextView nama_pasien;
        private TextView nik;
        private TextView nomor_telepon;
        private TextView gender;

        public PasienViewHolder(@NonNull View itemView) {
            super(itemView);

            nama_pasien = itemView.findViewById(R.id.txt_nama_pasien);
            nik = itemView.findViewById(R.id.txt_nik);
            nomor_telepon = itemView.findViewById(R.id.txt_nomor_telepon);
            gender = itemView.findViewById(R.id.txt_gender);
            radioButton = itemView.findViewById(R.id.radio_button);
        }
    }
}
