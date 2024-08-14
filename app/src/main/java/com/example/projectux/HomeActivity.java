package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends BaseActivity {
    private static float bmi = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        Remove Action Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_home);

//        Navbar Functionalities
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navbar);
        bottomNavigationView.setSelectedItemId(R.id.menu_beranda);

        top_navbar();
        bottom_navbar();

        EditText editTextBerat = findViewById(R.id.beratBadanInput);
        EditText editTextTinggi = findViewById(R.id.tinggiBadanInput);
        Button button = findViewById(R.id.submitBtn);
        TextView textView = findViewById(R.id.resultTv);
        ImageView notifIcon = findViewById(R.id.notificationIcon);
        TextView categoryTextView = findViewById(R.id.categoryBMI);

        if (bmi == -1)
        {
            categoryTextView.setTextColor(Color.RED);
            categoryTextView.setText("Cek skor BMI Anda sekarang!");
            categoryTextView.setTextSize(14);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightStr = editTextTinggi.getText().toString();
                String weightStr = editTextBerat.getText().toString();

                if (heightStr.isEmpty() || weightStr.isEmpty()) {
                    Toast.makeText(HomeActivity.this, "Masukkan tinggi dan berat badan Anda!", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    float height = Float.parseFloat(heightStr) / 100;
                    float weight = Float.parseFloat(weightStr);
                    bmi = weight / (height * height);
                    textView.setText(String.valueOf(bmi));

                    String bmiCategory = getBMICategory(bmi, categoryTextView);
                    categoryTextView.setTextSize(18);
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
            categoryTextView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
            return "Kurus";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            categoryTextView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            return "Normal";
        } else if (bmi >= 24.9 && bmi < 29.9) {
            categoryTextView.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
            return "Gemuk";
        } else {
            categoryTextView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            return "Obesitas";
        }
    }
}