package com.example.introtodnddecisiongame;


import android.content.Context;
import android.content.Intent;

public class gameProgression{


    int[] decisionRollIDs = {1000,1001,2000,2001,2002,3000,3001};
    int[] textRollIDs = {27,11,12};

    int roll;
    static int caseDecision;


    public String handleTextProgression(DecisionNode node){
        for (int i = 0 ; i < textRollIDs.length; i++){
            if (node.getNodeID() ==  textRollIDs[i]){
                caseDecision = node.getNodeID();
                textRollIDs[i] = 0;
                return handleTextDecsionNode(node);
            }
        }
        return null;
    }

    public DecisionNode handleGameProgression (DecisionNode node){

            for (int i = 0 ; i < decisionRollIDs.length; i++){
                if (node.getNodeID() ==  decisionRollIDs[i]){
                    caseDecision = node.getNodeID();
                    return handleDecisionRollIDs(node);
                }
            }
        return null;
    }

    public DecisionNode handleDecisionRollIDs(DecisionNode node){

        switch (caseDecision){

            case 1000:
                return rushingBandits(node);
            case 1001:
                return sneekingBandits(node);
            case 2000:
                return examineMap(node);
            case 2001:
                return runToEntrance(node);
            case 2002:
                return sneekingGoblins(node);
            case 3000:
                return examineArea(node);
            case 3001:
                return jumpDown(node);

        }


        return node;
    }

    public String handleTextDecsionNode(DecisionNode node){

        switch (caseDecision){
            case 27:
                return dwarfReward(node);
            case 11:
                return rushKillingBandits(node);
            case 12:
                return sneekKillingBandits(node);

        }

        return null;
    }


    public DecisionNode rushingBandits(DecisionNode node){
        int playerRollValue = rollD20() + characterAttributes.getStrengthMod();
        if(classesAndItems.getUserClass() == "Warrior" || classesAndItems.getUserClass() == "Rouge"){
            playerRollValue += 1;
        }
        if (classesAndItems.getUserClass() == "Mage"){
            playerRollValue -= 1;
        }
        if (playerRollValue > 15){
            return node.getOptionOneNode();
        }
        else{
            return node.getOptionTwoNode();
        }
    }
    public DecisionNode sneekingBandits(DecisionNode node){
        int playerRollValue = rollD20() + characterAttributes.getDexterityMod();
        if(classesAndItems.getUserClass() == "Rouge"){
            playerRollValue += 1;
        }
        if (classesAndItems.getUserClass() == "Warrior" || classesAndItems.getUserClass() == "Mage"){
            playerRollValue -= 1;
        }
        if (playerRollValue > 12){
            return node.getOptionOneNode();
        }
        else{
            return node.getOptionTwoNode();
        }
    }
    public DecisionNode examineMap(DecisionNode node){
        int playerRollValue = rollD20() + characterAttributes.getIntelligenceMod();
        if(classesAndItems.getUserClass() == "Rouge" || classesAndItems.getUserClass() == "Mage"){
            playerRollValue += 1;
        }
        if (classesAndItems.getUserClass() == "Warrior"){
            playerRollValue -= 1;
        }
        if (playerRollValue > 14){
            return node.getOptionOneNode();
        }
        else{
            return node.getOptionTwoNode();
        }
    }
    public DecisionNode runToEntrance(DecisionNode node){
        int playerRollValue = rollD20() + characterAttributes.getDexterityMod();
        if(classesAndItems.getUserClass() == "Warrior" || classesAndItems.getUserClass() == "Rouge"){
            playerRollValue += 1;
        }
        if (classesAndItems.getUserClass() == "Mage"){
            playerRollValue -= 1;
        }
        if (playerRollValue > 13){
            return node.getOptionOneNode();
        }
        else{
            return node.getOptionTwoNode();
        }
    }
    public DecisionNode sneekingGoblins(DecisionNode node){
        int playerRollValue = rollD20() + characterAttributes.getDexterityMod();
        if(classesAndItems.getUserClass() == "Rouge" || classesAndItems.getUserClass() == "Mage"){
            playerRollValue += 1;
        }
        if (classesAndItems.getUserClass() == "Warrior"){
            playerRollValue -= 1;
        }
        if (playerRollValue > 14){
            return node.getOptionOneNode();
        }
        else{
            return node.getOptionTwoNode();
        }
    }
    public DecisionNode examineArea(DecisionNode node){
        int playerRollValue = rollD20() + characterAttributes.getIntelligenceMod();
        if(classesAndItems.getUserClass() == "Rouge" || classesAndItems.getUserClass() == "Mage"){
            playerRollValue += 1;
        }
        if (classesAndItems.getUserClass() == "Warrior"){
            playerRollValue -= 1;
        }
        if (playerRollValue > 14){
            return node.getOptionOneNode();
        }
        else{
            return node.getOptionTwoNode();
        }
    }
    public DecisionNode jumpDown(DecisionNode node){
        int playerRollValue = rollD20() + characterAttributes.getDexterityMod();
        if(classesAndItems.getUserClass() == "Warrior" || classesAndItems.getUserClass() == "Rouge"){
            playerRollValue += 1;
        }
        if (classesAndItems.getUserClass() == "Mage"){
            playerRollValue -= 1;
        }
        if (playerRollValue > 16){
            return node.getOptionOneNode();
        }
        else{
            return node.getOptionTwoNode();
        }
    }



