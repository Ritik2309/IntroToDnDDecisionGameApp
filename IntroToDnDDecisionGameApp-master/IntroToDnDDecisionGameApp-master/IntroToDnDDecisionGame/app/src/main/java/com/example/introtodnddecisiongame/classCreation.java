package com.example.introtodnddecisiongame;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class classCreation extends AppCompatActivity {

    Button Warrior;
    Button Mage;
    Button Rouge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_creation);
        Warrior = (Button)findViewById(R.id.warriorBtn);
        Mage = (Button)findViewById(R.id.mageBtn);
        Rouge = (Button)findViewById(R.id.rougeBtn);

        Warrior.setText("Warrior");
        Mage.setText("Mage");
        Rouge.setText("Rouge");

        classesAndItems.makeClasses();
        classesAndItems.makePrices();

        Warrior.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) { warriorSelected(); }
        });

        Mage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { mageSelected();}
        });

        Rouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { rougeSelected();}
        });

    }

    public void warriorSelected() {

        classesAndItems.setUserClass("Warrior");
        classesAndItems.setUserItems();


        Toast.makeText(getBaseContext(), "Warrior selected!", Toast.LENGTH_SHORT).show();

        Intent attributeSelection = new Intent(this, attributeSelection.class);
        startActivity(attributeSelection);
    }

    public void mageSelected() {

        classesAndItems.setUserClass("Mage");
        classesAndItems.setUserItems();

        Toast.makeText(getBaseContext(), "Mage selected!", Toast.LENGTH_SHORT).show();

        Intent attributeSelection = new Intent(this, attributeSelection.class);
        startActivity(attributeSelection);
    }

    public void rougeSelected() {

        classesAndItems.setUserClass("Rouge");
        classesAndItems.setUserItems();


        Toast.makeText(getBaseContext(), "Rouge selected!", Toast.LENGTH_SHORT).show();

        Intent attributeSelection = new Intent(this, attributeSelection.class);
        startActivity(attributeSelection);
    }



}