package com.cmt.taxcalculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class IncomeActivity extends AppCompatActivity {

    EditText et;
    TextView tx;
    TextView tx1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        et=findViewById(R.id.edit1);
        tx=findViewById(R.id.text1);
        tx1=findViewById(R.id.text2);
        b1=findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Integer.parseInt(String.valueOf(et.getText()));
                    calculate();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "You have exceeded the Input Limit!", Toast.LENGTH_LONG).show();
                    tx1.setText("");
                }
            }
        });
    }


    @SuppressLint("SetTextI18n")
    public void calculate()
    {
        long Total = 0;
        long Tax=0;
        long in= Integer.parseInt(et.getText().toString());
        if (in >= 200000 && in < 1000000)
        {
            Tax= (in * 5)/100;
            Total = in + Tax;
        }
        else if(in >= 1000000 && in < 2000000)
        {
            Tax = (in * 10)/100;
            Total = in + Tax;
        }
        else if(in >= 2000000 && in < 3000000)
        {
            Tax= (in * 15)/100;
            Total = in + Tax;
        }
        else if (in >= 3000000 && in < 4000000)
        {
            Tax = (in * 20)/100;
            Total = in + Tax;
        }
        else if(in >= 4000000 && in < 5000000)
        {
            Tax = (in * 25)/100;
            Total = in + Tax;
        }
        else if (in >= 5000000 && in < 7000000)
        {
            Tax = (in * 30)/100;
            Total = in + Tax;
        }
        else if (in >= 7000000 && in < 10000000)
        {
            Tax = (in * 35)/100;
            Total = in + Tax;
        }
        else if (in >= 10000000)
        {
            Tax = (in * 40)/100;
            Total = in + Tax;
        }
        tx1.setText("Tax on your income "+et.getText()+"= \t"+Tax+"\n \n"+
                "Total Income (Inclusion of Tax) "+"= \t"+Total);
    }
}
