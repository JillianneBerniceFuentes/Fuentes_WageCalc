package com.example.wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText one,two,three,four;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                one.setText("");
                two.setText("");
                three.setText("");
                four.setText("");
                four.requestFocus();
                Toast.makeText(MainActivity.this, "Fields cleared", Toast.LENGTH_SHORT).show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (one.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter the salary", Toast.LENGTH_SHORT).show();
                    return;
                }

                double salary = Double.parseDouble(one.getText().toString());
                double tax;

                if (salary > 50000) {
                    tax = salary * 0.10;
                } else if (salary > 30000) {
                    tax = salary * 0.05;
                } else {
                    tax = 0;
                }

                two.setText(String.valueOf(tax));
                double netSalary = salary - tax;
                three.setText(String.valueOf(netSalary));
                Toast.makeText(MainActivity.this, "Calculation completed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}