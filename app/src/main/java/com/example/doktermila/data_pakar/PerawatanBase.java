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

public class PerawatanBase extends AppCompatActivity implements ListView.OnItemClickListener {

    String id, username, id_user, nama_user;
    TextView base_p_id, base_p_user;

    private ListView listViewPerawaan;
    private String JSON_STRING;

    SharedPreferences sharedpreferences;
    FloatingActionButton addPerawatan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perawatan_base);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        base_p_id = (TextView) findViewById(R.id.base_p_id);
        base_p_user = (TextView) findViewById(R.id.base_p_user);
        addPerawatan = findViewById(R.id.addPerawatan);


        id = getIntent().getStringExtra(TAG_ID_USER);
        id_user = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);

        base_p_id.setText(id);
        base_p_user.setText(username);


           listViewPerawaan = (ListView) findViewById(R.id.listVie_dperawatan);
           listViewPerawaan.setOnItemClickListener(this);
           getJSON();



        addPerawatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewClicked();
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




    private void showPerawatanBase(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id_dp = jo.getString(konfigurasi.TAG_ID_DAFTAR_PERAWATAN);
                String kd_dp = jo.getString(konfigurasi.TAG_KODE_DAFTAR_PERAWATAN);
                String nm_dp = jo.getString(konfigurasi.TAG_NAMA_PERAWATAN);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(konfigurasi.TAG_ID_DAFTAR_PERAWATAN,id_dp);
                employees.put(konfigurasi.TAG_KODE_DAFTAR_PERAWATAN, kd_dp);
                employees.put(konfigurasi.TAG_NAMA_PERAWATAN, nm_dp);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                PerawatanBase.this, list, R.layout.activity_list_item,
                new String[]{konfigurasi.TAG_ID_DAFTAR_PERAWATAN,konfigurasi.TAG_KODE_DAFTAR_PERAWATAN,konfigurasi.TAG_NAMA_PERAWATAN},
                new int[]{R.id.id_dp, R.id.kd_dp, R.id.nm_dp});

        listViewPerawaan.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(PerawatanBase.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showPerawatanBase();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_ALL_DAFTAR_PERAWATAN);
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

            Intent intent = new Intent(this, EditPerawatanBase.class);
            HashMap<String, String> map = (HashMap) parent.getItemAtPosition(position);
            String empId = map.get(konfigurasi.TAG_ID_DAFTAR_PERAWATAN).toString();
            intent.putExtra(konfigurasi.DPERAWATAN_ID, empId);
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
            Intent toAct = new Intent(PerawatanBase.this, AddPerawatan.class);
            toAct.putExtra(konfigurasi.PELAPOR_ID,id_user);
            toAct.putExtra(konfigurasi.USERE,nama_user);
            startActivity(toAct);
        }

        }if (!id_user.equals(admin)){
            Toast.makeText(this, "Anda Bukan Admin", Toast.LENGTH_SHORT).show();
        }

    }




}