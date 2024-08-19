package com.example.projectux;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LabCardAdapter extends RecyclerView.Adapter<LabCardAdapter.LabCardViewHolder> {
    private List<LabCard> labCardList;
    private String testName;

    public LabCardAdapter(List<LabCard> labCardList) {
        this.labCardList = labCardList;
        this.testName = testName;
    }

    @NonNull
    @Override
    public LabCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lab_card, parent, false);
        return new LabCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LabCardViewHolder holder, @SuppressLint("RecyclerView") int position) {
        LabCard labCard = labCardList.get(position);
        holder.labName.setText(labCard.getName());
        holder.labAddress.setText(labCard.getAddress());
        holder.labHours.setText(labCard.getHours());
        holder.labPhone.setText(labCard.getPhone());
        holder.labImage.setImageResource(labCard.getImageResId());

        holder.selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LabCard clickedLabCard = labCardList.get(position);
                Intent intent = new Intent(v.getContext(), BookingTesActivity.class);
                TesPasienHolder.getInstance().getTesPasien().setLokasi(clickedLabCard.getAddress());
                TesPasienHolder.getInstance().setLabName(clickedLabCard.getName());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return labCardList.size();
    }

    static class LabCardViewHolder extends RecyclerView.ViewHolder {
        ImageView labImage;
        TextView labName, labAddress, labHours, labPhone;
        Button selectButton;

        LabCardViewHolder(View itemView) {
            super(itemView);
            labImage = itemView.findViewById(R.id.labImage);
            labName = itemView.findViewById(R.id.labName);
            labAddress = itemView.findViewById(R.id.labAddress);
            labHours = itemView.findViewById(R.id.labHours);
            labPhone = itemView.findViewById(R.id.labPhone);
            selectButton = itemView.findViewById(R.id.selectButton);
        }
    }
}