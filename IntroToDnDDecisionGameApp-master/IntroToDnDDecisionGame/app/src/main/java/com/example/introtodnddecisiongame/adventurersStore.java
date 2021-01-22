package com.example.introtodnddecisiongame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class adventurersStore extends AppCompatActivity {

    TextView GoldTextView;

    TextView titleTextView;

    TextView itemOne;
    TextView itemTwo;
    TextView itemThree;
    TextView itemFour;

    TextView itemOnePriceView;
    TextView itemTwoPriceView;
    TextView itemThreePriceView;
    TextView itemFourPriceView;

    Button buyItemOne;
    Button buyItemTwo;
    Button buyItemThree;
    Button buyItemFour;

    Button leftButton;
    Button rightButton;

    gameScreen gameScreen = new gameScreen();
    DecisionNode previousNode = gameScreen.previousNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventurers_store);


        classesAndItems.setStoreItems();
        classesAndItems.makePrices();
        List storeItems = classesAndItems.getStoreItems();
        int[] itemPrices = classesAndItems.getItemPrices();

        GoldTextView = (TextView)findViewById(R.id.goldText);
        GoldTextView.setText(String.valueOf(classesAndItems.getGold()));

        titleTextView = (TextView)findViewById(R.id.titleTextView);

        itemOne = (TextView)findViewById(R.id.itemOneTextView);
        itemTwo =  (TextView)findViewById(R.id.itemTwoTextView);
        itemThree = (TextView)findViewById(R.id.itemThreeTextView);
        itemFour = (TextView)findViewById(R.id.itemFourTextView);

        itemOnePriceView = (TextView)findViewById(R.id.itemOnePrice);
        itemTwoPriceView = (TextView)findViewById(R.id.itemTwoPrice);
        itemThreePriceView = (TextView)findViewById(R.id.itemThreePrice);
        itemFourPriceView = (TextView)findViewById(R.id.itemFourPrice);


        titleTextView.setMovementMethod(new ScrollingMovementMethod());

        buyItemOne = (Button)findViewById(R.id.buyItemOneBtn);
        buyItemTwo = (Button)findViewById(R.id.buyItemTwoBtn);
        buyItemThree = (Button)findViewById(R.id.buyItemThreeBtn);
        buyItemFour = (Button)findViewById(R.id.buyItemFourBtn);

        leftButton = (Button)findViewById(R.id.leftOptionBtn);
        rightButton = (Button)findViewById(R.id.rightOptionButton);

        itemOne.setText(String.valueOf(storeItems.get(0)));
        itemTwo.setText(String.valueOf(storeItems.get(1)));
        itemThree.setText(String.valueOf(storeItems.get(2)));
        itemFour.setText(String.valueOf(storeItems.get(3)));

        itemOnePriceView.setText(String.valueOf(itemPrices[0]));
        itemTwoPriceView.setText(String.valueOf(itemPrices[1]));
        itemThreePriceView.setText(String.valueOf(itemPrices[2]));
        itemFourPriceView.setText(String.valueOf(itemPrices[3]));

        buyItemOne.setText("BUY");
        buyItemTwo.setText("BUY");
        buyItemThree.setText("BUY");
        buyItemFour.setText("BUY");

        leftButton.setVisibility(View.INVISIBLE);
        rightButton.setVisibility(View.INVISIBLE);

        if (previousNode.getNodeID() == 16){
            leftButton.setVisibility(View.VISIBLE);
            leftButton.setText("Leave store");
        }

        if (previousNode.getNodeID() == 3){
            rightButton.setVisibility(View.VISIBLE);
            rightButton.setText("Leave store");
        }

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buyItemOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (classesAndItems.getGold() > itemPrices[0]){
                    buyItemOne.setEnabled(false);
                    buyItemOne.setBackgroundColor(Color.GRAY);

                    int newGold = (classesAndItems.getGold() - itemPrices[0]);
                    classesAndItems.setGold(newGold);
                    GoldTextView.setText(String.valueOf(newGold) );

                    classesAndItems.addUserItems(String.valueOf(buyItemTwo.getText()));
                    Toast.makeText(adventurersStore.this,"Item Bought!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(adventurersStore.this,"Sorry unable to buy that item, not enough gold!", Toast.LENGTH_SHORT).show();
                    buyItemOne.setEnabled(false);
                    buyItemOne.setBackgroundColor(Color.GRAY);
                }
            }
        });

        buyItemTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (classesAndItems.getGold() > itemPrices[1]){
                    buyItemTwo.setEnabled(false);
                    buyItemTwo.setBackgroundColor(Color.GRAY);

                    int newGold = (classesAndItems.getGold() - itemPrices[1]);
                    classesAndItems.setGold(newGold);
                    GoldTextView.setText(String.valueOf(newGold) );

                    Toast.makeText(adventurersStore.this,"Item Bought!", Toast.LENGTH_SHORT).show();
                    classesAndItems.addUserItems(String.valueOf(buyItemTwo.getText()));

                }
                else{
                    Toast.makeText(adventurersStore.this,"Sorry unable to buy that item, not enough gold!", Toast.LENGTH_SHORT).show();
                    buyItemTwo.setEnabled(false);
                    buyItemTwo.setBackgroundColor(Color.GRAY);
                }
            }
        });

        buyItemThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (classesAndItems.getGold() > itemPrices[2]){
                    buyItemThree.setEnabled(false);
                    buyItemThree.setBackgroundColor(Color.GRAY);

                    int newGold = (classesAndItems.getGold() - itemPrices[2]);
                    classesAndItems.setGold(newGold);
                    GoldTextView.setText(String.valueOf(newGold) );

                    Toast.makeText(adventurersStore.this,"Item Bought!", Toast.LENGTH_SHORT).show();
                    classesAndItems.addUserItems(String.valueOf(buyItemTwo.getText()));

                }
                else{
                    Toast.makeText(adventurersStore.this,"Sorry unable to buy that item, not enough gold!", Toast.LENGTH_SHORT).show();
                    buyItemThree.setEnabled(false);
                    buyItemThree.setBackgroundColor(Color.GRAY);
                }
            }
        });

        buyItemFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (classesAndItems.getGold() > itemPrices[3]){
                    buyItemFour.setEnabled(false);
                    buyItemFour.setBackgroundColor(Color.GRAY);

                    int newGold = (classesAndItems.getGold() - itemPrices[3]);
                    classesAndItems.setGold(newGold);
                    GoldTextView.setText(String.valueOf(newGold));

                    Toast.makeText(adventurersStore.this,"Item Bought!", Toast.LENGTH_SHORT).show();
                    classesAndItems.addUserItems(String.valueOf(buyItemFour.getText()));

                }
                else{
                    Toast.makeText(adventurersStore.this,"Sorry unable to buy that item, not enough gold!", Toast.LENGTH_SHORT).show();
                    buyItemFour.setEnabled(false);
                    buyItemFour.setBackgroundColor(Color.GRAY);
                }
            }
        });

    }
}