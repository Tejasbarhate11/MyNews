package com.barhatetejas.mynews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 4000;

    //Animations
    Animation top,bottom;

    //Views
    private ImageView logo;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        top = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        logo = findViewById(R.id.logo);
        name = findViewById(R.id.name);

        logo.setAnimation(top);
        name.setAnimation(bottom);


        final boolean b = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}
