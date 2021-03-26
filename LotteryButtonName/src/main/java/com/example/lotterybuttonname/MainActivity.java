package com.example.lotterybuttonname;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // GUI controls
    private EditText etName;
    private Button btDisplayName;
    private Button btCancel;
    private TextView tvName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get references to the EditText, two Buttons and TextView
        etName = findViewById(R.id.etName);
        btDisplayName = findViewById(R.id.btDisplayName);
        btCancel = findViewById(R.id.btCancel);
        tvName = findViewById(R.id.tvName);

        btDisplayName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etName.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter a name!", Toast.LENGTH_SHORT).show();
                else tvName.setText("Hello " + etName.getText().toString());
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                tvName.setText("");
            }
        });
    }
}
