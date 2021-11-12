package com.example.doktermila;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
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
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;

public class KetList extends AppCompatActivity {

    private static final int STORAGE_CODE = 1000;

    private String id;
    private TextView titlee;
    private TextView isii, id_rwy, username_rwy,user_riwayat, tgl_diag, pr,pr2, tgl_lhr_riwayat,jk_riwayat,kode, ket1, ket2;
    Button btn_pdf;

    String ido, username, tglr, p_r, kdpg;

    ImageView imageHasil;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    ArrayList<HashMap<String, String>> list_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        final Intent intent = getIntent();

     //   id = intent.getStringExtra(konfigurasi.EMP_ID);
        tglr = intent.getStringExtra(konfigurasi.TGL_DIAG);
        p_r = intent.getStringExtra(konfigurasi.PR);
        kdpg = intent.getStringExtra(konfigurasi.TAG_KD_PG);

        id_rwy = (TextView) findViewById(R.id.idep);
        username_rwy = (TextView) findViewById(R.id.hsl_user_p);
        btn_pdf = (Button) findViewById(R.id.pdf_btn);

        user_riwayat = (TextView) findViewById(R.id.user_riwayat);
        tgl_diag = (TextView) findViewById(R.id.tgl_diagnosa_riwayat);

        pr = (TextView) findViewById(R.id.perawatan_riwayat);
        pr2 = (TextView) findViewById(R.id.perawatan_riwayat2);
        ket1 = (TextView) findViewById(R.id.keterangan_riwayat1);
        ket2 = (TextView) findViewById(R.id.keterangan_riwayat2);


        tgl_lhr_riwayat = (TextView) findViewById(R.id.tgl_lhr_riwayat);
        jk_riwayat = (TextView) findViewById(R.id.jk_riwayat);

        kode = (TextView) findViewById(R.id.kdpg);
        imageHasil = (ImageView) findViewById(R.id.image_hslr);

