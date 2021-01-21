package com.example.introtodnddecisiongame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class titleScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        Button startButton = (Button)findViewById(R.id.startButton);
        TextView gameTitle = (TextView)findViewById(R.id.gameTitle);


    }


    public void startGameScreen(View view){
        Intent classCreation = new Intent(this, classCreation.class);
        startActivity(classCreation);
    }

}