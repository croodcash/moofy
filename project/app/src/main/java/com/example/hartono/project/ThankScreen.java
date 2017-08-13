package com.example.hartono.project;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Hartono on 2017/7/8.
 */

public class ThankScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankscreen);
    }
    public void payed(View view){
        Intent intent =  new Intent(this,Order.class);
        startActivity(intent);
    }
}