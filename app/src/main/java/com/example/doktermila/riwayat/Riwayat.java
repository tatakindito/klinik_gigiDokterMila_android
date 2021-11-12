package com.example.doktermila.riwayat;

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

import com.example.doktermila.KetList;
import com.example.doktermila.R;
import com.example.doktermila.RequestHandler;
import com.example.doktermila.konfigurasi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.doktermila.login_register.Login.my_shared_preferences;

public class Riwayat extends AppCompatActivity implements ListView.OnItemClickListener{

    TextView txt_id, txt_username;
    String id, username;
    SharedPreferences sharedpreferences;

    private ListView listView;
    private String JSON_STRING;

    public static final String TAG_ID_USER = "id";
    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        listView = (ListView) findViewById(R.id.listview_riwayat);
        listView.setOnItemClickListener(this);
        getJSONRiwayat();

        /** dari login session **/

        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_username = (TextView) findViewById(R.id.txt_username);
        //btn_logout = (Button) findViewById(R.id.btn_logout);


        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);

        txt_id.setText(id);
        txt_username.setText(username);

        /** batas dari login session **/

    }  // on creat


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


   private void showRiwayat(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(konfigurasi.TAG_ID_RIWAYAT);
                String title = jo.getString(konfigurasi.TAG_JUDUL_RIWAYAT);
                String kdpg = jo.getString(konfigurasi.TAG_KD_PG);
                String isi = jo.getString(konfigurasi.TAG_TGL_RIWAYAT);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(konfigurasi.TAG_ID_RIWAYAT,id);
                employees.put(konfigurasi.TAG_JUDUL_RIWAYAT, title);
                employees.put(konfigurasi.TAG_KD_PG, kdpg);
                employees.put(konfigurasi.TAG_TGL_RIWAYAT, isi);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                Riwayat.this, list, R.layout.activity_list_item_riwayat,
                new String[]{konfigurasi.TAG_ID_RIWAYAT,konfigurasi.TAG_JUDUL_RIWAYAT,konfigurasi.TAG_KD_PG,konfigurasi.TAG_TGL_RIWAYAT},
                new int[]{R.id.id_riwayat, R.id.jdl_riwayat, R.id.kdpg,R.id.tgl_riwayat});

        listView.setAdapter(adapter);
    }

    private void getJSONRiwayat(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Riwayat.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showRiwayat();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_ALL_RIWAYAT,id);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, KetList.class);
        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String empId = map.get(konfigurasi.TAG_ID_RIWAYAT).toString();
        String kdpg = map.get(konfigurasi.TAG_KD_PG).toString();
        String tglr = map.get(konfigurasi.TAG_TGL_RIWAYAT).toString();
        String p_r = map.get(konfigurasi.TAG_JUDUL_RIWAYAT).toString();

        intent.putExtra(konfigurasi.KD_PG,kdpg);
        intent.putExtra(konfigurasi.TGL_DIAG,tglr);
        intent.putExtra(konfigurasi.PR,p_r);
        intent.putExtra(TAG_ID_USER, id);
        intent.putExtra(TAG_USERNAME, username);

        startActivity(intent);
    }












  /**  private void showRiwayat(String json){
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            //String ed = c.getString(konfigurasi.TAG_ID);
            String ir = c.getString(konfigurasi.TAG_ID_RIWAYAT);
            String jr = c.getString(konfigurasi.TAG_JUDUL_RIWAYAT);
            String tr = c.getString(konfigurasi.TAG_TGL_RIWAYAT);
            String by = c.getString(konfigurasi.TAG_BIAYA);

            HashMap<String,String> employees = new HashMap<>();
            employees.put(konfigurasi.TAG_ID_RIWAYAT,ir);
            employees.put(konfigurasi.TAG_JUDUL_RIWAYAT, jr);
            employees.put(konfigurasi.TAG_TGL_RIWAYAT, tr);
            employees.put(konfigurasi.TAG_BIAYA, by);
            list.add(employees);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                Riwayat.this, list, R.layout.activity_list_item_riwayat,
                new String[]{konfigurasi.TAG_ID_RIWAYAT,konfigurasi.TAG_JUDUL_RIWAYAT,konfigurasi.TAG_TGL_RIWAYAT,konfigurasi.TAG_BIAYA},
                new int[]{R.id.id_riwayat, R.id.jdl_riwayat, R.id.tgl_riwayat, R.id.biaya});

        listView.setAdapter(adapter);
    }**/


}