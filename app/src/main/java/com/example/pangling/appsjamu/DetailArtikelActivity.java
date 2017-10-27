package com.example.pangling.appsjamu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailArtikelActivity extends AppCompatActivity {

    TextView tj,tk;
    ImageView im;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artikel);

        tk = (TextView) findViewById(R.id.tvIsiKonten);
        tj = (TextView) findViewById(R.id.tvJudul);
        im = (ImageView) findViewById(R.id.imgKonten);

        Intent intent = getIntent();
        String judul = intent.getStringExtra("judul");
        String konten = intent.getStringExtra("konten");
        String gambar = intent.getStringExtra("gambar");

        tk.setText(konten);
        tj.setText(judul);
        Picasso.with(context).load(gambar).into(im);
    }
}
