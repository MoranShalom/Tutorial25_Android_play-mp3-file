package com.example.class3;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class SecondActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    // view
    private TextView display;
    private Button play, show, stop;

    //music
    private MediaPlayer mPlayer;


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_second);

        //init view
        display = (TextView) findViewById(R.id.display);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        show = (Button) findViewById(R.id.show);


        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mPlayer = MediaPlayer.create(v.getContext(), R.raw.soundtrack);
                mPlayer.start();

            }
        });

        stop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                onStop();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                readTxtFileFromRaw();

            }
        });


    }


    private void readTxtFileFromRaw() {

        //init stream
        InputStream input = getResources().openRawResource(R.raw.soundtrack_list);
        BufferedReader reader = new BufferedReader(new InputStreamReader((input)));
        String line = "";
        String txt = " ";

        // remove old text
        display.setText("");

        //read txt from file
        try {
            //loop though the file line by line
            while ((line = reader.readLine()) != null) {

                txt += "\n";
                txt += line;
            }
            //close the input stream
            input.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //display text
        display.setText(txt);

    }

    @Override
    protected void onStop() {

        super.onStop();

        //stop the music
        if (mPlayer != null) {

            mPlayer.stop();
        }
    }
}