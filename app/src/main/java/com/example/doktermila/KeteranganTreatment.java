package com.example.doktermila;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doktermila.treatment.MyConstantTreat;
import com.example.doktermila.treatment.MyFungsiTreat;
import com.squareup.picasso.Picasso;

public class KeteranganTreatment extends MyFungsiTreat {

    ImageView imgmakanan;
            TextView txtnama;
            TextView txtdetail;
            String id,nama,detail,gambar;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterangan_treatment);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imgmakanan = findViewById(R.id.img_treat);
        txtnama= findViewById(R.id.nama_treat);
        txtdetail = findViewById(R.id.detail_treat);
        //tambahan
        id = getIntent().getStringExtra("id");
        nama = getIntent().getStringExtra("nm");
        detail = getIntent().getStringExtra("i");
        gambar = getIntent().getStringExtra("gb");

        txtnama.setText(nama);
        // Hehe
        txtdetail.setText(detail);
        Picasso.with(con)
        .load(MyConstantTreat.IMAGE_URL+gambar)
        .error(R.mipmap.ic_launcher)
        .into(imgmakanan);

        } // oncreat


@Override
public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
        }

@Override
public void onBackPressed() {
        super.onBackPressed();
        }


        }
