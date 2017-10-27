package com.example.pangling.appsjamu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityMenu extends AppCompatActivity {

    Button konsul,history,artikel;
    Intent it = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_menu);

        konsul = (Button) findViewById(R.id.btnKonsultasi);
        konsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it = new Intent(ActivityMenu.this,KonsultasiActivity.class);
                startActivity(it);
            }
        });

        history = (Button) findViewById(R.id.btnHistory);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it = new Intent(ActivityMenu.this,HistoryActivity.class);
                startActivity(it);
            }
        });

        artikel = (Button) findViewById(R.id.btnArtikel);
        artikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it = new Intent(ActivityMenu.this,ArtikelActivity.class);
                startActivity(it);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_setting:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void logout(){
        Toast.makeText(getApplicationContext(),"Ciee",Toast.LENGTH_SHORT).show();
    }
}
