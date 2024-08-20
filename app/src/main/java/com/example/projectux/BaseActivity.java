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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseActivity extends AppCompatActivity {
    Toolbar toolbar;
    public static List<Pasien> pasienList = new ArrayList<>();
    public static List<Alamat> alamatList = new ArrayList<>();

    public static Pasien SelectedPasien;
    public static Alamat SelectedAlamat;
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
                    intent = new Intent(this, TesActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.menu_beranda:
                    intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.menu_riwayat:
                    intent = new Intent(this, RiwayatPasienActivity.class);
                    startActivity(intent);
                    return true;
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

    protected void simplified_top_navbar()
    {
        ImageView btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

}