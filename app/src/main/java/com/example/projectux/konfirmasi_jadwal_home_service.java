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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class konfirmasi_jadwal_home_service extends BaseActivity {
    private TextView ubah;
    private Button jadwalkanTes;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.konfirmasi_jadwal_home_service);

        top_navbar();
        bottom_navbar();

        jadwalkanTes=findViewById(R.id.jadwalkanTes);

        textView= (TextView)findViewById(R.id.ubahInfo);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(konfirmasi_jadwal_home_service.this, UbahInformasiPasienActivity.class);
                intent.putExtra("returnTo", "konfirmasi_jadwal_home_service");
                startActivity(intent);
            }
        });

        jadwalkanTes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(konfirmasi_jadwal_home_service.this,SuccessActivity.class);
                startActivity(intent);
            }
        });

        TextView ubahInfoAlamat = findViewById(R.id.ubahInfoAlamat);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        ubahInfoAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(konfirmasi_jadwal_home_service.this, UbahAlamatActivity.class);
                startActivity(intent);
            }
        });

        TesPasien tesPasien = TesPasienHolder.getInstance().getTesPasien();
        String namaTes = tesPasien.getNamaTes();
        String tanggalTes = tesPasien.getTanggal();
        String jamTes = tesPasien.getWaktu();

        TextView namaTesView = findViewById(R.id.namaTes);
        TextView tanggalTesView = findViewById(R.id.tanggalTes);
        TextView jamTesView = findViewById(R.id.jamTes);

        namaTesView.setText(namaTes);
        tanggalTesView.setText(tanggalTes);
        jamTesView.setText(jamTes);



//        SelectedAlamat = (Alamat) getIntent().getSerializableExtra("selectedAlamat");
        TextView namaAlamat = findViewById(R.id.namaLokasi);
        TextView alamatLengkap = findViewById(R.id.alamat);
        if (SelectedAlamat == null) {
            SelectedAlamat = alamatList.get(alamatList.size()-1);
        }
        namaAlamat.setText(SelectedAlamat.getNama_alamat());
        alamatLengkap.setText(SelectedAlamat.getAlamat_lengkap());

//        SelectedPasien = (Pasien) getIntent().getSerializableExtra("selectedPasien");
        if (SelectedPasien == null) {
            SelectedPasien = pasienList.get(pasienList.size()-1);
        }
        TextView namaUser = findViewById(R.id.namaUser);
        TextView nikUser = findViewById(R.id.nikUser);
        TextView noTelp = findViewById(R.id.noTelp);
        TextView gender = findViewById(R.id.gender);

        namaUser.setText(SelectedPasien.getNama());
        nikUser.setText(SelectedPasien.getNIK());
        noTelp.setText(SelectedPasien.getNo_telp());
        gender.setText(SelectedPasien.getGender());

    }
}
