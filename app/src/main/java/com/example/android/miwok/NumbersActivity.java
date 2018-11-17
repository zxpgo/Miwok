package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //创建一个数组列表
        ArrayList<Word> words = new ArrayList<Word>();
        //words.add("one");
        words.add(new Word("one","一", R.drawable.number_one));
        words.add(new Word("two","二",R.drawable.number_two));
        words.add(new Word("three","三",R.drawable.number_three));
        words.add(new Word("four","四",R.drawable.number_four));
        words.add(new Word("five","五",R.drawable.number_five));
        words.add(new Word("six","六",R.drawable.number_six));
        words.add(new Word("seven","七",R.drawable.number_seven));
        words.add(new Word("eight","八",R.drawable.number_eight));
        words.add(new Word("nine","九",R.drawable.number_nine));
        words.add(new Word("ten","十",R.drawable.number_ten));

        WordAdapter adapter = new WordAdapter(this,words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
