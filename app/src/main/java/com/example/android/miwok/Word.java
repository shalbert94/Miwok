package com.example.android.miwok;

/**
 * Created by shalom on 2017-04-05.
 */

public class Word {
    //Term in english
    private String defaultTranslation;
    //Term in miwok
    private String miwokTranslation;
    //Image resource ID
    private int imageResourceId;
    //Audio resource ID
    private int audioResourceId;

    /**
     * Used where an image should not be shown
     *
     * @param defaultTranslation sets the english word
     * @param miwokTranslation   sets the miwok word
     * @param audioResourceId    sets that mp3 file that will play if view is pressed
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.audioResourceId = audioResourceId;
    }

    /**
     * Used where an image should be shown
     *
     * @param defaultTranslation sets english word
     * @param miwokTranslation   sets miwok word
     * @param imageResourceId    sets image's resource ID
     * @param audioResourceId    sets that mp3 file that will play if view is pressed
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceId = imageResourceId;
        this.audioResourceId = audioResourceId;
    }

    //Retrieve each varable's value
    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }
}
