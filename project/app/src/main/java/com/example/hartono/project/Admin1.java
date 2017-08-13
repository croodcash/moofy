package com.example.hartono.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Hartono on 2017/7/8.
 */

public class Admin1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin1);
    }
    public void edit (View view){
        Intent intent =  new Intent(Admin1.this,EditBioskop.class);
        startActivity(intent);
    }
    public void overview (View view){
        Intent intent =  new Intent(Admin1.this,OverviewBioskop.class);
        startActivity(intent);
    }
    public void tiketTerjual (View view){
        Intent intent =  new Intent(Admin1.this,TiketTerjual.class);
        startActivity(intent);
    }

}
