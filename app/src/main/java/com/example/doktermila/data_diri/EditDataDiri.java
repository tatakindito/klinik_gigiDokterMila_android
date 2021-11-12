package com.example.doktermila.data_diri;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doktermila.R;
import com.example.doktermila.RequestHandler;
import com.example.doktermila.konfigurasi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;
import static com.example.doktermila.login_register.Login.my_shared_preferences;
import static com.example.doktermila.login_register.Login.session_status;

public class EditDataDiri extends AppCompatActivity {

    // variable session
    String id_use, username;
    SharedPreferences sharedpreferences;

    EditText edt_nama, edt_jk, edt_tgl_lahir, edt_tmp_lahir, edt_pekerjaan, edt_nohp,
             edt_alamat; // edt_agama, edt_pernikahan, edt_ortu,
    Button edt_btn;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_diri);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        edt_nama = (EditText) findViewById(R.id.edt_nama);
        edt_jk = (EditText) findViewById(R.id.edt_jk);
        edt_tgl_lahir = (EditText) findViewById(R.id.edt_tgl_l);
        edt_tmp_lahir = (EditText) findViewById(R.id.edt_tmp_l);
        edt_pekerjaan = (EditText) findViewById(R.id.edt_kerja);
        edt_nohp = (EditText) findViewById(R.id.edt_hp);
    //    edt_agama = (EditText) findViewById(R.id.edt_agama);
     //   edt_pernikahan = (EditText) findViewById(R.id.edt_nikah);
     //   edt_ortu = (EditText) findViewById(R.id.edt_ortu);
        edt_alamat = (EditText) findViewById(R.id.edt_alamat);

        edt_btn = (Button) findViewById(R.id.edt_dd_btn);

        //get session id
        final Intent intent = getIntent();
        id = intent.getStringExtra(konfigurasi.PELAPOR_ID);
        getDataDiri();

        edt_btn.setOnClickListener(new View.OnClickListener() {
            Boolean session=false;
            @Override
            public void onClick(View v) {
                updateDataDiri();

                // Cek session login jika TRUE maka langsung buka MainActivity
                sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
                session = sharedpreferences.getBoolean(session_status, false);
                id_use = sharedpreferences.getString(TAG_ID_USER, null);
                username = sharedpreferences.getString(TAG_USERNAME, null);

                if (session) {
                    Intent y = new Intent(EditDataDiri.this, DataDiri.class);
                    y.putExtra(TAG_ID_USER, id_use);
                    y.putExtra(TAG_USERNAME, username);
                    y.putExtra(konfigurasi.PELAPOR_ID,id_use);
                    startActivity(y);
                    finish();
                }
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
                loading = ProgressDialog.show(EditDataDiri.this,"Fetching...","Wait...",false,false);
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
            String nama_ = c.getString(konfigurasi.TAG_DD_NAMA);
            String jk_ = c.getString(konfigurasi.TAG_DD_JK);
            String tgl_lahir_ = c.getString(konfigurasi.TAG_DD_TGL_LAHIR);
            String tmp_lahir_ = c.getString(konfigurasi.TAG_DD_TMP_LAHIR);
            String pekerjaan_ = c.getString(konfigurasi.TAG_DD_PEKERJAAN);
            String nohp_ = c.getString(konfigurasi.TAG_DD_NOHP);
        //    String agama_ = c.getString(konfigurasi.TAG_DD_AGAMA);
        //    String nikah_ = c.getString(konfigurasi.TAG_DD_NIKAH);
        //    String ortu_ = c.getString(konfigurasi.TAG_DD_ORTU);
            String alamat_ = c.getString(konfigurasi.TAG_DD_ALAMAT);

            edt_nama.setText(nama_);
            edt_jk.setText(jk_);
            edt_tgl_lahir.setText(tgl_lahir_);
            edt_tmp_lahir.setText(tmp_lahir_);
            edt_pekerjaan.setText(pekerjaan_);
            edt_nohp.setText(nohp_);
        //    edt_agama.setText(agama_);
        //    edt_pernikahan.setText(nikah_);
        //    edt_ortu.setText(ortu_);
            edt_alamat.setText(alamat_);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateDataDiri(){
        final String nama_udt = edt_nama.getText().toString().trim();
        final String jk_udt = edt_jk.getText().toString().trim();
        final String tgl_lahir_udt = edt_tgl_lahir.getText().toString().trim();
        final String tmp_lahir_udt = edt_tmp_lahir.getText().toString().trim();
        final String pekerjaan_udt = edt_pekerjaan.getText().toString().trim();
        final String nohp_udt = edt_nohp.getText().toString().trim();
    //    final String agama_udt = edt_agama.getText().toString().trim();
    //    final String pernikahan_udt = edt_pernikahan.getText().toString().trim();
    //    final String ortu_udt = edt_ortu.getText().toString().trim();
        final String alamat_udt = edt_alamat.getText().toString().trim();

        class UpdateEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(EditDataDiri.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(EditDataDiri.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(konfigurasi.KEY_USER_ID,id);
                hashMap.put(konfigurasi.KEY_NAMA,nama_udt);
                hashMap.put(konfigurasi.KEY_JK,jk_udt);
                hashMap.put(konfigurasi.KEY_TGL_LAHIR,tgl_lahir_udt);
                hashMap.put(konfigurasi.KEY_TMP_LAHIR,tmp_lahir_udt);
                hashMap.put(konfigurasi.KEY_PEKERJANN,pekerjaan_udt);
                hashMap.put(konfigurasi.KEY_NOHP,nohp_udt);
            //    hashMap.put(konfigurasi.KEY_AGAMA,agama_udt);
            //    hashMap.put(konfigurasi.KEY_PERNIKAHAN,pernikahan_udt);
            //    hashMap.put(konfigurasi.KEY_ORTU,ortu_udt);
                hashMap.put(konfigurasi.KEY_ALAMAT,alamat_udt);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(konfigurasi.URL_UPDATE_DATADIRI,hashMap);

                return s;
            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }



}
