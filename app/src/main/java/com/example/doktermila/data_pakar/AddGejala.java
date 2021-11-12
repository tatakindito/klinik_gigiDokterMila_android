package com.example.doktermila.data_pakar;

import android.app.ProgressDialog;
import android.content.Intent;
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

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;

public class AddGejala extends AppCompatActivity {

    String id, username;
    EditText add_kd_dg, add_nm_dg;
    Button add_button_dg;
    TextView g_id, g_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gejala);

        g_id = (TextView) findViewById(R.id.add_g_id);
        g_user = (TextView) findViewById(R.id.add_g_user);

        add_kd_dg = (EditText) findViewById(R.id.edt_add_kd_dg);
        add_nm_dg = (EditText) findViewById(R.id.edt_add_nm_dg);
        add_button_dg = (Button) findViewById(R.id.btn_add_dg);

        id = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);

        g_id.setText(id);
        g_user.setText(username);

        add_button_dg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addGejala();
                Intent tmbh = new Intent(AddGejala.this, GejalaBase.class);
                tmbh.putExtra(TAG_ID_USER, id);
                tmbh.putExtra(TAG_USERNAME, username);
                startActivity(tmbh);
                finish();
            }
        });

    } // Oncreate



    private void addGejala(){

        final String kddg = add_kd_dg.getText().toString().trim();
        final String nmdg = add_nm_dg.getText().toString().trim();

        class AddGejalas extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(AddGejala.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(AddGejala.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_KODE_DAFTAR_GEJALA,kddg);
                params.put(konfigurasi.KEY_NAMA_GEJALA,nmdg);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD_GEJALA, params);
                return res;
            }
        }

        AddGejalas ae = new AddGejalas();
        ae.execute();
    }


}