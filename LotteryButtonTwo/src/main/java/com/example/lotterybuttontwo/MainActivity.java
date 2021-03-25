package com.example.lotterybuttontwo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // GUI controls
    private TextView tvText;
    private Button btGenerateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting references to the Button and the TextView
        btGenerateText = findViewById(R.id.btGenerateText);
        tvText = findViewById(R.id.tvText);
        // Anonymous inner class
        btGenerateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvText.setText("Let's go for some tips!");
            }
        });
    }
}
