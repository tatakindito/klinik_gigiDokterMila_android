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

public class AddPerawatan extends AppCompatActivity {

    String id, username;
    EditText add_kd_dp, add_nm_dp;
    Button add_button_dp;
    TextView p_id, p_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_perawatan);

        p_id = (TextView) findViewById(R.id.add_p_id);
        p_user = (TextView) findViewById(R.id.add_p_user);

        add_kd_dp = (EditText) findViewById(R.id.edt_add_kd_dp);
        add_nm_dp = (EditText) findViewById(R.id.edt_add_nm_dp);
        add_button_dp = (Button) findViewById(R.id.btn_add_dp);

        id = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);

        p_id.setText(id);
        p_user.setText(username);


        add_button_dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPerawatan();
                Intent tmbh = new Intent(AddPerawatan.this, PerawatanBase.class);
                tmbh.putExtra(TAG_ID_USER, id);
                tmbh.putExtra(TAG_USERNAME, username);
                startActivity(tmbh);
                finish();
            }
        });

    } //onCreate


    private void addPerawatan(){

        final String kddp = add_kd_dp.getText().toString().trim();
        final String nmdp = add_nm_dp.getText().toString().trim();

        class AddPerawatans extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(AddPerawatan.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(AddPerawatan.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_KODE_DAFTAR_PERAWATAN,kddp);
                params.put(konfigurasi.KEY_NAMA_PERAWATAN,nmdp);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD_PERAWATAN, params);
                return res;
            }
        }

        AddPerawatans ae = new AddPerawatans();
        ae.execute();
    }

}