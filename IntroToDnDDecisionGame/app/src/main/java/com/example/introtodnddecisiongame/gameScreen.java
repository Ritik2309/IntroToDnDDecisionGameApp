package com.example.introtodnddecisiongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class gameScreen extends AppCompatActivity {

    Button optionOne;
    Button optionTwo;
    Button optionThree;
    TextView nodeDesc;
    ImageView image;
    static DecisionNode previousNode = null;

    int[] decisionRollIDs = {1000,1001,2000,2001,2002,3000,3001,7};
    int[] textRollIDs = {27,11,12};
    String newNodeDesc;
    gameProgression gameProgression = new gameProgression();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        optionOne = (Button)findViewById(R.id.optionOne);
        optionTwo = (Button)findViewById(R.id.optionTwo);
        optionThree = (Button)findViewById(R.id.optionThree);
        nodeDesc = (TextView)findViewById(R.id.nodeDescription);
        nodeDesc.setMovementMethod(new ScrollingMovementMethod());
        image = (ImageView)findViewById(R.id.gameImage);


        DecisionMap perec = new DecisionMap(getCSV());
        navigate(perec);
    }

    public BufferedReader getCSV(){

        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        return reader;
    }

    private void navigate(DecisionMap perec) {
        DecisionNode node = perec.entryPoint();
        currentNode(node);

    }

    public void currentNode(DecisionNode node){

        if (node.getNodeID() == 1){
            classesAndItems.setGold(50);
        }

         newNodeDesc = null;
        checkTextProgression(node);

          optionTwo.setVisibility(View.INVISIBLE);
          optionThree.setVisibility(View.INVISIBLE);

        if (newNodeDesc == null){nodeDesc.setText(node.getNodeDescription());}
        else nodeDesc.setText(newNodeDesc);

        if (node.getOptionOneNode().equals("-1")){
            optionOne.setText(null);
        }
        else{
            optionOne.setVisibility(View.VISIBLE);
            optionOne.setText(node.getOptionOneQues());
        }

        if (node.getOptionTwoQues().equals("-1")){
            optionTwo.setText(null);
        }
        else {
            optionTwo.setVisibility(View.VISIBLE);
            optionTwo.setText(node.getOptionTwoQues());
        }

        if (node.getOptionThreeQues().equals("-1")){
            optionThree.setText(null);
        }
        else{
            optionThree.setVisibility(View.VISIBLE);
            optionThree.setText(node.getOptionThreeQues());
        }



        optionOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                previousNode = node;
                checkGameProgressionNodeOne(node);

            }
        });

        optionTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                previousNode = node;
                checkGameProgressionNodeTwo(node);

            }
        });

        optionThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                previousNode = node;
               checkGameProgressionNodeThree(node);

            }
        });


    }

    public DecisionNode optionONE(DecisionNode node){
        return node.getOptionOneNode();
    }

    public DecisionNode optionTWO(DecisionNode node){
        return node.getOptionTwoNode();
    }

    public DecisionNode optionTHREE(DecisionNode node){
        return node.getOptionThreeNode();
    }

    public String checkTextProgression(DecisionNode node){
        for ( int i = 0; i < textRollIDs.length; i++){
            if (node.getNodeID() == textRollIDs[i]){
                textRollIDs[i] = 0;
                return newNodeDesc =  gameProgression.handleTextProgression(node);

            }
        }
        return null;

    }

    public DecisionNode checkGameProgressionNodeOne(DecisionNode node){
        if (node.getOptionOneNode().getNodeID() == decisionRollIDs[0]){
            currentNode(gameProgression.handleGameProgression((node.getOptionOneNode())));
        }
        else if (node.getOptionOneNode().getNodeID() == decisionRollIDs[1]){
            currentNode(gameProgression.handleGameProgression((node.getOptionOneNode())));
        }
        else if (node.getOptionOneNode().getNodeID() == decisionRollIDs[2]){
            currentNode(gameProgression.handleGameProgression((node.getOptionOneNode())));
        }
        else if (node.getOptionOneNode().getNodeID() == decisionRollIDs[3]){
            currentNode(gameProgression.handleGameProgression((node.getOptionOneNode())));
        }
        else if (node.getOptionOneNode().getNodeID() == decisionRollIDs[4]){
            currentNode(gameProgression.handleGameProgression((node.getOptionOneNode())));
        }
        else if (node.getOptionOneNode().getNodeID() == decisionRollIDs[5]){
            currentNode(gameProgression.handleGameProgression((node.getOptionOneNode())));
        }
        else if (node.getOptionOneNode().getNodeID() == decisionRollIDs[6]){
            currentNode(gameProgression.handleGameProgression((node.getOptionOneNode())));
        }
        else if (node.getOptionOneNode().getNodeID() == decisionRollIDs[7]){
            Intent adventurersStore = new Intent(this, com.example.introtodnddecisiongame.adventurersStore.class);
            startActivity(adventurersStore);
        }


        else currentNode(optionONE(node));
        return null;
    }

    public DecisionNode checkGameProgressionNodeTwo(DecisionNode node){

        if (node.getOptionTwoNode().getNodeID() == decisionRollIDs[0]){
            currentNode(gameProgression.handleGameProgression(node.getOptionTwoNode()));
        }
        else if (node.getOptionTwoNode().getNodeID() == decisionRollIDs[1]){
            currentNode(gameProgression.handleGameProgression(node.getOptionTwoNode()));
        }
        else if (node.getOptionTwoNode().getNodeID() == decisionRollIDs[2]){
            currentNode(gameProgression.handleGameProgression(node.getOptionTwoNode()));
        }
        else if (node.getOptionTwoNode().getNodeID() == decisionRollIDs[3]){
            currentNode(gameProgression.handleGameProgression(node.getOptionTwoNode()));
        }
        else if (node.getOptionTwoNode().getNodeID() == decisionRollIDs[4]){
            currentNode(gameProgression.handleGameProgression(node.getOptionTwoNode()));
        }
        else if (node.getOptionTwoNode().getNodeID() == decisionRollIDs[5]){
            currentNode(gameProgression.handleGameProgression(node.getOptionTwoNode()));
        }
        else if (node.getOptionTwoNode().getNodeID() == decisionRollIDs[6]){
            currentNode(gameProgression.handleGameProgression(node.getOptionTwoNode()));
        }
        else if (node.getOptionTwoNode().getNodeID() == decisionRollIDs[7]){
            Intent adventurersStore = new Intent(this, com.example.introtodnddecisiongame.adventurersStore.class);
            startActivity(adventurersStore);
        }

        else currentNode(optionTWO(node));
        return null;

    }

    public DecisionNode checkGameProgressionNodeThree(DecisionNode node){
        if (node.getOptionThreeNode().getNodeID() == decisionRollIDs[0]){
            currentNode(gameProgression.handleGameProgression(node.getOptionThreeNode()));
        }
        else if (node.getOptionThreeNode().getNodeID() == decisionRollIDs[1]){
            currentNode(gameProgression.handleGameProgression(node.getOptionThreeNode()));
        }
        else if (node.getOptionThreeNode().getNodeID() == decisionRollIDs[2]){
            currentNode(gameProgression.handleGameProgression(node.getOptionThreeNode()));
        }
        else if (node.getOptionThreeNode().getNodeID() == decisionRollIDs[3]){
            currentNode(gameProgression.handleGameProgression(node.getOptionThreeNode()));
        }
        else if (node.getOptionThreeNode().getNodeID() == decisionRollIDs[4]){
            currentNode(gameProgression.handleGameProgression(node.getOptionThreeNode()));
        }
        else if (node.getOptionThreeNode().getNodeID() == decisionRollIDs[5]){
            currentNode(gameProgression.handleGameProgression(node.getOptionThreeNode()));
        }
        else if (node.getOptionThreeNode().getNodeID() == decisionRollIDs[6]){
            currentNode(gameProgression.handleGameProgression(node.getOptionThreeNode()));
        }
        else if (node.getOptionTwoNode().getNodeID() == decisionRollIDs[7]){
            Intent adventurersStore = new Intent(this, com.example.introtodnddecisiongame.adventurersStore.class);
            startActivity(adventurersStore);
        }

        else currentNode(optionTHREE(node));
        return null;
    }



}









