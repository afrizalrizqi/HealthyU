package com.example.projectux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.ListViewHolder> {

    private ArrayList<Reminder> listReminder;
    public AdapterData(ArrayList<Reminder> list){
        this.listReminder = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_notification, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Reminder reminder = listReminder.get(position);

        // Load image using Glide
        Glide.with(holder.itemView.getContext())
                .load(reminder.getLogo())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        // Set text for TextViews
        holder.tvName.setText(reminder.getReminder());
        holder.tvDetail.setText(reminder.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return listReminder.size();
    }


    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        TextView tvDetail;

        public ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.logoHealthyU);
            tvName = itemView.findViewById(R.id.headerContentNotification);
            tvDetail = itemView.findViewById(R.id.descContentNotification);
        }
    }
}
