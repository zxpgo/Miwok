package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //创建一个数组列表
        ArrayList<Word> words = new ArrayList<Word>();
        //words.add("one");
        words.add(new Word("red","红色",R.drawable.color_red));
        words.add(new Word("green","绿色",R.drawable.color_green));
        words.add(new Word("brown","棕色",R.drawable.color_brown));
        words.add(new Word("gray","灰色",R.drawable.color_gray));
        words.add(new Word("black","黑色",R.drawable.color_black));
        words.add(new Word("white","白色",R.drawable.color_white));
        words.add(new Word("yellow","黄色",R.drawable.color_dusty_yellow));
        words.add(new Word("blue","蓝色",R.drawable.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setBackgroundColor(R.string.category_colors);

    }
}
