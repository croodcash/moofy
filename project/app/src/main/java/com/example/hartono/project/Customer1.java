package com.example.hartono.project;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Hartono on 2017/7/8.
 */

public class Customer1 extends AppCompatActivity {
    public int pilihan=0;
    TextView[] jdl=new TextView[5];
    TextView[] jam=new TextView[20];
    Cursor res;
    DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer1);
        /*jdl[1]=(TextView) findViewById(R.id.jdl1);
        jdl[2]=(TextView) findViewById(R.id.jdl2);
        jdl[3]=(TextView) findViewById(R.id.jdl3);
        jdl[4]=(TextView) findViewById(R.id.jdl4);
        db= new DataBaseHelper(this);
        res= db.getAllData();
        for(int a=1; a<=4;a++) {
            if (res != null && res.getCount() > 0 && cari(a)) {
                jdl[a].setText(res.getString(1));
                for (int b=1; b<=4;b++)
                    jam[b].setText(res.getString(b+5));
            }
        }*/

    }

    public Boolean cari(int ids) {
        int zz=1;
        res.moveToFirst();
        for (int i=1;i<=res.getCount();i++) {
            if (i==1) continue;
            res.moveToNext();
            if (res.getInt(0)==ids) zz=i;

        }
        if (zz==1 && res.getInt(0)!=ids)
            return false;
        else {
            res.moveToFirst();
            for (int i=1;i<zz;i++) {
                res.moveToNext();
            }
            return true;
        }
    }

    public void order (View v){
        Intent intent =  new Intent(this,Order.class);
        startActivity(intent);
    }
    public void view1 (View v){
        pilihan=1;
        Intent intent =  new Intent(this,ViewMovie.class);
        startActivity(intent);
    }
    public void view2 (View v){
        pilihan=2;
        Intent intent =  new Intent(this,ViewMovie.class);
        startActivity(intent);
    }
    public void view3 (View v){
        pilihan=3;
        Intent intent =  new Intent(this,ViewMovie.class);
        startActivity(intent);
    }
    public void view4 (View v){
        pilihan=4;
        Intent intent =  new Intent(this,ViewMovie.class);
        startActivity(intent);
    }

}
