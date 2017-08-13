package com.example.hartono.project;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hartono on 2017/7/8.
 */

public class OverviewBioskop extends AppCompatActivity {
    DataBaseHelper db;
    TextView jdl1,jdl2,jdl3,jdl4;
    Cursor res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overviewbioskop);
        db= new DataBaseHelper(this);
        jdl1= (TextView) findViewById(R.id.judul1);
        jdl2= (TextView) findViewById(R.id.judul2);
        jdl3= (TextView) findViewById(R.id.judul3);
        jdl4= (TextView) findViewById(R.id.judul4);
        res=db.getAllData();
        if (res!=null && res.getCount()>0 && cari(1))
            jdl1.setText(res.getString(1));
        if (res!=null && res.getCount()>0 && cari(2))
            jdl2.setText(res.getString(1));
        if (res!=null && res.getCount()>0 && cari(3))
            jdl3.setText(res.getString(1));
        if (res!=null && res.getCount()>0 && cari(4))
            jdl4.setText(res.getString(1));
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

    // convert from byte array to bitmap
  /*  public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }*/

}
