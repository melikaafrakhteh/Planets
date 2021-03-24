package com.afrakhteh.planets.ui.intro;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.afrakhteh.planets.R;
import com.afrakhteh.planets.ui.adapter.SliderAdapter;
import com.afrakhteh.planets.ui.home.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntroActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.dots)
    LinearLayout linearLayout;

    private SliderAdapter sliderAdapter;
    private TextView[] dots;

    @BindView(R.id.nextbtn)
    Button next;
    @BindView(R.id.backbtn)
    Button back;

    @OnClick(R.id.backbtn)
    void backButton() {
        if (current >= 0) {
            viewPager.setCurrentItem(current - 1);
        }

    }

    @OnClick(R.id.nextbtn)
    void nextButton() {
        if (current + 1 < dots.length) {
            viewPager.setCurrentItem(current + 1);
        } else {
            lunchHomeActivity();
        }

    }

    private void lunchHomeActivity() {
        Intent i = new Intent(IntroActivity.this, HomeActivity.class);
        startActivity(i);
        finish();
    }

    private int current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);
        setUpSlider();
    }

    private void setUpSlider() {
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(listener);
    }

    public void addDotsIndicator(int position) {
        dots = new TextView[4];
        linearLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextColor(getResources().getColor(R.color.mainTexttransparent));
            dots[i].setTextSize(36);
            linearLayout.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.mainText));
        }
    }

    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            current = position;
            if (position == 0) {
                next.setEnabled(true);
                back.setEnabled(false);
                back.setVisibility(View.INVISIBLE);
                next.setText(getResources().getString(R.string.next_btn_txt));
                back.setText("");
            } else if (position == dots.length - 1) {
                next.setEnabled(true);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);
                next.setText(getResources().getString(R.string.next_btn_txt_finish));
                back.setText(getResources().getString(R.string.back_btn_txt));
            } else {
                next.setEnabled(true);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);
                next.setText(getResources().getString(R.string.next_btn_txt));
                back.setText(getResources().getString(R.string.back_btn_txt));
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
