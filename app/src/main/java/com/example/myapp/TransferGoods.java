package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TransferGoods extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_transfer_goods);

        // Set the status bar color
        //  getWindow().setStatusBarColor(getResources().getColor(R.color.customStatusBarColor));
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));

        // Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set custom title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Transfer Goods");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable back button
            // Change the back arrow color
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow); // Set the custom back arrow
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText inputField = findViewById(R.id.et_message);
        Button sendOrder = findViewById(R.id.btn_sendOrder);
        sendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputText = inputField.getText().toString().trim();
                //  Check the condition
                if (inputText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter your delivery instruction", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Order submitted successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}