    public String dwarfReward(DecisionNode node){
        String[] rewards = {"as a glistening Mytheral short sword.", "as a pair of glistening Mytheral daggers.", "as a brand new wand infused with a Mytheral core."};
        String rewardItem = null;
        if (classesAndItems.getUserClass() == "Warrior"){
             rewardItem  = rewards[0];
        }
        else if (classesAndItems.getUserClass() == "Rouge"){
            rewardItem  = rewards[1];
        }
        else if (classesAndItems.getUserClass() == "Mage"){
            rewardItem  = rewards[2];
        }
        String newNodeDesc = (node.getNodeDescription() + " " + rewardItem +"You graciously accept the gift and let the dwarf know that you hope to revisit him in the future while shaking shake hands. Congratulations! You've reached the end of one path of the intro to DnD decision adventure game, why not start over or go back a decision and head down a different path?");
        return newNodeDesc;
    }

    public String rushKillingBandits(DecisionNode node){
        String[] rewards = {"sword and", "daggers and", "wand chanting fire spell and"};
        String rewardItem = null;
        if (classesAndItems.getUserClass() == "Warrior"){
            rewardItem  = rewards[0];
        }
        else if (classesAndItems.getUserClass() == "Rouge"){
            rewardItem  = rewards[1];
        }
        else if (classesAndItems.getUserClass() == "Mage"){
            rewardItem  = rewards[2];
        }
        String newNodeDesc = (node.getNodeDescription() + " " + rewardItem +" you manage to finish the remaining two bandits. You both approach the squirming bandit with the injured leg then drag him and tie him as he hurls insults and threats at you. Afterwards, you look through the bandits' loot the elf thanks you and hands 50 gold she uncovered from the bandits stash for helping her clear the trade route for the village. The elf heads off to her village with the bandit that's still breathing while wishing you well in returning to town. Congratulations! You've reached the end of one path of the intro to DnD decision adventure game, why not start over or go back a decision and head down a different path?");
        return newNodeDesc;
    }

    public String sneekKillingBandits(DecisionNode node){
        String[] rewards = {"sword and", "daggers and", "wand chanting fire spell and"};
        String rewardItem = null;
        if (classesAndItems.getUserClass() == "Warrior"){
            rewardItem  = rewards[0];
        }
        else if (classesAndItems.getUserClass() == "Rouge"){
            rewardItem  = rewards[1];
        }
        else if (classesAndItems.getUserClass() == "Mage"){
            rewardItem  = rewards[2];
        }
        String newNodeDesc =  (node.getNodeDescription() + " " + rewardItem + " you manage to finish the remaining two bandits. You both approach the squirming bandit with the injured leg then drag him and tie him as he hurls insults and threats at you. Afterwards, you look through the bandits' loot the elf thanks you and hands 50 gold she uncovered from the bandits stash for helping her clear the trade route for the village. The elf heads off to her village with the bandit that's still breathing while wishing you well in returning to town. Congratulations! You've reached the end of one path of the intro to DnD decision adventure game, why not start over or go back a decision and head down a different path?");
        return newNodeDesc;
    }

    public int rollD20(){
        roll = (int) (Math.random() * 20) + 1;
        return roll;
    }



}
