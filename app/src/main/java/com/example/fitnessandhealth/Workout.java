package com.example.fitnessandhealth;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

public class Workout extends Fragment {
    public static final Random RANDOM = new Random();
    private Button btn_6;
    private ImageView body;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.workouts,container,false);
        body = (ImageView) v.findViewById(R.id.frontView);
        btn_6 = v.findViewById(R.id.btn_6);
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flipCoin();
            }
        });
        return v;

    }
    private void flipCoin(){
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000);
        fadeOut.setFillAfter(true);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                  body.setImageResource(RANDOM.nextFloat() > 0.5f ? R.drawable.back1 : R.drawable.front1);
                  Animation fadeIn = new AlphaAnimation(0, 1);
                  fadeIn.setInterpolator(new DecelerateInterpolator());
                  fadeIn.setDuration(1000);
                  fadeIn.setFillAfter(true);
                  body.startAnimation(fadeIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        body.startAnimation(fadeOut);
    }


    }

