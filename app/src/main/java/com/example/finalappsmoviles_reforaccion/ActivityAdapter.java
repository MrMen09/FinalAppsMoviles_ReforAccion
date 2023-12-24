package com.example.finalappsmoviles_reforaccion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {

    private List<Activity> activityList;

    public ActivityAdapter(List<Activity> activityList) {
        this.activityList = activityList;
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_activity, parent, false);
        return new ActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        Activity activity = activityList.get(position);

        holder.textTitle.setText(activity.getTitle());
        holder.textDescription.setText(activity.getDescription());
        holder.textDate.setText(activity.getDate());
        holder.textUbication.setText(activity.getUbication());
        holder.imageView.setImageResource(activity.getImagePostId());
    }

    @Override
    public int getItemCount() {
        return activityList.size();
    }

    public static class ActivityViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textDescription;
        TextView textDate;
        TextView textUbication;
        ImageView imageView;

        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.titleTV_CVTip);
            textDescription = itemView.findViewById(R.id.descriptionTV_CVTip);
            textDate = itemView.findViewById(R.id.dateTV_CVTip);
            textUbication = itemView.findViewById(R.id.ubicationTV_CV);
            imageView = itemView.findViewById(R.id.postImageIV_CVTip);
        }
    }
}

