package com.example.projectux;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView namaView, jenisKelaminView;
    Button lihatTesBtn;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        namaView = itemView.findViewById(R.id.nama_pasien);
        jenisKelaminView = itemView.findViewById(R.id.jenisKelamin_pasien);
        lihatTesBtn = itemView.findViewById(R.id.btn_lihatTes);
    }
}
