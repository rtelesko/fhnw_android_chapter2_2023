package com.example.lotterybuttonone;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // GUI control
    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void generateText(View view) {
        // Get reference to the TextView
        tvText = findViewById(R.id.tvText);
        tvText.setText("Let's go for some tips!");
    }
}
