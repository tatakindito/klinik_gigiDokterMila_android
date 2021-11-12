package com.example.doktermila.data_pakar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doktermila.R;
import com.example.doktermila.RequestHandler;
import com.example.doktermila.konfigurasi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;
import static com.example.doktermila.login_register.Login.my_shared_preferences;
import static com.example.doktermila.login_register.Login.session_status;

public class GejalaBase extends AppCompatActivity implements ListView.OnItemClickListener {

    String id, username, id_user, nama_user;
    TextView base_g_id, base_g_user;


    private ListView listViewGejala;
    private String JSON_STRING;

    SharedPreferences sharedpreferences;
    FloatingActionButton addGejala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gejala_base);


        base_g_id = (TextView) findViewById(R.id.base_g_id);
        base_g_user = (TextView) findViewById(R.id.base_g_user);
        addGejala = findViewById(R.id.addGejala);


        id = getIntent().getStringExtra(TAG_ID_USER);
        id_user = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);

        base_g_id.setText(id);
        base_g_user.setText(username);


        listViewGejala = (ListView) findViewById(R.id.listVie_dgejala);
        listViewGejala.setOnItemClickListener(this);
        getJSON();


        addGejala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewClicked();
            }
        });

    }  // onCreatae


    private void showGejalaBase(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id_dg = jo.getString(konfigurasi.TAG_ID_DAFTAR_GEJALA);
                String kd_dg = jo.getString(konfigurasi.TAG_KODE_DAFTAR_GEJALA);
                String nm_dg = jo.getString(konfigurasi.TAG_NAMA_GEJALA);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(konfigurasi.TAG_ID_DAFTAR_GEJALA,id_dg);
                employees.put(konfigurasi.TAG_KODE_DAFTAR_GEJALA, kd_dg);
                employees.put(konfigurasi.TAG_NAMA_GEJALA, nm_dg);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                GejalaBase.this, list, R.layout.activity_list_item_gejala,
                new String[]{konfigurasi.TAG_ID_DAFTAR_GEJALA,konfigurasi.TAG_KODE_DAFTAR_GEJALA,konfigurasi.TAG_NAMA_GEJALA},
                new int[]{R.id.id_dg, R.id.kd_dg, R.id.nm_dg});

        listViewGejala.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(GejalaBase.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showGejalaBase();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_ALL_DAFTAR_GEJALA);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String admin = "1";
        if (id_user.equals(admin)) {

        Intent intent = new Intent(this, EditGejalaBase.class);
        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String empId = map.get(konfigurasi.TAG_ID_DAFTAR_GEJALA).toString();
        intent.putExtra(konfigurasi.DGEJALA_ID,empId);
        intent.putExtra(TAG_ID_USER, id_user);
        intent.putExtra(TAG_USERNAME, username);
        startActivity(intent);

        }if (!id_user.equals(admin)){
            Toast.makeText(this, "Anda Bukan Admin", Toast.LENGTH_SHORT).show();
        }
    }



    Boolean session = false;

    public void onViewClicked() {

        String admin = "1";
        if (id_user.equals(admin)) {

        // Cek session login jika TRUE maka langsung buka MainActivity
        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, false);
        id_user = sharedpreferences.getString(TAG_ID_USER, null);
        nama_user = sharedpreferences.getString(TAG_USERNAME, null);

            if (session) {
                Intent toAct = new Intent(GejalaBase.this, AddGejala.class);
                toAct.putExtra(konfigurasi.PELAPOR_ID,id_user);
                toAct.putExtra(konfigurasi.USERE,nama_user);
                startActivity(toAct);
            }

        }if (!id_user.equals(admin)){
            Toast.makeText(this, "Anda Bukan Admin", Toast.LENGTH_SHORT).show();
        }

    }


}