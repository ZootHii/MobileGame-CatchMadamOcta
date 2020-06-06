package com.zoothii.yakalamaca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        totalScore = findViewById(R.id.totalScore);
        Intent intent = getIntent();
        totalScore.setText("Total Score:\n\n"+intent.getIntExtra("scoreData",0));
    }

    public void playAgain(View view){
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}
