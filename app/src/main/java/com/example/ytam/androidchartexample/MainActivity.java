package com.example.ytam.androidchartexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnExample1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PieChartExample.class));
            }
        });

        findViewById(R.id.btnExample2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LineChartExample.class));
            }
        });

        findViewById(R.id.btnExample3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HalfChartActivity.class));
            }
        });

        findViewById(R.id.btnExample4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BarChartActivity.class));
            }
        });

        findViewById(R.id.btnExample5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BarChart2Activity.class));
            }
        });

        findViewById(R.id.btnExample6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PieChart2Example.class));
            }
        });

        findViewById(R.id.btnExample7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PositiveNegativeActivity.class));
            }
        });

        findViewById(R.id.btnExample8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BarChart3Activity.class));
            }
        });

        findViewById(R.id.btnExample9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BarChart4Activity.class));
            }
        });

        findViewById(R.id.btnExample10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FitChart.class));
            }
        });

        findViewById(R.id.btnExample11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HorizontalBarActivity.class));
            }
        });

        findViewById(R.id.btnExample12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StackedBarNegativeActivity.class));
            }
        });

        findViewById(R.id.btnExample13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PyramideActivity.class));
            }
        });

        findViewById(R.id.btnExample14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PieNewActivity.class));
            }
        });

        findViewById(R.id.btnExample15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LineActivity.class));
            }
        });

        findViewById(R.id.btnExample16).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TagCloudActivity.class));
            }
        });

        findViewById(R.id.btnExample17).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PieViewActivity.class));
            }
        });

        findViewById(R.id.btnExample18).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PieChartLibActivity.class));
            }
        });

        findViewById(R.id.btnExample19).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, denem.class));
            }
        });

        findViewById(R.id.btnExample20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LineFromAnother.class));
            }
        });



    }
}
