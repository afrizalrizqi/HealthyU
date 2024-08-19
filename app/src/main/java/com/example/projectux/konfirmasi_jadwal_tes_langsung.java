package com.example.projectux;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class konfirmasi_jadwal_tes_langsung extends BaseActivity {
    private TextView ubah;
    private Button jadwalkanTes;
    private TextView nama;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.konfirmasi_jadwal_tes_langsung);
        TesPasien tesPasien = TesPasienHolder.getInstance().getTesPasien();
        String SelectedLab = TesPasienHolder.getInstance().getLabName();
        String testName = tesPasien.getNamaTes();
        String labName = SelectedLab;
        String bookingDay = tesPasien.getTanggal();
        String bookingTime = tesPasien.getWaktu();
        String alamat = tesPasien.getLokasi();

        top_navbar();
        bottom_navbar();

        nama = findViewById(R.id.username);

        jadwalkanTes=findViewById(R.id.jadwalkanTes);

        textView= (TextView)findViewById(R.id.ubahInfo);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(konfirmasi_jadwal_tes_langsung.this, UbahInformasiPasienActivity.class);
                intent.putExtra("returnTo", "konfirmasi_jadwal_tes_langsung");
                startActivity(intent);
            }
        });

        jadwalkanTes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(konfirmasi_jadwal_tes_langsung.this,MainActivity.class);
                startActivity(intent);
            }
        });



        Pasien selectedPasien = (Pasien) getIntent().getSerializableExtra("selectedPasien");
        if (selectedPasien != null) {
            SelectedPasien = selectedPasien;
        } else {
            SelectedPasien = pasienList.get(0);
        }

        TextView namaUser = findViewById(R.id.namaUser);
        TextView nikUser = findViewById(R.id.nikUser);
        TextView noTelp = findViewById(R.id.noTelp);
        TextView gender = findViewById(R.id.gender);

        namaUser.setText(SelectedPasien.getNama());
        nikUser.setText(SelectedPasien.getNIK());
        noTelp.setText(SelectedPasien.getNo_telp());
        gender.setText(SelectedPasien.getGender());


        Button jadwalkanTes = findViewById(R.id.jadwalkanTes);

        TextView namaTes = findViewById(R.id.namaTes);
        TextView namaLab = findViewById(R.id.namaLab);
        TextView tanggalTes = findViewById(R.id.tanggalTes);
        TextView waktuTes = findViewById(R.id.jamTes);
        TextView alamatLab = findViewById(R.id.alamat);

        namaTes.setText(testName);
        namaLab.setText(labName);
        tanggalTes.setText(bookingDay);
        waktuTes.setText(bookingTime);
        alamatLab.setText(alamat);

        jadwalkanTes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(konfirmasi_jadwal_tes_langsung.this, SuccessActivity.class);
                startActivity(intent);
            }
        });
    }

}
