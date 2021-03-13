package com.example.viikko8;


public class Bottle {
    private String name;
    private String manufacturer;
    private double size;
    private double prize;
    private int x=0;

    public Bottle(){
        name="Pepsi Max";
        manufacturer="Pepsi";
        size=0.5;
        prize = 1.80;
    }
    public Bottle(String name1, double size1, double prize1){
        name=name1;
        size=size1;
        prize=prize1;


    }
    public String getName(){
        return name;
    }
    public double getPrize() {
        return prize;
    }
    public double getSize() {
        return size;
    }

}