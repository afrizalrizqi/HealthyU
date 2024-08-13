package com.example.projectux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class BaseActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void bottom_navbar()
    {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navbar);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Intent intent;

            switch (item.getItemId())
            {
                case R.id.menu_penjadwalan:
                    Toast.makeText(this, "Penjadwalan", Toast.LENGTH_SHORT).show();
//                    intent = new Intent();
//                    startActivity(intent);
                    break;

                case R.id.menu_beranda:
//                    intent = new Intent();
//                    startActivity(intent);
                    break;

                case R.id.menu_riwayat:
//                    intent = new Intent();
//                    startActivity(intent);
                    break;
            }

            return false;
        });
    }

    protected void top_navbar()
    {
        TextView navbar_username = findViewById(R.id.profile_username);
        ImageView navbar_prof_pic = findViewById(R.id.profile_pic);

        navbar_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        navbar_prof_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}