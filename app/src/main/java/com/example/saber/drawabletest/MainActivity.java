package com.example.saber.drawabletest;

import android.app.DatePickerDialog;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnLevelList = (Button) findViewById(R.id.btn_level_list);
        btnLevelList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //不同的等级显示不同的drawable
                int level = new Random().nextInt(6);
                btnLevelList.getBackground().setLevel(level);
            }
        });

        //实现淡出淡出的效果
        TextView textView = (TextView) findViewById(R.id.tv_transition_drawable);
        TransitionDrawable drawable = (TransitionDrawable) textView.getBackground();
        drawable.startTransition(2000);

        //scaleDrawable实现缩放效果
        View view = findViewById(R.id.scale_drawable);
        ScaleDrawable scaleDrawable = (ScaleDrawable) view.getBackground();
        scaleDrawable.setLevel(1);

        //ClipDrawable实现裁剪表示进度
        TextView tvClipDrawable = (TextView) findViewById(R.id.tv_clip_drawable);
        ClipDrawable clipDrawable = (ClipDrawable) tvClipDrawable.getBackground();
        clipDrawable.setLevel(5000);

        NumberPicker

    }
}
