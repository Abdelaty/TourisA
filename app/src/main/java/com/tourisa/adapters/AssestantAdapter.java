package com.tourisa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tourisa.R;
import com.tourisa.models.Assesstant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssestantAdapter extends RecyclerView.Adapter<AssestantAdapter.Holder> {
    private Context context;
    private List<Assesstant> list;

    public AssestantAdapter(Context context, List<Assesstant> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.item_assesstant, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Assesstant assesstant = list.get(position);
        holder.name.setText(assesstant.getName());
        holder.rating.setRating(assesstant.getRate());
        Picasso.get().load(assesstant.getImage()).fit().centerCrop().into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.rating)
        AppCompatRatingBar rating;
        @BindView(R.id.image)
        ImageView image;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
