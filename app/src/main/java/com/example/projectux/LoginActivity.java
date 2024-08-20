package com.example.projectux;

import android.content.Intent;
import android.graphics.Paint;
import android.hardware.usb.UsbRequest;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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

        //        Remove Action Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

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
//                if(username.getText().toString().equals("")){
//                    Toast.makeText(LoginActivity.this, "Username tidak boleh kosong!", Toast.LENGTH_SHORT).show();
//                }else if (username.getText().toString().length()<5){
//                    Toast.makeText(LoginActivity.this, "Username harus minimal 5 karakter!", Toast.LENGTH_SHORT).show();
//                }else if (password.getText().toString().equals("")) {
//                    Toast.makeText(LoginActivity.this, "Kata Sandi tidak boleh kosong!", Toast.LENGTH_SHORT).show();
//                }else if (password.getText().toString().length()<8){
//                    Toast.makeText(LoginActivity.this, "Kata Sandi harus minimal 8 karakter!", Toast.LENGTH_SHORT).show();
//                }else if (!username.getText().toString().equals(User.user.getUsername()) || !password.getText().toString().equals(User.user.getPassword())){
//                    Toast.makeText(LoginActivity.this, "Username atau Kata Sandi tidak valid!", Toast.LENGTH_SHORT).show();
//                }else{
                    Intent intent =  new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
//                }
            }
        });
    }
}
