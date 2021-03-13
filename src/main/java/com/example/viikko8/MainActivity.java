package com.example.viikko8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button rahanlisays, osta, rahanpalautus;
    BottleDispenser bottledispenser;
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text=findViewById(R.id.textWindow);
        rahanlisays=findViewById(R.id.addMoney);
        osta=findViewById(R.id.buyBottle);
        rahanpalautus=findViewById(R.id.returnMoney);
        seekBar=findViewById(R.id.seekBar);

        bottledispenser = BottleDispenser.getInstance();


        rahanlisays.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addMoney();
            seekBar.setProgress(0);

        }
    });

        osta.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buyBottle();
        }
    });

        rahanpalautus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            returnMoney();
        }
    });


}
    public void addMoney(){
        int amount=seekBar.getProgress();

        bottledispenser.addMoney(text, amount);

    }
    public void buyBottle(){
        bottledispenser.buyBottle(text);
    }
    public void returnMoney(){
        bottledispenser.returnMoney(text);
    }
}