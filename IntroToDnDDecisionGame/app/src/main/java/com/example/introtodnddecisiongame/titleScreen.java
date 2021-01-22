package com.example.introtodnddecisiongame;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class titleScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

    }


    public void startGameScreen(View view){
        Intent classCreation = new Intent(this, classCreation.class);
        startActivity(classCreation);
    }

}