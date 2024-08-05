package com.example.projectux;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText namalengkap;
    private EditText nik;
    private EditText email;
    private EditText password;
    private Button register;
    private TextView cek_akun;
    TextView textView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        namalengkap=findViewById(R.id.namalengkap);
        nik=findViewById(R.id.nik);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);


        textView= (TextView)findViewById(R.id.ke_login);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

//        TextView ke_login = findViewById(R.id.underline);

//        cek_akun.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Selamat Datang di Login!", Toast.LENGTH_SHORT).show();
//                Intent intent =  new Intent(MainActivity.this,LoginActivity.class);
//                startActivity(intent);
//            }
//        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Username tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }else if (username.getText().toString().length()<5){
                    Toast.makeText(MainActivity.this, "Username harus lebih dari 5!", Toast.LENGTH_SHORT).show();
                } else if (namalengkap.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Nama Lengkap tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (nik.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "NIK tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (email.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Email tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (!email.getText().toString().contains("@gmail.com")) {
                    Toast.makeText(MainActivity.this, "Email harus memiliki @gmail.com!", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Kata Sandi tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().length()<8){
                    Toast.makeText(MainActivity.this, "Kata Sandi harus lebih dari 8!", Toast.LENGTH_SHORT).show();
                } else{
                    AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                    dialog.setTitle("Konfirmasi");
                    dialog.setMessage("Apakah data sudah benar?");
                    dialog.setButton(DialogInterface.BUTTON_POSITIVE, "YA", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "Akun telah berhasil dibuat!", Toast.LENGTH_SHORT).show();
                            Intent intent =  new Intent(MainActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                    });
                    dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "TUTUP", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                }
            }
        });
    }
}
