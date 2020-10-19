package com.example.a5r_app;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    

    Button product;
    Button label;
    Button recycling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        product = findViewById(R.id.product);
        label = findViewById(R.id.label);
        recycling = findViewById(R.id.recycling);

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProductSelection.class);

                startActivity(intent);
            }
        });
        label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScanLabel.class);
                startActivity(intent);
            }
        });

        recycling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclingInformation.class);
                startActivity(intent);
            }
        });

    }


}