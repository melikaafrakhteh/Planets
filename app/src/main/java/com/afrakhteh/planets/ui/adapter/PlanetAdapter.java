package com.afrakhteh.planets.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afrakhteh.planets.R;
import com.afrakhteh.planets.data.model.PlanetModel;
import com.afrakhteh.planets.ui.detail.DetailActivity;
import com.afrakhteh.planets.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder> {
    Context context;
    List<PlanetModel> planetModels;

    public PlanetAdapter(Context context, List<PlanetModel> planetModels) {
        this.context = context;
        this.planetModels = planetModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlanetModel model = planetModels.get(position);

        holder.text.setText(model.getName());
        Picasso.get().load(model.getImage()).into(holder.image);
        holder.image.setOnClickListener(v -> {
            Intent i = new Intent(PlanetAdapter.this.context, DetailActivity.class);
            i.putExtra(Constants.IMAGE, model.getImage());
            i.putExtra(Constants.NAME, model.getName());
            i.putExtra(Constants.DESCRIPTION, model.getDescription());
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        });

    }

    @Override
    public int getItemCount() {
        return planetModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.img_planet_image_item)
        ImageView image;

        @BindView(R.id.txt_planet_name_item)
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
