package com.afrakhteh.planets.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.afrakhteh.planets.R;
import com.afrakhteh.planets.data.adapter.PlanetAdapter;
import com.afrakhteh.planets.data.model.PlanetModel;
import com.afrakhteh.planets.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

   @BindView(R.id.recycler_show_planets_home)
     RecyclerView recyclerView;

    private PlanetAdapter adapter;
    private List<PlanetModel> planetModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        initMethods();
    }

    private void initMethods() {
        recyclerViewSetUp();
    }

    private void recyclerViewSetUp() {
        planetModelList = new ArrayList<>();
        adapter = new PlanetAdapter(HomeActivity.this,planetModelList);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        setManualItems();
        adapter.notifyDataSetChanged();
    }

    private void setManualItems() {
        planetModelList.add(new PlanetModel(1,getResources().getString(R.string.text_mercury)
                ,getResources().getString(R.string.desc_mercury), Constants.MERCURY));

        planetModelList.add(new PlanetModel(2,getResources().getString(R.string.text_venus)
                ,getResources().getString(R.string.desc_venus), Constants.VENUS));

        planetModelList.add(new PlanetModel(3,getResources().getString(R.string.text_earth)
                ,getResources().getString(R.string.desc_earth), Constants.EARTH));

        planetModelList.add(new PlanetModel(4,getResources().getString(R.string.text_mars)
                ,getResources().getString(R.string.desc_mars), Constants.MARS));

        planetModelList.add(new PlanetModel(5,getResources().getString(R.string.text_jupiter)
                ,getResources().getString(R.string.desc_jupiter), Constants.JUPITER));

        planetModelList.add(new PlanetModel(6,getResources().getString(R.string.text_saturn)
                ,getResources().getString(R.string.desc_saturn), Constants.SATURN));

        planetModelList.add(new PlanetModel(7,getResources().getString(R.string.text_uranus)
                ,getResources().getString(R.string.desc_uranus), Constants.URANUS));

        planetModelList.add(new PlanetModel(8,getResources().getString(R.string.text_neptune)
                ,getResources().getString(R.string.desc_neptune), Constants.NEPTUNE));

        planetModelList.add(new PlanetModel(9,getResources().getString(R.string.text_pluto)
                ,getResources().getString(R.string.desc_pluto), Constants.PLUTO));


    }
}
