package com.example.paymentrestfulclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button credit = findViewById(R.id.add_credit_card);
        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AddCreditCard.class);
                startActivity(i);
            }
        });
        Button pay = findViewById(R.id.make_payment);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MakePayment.class);
                startActivity(i);
            }
        });
        Button getCredit = findViewById(R.id.getListCard);
        getCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,GetCreditCardList.class);
                startActivity(i);
            }
        });
    }
}