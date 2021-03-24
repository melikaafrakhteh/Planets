package com.afrakhteh.planets.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.afrakhteh.planets.R;
import com.afrakhteh.planets.utils.Constants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.textView_name)
    TextView nameTV;
    @BindView(R.id.imageView_detail)
    ImageView imageIMG;
    @BindView(R.id.textView_description)
    TextView descTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        getData();
    }

    public void getData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = getIntent().getStringExtra(Constants.NAME);
            String desc = getIntent().getStringExtra(Constants.DESCRIPTION);
            nameTV.setText(name);
            descTV.setText(desc);
            Picasso.get().load(getIntent().getStringExtra(Constants.IMAGE)).into(imageIMG);
        }

    }
}
