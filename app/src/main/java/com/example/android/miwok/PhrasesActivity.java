package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //创建一个数组列表
        ArrayList<Word> words = new ArrayList<Word>();
        //words.add("one");
        words.add(new Word("Where are you going?", "你准备去哪里？"));
        words.add(new Word("What is your name?", "你叫什么？"));
        words.add(new Word("I'm feeling good.", "我很好。"));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
