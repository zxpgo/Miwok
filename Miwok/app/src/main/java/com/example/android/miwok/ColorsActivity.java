package com.example.android.miwok;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private  MediaPlayer mMediaPlayer;

    //创建一个全局mCompletionListener，防止每次播放音频都创建一次，浪费资源
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //创建一个数组列表
        final ArrayList<Word> words = new ArrayList<Word>();
        //words.add("one");
        words.add(new Word("red","红色",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("green","绿色",R.drawable.color_green,R.raw.color_gray));
        words.add(new Word("brown","棕色",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("gray","灰色",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("black","黑色",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("white","白色",R.drawable.color_white,R.raw.color_white));
        words.add(new Word("yellow","黄色",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("blue","蓝色",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setBackgroundColor(R.string.category_colors);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                //因为准备去播放另一个音频，如果当前在播放音频，释放当前的音频
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(ColorsActivity.this,word.getAudioResourceId());
                mMediaPlayer.start();

                //设置一个media player监听器，以至于一旦音频播放完我们可以停止和释放media player
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    /**
     * 通过释放资源，清除media player
     */
    private void releaseMediaPlayer()
    {
        //如果media player不为空，当前可能正在播放音乐
        if (mMediaPlayer != null) {
            //不管当前medid player的状态，释放它的资源
            //因为不再需要它
            mMediaPlayer.release();
            //设置media player为空
            mMediaPlayer = null;
        }
    }
    //当用户离开当前Activity，立即释放资源
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
