package com.example.projectux;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    TextInputEditText editTextUsername, editTextPassword;
    TextView textView;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password = findViewById(R.id.password);
        login=findViewById(R.id.login);

        textView= (TextView)findViewById(R.id.ke_register);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Username tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }else if (username.getText().toString().length()<5){
                    Toast.makeText(LoginActivity.this, "Username harus lebih dari 5!", Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Kata Sandi tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().length()<8){
                    Toast.makeText(LoginActivity.this, "Kata Sandi harus lebih dari 8!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent =  new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
