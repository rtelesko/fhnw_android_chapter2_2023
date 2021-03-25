package com.example.lotteryspinner;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Constants for tip systems
    static final int EUROMILLIONS_NUMBERS = 5;
    static final int SWISSLOTTERY_NUMBERS = 6;
    // GUI controls
    private TextView tvResult;
    private TextView tvValidation;
    private Spinner spType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get a reference to the Spinner
        spType = findViewById(R.id.spType);
        // Get references to the TextViews
        tvResult = findViewById(R.id.tvResult);
        tvValidation = findViewById(R.id.tvValidation);
    }

    public void generateRandomNumbers(View view) {
        // Get the selected item in the Spinner
        String lotteryType = spType.getSelectedItem().toString();
        // Selecting Lottery
        if (lotteryType.equals("Swiss Lottery"))
            randomLottery(SWISSLOTTERY_NUMBERS);
        else
            randomLottery(EUROMILLIONS_NUMBERS);
    }

    public void randomLottery(int count) {
        // Initialize TextView for numbers
        tvResult.setText("");

        Random random = new Random();

        if (count == SWISSLOTTERY_NUMBERS) {
            int[] numbersSwiss = new int[SWISSLOTTERY_NUMBERS];
            for (int i = 0; i < SWISSLOTTERY_NUMBERS; i++) {
                numbersSwiss[i] = random.nextInt(42) + 1;
                tvResult.append(numbersSwiss[i] + "  ");
            }
            // Check for duplicates in Swiss Lottery array
            if (validationCheck(numbersSwiss)) {
                tvValidation.setTextColor(new Color().parseColor("#008000"));
                tvValidation.setText("Validation OK");
            } else {
                tvValidation.setTextColor(new Color().parseColor("#FF0000"));
                tvValidation.setText("Validation NOT OK - Please make a new try!");
            }

        } else {
            int[] numbersEuro = new int[EUROMILLIONS_NUMBERS];
            for (int i = 0; i < EUROMILLIONS_NUMBERS; i++) {
                numbersEuro[i] = random.nextInt(50) + 1;
                tvResult.append(numbersEuro[i] + "  ");
            }
            // Check for duplicates in EuroMillions Lottery array
            if (validationCheck(numbersEuro)) {
                tvValidation.setTextColor(new Color().parseColor("#008000"));
                tvValidation.setText("Validation OK");
            } else {
                tvValidation.setTextColor(new Color().parseColor("#FF0000"));
                tvValidation.setText("Validation NOT OK - Please make a new try!");
            }
        }

    }

    // Check for duplicates in array
    private boolean validationCheck(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j])
                    return false;  // Not valid: Got a duplicate element
            }
        }
        return true;    // Valid tip
    }
}