package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.security.Key;

public class ProfileActivity extends BaseActivity {
    private EditText txt_username;
    private EditText txt_nama_lengkap;
    private EditText txt_nik;
    private EditText txt_email;
    private EditText txt_nomor_telepon;
    private TextView txt_alamat;
    private TextView txt_detail_alamat;
    private TextView link_ubah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        Remove Action Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_profile);

//        Navbar Functionalities
        simplified_top_navbar();

        txt_username = findViewById(R.id.txt_username);
        txt_nama_lengkap = findViewById(R.id.txt_nama_lengkap);
        txt_nik = findViewById(R.id.txt_nik);
        txt_email = findViewById(R.id.txt_email);
        txt_nomor_telepon = findViewById(R.id.txt_nomor_telepon);
//        txt_alamat = findViewById(R.id.txt_nama_alamat);
//        txt_detail_alamat = findViewById(R.id.txt_detail_alamat);
        link_ubah = findViewById(R.id.link_ubah);

//        Set Text
        txt_username.setText(User.user.getUsername());
        txt_nama_lengkap.setText(User.user.getNama_lengkap());
        txt_nik.setText(User.user.getNik());
        txt_email.setText(User.user.getEmail());


        if (User.user.getNomor_telepon() == null)
        {
            txt_nomor_telepon.setHint("Lengkapi Nomor Telepon!");
            txt_nomor_telepon.setHintTextColor(Color.RED);
        } else
        {
            txt_nomor_telepon.setText(User.user.getNomor_telepon());
        }

//        if (User.user.getAlamat() == null || User.user.getDetail_alamat() == null)
//        {
//            txt_alamat.setText("Lengkapi Alamatmu!");
//            txt_alamat.setTextColor(Color.RED);
//        } else
//        {
//            txt_alamat.setText(User.user.getAlamat());
//            txt_detail_alamat.setText(User.user.getDetail_alamat());
//        }

        txt_nik.setEnabled(false);

        txt_nomor_telepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_nomor_telepon.setTextColor(getResources().getColor(R.color.black));
            }
        });

        link_ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link_ubah.setTextColor(getResources().getColor(R.color.primary_color));

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        link_ubah.setTextColor(Color.BLACK);
                    }
                }, 500);

                String username = txt_username.getText().toString();
                String nama_lengkap = txt_nama_lengkap.getText().toString();
                String email = txt_email.getText().toString();
                String nomor_telepon = txt_nomor_telepon.getText().toString();

                if (txt_username.getText().toString().equals("") || txt_username.getText().toString().equals(" "))
                {
                    Toast.makeText(ProfileActivity.this, "Username wajib diisi!", Toast.LENGTH_SHORT).show();
                } else if (txt_username.getText().toString().length() < 5)
                {
                    Toast.makeText(ProfileActivity.this, "Username harus minimal 5 karakter!", Toast.LENGTH_SHORT).show();
                } else if (txt_nama_lengkap.getText().toString().equals("") || txt_nama_lengkap.getText().toString().equals(" "))
                {
                    Toast.makeText(ProfileActivity.this, "Nama Lengkap wajib diisi!", Toast.LENGTH_SHORT).show();
                } else if (txt_email.getText().toString().equals("") || txt_email.getText().toString().equals(" "))
                {
                    Toast.makeText(ProfileActivity.this, "Email wajib diisi!", Toast.LENGTH_SHORT).show();
                } else if (!txt_email.getText().toString().endsWith("@gmail.com"))
                {
                    Toast.makeText(ProfileActivity.this, "Email harus berakhiran @gmail.com!", Toast.LENGTH_SHORT).show();
                } else if (txt_nomor_telepon.getText().toString().equals("") || txt_nomor_telepon.getText().toString().contains(" "))
                {
                    Toast.makeText(ProfileActivity.this, "Nomor Telepon wajib diisi!", Toast.LENGTH_SHORT).show();
                } else if (!txt_nomor_telepon.getText().toString().startsWith("08") || txt_nomor_telepon.getText().length() < 10)
                {
                    Toast.makeText(ProfileActivity.this, "Nomor Telepon tidak valid!", Toast.LENGTH_SHORT).show();
                } else {
                    User.user.setUsername(username);
                    User.user.setNama_lengkap(nama_lengkap);
                    User.user.setEmail(email);
                    User.user.setNomor_telepon(nomor_telepon);

                    Toast.makeText(ProfileActivity.this, "Profil berhasil diubah!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}