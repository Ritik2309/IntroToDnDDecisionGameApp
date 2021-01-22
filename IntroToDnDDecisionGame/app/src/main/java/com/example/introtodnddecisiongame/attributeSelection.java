package com.example.introtodnddecisiongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;

public class attributeSelection extends AppCompatActivity {

    Button strength;
    Button dexterity;
    Button constitution;
    Button intelligence;
    Button wisdom;
    Button charisma;
    TextView numGeneratedTextView;
    Button generateNum;
    int attributeNumberGenerated = 0;
    int attributeNumberGeneratedMod = 0;
    int numOfAttributesGenerated = 0;
    Boolean str = false;
    Boolean dex = false;
    Boolean inte = false;
    Boolean wis = false;
    Boolean cons = false;
    Boolean chari = false;

    characterAttributes characterAttributes = new characterAttributes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_selection);
        strength = (Button)findViewById(R.id.strengthAtt);
        dexterity = (Button)findViewById(R.id.dexterityAtt);
        constitution = (Button)findViewById(R.id.constitutionAtt);
        intelligence = (Button)findViewById(R.id.intelligenceAtt);
        wisdom = (Button)findViewById(R.id.wisdomAtt);
        charisma = (Button)findViewById(R.id.charismaAtt);
        numGeneratedTextView = (TextView)findViewById(R.id.numGeneratedTextView);
        generateNum = (Button)findViewById(R.id.generateNumBtn);

        disableAttributeButtons();

        generateNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfAttributesGenerated++;
                enableButtons();
                attributeNumberGenerated =  generateNum();
                attributeNumberGeneratedMod = generateMod();
                String attributeNumberGeneratedString = String.valueOf(attributeNumberGenerated);
                numGeneratedTextView.setText(attributeNumberGeneratedString);
                generateNum.setEnabled(false);
            }
        });

        strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                characterAttributes.setStrength(attributeNumberGenerated);
                characterAttributes.setStrengthMod(attributeNumberGeneratedMod);
                strength.setEnabled(false);
                strength.setBackgroundColor(Color.GRAY);
                checkNumOfAttributes();
                generateNum.setEnabled(true);
                str = true;
            }
        });

        intelligence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                characterAttributes.setIntelligence(attributeNumberGenerated);
                characterAttributes.setIntelligenceMod(attributeNumberGeneratedMod);
                intelligence.setEnabled(false);
                intelligence.setBackgroundColor(Color.GRAY);
                checkNumOfAttributes();
                generateNum.setEnabled(true);
                inte = true;
            }
        });

        wisdom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                characterAttributes.setWisdom(attributeNumberGenerated);
                characterAttributes.setWisdomMod(attributeNumberGeneratedMod);
                wisdom.setEnabled(false);
                wisdom.setBackgroundColor(Color.GRAY);
                checkNumOfAttributes();
                generateNum.setEnabled(true);
                wis = true;
            }
        });

        dexterity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                characterAttributes.setDexterity(attributeNumberGenerated);
                characterAttributes.setDexterityMod(attributeNumberGeneratedMod);
                dexterity.setEnabled(false);
                dexterity.setBackgroundColor(Color.GRAY);
                checkNumOfAttributes();
                generateNum.setEnabled(true);
                dex = true;
            }
        });

        constitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                characterAttributes.setConstitution(attributeNumberGenerated);
                characterAttributes.setConstitutionMod(attributeNumberGeneratedMod);
                constitution.setEnabled(false);
                constitution.setBackgroundColor(Color.GRAY);
                checkNumOfAttributes();
                generateNum.setEnabled(true);
                cons = true;
            }
        });

        charisma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                characterAttributes.setCharisma(attributeNumberGenerated);
                characterAttributes.setCharismaMod(attributeNumberGeneratedMod);
                charisma.setEnabled(false);
                charisma.setBackgroundColor(Color.GRAY);
                checkNumOfAttributes();
                generateNum.setEnabled(true);
                chari = true;
            }
        });

    }

    public int generateNum(){

        int[] holdDiceResults = new int[4];

        int generatedAttributeNum = 0;

        Random random = new Random();

        for (int i = 0; i < holdDiceResults.length; i++) {
            holdDiceResults[i] = random.nextInt(6) + 1;
            System.out.println(holdDiceResults[i]);
        }

        int lowestNum = holdDiceResults[0];
        int indexOfSmallestValue = 0;

        for (int i = 0; i < holdDiceResults.length; i++) {
            if(holdDiceResults[i] < lowestNum){
                indexOfSmallestValue = i;
            }
        }

        for(int i = 0; i < holdDiceResults.length; i++){
            if(i != indexOfSmallestValue){
                generatedAttributeNum += holdDiceResults[i];
            }
            else{

            }
        }
        return generatedAttributeNum;

    }

    public int generateMod(){
        double tempMOD = 0;
        tempMOD = ((attributeNumberGenerated-10)/2);
        tempMOD = Math.floor(tempMOD);
        int MOD = (int) tempMOD;
        return MOD;
    }

    public void checkNumOfAttributes(){
        if (numOfAttributesGenerated == 6){
            Intent characterSheet = new Intent(getApplicationContext(), characterSheet.class);
            startActivity(characterSheet);
        }
        else{
            disableAttributeButtons();
        }

    }

    public void enableButtons(){
        if (str == false){ strength.setEnabled(true);
            strength.setBackgroundColor(Color.parseColor("#7ba428"));}
       if (inte == false){ intelligence.setEnabled(true);
           intelligence.setBackgroundColor(Color.parseColor("#7ba428"));}
       if (wis == false){
           wisdom.setEnabled(true);
           wisdom.setBackgroundColor(Color.parseColor("#7ba428"));}
        if (dex == false){ dexterity.setEnabled(true);
            dexterity.setBackgroundColor(Color.parseColor("#7ba428"));}
        if (cons == false){constitution.setEnabled(true);
            constitution.setBackgroundColor(Color.parseColor("#7ba428"));}
        if (chari == false){charisma.setEnabled(true);
            charisma.setBackgroundColor(Color.parseColor("#7ba428"));
        }
    }



    public void disableAttributeButtons(){
        strength.setEnabled(false);
        strength.setBackgroundColor(Color.GRAY);
        intelligence.setEnabled(false);
        intelligence.setBackgroundColor(Color.GRAY);
        wisdom.setEnabled(false);
        wisdom.setBackgroundColor(Color.GRAY);
        dexterity.setEnabled(false);
        dexterity.setBackgroundColor(Color.GRAY);
        constitution.setEnabled(false);
        constitution.setBackgroundColor(Color.GRAY);
        charisma.setEnabled(false);
        charisma.setBackgroundColor(Color.GRAY);
    }

}