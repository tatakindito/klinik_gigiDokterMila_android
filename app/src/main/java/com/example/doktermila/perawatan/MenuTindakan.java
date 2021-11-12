package com.example.doktermila.perawatan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doktermila.HalamanUtama;
import com.example.doktermila.MainActivity;
import com.example.doktermila.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MenuTindakan extends AppCompatActivity {

    String id, username;
    public static final String TAG_ID_USER = "id";
    public static final String TAG_USERNAME = "username";

    TextView mt_id, my_user;

    public CardView keControl, keScaling, kawatGigi,cabutGigi,tambal,restorasi, keMahkota, keVeneer, keEndodontik;
    Button btn_view_jadwal;

    // AdMob
    private AdView adView;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tindakan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btn_view_jadwal = (Button) findViewById(R.id.btn_view_jadwal);
        keControl = (CardView) findViewById(R.id.card_kontrol);
        keMahkota = (CardView) findViewById(R.id.card_mahkota);
        keEndodontik = (CardView) findViewById(R.id.card_endodontik);
        keVeneer = (CardView) findViewById(R.id.card_veneer);
        keScaling = (CardView) findViewById(R.id.card_scaling);
        kawatGigi = (CardView) findViewById(R.id.slide_qr);
        cabutGigi = (CardView) findViewById(R.id.slide_penginapan);
        tambal = (CardView) findViewById(R.id.card_tooth1);
        restorasi = (CardView) findViewById(R.id.card_tooth3);
        mt_id = (TextView) findViewById(R.id.mt_id);
        my_user = (TextView) findViewById(R.id.mt_user);

        id = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);

        mt_id.setText("ID : " + id);
        my_user.setText("USERNAME : " + username);


        /////////////////////////////////////////////////////////////////////////AdMob
        adView = (AdView) findViewById(R.id.adView);
        adView.loadAd(new AdRequest.Builder().build());

        interstitialAd = new InterstitialAd(MenuTindakan.this);

        //memanggil id iklan di string
        interstitialAd.setAdUnitId(getString(R.string.admob_interstitial_id));
        AdRequest adRequest = new AdRequest.Builder().build();

        //muat iklan interstitial
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded(){
                displayInterstitial();
            }
        });

        //////////////////////////////////////////////////////////////////////////////////



        btn_view_jadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(MenuTindakan.this, HalamanUtama.class);
                view.putExtra(TAG_ID_USER, id);
                view.putExtra(TAG_USERNAME, username);
                startActivity(view);
            }
        });


        keControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent control = new Intent(MenuTindakan.this, ActTindakan.class);
                control.putExtra(TAG_ID_USER, id);
                control.putExtra(TAG_USERNAME, username);
                startActivity(control);
            }
        });

        keScaling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuTindakan.this, "Halaman Scaling Sementara Belum Di Buat", Toast.LENGTH_SHORT).show();
            }
        });

        kawatGigi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuTindakan.this, "Halaman Kawat Gigi Sementara Belum Di Buat", Toast.LENGTH_SHORT).show();
            }
        });

        cabutGigi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuTindakan.this, "Halaman Cabut Gigi Sementara Belum Di Buat", Toast.LENGTH_SHORT).show();
            }
        });

        tambal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuTindakan.this, "Halaman Tambal Gigi Sementara Belum Di Buat", Toast.LENGTH_SHORT).show();
            }
        });

        restorasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuTindakan.this, "Halaman Restorasi Sementara Belum Di Buat", Toast.LENGTH_SHORT).show();
            }
        });

        keMahkota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuTindakan.this, "Halaman Restorasi Sementara Belum Di Buat", Toast.LENGTH_SHORT).show();
            }
        });

        keEndodontik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuTindakan.this, "Halaman Restorasi Sementara Belum Di Buat", Toast.LENGTH_SHORT).show();
            }
        });

        keVeneer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuTindakan.this, "Halaman Restorasi Sementara Belum Di Buat", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void displayInterstitial(){
        if (interstitialAd.isLoaded()){
            interstitialAd.show();
        }
    }
}
