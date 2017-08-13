package com.example.hartono.project;

import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Hartono on 2017/7/8.
 */

public class EditFilm1 extends AppCompatActivity {
    DataBaseHelper db;
    EditText judul,genre,pemain,jams1,jams2,jams3,jams4,tb,sinopsis;
    Spinner negara;
    SeekBar rat;
    byte[] imagess;
    public static final int SELECT_PICTURE=0;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editfilm1);
        db= new DataBaseHelper(this);
        imageView = (ImageView) findViewById(R.id.imageView);
        judul= (EditText) findViewById(R.id.judul);
        genre= (EditText) findViewById(R.id.genre);
        pemain= (EditText) findViewById(R.id.pemain);
        negara = (Spinner)findViewById(R.id.negara);
        rat = (SeekBar) findViewById(R.id.seekBar);
        jams1= (EditText)findViewById(R.id.jam1);
        jams2= (EditText)findViewById(R.id.jam2);
        jams3= (EditText)findViewById(R.id.jam3);
        jams4= (EditText)findViewById(R.id.jam4);
        tb= (EditText)findViewById(R.id.tanggalBertahan);
        sinopsis= (EditText)findViewById(R.id.synopsis);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK) {
            try {
                Uri image = data.getData();
                InputStream imageStream = null;
                imageStream = getContentResolver().openInputStream(image);
                Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imageView.setImageBitmap(selectedImage);
                imagess= getBytes(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectImage(View arg0) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }
    // convert from bitmap to byte array
    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    public void done (View view) {
        String title = judul.getText().toString();
        String jenre = genre.getText().toString();
        String player = pemain.getText().toString();
        String negara1 = negara.getSelectedItem().toString();
        int value = rat.getProgress();
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(value);
        String ratt= stringBuffer.toString();
        String time1 = jams1.getText().toString();
        String time2 = jams2.getText().toString();
        String time3 = jams3.getText().toString();
        String time4 = jams4.getText().toString();
        String bertahan = tb.getText().toString();
        String sinops = sinopsis.getText().toString();
        Bundle extras = getIntent().getExtras();
        int iden = extras.getInt("id");
        String ss = "0";
        if (iden == 1) ss = "1";
        if (iden == 2) ss = "2";
        if (iden == 3) ss = "3";
        if (iden == 4) ss = "4";

        if (db.insertData(ss,title, jenre, player,negara1,ratt,time1,time2,time3,time4,bertahan,sinops,imagess)) {
            Cursor res= db.getAllData();
            int x=res.getCount();
            StringBuffer sx=new StringBuffer();
            sx.append(x);
            Toast.makeText(this, sx, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "data gagal masuk", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

}