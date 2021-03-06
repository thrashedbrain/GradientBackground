package com.thrashedbrain.gradientbackground;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GradientBackground {
    private static GradientBackground INSTANCE;


    private List<int[]> colors;
    private List<android.graphics.drawable.GradientDrawable> drawables;
    private int duration;

    private AnimationDrawable animationDrawable;

    private static GradientBackground getInstance(List<int[]> list, int duration){
        if (INSTANCE == null){
            INSTANCE = new GradientBackground(list, duration);
        }
        return INSTANCE;
    }

    private GradientBackground(List<int[]> list, int duration){
        this.colors = list;
        this.duration = duration;
    }

    public static class Builder{
        private List<int[]> colors = new ArrayList<>();
        private int duration;

        public Builder addColor(String startColor, String endColor){
            colors.add(new int[]{Color.parseColor(startColor), Color.parseColor(endColor)});
            return this;
        }

        public Builder setDuration(int duration){
            this.duration = duration;
            return this;
        }

        public GradientBackground build(){
            return GradientBackground.getInstance(colors, duration);
        }
    }

    public void init(){
        animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        drawables = new ArrayList<>();
        for (int[] color : colors){
            drawables.add(new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP, color));
        }
        for (android.graphics.drawable.GradientDrawable drawable : drawables){
            animationDrawable.addFrame(drawable, duration);
        }
    }

    public void init(int radius){
        animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        drawables = new ArrayList<>();
        for (int[] color : colors){
            drawables.add(new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP, color));
        }
        for (android.graphics.drawable.GradientDrawable drawable : drawables){
            drawable.setCornerRadius((float) radius);
            animationDrawable.addFrame(drawable, duration);
        }

    }

    public void start(View view){
        animationDrawable.setExitFadeDuration(duration);
        view.setBackground(animationDrawable);
    }

    public void onResume(){
        if (animationDrawable != null){
            animationDrawable.start();
        }
    }

    public void onPause(){
        if (animationDrawable != null){
            animationDrawable.stop();
        }
    }
}
