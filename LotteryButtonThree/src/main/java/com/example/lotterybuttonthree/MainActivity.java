package com.example.lotterybuttonthree;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // GUI controls
    private TextView tvText;
    private Button btGenerateText, btGenerateTextTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting references to the two Buttons and the TextView
        btGenerateText = findViewById(R.id.btGenerateText);
        btGenerateTextTwo = findViewById(R.id.btGenerateTextTwo);
        tvText = findViewById(R.id.tvText);

        // Setting Listener to both Buttons
        btGenerateText.setOnClickListener(this);
        btGenerateTextTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btGenerateText:
                tvText.setText("Let's go for some great Swisslos tips!");
                break;
            case R.id.btGenerateTextTwo:
                tvText.setText("Let's go for some great Euro Millions tips!");
        }
    }
}
