package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //创建一个数组列表
        ArrayList<Word> words = new ArrayList<Word>();
        //words.add("one");
        words.add(new Word("father","爸爸",R.drawable.family_father));
        words.add(new Word("mother","妈妈",R.drawable.family_mother));
        words.add(new Word("son","儿子",R.drawable.family_son));
        words.add(new Word("daughter","女儿",R.drawable.family_daughter));
        words.add(new Word("older brother","妹妹",R.drawable.family_younger_sister));
        words.add(new Word("younger brother","弟弟",R.drawable.family_younger_brother));
        words.add(new Word("older sister","姐姐",R.drawable.family_older_sister));
        words.add(new Word("grandmother","奶奶",R.drawable.family_grandmother));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
