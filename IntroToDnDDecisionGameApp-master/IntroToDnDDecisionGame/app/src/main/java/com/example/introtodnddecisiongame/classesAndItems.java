package com.example.introtodnddecisiongame;

import java.util.ArrayList;
import java.util.List;

public class classesAndItems {

    static int Level = 1;
    static int Gold = 50;

    static String userClass;
    static List userItems = new ArrayList();
    static List storeItems = new ArrayList();
    static List classesList = new ArrayList();
    static int[] itemPrices = new int[100];

    public static void setStoreItems() {

        storeItems.add("Reinforced Sword");
        storeItems.add("Cloak of invisibility");
        storeItems.add("High Quality Wand");
        storeItems.add("Reinforced daggers");

    }

    public static List getStoreItems(){
        return storeItems;
    }



    public static void makePrices(){
        itemPrices[0] = 25;
        itemPrices[1] = 1000;
        itemPrices[2] = 40;
        itemPrices[3] = 60;
    }

    public static void makeClasses(){
        classesList.add("Warrior");
        classesList.add("Rouge");
        classesList.add("Mage");
    }



    public static int getLevel() {return Level;}
    public static int getGold() {return Gold;}


    public static List getUserItems() {

        return userItems;
    }

    public static void setUserItems(){
        if (getUserClass() == "Warrior"){
            userItems.add("Heavy Leather chestplate");
            userItems.add("old short sword");

        }
        if (getUserClass() == "Rouge"){
            userItems.add("Light Leather chestplate");
            userItems.add("Two rusty daggers");

        }
        if (getUserClass() == "Mage"){
            userItems.add("Tattered robes");
            userItems.add("Short wand");

        }
    }

    public static void addUserItems(String str){ userItems.add(str);
    }

    public static void setUserClass(String selectedUserClass) {
        for (int i = 0; i < classesList.size(); i++){
                if (classesList.contains(selectedUserClass)){
                    userClass = selectedUserClass;
                }
    }
    }
    public static String getUserClass(){return userClass; }
    public static int[] getItemPrices() {return itemPrices;}
    public static void setGold(int gold) {Gold = gold;}


}
