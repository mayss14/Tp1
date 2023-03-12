package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    EditText mad;
    Button convert;
    Spinner curList;
    TextView res;
    RadioGroup curlist;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mad= findViewById(R.id.montant);
        convert= findViewById(R.id.btnconvert);
        res= findViewById(R.id.result);
        curlist = findViewById(R.id.radiogroup);


        res.setText("");



        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double mt = 0.0;
                DecimalFormat df = new DecimalFormat("#.##");

                if(mad.getText().length() >0) {
                    mt = Double.valueOf(mad.getText().toString());
                    Double convertDollar = mt / 10.34;
                    Double convertEuro = mt / 11.01;

                    if(curlist.getCheckedRadioButtonId()== R.id.usdollar)
                    {
                        res.setText(String.valueOf( df.format(convertDollar))+"$");
                    }
                    else if(curlist.getCheckedRadioButtonId()== R.id.euro)
                    {
                        res.setText(String.valueOf( df.format(convertEuro))+"€");
                    }
                }

                //Toast.makeText(getApplicationContext(),convertDollar.toString(),Toast.LENGTH_SHORT).show();




            }
        });


    }
}