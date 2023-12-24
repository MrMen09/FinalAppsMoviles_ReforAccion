package com.example.finalappsmoviles_reforaccion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TipAdapter extends RecyclerView.Adapter<TipAdapter.TipViewHolder> {

    private List<Tip> tipList;

    public TipAdapter(List<Tip> tipList) {
        this.tipList = tipList;
    }

    @NonNull
    @Override
    public TipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tip, parent, false);
        return new TipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TipViewHolder holder, int position) {
        Tip tip = tipList.get(position);

        holder.textTitle.setText(tip.getTitle());
        holder.textDescription.setText(tip.getDescription());
        holder.textCategory.setText(tip.getCategory());
        holder.imageViewTip.setImageResource(tip.getImagePostId());
    }

    @Override
    public int getItemCount() {
        return tipList.size();
    }

    public static class TipViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textDescription;
        TextView textCategory;

        ImageView imageViewTip;

        public TipViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.titleTV_CVTip);
            textDescription = itemView.findViewById(R.id.descriptionTV_CVTip);
            textCategory = itemView.findViewById(R.id.categoryTV_CVTip);
            imageViewTip = itemView.findViewById(R.id.postImageIV_CVTip);
        }
    }
}

