package com.example.doktermila.sistem_pakar;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.doktermila.MainActivity;
import com.example.doktermila.R;
import com.example.doktermila.RequestHandler;
import com.example.doktermila.Whatsapp;
import com.example.doktermila.konfigurasi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;


public class HasilSp extends AppCompatActivity {

    private static final int STORAGE_CODE = 1000;

    String x, id, username, pdf, sharing,sharing1,sharing3,sharing4,sharing5,sharing6,sharing7, sharing2;

    TextView hasilsp,keterangan,keterangan2, tv_gejala, tv_kd_gejala, gejala_hsl,gejala_hsl2, kd_gejala_hsl;

    TextView tgl_diagnosa, tgl_lhr, hsl_id, hsl_user, user_sp_open, jk;
    Button selesai,pdf_bt, hubklink, smp;
    ImageView imageHasil;
    FloatingActionButton sc;

    TextView i1_hs, i2_hs, i3_hs, i4_hs, i5_hs, i6_hs, i7_hs, i8_hs, i9_hs, k1_hs, k2_hs, k3_hs, k4_hs, k5_hs, k6_hs, k7_hs, k8_hs, k9_hs;


    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_sp);

        i1_hs = (TextView) findViewById(R.id.i1_hs);
        i2_hs = (TextView) findViewById(R.id.i2_hs);
        i3_hs = (TextView) findViewById(R.id.i3_hs);
        i4_hs = (TextView) findViewById(R.id.i4_hs);
        i5_hs = (TextView) findViewById(R.id.i5_hs);
        i6_hs = (TextView) findViewById(R.id.i6_hs);
        i7_hs = (TextView) findViewById(R.id.i7_hs);
        i8_hs = (TextView) findViewById(R.id.i8_hs);
        i9_hs = (TextView) findViewById(R.id.i9_hs);

        k1_hs = (TextView) findViewById(R.id.k1_hs);
        k2_hs = (TextView) findViewById(R.id.k2_hs);
        k3_hs = (TextView) findViewById(R.id.k3_hs);
        k4_hs = (TextView) findViewById(R.id.k4_hs);
        k5_hs = (TextView) findViewById(R.id.k5_hs);
        k6_hs = (TextView) findViewById(R.id.k6_hs);
        k7_hs = (TextView) findViewById(R.id.k7_hs);
        k8_hs = (TextView) findViewById(R.id.k8_hs);
        k9_hs = (TextView) findViewById(R.id.k9_hs);

       // sc = findViewById(R.id.sc);

        hasilsp = (TextView) findViewById(R.id.hasilsp);
        keterangan = (TextView) findViewById(R.id.keterangan1);
        keterangan2 = (TextView) findViewById(R.id.keterangan2);

        tgl_lhr = (TextView) findViewById(R.id.tgl_lhr);
        tgl_diagnosa = (TextView) findViewById(R.id.tgl_diagnosa);
        user_sp_open = (TextView) findViewById(R.id.user_sp_open);
        jk = (TextView) findViewById(R.id.jk);

        gejala_hsl = (TextView) findViewById(R.id.tv_gejala_hsl);
        gejala_hsl2 = (TextView) findViewById(R.id.tv_gejala_hsl2);
        kd_gejala_hsl = (TextView) findViewById(R.id.tv_kd_gejala_hsl);

        imageHasil = (ImageView) findViewById(R.id.image_hsl);

        hsl_id = (TextView) findViewById(R.id.hsl_id);
        hsl_user = (TextView) findViewById(R.id.hsl_user);

        selesai = (Button) findViewById(R.id.btn_selesai);
        hubklink = (Button) findViewById(R.id.btn_wa);
        smp = (Button) findViewById(R.id.btn_smp);
        pdf_bt = (Button) findViewById(R.id.pdf);

        id = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);
        hsl_id.setText(id);
        hsl_user.setText(username);
        user_sp_open.setText(username);


        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        tgl_diagnosa.setText(date);


        selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHasilPakar();
                Intent rampung = new Intent(HasilSp.this, MainActivity.class);
                rampung.putExtra(TAG_ID_USER, id);
                rampung.putExtra(TAG_USERNAME, username);
                startActivity(rampung);
                finish();
            }
        });

        hubklink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hub = new Intent(HasilSp.this, Whatsapp.class);
                hub.putExtra(TAG_ID_USER, id);
                hub.putExtra(TAG_USERNAME, username);
                startActivity(hub);
            }
        });

        smp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sel = new Intent(HasilSp.this, MainActivity.class);
                sel.putExtra(TAG_ID_USER, id);
                sel.putExtra(TAG_USERNAME, username);
                startActivity(sel);
                finish();
            }
        });





        final Intent intent = getIntent();
        x = intent.getStringExtra("val");     // mengambil kode perawatan dr sistem pakar
        hasilsp.setText(x);


        ambilHasil();
        getHasilTglLhr();
        getHasilJk();

        sharing = hsl_user.getText().toString();
        //sharing2 = keterangan2.getText().toString();

        getKeteranganP1();



        /**
        btn_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPdf(keterangan.getText().toString());
            }
        });   **/

        String i1 = getIntent().getExtras().getString("i1");
        String i2 = getIntent().getExtras().getString("i2");
        String i3 = getIntent().getExtras().getString("i3");
        String i4 = getIntent().getExtras().getString("i4");
        String i5 = getIntent().getExtras().getString("i5");
        String i6 = getIntent().getExtras().getString("i6");
        String i7 = getIntent().getExtras().getString("i7");
        String i8 = getIntent().getExtras().getString("i8");
        String i9 = getIntent().getExtras().getString("i9");

        String k1 = getIntent().getExtras().getString("k1");
        String k2 = getIntent().getExtras().getString("k2");
        String k3 = getIntent().getExtras().getString("k3");
        String k4 = getIntent().getExtras().getString("k4");
        String k5 = getIntent().getExtras().getString("k5");
        String k6 = getIntent().getExtras().getString("k6");
        String k7 = getIntent().getExtras().getString("k7");
        String k8 = getIntent().getExtras().getString("k8");
        String k9 = getIntent().getExtras().getString("k9");



        i1_hs.setText(i1);
        i2_hs.setText(i2);
        i3_hs.setText(i3);
        i4_hs.setText(i4);
        i5_hs.setText(i5);
        i6_hs.setText(i6);
        i7_hs.setText(i7);
        i8_hs.setText(i8);
        i9_hs.setText(i9);

        k1_hs.setText(k1);
        k2_hs.setText(k2);
        k3_hs.setText(k3);
        k4_hs.setText(k4);
        k5_hs.setText(k5);
        k6_hs.setText(k6);
        k7_hs.setText(k7);
        k8_hs.setText(k8);
        k9_hs.setText(k9);


        pdf_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.R){
                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_DENIED){
                        String[] permisssions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permisssions, STORAGE_CODE);

                    }
                    else {
                        savePdf();

                    }
                }
                else {
                    savePdf();
                }
            }
        });


    /**    String last = getIntent().getExtras().getString("last_hsl");
        String lastyn = getIntent().getExtras().getString("last_yn");
        i0_hs.setText(last);
        k0_hs.setText(lastyn); **/











    /**    sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenshot();
            }
        });   **/



    } // onCreat





    public void ambilHasil(){

        String p1 = "p1";
        String p2 = "p2";
        String p3 = "p3";
        String p4 = "p4";
        String p5 = "p5";
        String p6 = "p6";
        String p7 = "p7";
        String p8 = "p8";
        String p9 = "p9";
        String p10 = "p10";
        String p11 = "p11";

        String y = hasilsp.getText().toString();

    /**
        if (p1.equals(y)){
            getP1();
            getKeteranganP1();
        }else if (p2.equals(y)){
            getP2();
            getKeteranganP2();
        }else if (p3.equals(y)){
            getP3();
            getKeteranganP3();
        }else if (p4.equals(y)){
            getP4();
            getKeteranganP4();
        }else if (p5.equals(y)){
            getP5();
            getKeteranganP5();
        }else if (p6.equals(y)){
            getP6();
            getKeteranganP6();
        }else if (p7.equals(y)){
            getP7();
            getKeteranganP7();
        }else if (p8.equals(y)){
            getP8();
            getKeteranganP8();
        }                               **/




        String url = "http://milaklinik.000webhostapp.com/doktermila/get_image_pakar.php";

        requestQueue = Volley.newRequestQueue(HasilSp.this);

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("perawatan");
                    for (int a = 0; a < jsonArray.length(); a ++){
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map  = new HashMap<String, String>();
                        map.put("id", json.getString("id"));
                    //    map.put("pg", json.getString("pg"));
                        map.put("gambar", json.getString("gambar"));
                        list_data.add(map);
                    }
                 /**   Glide.with(getApplicationContext())
                            .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(0).get("gambar"))
                            //       .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imageHasil);  **/

                    if (p1.equals(y)){
                        getP1();
                        getKeteranganP1();
                        Glide.with(getApplicationContext())
                                .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(0).get("gambar"))
                                //       .crossFade()
                                .placeholder(R.drawable.box)
                                .into(imageHasil);
                    }else if (p2.equals(y)){
                        getP2();
                        getKeteranganP2();
                        Glide.with(getApplicationContext())
                                .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(1).get("gambar"))
                                //       .crossFade()
                                .placeholder(R.drawable.box)
                                .into(imageHasil);
                    }else if (p3.equals(y)){
                        getP3();
                        getKeteranganP3();
                        Glide.with(getApplicationContext())
                                .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(2).get("gambar"))
                                //       .crossFade()
                                .placeholder(R.mipmap.ic_launcher)
                                .into(imageHasil);
                    }else if (p4.equals(y)){
                        getP4();
                        getKeteranganP4();
                        Glide.with(getApplicationContext())
                                .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(3).get("gambar"))
                                //       .crossFade()
                                .placeholder(R.mipmap.ic_launcher)
                                .into(imageHasil);
                    }else if (p5.equals(y)){
                        getP5();
                        getKeteranganP5();
                        Glide.with(getApplicationContext())
                                .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(4).get("gambar"))
                                //       .crossFade()
                                .placeholder(R.mipmap.ic_launcher)
                                .into(imageHasil);
                    }else if (p6.equals(y)){
                        getP6();
                        getKeteranganP6();
                        Glide.with(getApplicationContext())
                                .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(5).get("gambar"))
                                //       .crossFade()
                                .placeholder(R.mipmap.ic_launcher)
                                .into(imageHasil);
                    }else if (p7.equals(y)){
                        getP7();
                        getKeteranganP7();
                        Glide.with(getApplicationContext())
                                .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(6).get("gambar"))
                                //       .crossFade()
                                .placeholder(R.mipmap.ic_launcher)
                                .into(imageHasil);
                    }else if (p8.equals(y)){
                        getP8();
                        getKeteranganP8();
                        Glide.with(getApplicationContext())
                                .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(7).get("gambar"))
                                //       .crossFade()
                                .placeholder(R.mipmap.ic_launcher)
                                .into(imageHasil);
                    }else if (p9.equals(y)){
                        getP9();
                        getKeteranganP9();
                        Glide.with(getApplicationContext())
                                .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(8).get("gambar"))
                                //       .crossFade()
                                .placeholder(R.mipmap.ic_launcher)
                                .into(imageHasil);
                    }else if (p10.equals(y)){
                        getP10();
                        getKeteranganP10();
                        Glide.with(getApplicationContext())
                                .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(9).get("gambar"))
                                //       .crossFade()
                                .placeholder(R.mipmap.ic_launcher)
                                .into(imageHasil);
                    }else if (p11.equals(y)){
                        getP11();
                        getKeteranganP11();
                        Glide.with(getApplicationContext())
                                .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(10).get("gambar"))
                                //       .crossFade()
                                .placeholder(R.mipmap.ic_launcher)
                                .into(imageHasil);
                    }

                 //   gejala_hsl2.setText(list_data.get(0).get("pg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HasilSp.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);





    }



    ////////////////////////////////////// MENGAMBIL PERAWATAN  /////////////////////////////////////////////////

    private void getP1(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showP1(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_P1);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showP1(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_1);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_1);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_1);


            gejala_hsl.setText(perawatan);
            gejala_hsl2.setText(perawatan);
            kd_gejala_hsl.setText(kode);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }







    private void getP2(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showP2(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_P2);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();


    }

    public void showP2(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_2);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_2);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_2);


            gejala_hsl.setText(perawatan);
            gejala_hsl2.setText(perawatan);
            kd_gejala_hsl.setText(kode);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getP3(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showP3(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_P3);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showP3(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_3);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_3);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_3);

            gejala_hsl.setText(perawatan);
            gejala_hsl2.setText(perawatan);
            kd_gejala_hsl.setText(kode);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }








    private void getP4(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showP4(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_P4);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showP4(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_4);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_4);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_4);

            gejala_hsl.setText(perawatan);
            gejala_hsl2.setText(perawatan);
            kd_gejala_hsl.setText(kode);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }








    private void getP5(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showP5(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_P5);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showP5(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_5);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_5);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_5);

            gejala_hsl.setText(perawatan);
            gejala_hsl2.setText(perawatan);
            kd_gejala_hsl.setText(kode);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }










    private void getP6(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showP6(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_P6);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showP6(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_6);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_6);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_6);

            gejala_hsl.setText(perawatan);
            gejala_hsl2.setText(perawatan);
            kd_gejala_hsl.setText(kode);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }











    private void getP7(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showP7(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_P7);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showP7(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_7);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_7);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_7);

            gejala_hsl.setText(perawatan);
            gejala_hsl2.setText(perawatan);
            kd_gejala_hsl.setText(kode);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }









    private void getP8(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showP8(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_P8);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showP8(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_8);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_8);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_8);

            gejala_hsl.setText(perawatan);
            gejala_hsl2.setText(perawatan);
            kd_gejala_hsl.setText(kode);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }









    private void getP9(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showP9(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_P9);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showP9(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_9);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_9);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_9);

            gejala_hsl.setText(perawatan);
            gejala_hsl2.setText(perawatan);
            kd_gejala_hsl.setText(kode);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getP10(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showP10(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_P10);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showP10(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_10);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_10);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_10);

            gejala_hsl.setText(perawatan);
            gejala_hsl2.setText(perawatan);
            kd_gejala_hsl.setText(kode);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getP11(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showP11(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_P11);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showP11(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_11);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_11);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_11);

            gejala_hsl.setText(perawatan);
            gejala_hsl2.setText(perawatan);
            kd_gejala_hsl.setText(kode);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    ////////////////////////////////////// MENGAMBIL PERAWATAN  /////////////////////////////////////////////////



    //////////////////////////////////////////////////////////


    private void getHasilTglLhr(){
        class GetDataDiri extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showHasilTglLhr(s);
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

    private void showHasilTglLhr(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            //String ed = c.getString(konfigurasi.TAG_ID);
            String tgl = c.getString(konfigurasi.TAG_DD_TGL_LAHIR);

            tgl_lhr.setText(tgl);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }







    private void getHasilJk(){
        class GetDataDiri extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showHasilJk(s);
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

    private void showHasilJk(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            //String ed = c.getString(konfigurasi.TAG_ID);
            String gender = c.getString(konfigurasi.TAG_DD_JK);

            jk.setText(gender);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    //////////////////////////////////////////////////////////






    ////////////////////////////////////// MENGAMBIL KETERANGAN PERAWATAN  /////////////////////////////////////////////////

    private void getKeteranganP1(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showKeteranganP1(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KET_P1);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showKeteranganP1(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String ket = a.getString(konfigurasi.TAG_KETERANGAN_P1);
            String ket2 = a.getString(konfigurasi.TAG_KETERANGAN_P1_2);

            keterangan.setText(ket);
            keterangan2.setText(ket2);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getKeteranganP2(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showKeteranganP2(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KET_P2);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showKeteranganP2(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String ket = a.getString(konfigurasi.TAG_KETERANGAN_P2);
            String ket2 = a.getString(konfigurasi.TAG_KETERANGAN_P2_2);

            keterangan.setText(ket);
            keterangan2.setText(ket2);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getKeteranganP3(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showKeteranganP3(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KET_P3);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showKeteranganP3(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String ket = a.getString(konfigurasi.TAG_KETERANGAN_P3);
            String ket2 = a.getString(konfigurasi.TAG_KETERANGAN_P3_2);

            keterangan.setText(ket);
            keterangan2.setText(ket2);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getKeteranganP4(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showKeteranganP4(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KET_P4);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showKeteranganP4(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String ket = a.getString(konfigurasi.TAG_KETERANGAN_P4);
            String ket2 = a.getString(konfigurasi.TAG_KETERANGAN_P4_2);

            keterangan.setText(ket);
            keterangan2.setText(ket2);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getKeteranganP5(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showKeteranganP5(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KET_P5);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showKeteranganP5(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String ket = a.getString(konfigurasi.TAG_KETERANGAN_P5);
            String ket2 = a.getString(konfigurasi.TAG_KETERANGAN_P5_2);

            keterangan.setText(ket);
            keterangan2.setText(ket2);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getKeteranganP6(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showKeteranganP6(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KET_P6);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showKeteranganP6(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String ket = a.getString(konfigurasi.TAG_KETERANGAN_P6);
            String ket2 = a.getString(konfigurasi.TAG_KETERANGAN_P6_2);

            keterangan.setText(ket);
            keterangan2.setText(ket2);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getKeteranganP7(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showKeteranganP7(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KET_P7);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showKeteranganP7(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String ket = a.getString(konfigurasi.TAG_KETERANGAN_P7);
            String ket2 = a.getString(konfigurasi.TAG_KETERANGAN_P7_2);

            keterangan.setText(ket);
            keterangan2.setText(ket2);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void getKeteranganP8(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showKeteranganP8(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KET_P8);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showKeteranganP8(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String ket = a.getString(konfigurasi.TAG_KETERANGAN_P8);
            String ket2 = a.getString(konfigurasi.TAG_KETERANGAN_P8_2);

            keterangan.setText(ket);
            keterangan2.setText(ket2);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getKeteranganP9(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showKeteranganP9(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KET_P9);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showKeteranganP9(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String ket = a.getString(konfigurasi.TAG_KETERANGAN_P9);
            String ket2 = a.getString(konfigurasi.TAG_KETERANGAN_P9_2);

            keterangan.setText(ket);
            keterangan2.setText(ket2);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getKeteranganP10(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showKeteranganP10(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KET_P10);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showKeteranganP10(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String ket = a.getString(konfigurasi.TAG_KETERANGAN_P10);
            String ket2 = a.getString(konfigurasi.TAG_KETERANGAN_P10_2);

            keterangan.setText(ket);
            keterangan2.setText(ket2);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }






    private void getKeteranganP11(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilSp.this,"Mengambil ","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showKeteranganP11(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KET_P11);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showKeteranganP11(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String ket = a.getString(konfigurasi.TAG_KETERANGAN_P11);
            String ket2 = a.getString(konfigurasi.TAG_KETERANGAN_P11_2);

            keterangan.setText(ket);
            keterangan2.setText(ket2);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    ////////////////////////////////////// MENGAMBIL KETERANGAN PERAWATAN  /////////////////////////////////////////////////




/**
    private void createPdf(String sometext){
        // create a new document
        PdfDocument document = new PdfDocument();
        // crate a page description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(50, 50, 30, paint);
        paint.setColor(Color.BLACK);
        canvas.drawText(sometext, 80, 50, paint);
        //canvas.drawt
        // finish the page
        document.finishPage(page);
// draw text on the graphics object of the page
        // Create Page 2
        pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 2).create();
        page = document.startPage(pageInfo);
        canvas = page.getCanvas();
        paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(100, 100, 100, paint);
        document.finishPage(page);
        // write the document content
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/mypdf/";
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String targetPdf = directory_path+"test-2.pdf";
        File filePath = new File(targetPdf);
        try {
            document.writeTo(new FileOutputStream(filePath));
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.e("main", "error "+e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(),  Toast.LENGTH_LONG).show();
        }
        // close the document
        document.close();
    }  **/






  /////////////////////  Tambahan MENU
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu,menu);
    return super.onCreateOptionsMenu(menu);
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
   // sharing1 = jk.getText().toString();
   // sharing2 = tgl_diagnosa.getText().toString();
    sharing3 = keterangan.getText().toString();
    sharing4 = keterangan2.getText().toString();

        //Bitmap img =((BitmapDrawable)imageHasil.getDrawable()).getBitmap();
        int idd = item.getItemId();
        if (idd==R.id.share){
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String body = "Your body here";
            String sub = "Your Subject";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
            //myIntent.putExtra(Intent.EXTRA_TEXT,sharing);
           // myIntent.putExtra(Intent.EXTRA_TEXT,sharing1);
            //myIntent.putExtra(Intent.EXTRA_TEXT,sharing2);
            myIntent.putExtra(Intent.EXTRA_TEXT,sharing3);
            myIntent.putExtra(Intent.EXTRA_TEXT,sharing4);
            startActivity(Intent.createChooser(myIntent, "Share Using"));

        }
        return super.onOptionsItemSelected(item);
    }






    /////////// back /////////////

    public void onBackPressed() {
        ambilHasil();
        return;
    }



/**
    private void getImageHasil(){
        String url = "http://milaklinik.000webhostapp.com/doktermila/get_image_pakar.php";

        requestQueue = Volley.newRequestQueue(HasilSp.this);

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("perawatan");
                    for (int a = 0; a < jsonArray.length(); a ++){
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map  = new HashMap<String, String>();
                        map.put("id", json.getString("id"));
                        map.put("pg", json.getString("pg"));
                        map.put("gambar", json.getString("gambar"));
                        list_data.add(map);
                    }
                    Glide.with(getApplicationContext())
                            .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(0).get("gambar"))
                            //       .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imageHasil);
                    gejala_hsl2.setText(list_data.get(0).get("pg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HasilSp.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);

    }   **/


  /**  private void screenshot(){
        Date date = new Date();
        CharSequence now = android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss",date);
        String filename = Environment.getExternalStorageDirectory() + "/ScreenShoot/" + now + ".jpg";

        View root = getWindow().getDecorView();
        root.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(root.getDrawingCache());
        root.setDrawingCacheEnabled(false);

        File file = new File(filename);
        file.getParentFile().mkdir();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();

            Uri uri = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri,"image/*");
            startActivity(intent);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }   **/


  private void addHasilPakar(){

      final String id_add = hsl_id.getText().toString().trim();
      final String user_add = hsl_user.getText().toString().trim();
      final String add_hasil = gejala_hsl.getText().toString().trim();
      final String add_kdhasil = kd_gejala_hsl.getText().toString().trim();
      final String add_tgl_diag = tgl_diagnosa.getText().toString().trim();


      class AddHasilPakar extends AsyncTask<Void,Void,String> {

          ProgressDialog loading;

          @Override
          protected void onPreExecute() {
              super.onPreExecute();
              loading = ProgressDialog.show(HasilSp.this,"Menambahkan...","Data...",false,false);
          }

          @Override
          protected void onPostExecute(String s) {
              super.onPostExecute(s);
              loading.dismiss();
              Toast.makeText(HasilSp.this,s,Toast.LENGTH_LONG).show();
          }

          @Override
          protected String doInBackground(Void... v) {
              HashMap<String,String> params = new HashMap<>();
              params.put(konfigurasi.KEY_USER_ID,id_add);
              params.put(konfigurasi.KEY_NAMA,user_add);
              params.put(konfigurasi.KEY_ADD_HASILPAKAR,add_hasil);
              params.put(konfigurasi.KEY_ADD_KDHASILPAKAR,add_kdhasil);
              params.put(konfigurasi.KEY_ADD_TGLHASILPAKAR,add_tgl_diag);

              RequestHandler rh = new RequestHandler();
              String res = rh.sendPostRequest(konfigurasi.URL_ADD_HASIL_PAKAR, params);
              return res;
          }
      }

      AddHasilPakar ae = new AddHasilPakar();
      ae.execute();
  }





  // pdf

    private void savePdf(){
        Document mDoc = new Document();

        String mFileName = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(System.currentTimeMillis());

        String mFilePath = getExternalFilesDir(Environment.DIRECTORY_DCIM) + "/" + mFileName + ".pdf";

        try{
            PdfWriter.getInstance(mDoc, new FileOutputStream(mFilePath));
            mDoc.open();
            String nama = user_sp_open.getText().toString();
            String jkel = jk.getText().toString();
            String tgl_lahir = tgl_lhr.getText().toString();
            String tgl_diag = tgl_diagnosa.getText().toString();
            String perawatan = gejala_hsl.getText().toString();
            String mText = keterangan.getText().toString();
            String mText_ket = keterangan2.getText().toString();
            //Bitmap bitmap = ((BitmapDrawable)imageHasil.getDrawable()).getBitmap();
            String in1 = i1_hs.getText().toString();
            String in2 = i2_hs.getText().toString();
            String in3 = i3_hs.getText().toString();
            String in4 = i4_hs.getText().toString();
            String in5 = i5_hs.getText().toString();
            String in6 = i6_hs.getText().toString();
            String in7 = i7_hs.getText().toString();
            String in8 = i8_hs.getText().toString();
            String in9 = i9_hs.getText().toString();
            String k1 = k1_hs.getText().toString();
            String k2 = k2_hs.getText().toString();
            String k3 = k3_hs.getText().toString();
            String k4 = k4_hs.getText().toString();
            String k5 = k5_hs.getText().toString();
            String k6 = k6_hs.getText().toString();
            String k7 = k7_hs.getText().toString();
            String k8 = k8_hs.getText().toString();
            String k9 = k9_hs.getText().toString();

            mDoc.addAuthor("Tatak");
            //mDoc.add(new Chunk(mText));
            mDoc.add(new Paragraph("Nama : "+nama));
            mDoc.add(new Paragraph("Gender : "+jkel));
            mDoc.add(new Paragraph("Tanggal Lahir : "+tgl_lahir));
            mDoc.add(new Paragraph("Tanggal Diagnosa : "+tgl_diag));
            mDoc.add(new Paragraph("Disarankan Untuk : "+perawatan));
            mDoc.add(new Paragraph("_______________________________________________"));
            mDoc.add(new Paragraph("_______________________________________________"));
            mDoc.add(new Paragraph("Kondisi Dialami : "));
            mDoc.add(new Paragraph(in1+"  "+k1));
            mDoc.add(new Paragraph(in2+"  "+k2));
            mDoc.add(new Paragraph(in3+"  "+k3));
            mDoc.add(new Paragraph(in4+"  "+k4));
            mDoc.add(new Paragraph(in5+"  "+k5));
            mDoc.add(new Paragraph(in6+"  "+k6));
            mDoc.add(new Paragraph(in7+"  "+k7));
            mDoc.add(new Paragraph(in8+"  "+k8));
            mDoc.add(new Paragraph(in9+"  "+k9));
            mDoc.add(new Paragraph("                                               "));
            mDoc.add(new Paragraph(mText));
            mDoc.add(new Paragraph(mText_ket));
            mDoc.close();
            Toast.makeText(this, mFileName +".pdf\nis saved to\n"+ mFilePath, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case STORAGE_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    savePdf();
                }
                else {
                    Toast.makeText(this, "Permission denied...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }









}