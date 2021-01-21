package com.example.introtodnddecisiongame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class characterSheet extends AppCompatActivity {

    Button continueBtn;
    TextView strenTextView;
    TextView intellTextView;
    TextView wisdomTextView;
    TextView dexTextView;
    TextView constTextView;
    TextView charisTextView;
    TextView goldTextView;
    TextView levelTextView;
    TextView classTextView;
    TextView itemsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);




        strenTextView = (TextView)findViewById(R.id.strenText);
        intellTextView = (TextView)findViewById(R.id.intellText);
        wisdomTextView = (TextView)findViewById(R.id.wisdomText);
        dexTextView = (TextView)findViewById(R.id.dexterText);
        constTextView = (TextView)findViewById(R.id.constText);
        charisTextView = (TextView)findViewById(R.id.charisText);
        continueBtn = (Button)findViewById(R.id.continueBtn);
        goldTextView = (TextView)findViewById(R.id.goldText);
        levelTextView = (TextView)findViewById(R.id.levelText);
        classTextView = (TextView)findViewById(R.id.classTextView);
        itemsTextView = (TextView)findViewById(R.id.itemsText);


        String strengthStats = "    "   + characterAttributes.getStrength() + "         modifier: " + characterAttributes.getStrengthMod();
        String intelligenceStats = "    "   + characterAttributes.getIntelligence() + "          modifier: " + characterAttributes.getIntelligenceMod();
        String wisdomStats = "    "   + characterAttributes.getWisdom() + "       modifier: " + characterAttributes.getWisdomMod();
        String dexterityStats = "    "   + characterAttributes.getDexterity() + "         modifier: " + characterAttributes.getDexterityMod();
        String constitutionStats = "    "   + characterAttributes.getConstitution() + "       modifier: " + characterAttributes.getConstitutionMod();
        String charismaStats = "    "   + characterAttributes.getCharisma() + "       modifier: " + characterAttributes.getCharismaMod();


        strenTextView.setText(strengthStats);
        intellTextView.setText(intelligenceStats);
        wisdomTextView.setText(wisdomStats);
        dexTextView.setText(dexterityStats);
        constTextView.setText(constitutionStats);
        charisTextView.setText(charismaStats);




        classTextView.setText(classesAndItems.getUserClass());
        List userItems = classesAndItems.getUserItems();
        String userItemsString = "";
        for (int i = 0 ; i < userItems.size(); i++)
        {
            if (i > 0) {
                userItemsString += ", " + userItems.get(i);
            }
            else{
                userItemsString += userItems.get(i);
            }
        }
        itemsTextView.setText(userItemsString);
        String gold = String.valueOf(classesAndItems.getGold());
        String level = String.valueOf(classesAndItems.getLevel());
        goldTextView.setText(gold);
        levelTextView.setText(level);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameScreen = new Intent(v.getContext(), gameScreen.class);
                startActivity(gameScreen);
            }
        });



    }
}
