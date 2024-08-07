package com.example.projectux;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class konfirmasi_jadwal_tes_langsung extends AppCompatActivity {
    private TextView ubah;
    private Button jadwalkanTes;
    private TextView nama;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konfirmasi_jadwal_tes_langsung);

        nama = findViewById(R.id.username);


        jadwalkanTes=findViewById(R.id.jadwalkanTes);

        textView= (TextView)findViewById(R.id.ubahInfo);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(konfirmasi_jadwal_tes_langsung.this, LoginActivity.class);
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
    }
}
