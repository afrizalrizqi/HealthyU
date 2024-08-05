package com.example.projectux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LabCardAdapter extends RecyclerView.Adapter<LabCardAdapter.LabCardViewHolder> {
    private List<LabCard> labCardList;

    public LabCardAdapter(List<LabCard> labCardList) {
        this.labCardList = labCardList;
    }

    @NonNull
    @Override
    public LabCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lab_card, parent, false);
        return new LabCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LabCardViewHolder holder, int position) {
        LabCard labCard = labCardList.get(position);
        holder.labName.setText(labCard.getName());
        holder.labAddress.setText(labCard.getAddress());
        holder.labHours.setText(labCard.getHours());
        holder.labPhone.setText(labCard.getPhone());
        holder.labImage.setImageResource(labCard.getImageResId());
    }

    @Override
    public int getItemCount() {
        return labCardList.size();
    }

    static class LabCardViewHolder extends RecyclerView.ViewHolder {
        ImageView labImage;
        TextView labName, labAddress, labHours, labPhone;

        LabCardViewHolder(View itemView) {
            super(itemView);
            labImage = itemView.findViewById(R.id.labImage);
            labName = itemView.findViewById(R.id.labName);
            labAddress = itemView.findViewById(R.id.labAddress);
            labHours = itemView.findViewById(R.id.labHours);
            labPhone = itemView.findViewById(R.id.labPhone);
        }
    }
}