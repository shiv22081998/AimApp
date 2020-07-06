package com.shiv.aimapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etId;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId=findViewById(R.id.etId);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvResult=findViewById(R.id.tvResult);
        tvResult.setVisibility(View.GONE);

       btnSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String idNumber=etId.getText().toString().trim();
               String dob=idNumber.substring(0,6);
               int gender=Integer.parseInt(Character.toString(idNumber.charAt(6)));
               String sGender;
               if(gender<5) {
                   sGender=getString(R.string.m);
               } else {
                   sGender=getString(R.string.fm);
               }
               int nationality=Integer.parseInt(Character.toString(idNumber.charAt(10)));
               String sNationality;
               if(nationality==0) {
                   sNationality=getString(R.string.sacit);
               }
               else {
                   sNationality=getString(R.string.permanentr);
               }
                     String text=getString(R.string.dob)+dob+getString(R.string.newline)
                             +getString(R.string.gender)+sGender+getString(R.string.newline)
                             +getString(R.string.nationality)+sNationality;
               tvResult.setText(text);
               tvResult.setVisibility(View.VISIBLE);

           }
       });

    }
}