package com.zoothii.yakalamaca;

import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Ahmet Yıldırım
    TextView countDown;
    TextView points;
    ImageView madamOcta;
    Runnable runnable;
    Handler handler;
    Random random;
    int height;
    int width;
    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countDown = findViewById(R.id.countDown);
        points = findViewById(R.id.points);
        madamOcta = findViewById(R.id.madamocta);
        point = 0;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        random =  new Random();

        new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDown.setText("Time: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                countDown.setText("Time Off!");
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("scoreData",point);
                finish();
                startActivity(intent);
            }
        }.start();
        rotateImage();
    }

    public void risePoints(View view){
        point++;
        points.setText("Points: "+point);
    }

    public void rotateImage(){
        handler = new Handler();
        runnable = new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void run() {
                int rand_R = random.nextInt(180);
                int rand_X = random.nextInt((width-330) - (50) + 70) +50;
                int rand_Y = random.nextInt((height-644) - (200) + 70) +200;
                madamOcta.setX(rand_X);
                madamOcta.setY(rand_Y);
                madamOcta.setRotation(rand_R);
                handler.postDelayed(runnable,350);
            }
        };
        handler.post(runnable);
    }
}
