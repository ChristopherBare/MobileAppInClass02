package com.christopherbare.inclass2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Currency Converter");

        final EditText currencyInput = findViewById(R.id.CurrencyValue);
        final TextView result = (TextView) findViewById(R.id.ResultText);
        final String resultText = "Result: ";


        Button eur = (Button) findViewById(R.id.button);
        eur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("demo", "EUR button Clicked.");
                if (currencyInput.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a number to start!",
                            Toast.LENGTH_SHORT).show();
                } else if (currencyInput.getText().toString().trim().equals(".")) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid number!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    double input = Double.parseDouble(currencyInput.getText().toString());
                    double convert = input * 0.87;
                    result.setText(resultText + formatEuro(convert)+ " " + getString(R.string.eur));
                }
            }
        });

        Button cad = (Button) findViewById(R.id.button2);
        cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("demo", "CAD button Clicked.");
                if (currencyInput.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a number to start!",
                            Toast.LENGTH_SHORT).show();
                } else if (currencyInput.getText().toString().trim().equals(".")) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid number!",
                            Toast.LENGTH_SHORT).show();
                }else {
                    double input = Double.parseDouble(currencyInput.getText().toString());
                    double convert = input * 1.30;
                    result.setText(resultText + formatCanadian(convert) + " " + getString(R.string.cad));
                }
            }
        });

        Button clear = (Button) findViewById(R.id.button3);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("demo", "CAD button Clicked.");
                currencyInput.setText("");
                result.setText(resultText);
            }
        });


    }

    public String format(double value) {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(value));
    }

    //Formats Euro currency
    public String formatEuro(double value) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.ITALY);
        String formattedEuroString = format.format(value);
        return formattedEuroString;
    }

    //Formats Canadian currency
    public String formatCanadian(double value) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String formattedCanString = format.format(value);
        return formattedCanString;
    }
}
