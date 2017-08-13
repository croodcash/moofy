package com.example.hartono.project;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hartono on 2017/7/8.
 */

public class EditBioskop extends AppCompatActivity {
    public DataBaseHelper db;
    int id=0;
    Cursor res;
    public  TextView txtResult1,txtResult2,txtResult3,txtResult4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editbioskop);
        viewFromDB();
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

    public void viewFromDB(){
        db= new DataBaseHelper(this);
        txtResult1= (TextView) findViewById(R.id.judul1);
        txtResult2= (TextView) findViewById(R.id.judul2);
        txtResult3= (TextView) findViewById(R.id.judul3);
        txtResult4= (TextView) findViewById(R.id.judul4);
        res=db.getAllData();
       if (res!=null && res.getCount()>0 && cari(1)) {
            txtResult1.setText(res.getString(1));
        }
        if (res!=null && res.getCount()>0 && cari(2)) {
            txtResult2.setText(res.getString(1));
        }
        if (res!=null && res.getCount()>0 && cari(3)) {
            txtResult3.setText(res.getString(1));
        }
        if (res!=null && res.getCount()>0 && cari(4)) {
            txtResult4.setText(res.getString(1));
        }

    }

    public void editfilm1 (View view){
        id=1;
        Intent intent =  new Intent(EditBioskop.this,EditFilm1.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
    public void editfilm2 (View view){
        id=2;
        Intent intent =  new Intent(EditBioskop.this,EditFilm1.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
    public void editfilm3 (View view){
        id=3;
        Intent intent =  new Intent(EditBioskop.this,EditFilm1.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
    public void editfilm4 (View view){
        id=4;
        Intent intent =  new Intent(EditBioskop.this,EditFilm1.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }


}
