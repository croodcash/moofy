package com.example.hartono.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hartono on 2017/7/22.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE bioskop" + "( id INTEGER, " +
                "judul TEXT, genre TEXT, pemain TEXT , negara TEXT, popularitas TEXT, jam1 TEXT, jam2 TEXT, jam3 TEXT, jam4 TEXT," +
                "bertahan TEXT, sinopsis TEXT, gambar BLOB, saran TEXT, jmlpenonton INTEGER DEFAULT 0 )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS bioskop");
        onCreate(db);
    }

    public boolean insertData(String id,String judul,String genre,String pemain,String negara,String popularitas, String jam1,String jam2,String jam3,String jam4 ,String bertahan,String sinopsis,byte[] gambar){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put("id",id);
        contentValue.put("judul",judul);
        contentValue.put("genre",genre);
        contentValue.put("pemain",pemain);
        contentValue.put("negara",negara);
        contentValue.put("popularitas",popularitas);
        contentValue.put("jam1",jam1);
        contentValue.put("jam2",jam2);
        contentValue.put("jam3",jam3);
        contentValue.put("jam4",jam4);
        contentValue.put("bertahan",bertahan);
        contentValue.put("sinopsis",sinopsis);
        contentValue.put("gambar",gambar);
        long result = db.insert("bioskop",null,contentValue);
        db.close();
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor res= db.rawQuery("Select * from bioskop",null);
        return res;
    }
}
