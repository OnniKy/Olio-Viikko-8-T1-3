package com.example.viikko8;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Scanner;

public class BottleDispenser {
    private int bottles;
    double money;


    int valinta2=1;
    String printti;
    double roundoff;
    int amount;


    private ArrayList<Bottle> bottle_list = new ArrayList<Bottle>();
    private static BottleDispenser bottledispenser = null;


    public static BottleDispenser getInstance() {
        if (bottledispenser == null){
            bottledispenser = new BottleDispenser();
        }

        return bottledispenser;
    }

    public BottleDispenser() {

        bottles = 5;
        money = 0;



        bottle_list.add(new Bottle("Pepsi", 1.5, 2.0));
        bottle_list.add(new Bottle("Pepsi Max", 1.5, 2.2));
        bottle_list.add(new Bottle("Coca-Cola Zero", 0.5, 2.0));
        bottle_list.add(new Bottle("Coca-Cola Vanilla", 1.5, 2.5));
        bottle_list.add(new Bottle("Fanta Zero", 0.5, 1.95));



    }


    public void addMoney(TextView text, int amount) {
        money += amount;
        text.findViewById(R.id.textWindow);
        text.setText("Klink! Added more money!\n");

    }

    public void buyBottle(TextView text) {
        text.findViewById(R.id.textWindow);
        //Scanner scan = new Scanner(System.in);



        //for(int i=0;i<bottle_list.size();i++) {
            //System.out.println(i+1+". Name: "+bottle_list.get(i).getName());
            //System.out.println("\tSize: "+bottle_list.get(i).getSize()+"\tPrice: "+bottle_list.get(i).getPrize());
        //}
        //System.out.print("Your choice: ");
        //valinta2=scan.nextInt();
        if(bottle_list.size()==0){
            text.setText("Automaatti on tyhjä!");

        }

        else if(money < bottle_list.get(0).getPrize()){
            text.setText("Add money first!\n");
        }
        else{
            text.setText("KACHUNK! "+bottle_list.get(valinta2-1).getName()+" came out of the dispenser!");
            money-=bottle_list.get(valinta2-1).getPrize();
            bottle_list.remove(valinta2-1);
        }

    }

    public void returnMoney(TextView text) {
        text.findViewById(R.id.textWindow);
        double roundOff = Math.round(money * 100.0) / 100.0;
        printti = Double.toString(roundOff);
        if(printti.length()==3) {
            printti=printti+"0";
        }
        text.setText("Klink klink. Money came out! You got "+printti.replace(".",",")+"€ back");
        money = 0;
    }
    public void listBottles() {
        for(int i=0;i<bottle_list.size();i++) {
            System.out.println(i+1+". Name: "+bottle_list.get(i).getName());
            System.out.println("\tSize: "+bottle_list.get(i).getSize()+"\tPrice: "+bottle_list.get(i).getPrize());
        }
    }
}
