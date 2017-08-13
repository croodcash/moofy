package com.example.hartono.project;

/**
 * Created by Hartono on 2017/7/8.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SpashScreen extends Activity {
    private static int splashInterval = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.spashscreen);
        new Handler().postDelayed(new Runnable() {
        @Override
        public void run () {
            Intent i = new Intent(SpashScreen.this, MainActivity.class);
            startActivity(i);
        }
        }, splashInterval);
    };
}

