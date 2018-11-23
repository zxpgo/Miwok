package com.example.android.miwok;

/**
 * 创建了一个Wrod类，用户可以使用
 * 其包含一个默认翻译和一个Miwok翻译对于同一个单词
 * */
public class Word {
    //私有变量
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private  int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * 创建一个word对象，构造函数，有两个输入
     * @param defaultTranslation
     * @param miwokTranslaton
     */
    public Word(String defaultTranslation, String miwokTranslaton, int audioResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslaton;
        mAudioResourceId = audioResourceId;
    }
    /**
     * 创建一个Word对象，构造函数，有三个输入
     * @param defaultTranslation
     * @param miwokTranslaton
     * @param imageResourceId
     */
    public Word(String defaultTranslation, String miwokTranslaton, int imageResourceId, int audioResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslaton;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the Miwok Translation
     * @return
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the defualt translation
     * @return string
     */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * Get the image resource id
     * @return int
     */
    public int getImageSourceId(){return  mImageResourceId;}

    /**
     *
     * @return 一个单词是否有图片
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     *
     * @return 音频ID
     */
    public int getAudioResourceId(){return mAudioResourceId;}

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
