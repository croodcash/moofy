package com.example.hartono.project;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Hartono on 2017/7/8.
 */

public class TiketTerjual extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiketterjual);
    }
    public void done1 (View v){
        finish();
    }
}
