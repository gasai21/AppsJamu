package com.example.pangling.appsjamu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pangling.appsjamu.api.RegisteterAPI;
import com.example.pangling.appsjamu.model.Value;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KonsultasiActivity extends AppCompatActivity {

    int i=0;
    Button konsul,add;
    ListView lv;
    List<String> a = new ArrayList<>();
    ArrayAdapter ad;
    Spinner bahan;
    public static List<String> datakonsul = new ArrayList<>();
    String hasilkonsul;
    String coba="";
    public String URL ="http://192.168.1.14/jamu/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi);

        //inisialisasi
        konsul = (Button) findViewById(R.id.btnKonsul);
        add = (Button) findViewById(R.id.btnAdd);
        lv = (ListView) findViewById(R.id.listView);
        bahan = (Spinner) findViewById(R.id.spinner);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int i2 =i++;
                //Toast.makeText(getApplicationContext(),String.valueOf(i2),Toast.LENGTH_SHORT).show();
                final String data = bahan.getSelectedItem().toString();
                a.add(data);

                ad = new ArrayAdapter(KonsultasiActivity.this,android.R.layout.simple_list_item_1,a);
                lv.setAdapter(ad);

                //menyeleksi data
                String kamu = bahan.getSelectedItem().toString();

                if(kamu.equals("Pegal - Pegal")){
                    hasilkonsul = "Obat Pegal pegal adalah Beras kencur";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Menambah Nafsu Makan")){
                    hasilkonsul = "Obat Menambah Nafsu Makan adalah Beras kencur";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else {
                    hasilkonsul = "Obat Sakit Perut adalah Beras kencur";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }
            }
        });

        konsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpanData();
                Intent it = null;
                it = new Intent(KonsultasiActivity.this,HasilKonsulActivity.class);
                startActivity(it);
            }
        });
    }

    public void simpanData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String username = MainActivity.ambilId;
        String konsulan = coba;
        RegisteterAPI api = retrofit.create(RegisteterAPI.class);
        Call<Value> call = api.insert(username,konsulan);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();

                if(value.equals("1")){
                    Toast.makeText(getApplicationContext(),"Data Berhasil Di tambah!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Data Gagal Di tambah!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Koneksi Gagal!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
