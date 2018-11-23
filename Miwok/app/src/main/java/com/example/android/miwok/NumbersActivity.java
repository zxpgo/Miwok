package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    // 为AudioManager创建一个全局变量，并在生命周期Activity中初始化一次
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        //Pause playback,即暂时失去了audio focus，意味着我们可以暂停MediaPlayer
                        mMediaPlayer.pause();
                        //改变音频的位置，0表示开头
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        //永久失去了audio focus，应该暂停并清空MediaPlayer
                        releaseMediaPlayer();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        //AUDIOFOCUS_GAIN意味着我们已经注册了audio focus，可以重新播放音频
                        mMediaPlayer.start();
                    }
                }
            };

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
        //创建并初始化AudioManager来请求audio focus
        mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        //创建一个数组列表
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one","一", R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two","二",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three","三",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four","四",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five","五",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six","六",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven","七",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight","八",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine","九",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten","十",R.drawable.number_ten,R.raw.number_ten));


        WordAdapter adapter = new WordAdapter(this,words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Word word = words.get(i);
                    //请求audio focus
                    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            AudioManager.STREAM_MUSIC,
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    //成功获取Audio focus
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                        //现在，拥有一个audio focus，可以开始播放音频
                        releaseMediaPlayer();
                        Log.v("NumbersAcativity", "Cruuent word:" + word);
                        mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                        mMediaPlayer.start();

                        //设置一个media player监听器，以至于一旦音频播放完我们可以停止和释放media player
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
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
            //释放audio focus
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
    //当用户离开当前Activity，立即释放资源
    @Override
    protected void onStop() {
        super.onStop();
        //释放资源
        releaseMediaPlayer();
    }
}


