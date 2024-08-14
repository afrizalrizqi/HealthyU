package com.example.projectux;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class TambahPasienActivity extends AppCompatActivity {
    private EditText txt_nama;
    private EditText txt_nik;
    private EditText txt_no_telp;
    private RadioButton rd_laki;
    private RadioButton rd_perempuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pasien);
    }
}