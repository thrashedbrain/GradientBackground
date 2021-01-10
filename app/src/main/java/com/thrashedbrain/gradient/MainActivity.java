package com.thrashedbrain.gradient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

import com.thrashedbrain.gradientbackground.GradientBackground;


public class MainActivity extends AppCompatActivity {

    GradientBackground gradBg;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.container);

        gradBg = new GradientBackground.Builder()
                .addColor("#48cae4", "#023e8a")
                .addColor("#006400", "#38b000")
                .setDuration(10000)
                .build();
        gradBg.init();
        gradBg.start(constraintLayout);
    }

    @Override
    protected void onPause() {
        gradBg.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gradBg.onResume();
    }
}
