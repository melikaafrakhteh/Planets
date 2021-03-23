package com.afrakhteh.planets.ui.home;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.afrakhteh.planets.R;
import com.afrakhteh.planets.data.adapter.PlanetAdapter;
import com.afrakhteh.planets.data.model.PlanetModel;
import com.afrakhteh.planets.data.saving.SharedPref;
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
        checkingFirstInstall();
    }

    private void checkingFirstInstall() {
        boolean isFirst = SharedPref.getInstance(HomeActivity.this).getFirstRun();
        if (isFirst) {
            SharedPref.getInstance(HomeActivity.this).setRunned();
            channel();
            recyclerViewSetUp();
        } else {
            recyclerViewSetUp();
        }

    }
    private void channel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(Constants.CHANNEL_ID,Constants.CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
            channel.setLightColor(Color.argb(0,0,1,0));
            channel.enableLights(true);
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
        }
        showNotification();
    }

    private void showNotification() {

        NotificationCompat.Builder notification = new NotificationCompat.Builder(HomeActivity.this,Constants.CHANNEL_ID)
                .setSmallIcon(R.drawable.welcome)
                .setContentTitle(getResources().getString(R.string.welcome))
                .setContentText(getResources().getString(R.string.notify_txt))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(Constants.NOTIFICATION_ID,notification.build());
    }

    private void recyclerViewSetUp() {
        planetModelList = new ArrayList<>();
        adapter = new PlanetAdapter(HomeActivity.this, planetModelList);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        setManualItems();
        adapter.notifyDataSetChanged();
    }

    private void setManualItems() {
        planetModelList.add(new PlanetModel(1, getResources().getString(R.string.text_mercury)
                , getResources().getString(R.string.desc_mercury), Constants.MERCURY));

        planetModelList.add(new PlanetModel(2, getResources().getString(R.string.text_venus)
                , getResources().getString(R.string.desc_venus), Constants.VENUS));

        planetModelList.add(new PlanetModel(3, getResources().getString(R.string.text_earth)
                , getResources().getString(R.string.desc_earth), Constants.EARTH));

        planetModelList.add(new PlanetModel(4, getResources().getString(R.string.text_mars)
                , getResources().getString(R.string.desc_mars), Constants.MARS));

        planetModelList.add(new PlanetModel(5, getResources().getString(R.string.text_jupiter)
                , getResources().getString(R.string.desc_jupiter), Constants.JUPITER));

        planetModelList.add(new PlanetModel(6, getResources().getString(R.string.text_saturn)
                , getResources().getString(R.string.desc_saturn), Constants.SATURN));

        planetModelList.add(new PlanetModel(7, getResources().getString(R.string.text_uranus)
                , getResources().getString(R.string.desc_uranus), Constants.URANUS));

        planetModelList.add(new PlanetModel(8, getResources().getString(R.string.text_neptune)
                , getResources().getString(R.string.desc_neptune), Constants.NEPTUNE));

        planetModelList.add(new PlanetModel(9, getResources().getString(R.string.text_pluto)
                , getResources().getString(R.string.desc_pluto), Constants.PLUTO));


    }
}
