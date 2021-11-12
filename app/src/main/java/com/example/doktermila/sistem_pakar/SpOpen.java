package com.example.doktermila.sistem_pakar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.doktermila.MainActivity;
import com.example.doktermila.R;
import com.example.doktermila.RequestHandler;
import com.example.doktermila.data_diri.DataDiri;
import com.example.doktermila.konfigurasi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;
import static com.example.doktermila.login_register.Login.my_shared_preferences;
import static com.example.doktermila.login_register.Login.session_status;

public class SpOpen extends AppCompatActivity {


    String id, username;
    TextView id_sp_op, user_sp_op, sp_tgl, usert;
    Button mulai;

    String id_user_sp, user_sp;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_open);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        id_sp_op = (TextView) findViewById(R.id.id_sp_open);
        user_sp_op = (TextView) findViewById(R.id.user_sp_open);
        sp_tgl = (TextView) findViewById(R.id.sp_tgl_l);

        mulai = (Button) findViewById(R.id.btn_mulai_sp);

        id = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);

        id_sp_op.setText(id);
        user_sp_op.setText(username);

        getSpTgl();




        mulai.setOnClickListener(new View.OnClickListener() {

            Boolean session = false;
            @Override
            public void onClick(View v) {
                // Cek session login jika TRUE maka langsung buka MainActivity
                sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
                session = sharedpreferences.getBoolean(session_status, false);
                id_user_sp = sharedpreferences.getString(TAG_ID_USER, null);
                user_sp = sharedpreferences.getString(TAG_USERNAME, null);

                if (session) {
                    Intent keSp = new Intent(SpOpen.this, SistemPakar.class);
                    keSp.putExtra(TAG_ID_USER, id_user_sp);
                    keSp.putExtra(TAG_USERNAME, user_sp);
                    keSp.putExtra(konfigurasi.PELAPOR_ID,id_user_sp);
                    keSp.putExtra(konfigurasi.USERE,user_sp);
                    startActivity(keSp);
                }
            }
        });

    }   // on create


    private void getSpTgl(){
        class GetDataDiri extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SpOpen.this,"Mengambil","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showSpTgl(s);
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

    private void showSpTgl(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            //String ed = c.getString(konfigurasi.TAG_ID);
            String tgl = c.getString(konfigurasi.TAG_DD_TGL_LAHIR);

            sp_tgl.setText(tgl);

        } catch (JSONException e) {
            e.printStackTrace();
        }
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
}