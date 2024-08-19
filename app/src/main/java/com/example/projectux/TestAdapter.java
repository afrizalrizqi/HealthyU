package com.example.projectux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.content.Context;
import android.content.Intent;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private Context context;
    private List<TestItem> testItemList;

    public TestAdapter(Context context, List<TestItem> testItemList) {
        this.context = context;
        this.testItemList = testItemList;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new TestViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return testItemList.size();
    }

    public static class TestViewHolder extends RecyclerView.ViewHolder {
        public View cardView;
        ImageView iconImageView;
        TextView titleTextView;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImageView = itemView.findViewById(R.id.iconImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            cardView = (CardView) itemView;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        TestItem item = testItemList.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.iconImageView.setImageResource(item.getIconResId());

        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) holder.cardView.getLayoutParams();
        layoutParams.width = GridLayoutManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = GridLayoutManager.LayoutParams.WRAP_CONTENT;
        layoutParams.setMargins(16, 16, 16, 16); // Set margin around each item
        holder.cardView.setLayoutParams(layoutParams);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestItem clickedTestItem = testItemList.get(position);
                Intent intent = new Intent(v.getContext(), CariLabActivity.class);
                TesPasienHolder.getInstance().getTesPasien().setNamaTes(clickedTestItem.getTitle());
                v.getContext().startActivity(intent);
            }
        });

    }
}
