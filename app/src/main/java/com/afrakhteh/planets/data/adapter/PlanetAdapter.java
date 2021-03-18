package com.afrakhteh.planets.data.adapter;

import android.app.Activity;
import android.content.Context;
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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder>{
    Context context;
    List<PlanetModel> planetModels;

    public PlanetAdapter(Context context, List<PlanetModel> planetModels) {
        this.context = context;
        this.planetModels = planetModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlanetModel model = planetModels.get(position);

        holder.text.setText(model.getName());
        Picasso.get().load(model.getImage()).into(holder.image);
        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return planetModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.rlay_planet_click_item)
         RelativeLayout click;

        @BindView(R.id.img_planet_image_item)
         ImageView image;

        @BindView(R.id.txt_planet_name_item)
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
