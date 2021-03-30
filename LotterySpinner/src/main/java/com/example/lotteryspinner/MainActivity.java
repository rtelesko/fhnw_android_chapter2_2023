package com.example.lotteryspinner;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    // Constants for tip systems
    static final int EUROMILLIONS_NUMBERS = 5;
    static final int SWISSLOTTERY_NUMBERS = 6;
    static final int SWISSLOTTERY_NUMBER_LIMIT = 42;
    static final int EUROMILLIONS_NUMBER_LIMIT = 50;

    // GUI controls
    private TextView tvResult;
    private TextView tvValidation;
    private Spinner spType;

    private boolean useStreams = false;

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

            if (useStreams) {
                // stream version - creates unique values, sorts them and puts each value on the textfield
                // no validation required since the stream always returns unique values
                new Random().ints(SWISSLOTTERY_NUMBERS, 1, SWISSLOTTERY_NUMBER_LIMIT).distinct().sorted().forEach(val -> tvResult.append(" " + val));
            } else {
                // conventional array version
                int[] numbersSwiss = new int[SWISSLOTTERY_NUMBERS];
                for (int i = 0; i < SWISSLOTTERY_NUMBERS; i++) {
                    numbersSwiss[i] = random.nextInt(SWISSLOTTERY_NUMBER_LIMIT) + 1;
                    tvResult.append(numbersSwiss[i] + "  ");
                }
                // Check for duplicates in Swiss Lottery array
                if (validationCheck(numbersSwiss)) {
                    setValidationTextField(true);
                } else {
                    setValidationTextField(false);
                }
            }

        } else {

            if (useStreams) {
                // same same but with euromillions
                new Random().ints(EUROMILLIONS_NUMBERS, 1, EUROMILLIONS_NUMBER_LIMIT).distinct().sorted().forEach(val -> tvResult.append(" " + val));
            } else {
                int[] numbersEuro = new int[EUROMILLIONS_NUMBERS];
                for (int i = 0; i < EUROMILLIONS_NUMBERS; i++) {
                    numbersEuro[i] = random.nextInt(EUROMILLIONS_NUMBER_LIMIT) + 1;
                    tvResult.append(numbersEuro[i] + "  ");
                }
                // Check for duplicates in EuroMillions Lottery array
                if (validationCheck(numbersEuro)) {
                    setValidationTextField(true);
                } else {
                    setValidationTextField(false);
                }
            }
        }
    }

    private void setValidationTextField(boolean validated){
        if (validated){
            //tvValidation.setTextColor(new Color().GREEN);
            tvValidation.setTextColor(new Color().parseColor("#008000"));
            tvValidation.setText("Validation OK");
        } else {
            //tvValidation.setTextColor(new Color().RED);
            tvValidation.setTextColor(new Color().parseColor("#FF0000"));
            tvValidation.setText("Validation NOT OK - Please make a new try!");
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