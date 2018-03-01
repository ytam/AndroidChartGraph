package com.example.ytam.androidchartexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import devlight.io.library.ArcProgressStackView;

public class FitChart extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_chart);


        final ArrayList<ArcProgressStackView.Model> models = new ArrayList<>();
        models.add(new ArcProgressStackView.Model("Kadın Doğum", 25,   Color.WHITE, Color.RED));
        models.add(new ArcProgressStackView.Model("Psikoloji", 50, Color.WHITE, Color.RED));
        models.add(new ArcProgressStackView.Model("Genel Cerahi", 75,    Color.WHITE, Color.RED));
        models.add(new ArcProgressStackView.Model("Üroloji", 90,    Color.WHITE, Color.RED));

        final ArcProgressStackView arcProgressStackView = (ArcProgressStackView) findViewById(R.id.apsv);

        arcProgressStackView.setModels(models);

    }
}
