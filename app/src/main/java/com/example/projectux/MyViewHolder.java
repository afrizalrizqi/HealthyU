package com.example.projectux;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView namaView, jenisKelaminView;
    ImageView icon_gender;
    Button lihatTesBtn;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        namaView = itemView.findViewById(R.id.nama_pasien);
        jenisKelaminView = itemView.findViewById(R.id.jenisKelamin_pasien);
        icon_gender = itemView.findViewById(R.id.icon_gender);
        lihatTesBtn = itemView.findViewById(R.id.btn_lihatTes);
    }
}