        id = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);
        id_rwy.setText(id);
        username_rwy.setText(username);

        user_riwayat.setText(username);
        tgl_diag.setText(tglr);
        kode.setText(kdpg);
        pr.setText(p_r);
        pr2.setText(p_r);


        getRiwayat();
        getHasilTglLhr();
        getHasilJk();


    /**    if (kdpg == p1){
            getKeteranganP1();
        }else if (kdpg == p2){
            getKeteranganP2();
        }else if (kdpg == p3){
            getKeteranganP3();
        }else if (kdpg == p4){
            getKeteranganP4();
        }else if (kdpg == p5){
            getKeteranganP5();
        }else if (kdpg == p6){
            getKeteranganP6();
        }else if (kdpg == p7){
            getKeteranganP7();
        }else if (kdpg == p8){
            getKeteranganP8();
        }else if (kdpg == p9){
            getKeteranganP9();
        }else if (kdpg == p10){
            getKeteranganP10();
        }else if (kdpg == p11){
            getKeteranganP11();
        } **/


    btn_pdf.setOnClickListener(new View.OnClickListener() {
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


    } // oncreat



    private void savePdf(){
        Document mDoc = new Document();

        String mFileName = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(System.currentTimeMillis());

        String mFilePath = getExternalFilesDir(Environment.DIRECTORY_DCIM) + "/" + mFileName + ".pdf";

        try{
            PdfWriter.getInstance(mDoc, new FileOutputStream(mFilePath));
            mDoc.open();
            String nama = user_riwayat.getText().toString();
            String tgl = tgl_diag.getText().toString();
            String perawatan = pr.getText().toString();
            String mText = ket1.getText().toString();
            String mText_ket = ket2.getText().toString();
            //Bitmap bitmap = ((BitmapDrawable)imageHasil.getDrawable()).getBitmap();

            mDoc.addAuthor("Tatak");
            //mDoc.add(new Chunk(mText));
            mDoc.add(new Paragraph("Nama : "+nama));
            mDoc.add(new Paragraph("Tanggal Diagnosa : "+tgl));
            mDoc.add(new Paragraph("Disarankan Untuk : "+perawatan));
            mDoc.add(new Paragraph("_______________________________________________"));
            mDoc.add(new Paragraph("_______________________________________________"));
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





    public void getRiwayat(){


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

        String y = kode.getText().toString();



    String url = "http://milaklinik.000webhostapp.com/doktermila/get_image_pakar.php";

    requestQueue = Volley.newRequestQueue(KetList .this);

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
                    getKeteranganP1();
                    Glide.with(getApplicationContext())
                            .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(0).get("gambar"))
                            //       .crossFade()
                            .placeholder(R.drawable.box)
                            .into(imageHasil);
                }else if (p2.equals(y)){
                    getKeteranganP2();
                    Glide.with(getApplicationContext())
                            .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(1).get("gambar"))
                            //       .crossFade()
                            .placeholder(R.drawable.box)
                            .into(imageHasil);
                }else if (p3.equals(y)){
                    getKeteranganP3();
                    Glide.with(getApplicationContext())
                            .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(2).get("gambar"))
                            //       .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imageHasil);
                }else if (p4.equals(y)){
                    getKeteranganP4();
                    Glide.with(getApplicationContext())
                            .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(3).get("gambar"))
                            //       .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imageHasil);
                }else if (p5.equals(y)){
                    getKeteranganP5();
                    Glide.with(getApplicationContext())
                            .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(4).get("gambar"))
                            //       .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imageHasil);
                }else if (p6.equals(y)){
                    getKeteranganP6();
                    Glide.with(getApplicationContext())
                            .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(5).get("gambar"))
                            //       .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imageHasil);
                }else if (p7.equals(y)){
                    getKeteranganP7();
                    Glide.with(getApplicationContext())
                            .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(6).get("gambar"))
                            //       .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imageHasil);
                }else if (p8.equals(y)){
                    getKeteranganP8();
                    Glide.with(getApplicationContext())
                            .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(7).get("gambar"))
                            //       .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imageHasil);
                }else if (p9.equals(y)){
                    getKeteranganP9();
                    Glide.with(getApplicationContext())
                            .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(8).get("gambar"))
                            //       .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imageHasil);
                }else if (p10.equals(y)){
                    getKeteranganP10();
                    Glide.with(getApplicationContext())
                            .load("http://milaklinik.000webhostapp.com/doktermila/images/" + list_data.get(9).get("gambar"))
                            //       .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imageHasil);
                }else if (p11.equals(y)){
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
            Toast.makeText(KetList.this, error.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });

        requestQueue.add(stringRequest);





}













    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(KetList.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_EMP,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String ed = c.getString(konfigurasi.TAG_ID);
            String title = c.getString(konfigurasi.TAG_JUDUL);
            String isi = c.getString(konfigurasi.TAG_KONTEN);

            titlee.setText(title);
            isii.setText(isi);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }








    ///// tgl lahir

    private void getHasilTglLhr(){
        class GetDataDiri extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_DATADIRI_RIWAYAT,username);
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
            String tgl = c.getString(konfigurasi.TAG_DD_TGL_LAHIR_R);

            tgl_lhr_riwayat.setText(tgl);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    // jk
    private void getHasilJk(){
        class GetDataDiri extends AsyncTask<Void,Void,String> {

            String vt2 = id_rwy.getText().toString();
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_DATADIRI_RIWAYAT,username);
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
            String gender = c.getString(konfigurasi.TAG_DD_JK_R);

            jk_riwayat.setText(gender);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }








    ////////////////////////////////////// MENGAMBIL KETERANGAN PERAWATAN  /////////////////////////////////////////////////

    private void getKeteranganP1(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
            String kett = a.getString(konfigurasi.TAG_KETERANGAN_P1_2);

            ket1.setText(ket);
            ket2.setText(kett);


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
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
            String kett = a.getString(konfigurasi.TAG_KETERANGAN_P2_2);

            ket1.setText(ket);
            ket2.setText(kett);


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
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
            String kett = a.getString(konfigurasi.TAG_KETERANGAN_P3_2);

            ket1.setText(ket);
            ket2.setText(kett);

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
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
            String kett = a.getString(konfigurasi.TAG_KETERANGAN_P4_2);

            ket1.setText(ket);
            ket2.setText(kett);


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
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
            String kett = a.getString(konfigurasi.TAG_KETERANGAN_P5_2);

            ket1.setText(ket);
            ket2.setText(kett);


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
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
            String kett = a.getString(konfigurasi.TAG_KETERANGAN_P6_2);

            ket1.setText(ket);
            ket2.setText(kett);


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
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
            String kett = a.getString(konfigurasi.TAG_KETERANGAN_P7_2);

            ket1.setText(ket);
            ket2.setText(kett);


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
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
            String kett = a.getString(konfigurasi.TAG_KETERANGAN_P8_2);

            ket1.setText(ket);
            ket2.setText(kett);


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
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
            String kett = a.getString(konfigurasi.TAG_KETERANGAN_P9_2);

            ket1.setText(ket);
            ket2.setText(kett);


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
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
            String kett = a.getString(konfigurasi.TAG_KETERANGAN_P10_2);

            ket1.setText(ket);
            ket2.setText(kett);


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
                loading = ProgressDialog.show(KetList.this,"Mengambil ","Data..",false,false);
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
            String kett = a.getString(konfigurasi.TAG_KETERANGAN_P11_2);

            ket1.setText(ket);
            ket2.setText(kett);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    ////////////////////////////////////// MENGAMBIL KETERANGAN PERAWATAN  /////////////////////////////////////////////////



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
