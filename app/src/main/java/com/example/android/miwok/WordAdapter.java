package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shalom on 2017-04-05.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    //Global variables
    private int listItemBackgroundColor;
    private MediaPlayer playRecording;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    //Constructor
    public WordAdapter(Context context, ArrayList<Word> Word, int listItemBackgroundColor) {
        super(context, 0, Word);
        this.listItemBackgroundColor = listItemBackgroundColor;
    }

    //Sets views for each list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Word wordObject = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.image_aid);
        TextView miwokWord = (TextView) convertView.findViewById(R.id.miwok_word);
        TextView englishWord = (TextView) convertView.findViewById(R.id.english_word);
        RelativeLayout wordContainingLayout = (RelativeLayout) convertView.findViewById(R.id.word_containing_relative_layout);

        if (wordObject.getImageResourceId() == 0) {
            image.setVisibility(View.GONE);
        } else {
            image.setImageResource(wordObject.getImageResourceId());
        }
        miwokWord.setText(wordObject.getMiwokTranslation());
        englishWord.setText(wordObject.getDefaultTranslation());
        wordContainingLayout.setBackgroundResource(getListItemBackgroundColor());
        wordContainingLayout.setOnClickListener(new View.OnClickListener() {
            //Response to tapping a list item
            @Override
            public void onClick(View v) {
                releaseMediaPlayer();

                playRecording = MediaPlayer.create(getContext(), wordObject.getAudioResourceId());

                if (playRecording.isPlaying()) {
                    playRecording.stop();
                    releaseMediaPlayer();
                }
                playRecording.start();
                playRecording.setOnCompletionListener(completionListener);
            }
        });

        return convertView;
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    protected void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (playRecording != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            playRecording.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            playRecording = null;
        }
    }

    public int getListItemBackgroundColor() {
        return listItemBackgroundColor;
    }


    protected MediaPlayer getPlayRecording() {
        return playRecording;
    }
}
