package com.example.doktermila;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doktermila.listGambar.MyConstant;
import com.example.doktermila.listGambar.MyFunction;
import com.squareup.picasso.Picasso;


public class KeteranganGambar extends MyFunction {


    ImageView imgmakanan;
    TextView txtnama;
    TextView txtdetail;
    String id,nama,detail,gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterangan_gambar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imgmakanan = findViewById(R.id.imgmakanan);
        txtnama= findViewById(R.id.txtnama);
        txtdetail = findViewById(R.id.txtdetail);
        //tambahan
        id = getIntent().getStringExtra("id");
        nama = getIntent().getStringExtra("nm");
        detail = getIntent().getStringExtra("i");
        gambar = getIntent().getStringExtra("gb");

        txtnama.setText(nama);
        // Hehe
        txtdetail.setText(detail);
        Picasso.with(con)
                .load(MyConstant.IMAGE_URL+gambar)
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


    //tambahan
 /**   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idd = item.getItemId();
        if (idd==R.id.share){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("ID",id);
            intent.putExtra("NAMA",nama);
            intent.putExtra("DETAIL",detail);
            intent.putExtra("GAMBAR",gambar);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }  **/
}
