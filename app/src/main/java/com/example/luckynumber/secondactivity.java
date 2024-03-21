package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class secondactivity extends AppCompatActivity {
    TextView welcomeTxt, luckyNumberTxt;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.luck_number_txt);
        share_btn = findViewById(R.id.share_btn);
        //recieving the data from main activity
        Intent i = getIntent();
        String userName = i.getStringExtra("name");
        //Generating Random Numbers
        int random_num = generateRandomNumber();
        luckyNumberTxt.setText("" + random_num);
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, random_num);
            }
        });
    }
        public int generateRandomNumber(){
            Random random= new Random();
            int upper_limit= 1000;
            int randomNumberGenerated=random.nextInt(upper_limit);
            return randomNumberGenerated;
        }
        public void shareData(String username, int randomNum) {
            //implicit intent
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            //additional info
            i.putExtra(Intent.EXTRA_SUBJECT, username + "got lucky today!");
            i.putExtra(Intent.EXTRA_TEXT, "His Lucky Number is:" + randomNum);
            startActivity(Intent.createChooser(i, "choose a platform"));
        }
        }