package com.example.hartono.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Hartono on 2017/7/8.
 */

public class Login extends AppCompatActivity {
    EditText text1,text2;
    String email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void login(View view) {
        text1 = (EditText) findViewById(R.id.email);
        text2 = (EditText) findViewById(R.id.password);
        email = text1.getText().toString();
        pass = text2.getText().toString();

        if ((email.contains("croodcash@gmail.com"))&&((pass.contains("asalketikaja")))) {
            Toast.makeText(this, "login berhasil yey", Toast.LENGTH_SHORT).show();
            Intent intent =  new Intent(Login.this,Admin1.class);
            startActivity(intent);
        }
        else if ((email.matches("")||pass.matches("")))
        {
            Toast.makeText(this, "Isikan Email dan Password", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Email/Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

}
