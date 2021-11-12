package com.example.doktermila.data_pakar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class EditGejalaBase extends AppCompatActivity {


    String id_use, username, id_user, nama_user;
    SharedPreferences sharedpreferences;

    EditText edt_kd_dg, edt_nm_dg;
    Button update_button_dg, delete_button_dg;

    TextView ebase_g_id, ebase_g_user;

    private String id_dg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gejala_base);


        edt_kd_dg = (EditText) findViewById(R.id.edt_kd_dg);
        edt_nm_dg = (EditText) findViewById(R.id.edt_nm_dg);

        ebase_g_id = (TextView) findViewById(R.id.ebase_g_id);
        ebase_g_user = (TextView) findViewById(R.id.ebase_g_user);

        update_button_dg = (Button) findViewById(R.id.btn_update_dg);
        delete_button_dg = (Button) findViewById(R.id.btn_delete_dg);


        id_user = getIntent().getStringExtra(TAG_ID_USER);
        nama_user = getIntent().getStringExtra(TAG_USERNAME);

        ebase_g_id.setText(id_user);
        ebase_g_user.setText(nama_user);



        //get session id
        final Intent intent = getIntent();
        id_dg = intent.getStringExtra(konfigurasi.DGEJALA_ID);
        getDaftarGejala();

        update_button_dg.setOnClickListener(new View.OnClickListener() {
            Boolean session=false;
            @Override
            public void onClick(View v) {
                updateDaftarGejala();

                // Cek session login jika TRUE maka langsung buka MainActivity
                sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
                session = sharedpreferences.getBoolean(session_status, false);
                id_use = sharedpreferences.getString(TAG_ID_USER, null);
                username = sharedpreferences.getString(TAG_USERNAME, null);

                if (session) {
                    Intent y = new Intent(EditGejalaBase.this, GejalaBase.class);
                    y.putExtra(TAG_ID_USER, id_user);
                    y.putExtra(TAG_USERNAME, nama_user);
                    startActivity(y);
                    finish();
                }
            }
        });



        delete_button_dg.setOnClickListener(new View.OnClickListener() {
            Boolean session=false;
            @Override
            public void onClick(View v) {
                confirmDeleteGejalabase();
                    /**
                    Intent y = new Intent(EditGejalaBase.this, GejalaBase.class);
                    y.putExtra(TAG_ID_USER, id_use);
                    y.putExtra(TAG_USERNAME, username);
                    startActivity(y);
                    finish();**/
            }
        });





    } // oncreate






    private void getDaftarGejala(){
        class GetDataDiri extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(EditGejalaBase.this,"Mengambil","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showDaftarGejala(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_DETAIL_DG,id_dg);
                return s;
            }
        }
        GetDataDiri ge = new GetDataDiri();
        ge.execute();
    }


    private void showDaftarGejala(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String kd_dg = c.getString(konfigurasi.TAG_KODE_DAFTAR_GEJALA);
            String nm_dg = c.getString(konfigurasi.TAG_NAMA_GEJALA);

            edt_kd_dg.setText(kd_dg);
            edt_nm_dg.setText(nm_dg);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateDaftarGejala(){
        final String kd_dg = edt_kd_dg.getText().toString().trim();
        final String nm_dg = edt_nm_dg.getText().toString().trim();


        class UpdateGejala extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
             /**   loading = ProgressDialog.show(EditGejalaBase.this,"Updating...","Wait...",false,false); **/
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(EditGejalaBase.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(konfigurasi.KEY_ID_G,id_dg);
                hashMap.put(konfigurasi.KEY_KODE_DAFTAR_GEJALA,kd_dg);
                hashMap.put(konfigurasi.KEY_NAMA_GEJALA,nm_dg);


                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(konfigurasi.URL_UPDATE_DAFTAR_GEJALA,hashMap);

                return s;
            }
        }

        UpdateGejala ue = new UpdateGejala();
        ue.execute();
    }





    private void deleteGejalaBase(){
        class DeleteGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
             //   loading = ProgressDialog.show(EditGejalaBase.this, "Sedang...", "Menghapus...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(EditGejalaBase.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_DELETE_DG, id_dg);
                return s;
            }
        }

        DeleteGejala de = new DeleteGejala();
        de.execute();
    }

    private void confirmDeleteGejalabase(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Yakin Menghapus Gejala ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteGejalaBase();
                        startActivity(new Intent(EditGejalaBase.this, GejalaBase.class));
                        finish();
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }





}