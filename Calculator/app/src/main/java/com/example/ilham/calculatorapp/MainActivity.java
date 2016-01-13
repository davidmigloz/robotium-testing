package com.example.ilham.calculatorapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.PrivateKey;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {
   private   Button btnAdd,btnSub,btnMult,btnDiv;
   private   EditText etFirst, etSecond;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
   private   void init() {
         btnAdd= (Button) findViewById(R.id.btnAdd);
         btnSub= (Button) findViewById(R.id.btnSub);
         btnMult= (Button) findViewById(R.id.btnMult);
         btnDiv= (Button) findViewById(R.id.btnDiv);
         etFirst= (EditText) findViewById(R.id.etFirstNumber);
         etSecond= (EditText)findViewById(R.id.etSecondNumber);
         tvResult= (TextView)findViewById(R.id.tvResult);

       btnAdd.setOnClickListener(this);
       btnSub.setOnClickListener(this);
       btnMult.setOnClickListener(this);
       btnDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String num1= etFirst.getText().toString();
        String num2= etSecond.getText().toString();
        switch (view.getId()) {
            case R.id.btnAdd:
                int addition = Integer.parseInt(num1)+ Integer.parseInt(num2);
                tvResult.setText(String.valueOf(addition));
                break;
            case R.id.btnSub:
                int subtraction = Integer.parseInt(num1)- Integer.parseInt(num2);
                tvResult.setText(String.valueOf(subtraction));
                break;
            case R.id.btnMult:
                try {
                int multiplication = Integer.parseInt(num1)* Integer.parseInt(num2);
                tvResult.setText(String.valueOf(multiplication));}
                catch (Exception e) {
                tvResult.setText("Cannot be Multiply");
                }
                break;
            case R.id.btnDiv:
                try{
                int division = Integer.parseInt(num1)/ Integer.parseInt(num2);
                tvResult.setText(String.valueOf(division));}
                catch (Exception e) {
                tvResult.setText("Cannot be Divid!");
                }
                break;

        }

    }
}

