package com.example.doktermila.data_diri;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.doktermila.R;
import com.example.doktermila.RequestHandler;
import com.example.doktermila.konfigurasi;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;
import static com.example.doktermila.login_register.Login.my_shared_preferences;
import static com.example.doktermila.login_register.Login.session_status;

public class DataDiri extends AppCompatActivity {

    String id_use, username;
    SharedPreferences sharedpreferences;

    TextView nama, jenis_kelamin, tgl_lahir, tmp_lahir,pekerjaan, no_hp,  alamat,di; // agama, pernikahan, ortu,
    Button perbarui_btn;
    //ImageView add;
    private String id;


    // AdMob
    private AdView adView;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_diri);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        di = (TextView) findViewById(R.id.di);
        nama = (TextView) findViewById(R.id.dd_nama);
        jenis_kelamin = (TextView) findViewById(R.id.dd_jk);
        tgl_lahir = (TextView) findViewById(R.id.dd_tgl_l);
        tmp_lahir = (TextView) findViewById(R.id.dd_tmp_l);
        pekerjaan = (TextView) findViewById(R.id.dd_kerja);
        no_hp = (TextView) findViewById(R.id.dd_hp);
    //    agama = (TextView) findViewById(R.id.dd_agama);
    //    pernikahan = (TextView) findViewById(R.id.dd_nikah);
    //    ortu = (TextView) findViewById(R.id.dd_ortu);
        alamat = (TextView) findViewById(R.id.dd_alamat);

        //add = (ImageView) findViewById(R.id.tambah_dd) ;
        perbarui_btn = (Button) findViewById(R.id.dd_btn);

        //get session id
        final Intent intent = getIntent();
        id = intent.getStringExtra(konfigurasi.PELAPOR_ID);

        di.setText(id);

        getDataDiri();



        perbarui_btn.setOnClickListener(new View.OnClickListener() {
            Boolean session = false;
            String getdi;
            @Override
            public void onClick(View v) {
                //Intent dd = new Intent(DataDiri.this, EditDd.class);

                //getdi = di.getText().toString();
                //dd.putExtra(konfigurasi.DD_ID, getdi);

                // Cek session login jika TRUE maka langsung buka MainActivity
                sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
                session = sharedpreferences.getBoolean(session_status, false);
                id_use = sharedpreferences.getString(TAG_ID_USER, null);
                username = sharedpreferences.getString(TAG_USERNAME, null);

                if (session) {
                    Intent x = new Intent(DataDiri.this, EditDataDiri.class);
                    x.putExtra(TAG_ID_USER, id_use);
                    x.putExtra(TAG_USERNAME, username);
                    x.putExtra(konfigurasi.PELAPOR_ID,id_use);
                    startActivity(x);
                }
                //startActivity(dd);
            }
        });



        /**   add.setOnClickListener(new View.OnClickListener() {
         Boolean session=false;
         @Override
         public void onClick(View v) {

         // Cek session login jika TRUE maka langsung buka MainActivity
         sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
         session = sharedpreferences.getBoolean(session_status, false);
         id = sharedpreferences.getString(TAG_ID_USER, null);
         username = sharedpreferences.getString(TAG_USERNAME, null);

         if (session) {
         Intent addd = new Intent(DataDiri.this, TambahDataDiri.class);
         addd.putExtra(TAG_ID_USER, id);
         addd.putExtra(TAG_USERNAME, username);
         addd.putExtra(konfigurasi.PELAPOR_ID,id);
         startActivity(addd);
         }
         }
         });     **/

        //AdMob
        adView = (AdView) findViewById(R.id.adView);
        adView.loadAd(new AdRequest.Builder().build());

        interstitialAd = new InterstitialAd(DataDiri.this);

        //memanggil id iklan di string
        interstitialAd.setAdUnitId("ca-app-pub-4193119508422984/6056042855");
        AdRequest adRequest = new AdRequest.Builder().build();

        //muat iklan interstitial
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded(){
                displayInterstitial();
            }
        });


    } // onCreate



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }





    private void getDataDiri(){
        class GetDataDiri extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DataDiri.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showDataDiri(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_DATADIRI,id);
                return s;
            }
        }
        GetDataDiri ge = new GetDataDiri();
        ge.execute();
    }

    private void showDataDiri(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            //String ed = c.getString(konfigurasi.TAG_ID);
            String nama_ = c.getString(konfigurasi.TAG_DD_NAMA);
            String jk_ = c.getString(konfigurasi.TAG_DD_JK);
            String tgl_lahir_ = c.getString(konfigurasi.TAG_DD_TGL_LAHIR);
            String tmp_lahir_ = c.getString(konfigurasi.TAG_DD_TMP_LAHIR);
            String pekerjaan_ = c.getString(konfigurasi.TAG_DD_PEKERJAAN);
            String nohp_ = c.getString(konfigurasi.TAG_DD_NOHP);
         //   String agama_ = c.getString(konfigurasi.TAG_DD_AGAMA);
         //   String nikah_ = c.getString(konfigurasi.TAG_DD_NIKAH);
         //   String ortu_ = c.getString(konfigurasi.TAG_DD_ORTU);
            String alamat_ = c.getString(konfigurasi.TAG_DD_ALAMAT);

            nama.setText(nama_);
            jenis_kelamin.setText(jk_);
            tgl_lahir.setText(tgl_lahir_);
            tmp_lahir.setText(tmp_lahir_);
            pekerjaan.setText(pekerjaan_);
            no_hp.setText(nohp_);
        //    agama.setText(agama_);
        //    pernikahan.setText(nikah_);
        //    ortu.setText(ortu_);
            alamat.setText(alamat_);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    public void displayInterstitial(){
        if (interstitialAd.isLoaded()){
            interstitialAd.show();
        }
    }

}
