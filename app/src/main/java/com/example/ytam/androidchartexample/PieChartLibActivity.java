package com.example.ytam.androidchartexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.callback.OnPieSelectListener;
import com.razerdp.widget.animatedpieview.data.IPieInfo;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;
import com.razerdp.widget.animatedpieview.utils.PLog;

import java.util.Locale;
import java.util.Random;

public class PieChartLibActivity extends AppCompatActivity {

    Random rand = new Random();

    private AnimatedPieView mAnimatedPieView;
    private TextView desc;
    int rainFall[] = {98, 102, 120, 95, 120};
    String monthNames[] = {"Kadın Doğum", "Polikinik", "Genel Cerahi", "Psikoloji", "Üroloji"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart_lib);

        initView();
        mAnimatedPieView.start();
    }

    private void initView() {
        PLog.setDebuggable(true);
        desc = findViewById(R.id.tv_desc);
        mAnimatedPieView = findViewById(R.id.animatedPieView);
        AnimatedPieViewConfig config = new AnimatedPieViewConfig();
        Random random = new Random();
        for (int i = 0; i < monthNames.length; i++) {
            config.startAngle(0.9224089f)
                    .addData(new SimplePieInfo(rainFall[i], getColor(String.format("#%06x", random.nextInt(256*256*256))), monthNames[i]), false)
                    .splitAngle(2   )
                    .selectListener(new OnPieSelectListener() {
                        @Override
                        public void onSelectPie(@NonNull IPieInfo pieInfo, boolean isFloatUp) {
                            desc.setTextSize(15);
                            desc.setTextColor(Color.BLACK);
                            desc.setText(String.format(Locale.getDefault(),
                                    "%s \nKişi Sayısı = %s;",
                                    pieInfo.getDesc(), pieInfo.getValue(), isFloatUp));
                        }
                    })
                    .drawText(true)
                    .duration(1200)
                    .textSize(56)
                    .focusAlphaType(AnimatedPieViewConfig.FOCUS_WITH_ALPHA)
                    .textGravity(AnimatedPieViewConfig.ABOVE)
                    .interpolator(new DecelerateInterpolator());

        }


        mAnimatedPieView.applyConfig(config);

    }

    private int getColor(String colorStr) {
        if (TextUtils.isEmpty(colorStr)) return Color.BLACK;
        if (!colorStr.startsWith("#")) colorStr = "#" + colorStr;
        return Color.parseColor(colorStr);
    }
}