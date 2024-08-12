package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
        ImageView notifIcon = findViewById(R.id.notificationIcon);
        TextView categoryTextView = findViewById(R.id.categoryBMI);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightStr = editTextTinggi.getText().toString();
                String weightStr = editTextBerat.getText().toString();

                if (heightStr.isEmpty() || weightStr.isEmpty()) {
                    Toast.makeText(HomeActivity.this, "Please enter both height and weight", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    float height = Float.parseFloat(heightStr) / 100;
                    float weight = Float.parseFloat(weightStr);
                    float bmi = weight / (height * height);
                    textView.setText(String.valueOf(bmi));

                    String bmiCategory = getBMICategory(bmi, categoryTextView);
                    categoryTextView.setText(bmiCategory);
                } catch (NumberFormatException e) {
                    Toast.makeText(HomeActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        notifIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });
    }

    private String getBMICategory(float bmi, TextView categoryTextView){
        if (bmi < 18.5){
            categoryTextView.setTextColor(getResources().getColor(android.R.color.holo_blue_light));
            return "Kurus";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            categoryTextView.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            return "Normal";
        } else if (bmi >= 24.9 && bmi < 29.9) {
            categoryTextView.setTextColor(getResources().getColor(android.R.color.holo_orange_light));
            return "Gemuk";
        } else {
            categoryTextView.setTextColor(getResources().getColor(android.R.color.holo_red_light));
            return "Obesitas";
        }
    }
}