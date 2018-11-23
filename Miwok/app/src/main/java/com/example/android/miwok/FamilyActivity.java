package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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
        words.add(new Word("father","爸爸",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("mother","妈妈",R.drawable.family_mother,R.raw.family_father));
        words.add(new Word("son","儿子",R.drawable.family_son,R.raw.family_son));
        words.add(new Word("daughter","女儿",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word("older brother","妹妹",R.drawable.family_younger_sister,R.raw.family_older_brother));
        words.add(new Word("younger brother","弟弟",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("older sister","姐姐",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("grandmother","奶奶",R.drawable.family_grandmother,R.raw.family_grandmother));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                //因为准备去播放另一个音频，如果当前在播放音频，释放当前的音频
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(FamilyActivity.this,word.getAudioResourceId());
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
