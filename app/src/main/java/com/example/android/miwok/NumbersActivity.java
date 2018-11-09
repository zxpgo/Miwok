package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        /**
         //创建一个存储数字的数组
        String [] words = new String[10];
        words[0] = "one";
        words[1] = "two";
        words[2] = "three";
        words[3] = "four";
        words[4] = "five";
        words[5] = "six";
        words[6] = "seven";
        words[7] = "eight";
        words[8] = "nine";
        words[9] = "ten";
        Log.v("NumbersActivity","Word at index 0: " + words[0]);*/
        //创建一个数组列表
        ArrayList<String> words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("seven");
        words.add("ten");
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        /**int index = 0;
        while (index < words.size()){
            TextView wordView = new TextView(this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
            index ++;
        }*/
        for(int index = 0; index < words.size(); index++)
        {
            //创建一个新TextView
            TextView wordView = new TextView(this);
            //将内容设置为当前下标的值
            wordView.setText(words.get(index));
            //添加TextView作为layout布局的子视图
            rootView.addView(wordView);
        }
    }
}
