package com.example.lotteryonetip;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // GUI controls
    private Button btGenerateNumbers;
    private TextView tvResult;
    private TextView tvValidation;

    static final int LOTTO_NUMBERS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference to the Button
        btGenerateNumbers = findViewById(R.id.btGenerateNumbers);
        // Get references to the TextViews which show the numbers and the validation result
        tvResult = findViewById(R.id.tvResult);
        tvValidation = findViewById(R.id.tvValidation);

        // Event Handler with Anonymous Inner Class
        btGenerateNumbers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tvResult.setText("");      // Initialize TextView for numbers
                tvValidation.setText("");      // Initialize TextView for validation
                Random random = new Random();
                int numbers[] = new int[LOTTO_NUMBERS];
                for (int i = 0; i < LOTTO_NUMBERS; i++) {
                    numbers[i] = random.nextInt(50) + 1;
                    tvResult.append(numbers[i] + "  ");
                }
                if (validationCheck(numbers)) {
                    tvValidation.setTextColor(new Color().parseColor("#008000"));
                    tvValidation.setText("Validation OK");
                } else {
                    tvValidation.setTextColor(new Color().parseColor("#FF0000"));
                    tvValidation.setText("Validation NOT OK - Please make a new try!");
                }
            }
        });

    }

    // Check for duplicates in array
    private boolean validationCheck(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j])
                    return false;  // Not valid: Got a duplicate element
            }
        }
        return true; // Valid tip
    }
}