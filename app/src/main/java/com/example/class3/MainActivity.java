package com.example.class3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    //views
    private TextView display;
    private EditText input;
    private Button save, next;

    //preferences
    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init shared preferences
        sharedPrefs = Utils.getSharedPreferences(this);
        editor = Utils.getSharedPreferencesEditor(this);

        //init views
        display = (TextView) findViewById(R.id.userName);
        input = (EditText) findViewById(R.id.inputName);
        save = (Button) findViewById(R.id.save);
        next = (Button) findViewById(R.id.next);

        //get users name from shared preferences and display it
        String userName = sharedPrefs.getString(Utils.userName, "");
        display.setText(userName);

        //event listeners
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //display users name
                String userName = input.getText().toString();
                display.setText(userName);

                //save user name to shared preferences
                editor.putString(Utils.userName, userName);
                editor.apply();

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //go to second activity
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                startActivity(intent);
            }
        });




      
    }
}
