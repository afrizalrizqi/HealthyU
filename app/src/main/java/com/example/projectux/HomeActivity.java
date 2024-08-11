package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        EditText editTextBerat = findViewById(R.id.beratBadanInput);
        EditText editTextTinggi = findViewById(R.id.tinggiBadanInput);
        Button button = findViewById(R.id.submitBtn);
        TextView textView = findViewById(R.id.resultTv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightStr = editTextTinggi.getText().toString();
                String weightStr = editTextBerat.getText().toString();

                if (heightStr.isEmpty() || weightStr.isEmpty()) {
                    Toast.makeText(HomeActivity.this, "Masukkan Berat Badan dan Tinggi Badan", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    float tinggi = Float.parseFloat(String.valueOf(editTextTinggi.getText())) / 100;
                    float berat = Float.parseFloat(String.valueOf(editTextBerat.getText()));
                    float bmi = berat/ (tinggi * tinggi);

                    textView.setText(String.valueOf(bmi));
                } catch (NumberFormatException e){
                    Toast.makeText(HomeActivity.this, "Input salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}