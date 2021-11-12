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

public class EditPerawatanBase extends AppCompatActivity {

    String id_use, username,  nama_user, id_user;
    SharedPreferences sharedpreferences;

    EditText edt_kd_dp, edt_nm_dp;
    Button update_button_dp, delete_button_dp;

    private String id_dp;

    TextView ebase_p_id, ebase_p_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_perawatan_base);


        edt_kd_dp = (EditText) findViewById(R.id.edt_kd_dp);
        edt_nm_dp = (EditText) findViewById(R.id.edt_nm_dp);

        ebase_p_id = (TextView) findViewById(R.id.ebase_p_id);
        ebase_p_user = (TextView) findViewById(R.id.ebase_p_user);

        update_button_dp = (Button) findViewById(R.id.btn_update_dp);
        delete_button_dp = (Button) findViewById(R.id.btn_delete_dp);

        id_user = getIntent().getStringExtra(TAG_ID_USER);
        nama_user = getIntent().getStringExtra(TAG_USERNAME);

        ebase_p_id.setText(id_user);
        ebase_p_user.setText(nama_user);



        //get session id
        final Intent intent = getIntent();
        id_dp = intent.getStringExtra(konfigurasi.DPERAWATAN_ID);
        getDaftarPerawatan();

        update_button_dp.setOnClickListener(new View.OnClickListener() {
            Boolean session=false;
            @Override
            public void onClick(View v) {
                updateDaftarPerawatan();

                // Cek session login jika TRUE maka langsung buka MainActivity
                sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
                session = sharedpreferences.getBoolean(session_status, false);
                id_use = sharedpreferences.getString(TAG_ID_USER, null);
                username = sharedpreferences.getString(TAG_USERNAME, null);

                if (session) {
                    Intent y = new Intent(EditPerawatanBase.this, PerawatanBase.class);
                    y.putExtra(TAG_ID_USER, id_user);
                    y.putExtra(TAG_USERNAME, nama_user);
                    startActivity(y);
                    finish();
                }
            }
        });




        delete_button_dp.setOnClickListener(new View.OnClickListener() {
            Boolean session=false;
            @Override
            public void onClick(View v) {
                confirmDeletePerawatanbase();
                    /**
                    Intent y = new Intent(EditPerawatanBase.this, PerawatanBase.class);
                    y.putExtra(TAG_ID_USER, id_use);
                    y.putExtra(TAG_USERNAME, username);
                    startActivity(y);
                    finish();**/
            }
        });




    } // onCreate



    private void getDaftarPerawatan(){
        class GetDataDiri extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(EditPerawatanBase.this,"Mengambil","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showDaftarPerawatan(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_DETAIL_DP,id_dp);
                return s;
            }
        }
        GetDataDiri ge = new GetDataDiri();
        ge.execute();
    }


    private void showDaftarPerawatan(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String kd_dp = c.getString(konfigurasi.TAG_KODE_DAFTAR_PERAWATAN);
            String nm_dp = c.getString(konfigurasi.TAG_NAMA_PERAWATAN);

            edt_kd_dp.setText(kd_dp);
            edt_nm_dp.setText(nm_dp);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateDaftarPerawatan(){
        final String kode_dp = edt_kd_dp.getText().toString().trim();
        final String nama_dp = edt_nm_dp.getText().toString().trim();


        class UpdatePerawatan extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
             /**   loading = ProgressDialog.show(EditPerawatanBase.this,"Updating...","Wait...",false,false); **/
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(EditPerawatanBase.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(konfigurasi.KEY_ID_P,id_dp);
                hashMap.put(konfigurasi.KEY_KODE_DAFTAR_PERAWATAN,kode_dp);
                hashMap.put(konfigurasi.KEY_NAMA_PERAWATAN,nama_dp);


                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(konfigurasi.URL_UPDATE_DAFTAR_PERAWATAN,hashMap);

                return s;
            }
        }

        UpdatePerawatan ue = new UpdatePerawatan();
        ue.execute();
    }





    private void deletePerawatanBase(){
        class DeletePerawatan extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
             //  loading = ProgressDialog.show(EditPerawatanBase.this, "Sedang...", "Menghapus...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(EditPerawatanBase.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_DELETE_DP, id_dp);
                return s;
            }
        }

        DeletePerawatan de = new DeletePerawatan();
        de.execute();
    }

    private void confirmDeletePerawatanbase(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Yakin Menghapus Perawatan ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deletePerawatanBase();
                        startActivity(new Intent(EditPerawatanBase.this, PerawatanBase.class));
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