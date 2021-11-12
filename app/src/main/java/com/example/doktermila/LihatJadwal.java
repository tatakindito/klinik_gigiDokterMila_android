package com.example.doktermila;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doktermila.perawatan.ActTindakan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class LihatJadwal extends AppCompatActivity {

    private String JSON_STRING;
    private ListView list_jdw;
    TextView tmp;

    private TextView a1,a2,a3,a4,a5,
    b1,b2,b3,b4,b5,
    c1,c2,c3,c4,c5,
    d1,d2,d3,d4,d5,
    e1,e2,e3,e4,e5,
    f1,f2,f3,f4,f5,
    g1,g2,g3,g4,g5,
    h1,h2,h3,h4,h5,
    i1,i2,i3,i4,i5,
    j1,j2,j3,j4,j5,
    k1,k2,k3,k4,k5;

    Button a6,b6,c6,d6,e6,f6,g6,h6,i6,j6,k6;

    private String data, kosong;
    
    String [] value = new String[]{
            "Control",
            "Scaling",
            "Kawat Gigi",
            "Cabut Gigi",
            "Tambal",
            "Restorasi"
    };
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_jadwal);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        a1 = (TextView) findViewById(R.id.a1);
        a2 = (TextView) findViewById(R.id.a2);
        a3 = (TextView) findViewById(R.id.a3);
        a4 = (TextView) findViewById(R.id.a4);
        a5 = (TextView) findViewById(R.id.a5);

        b1 = (TextView) findViewById(R.id.b1);
        b2 = (TextView) findViewById(R.id.b2);
        b3 = (TextView) findViewById(R.id.b3);
        b4 = (TextView) findViewById(R.id.b4);
        b5 = (TextView) findViewById(R.id.b5);

        c1 = (TextView) findViewById(R.id.c1);
        c2 = (TextView) findViewById(R.id.c2);
        c3 = (TextView) findViewById(R.id.c3);
        c4 = (TextView) findViewById(R.id.c4);
        c5 = (TextView) findViewById(R.id.c5);

        d1 = (TextView) findViewById(R.id.d1);
        d2 = (TextView) findViewById(R.id.d2);
        d3 = (TextView) findViewById(R.id.d3);
        d4 = (TextView) findViewById(R.id.d4);
        d5 = (TextView) findViewById(R.id.d5);

        e1 = (TextView) findViewById(R.id.e1);
        e2 = (TextView) findViewById(R.id.e2);
        e3 = (TextView) findViewById(R.id.e3);
        e4 = (TextView) findViewById(R.id.e4);
        e5 = (TextView) findViewById(R.id.e5);

        f1 = (TextView) findViewById(R.id.f1);
        f2 = (TextView) findViewById(R.id.f2);
        f3 = (TextView) findViewById(R.id.f3);
        f4 = (TextView) findViewById(R.id.f4);
        f5 = (TextView) findViewById(R.id.f5);

        g1 = (TextView) findViewById(R.id.g1);
        g2 = (TextView) findViewById(R.id.g2);
        g3 = (TextView) findViewById(R.id.g3);
        g4 = (TextView) findViewById(R.id.g4);
        g5 = (TextView) findViewById(R.id.g5);

        h1 = (TextView) findViewById(R.id.h1);
        h2 = (TextView) findViewById(R.id.h2);
        h3 = (TextView) findViewById(R.id.h3);
        h4 = (TextView) findViewById(R.id.h4);
        h5 = (TextView) findViewById(R.id.h5);

        i1 = (TextView) findViewById(R.id.i1);
        i2 = (TextView) findViewById(R.id.i2);
        i3 = (TextView) findViewById(R.id.i3);
        i4 = (TextView) findViewById(R.id.i4);
        i5 = (TextView) findViewById(R.id.i5);

        j1 = (TextView) findViewById(R.id.j1);
        j2 = (TextView) findViewById(R.id.j2);
        j3 = (TextView) findViewById(R.id.j3);
        j4 = (TextView) findViewById(R.id.j4);
        j5 = (TextView) findViewById(R.id.j5);

        k1 = (TextView) findViewById(R.id.k1);
        k2 = (TextView) findViewById(R.id.k2);
        k3 = (TextView) findViewById(R.id.k3);
        k4 = (TextView) findViewById(R.id.k4);
        k5 = (TextView) findViewById(R.id.k5);

        a6 = (Button) findViewById(R.id.a6);
        b6 = (Button) findViewById(R.id.b6);
        c6 = (Button) findViewById(R.id.c6);
        d6 = (Button) findViewById(R.id.d6);
        e6 = (Button) findViewById(R.id.e6);
        f6 = (Button) findViewById(R.id.f6);
        g6 = (Button) findViewById(R.id.g6);
        h6 = (Button) findViewById(R.id.h6);
        i6 = (Button) findViewById(R.id.i6);
        j6 = (Button) findViewById(R.id.j6);
        k6 = (Button) findViewById(R.id.k6);

        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(LihatJadwal.this);
                alert.setTitle("Pilih Perawatan");
                alert.setItems(value, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String select = Arrays.asList(value).get(which);
                        if (select == "Control"){
                            Intent i = new Intent(LihatJadwal.this, ActTindakan.class);
                            startActivity(i);
                        }
                        if (select == "Scaling"){
                            Toast.makeText(LihatJadwal.this, "Scaling", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
                
                AlertDialog dialog = alert.create();
                dialog.show();
                
                Intent aa = new Intent(LihatJadwal.this, ActTindakan.class);
                startActivity(aa);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bb = new Intent(LihatJadwal.this, ActTindakan.class);
                startActivity(bb);
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cc = new Intent(LihatJadwal.this, ActTindakan.class);
                startActivity(cc);
            }
        });

        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dd = new Intent(LihatJadwal.this, ActTindakan.class);
                startActivity(dd);
            }
        });

        e6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ee = new Intent(LihatJadwal.this, ActTindakan.class);
                startActivity(ee);
            }
        });

        f6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ff = new Intent(LihatJadwal.this, ActTindakan.class);
                startActivity(ff);
            }
        });

        g6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gg = new Intent(LihatJadwal.this, ActTindakan.class);
                startActivity(gg);
            }
        });

        h6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hh = new Intent(LihatJadwal.this, ActTindakan.class);
                startActivity(hh);
            }
        });

        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(LihatJadwal.this, ActTindakan.class);
                startActivity(ii);
            }
        });

        j6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jj = new Intent(LihatJadwal.this, ActTindakan.class);
                startActivity(jj);
            }
        });

        k6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kk = new Intent(LihatJadwal.this, ActTindakan.class);
                startActivity(kk);
            }
        });

        tmp = (TextView) findViewById(R.id.bp);
        data = getIntent().getExtras().getString("cekjadwal");  // ambil tgl dr HalamanUtama
        tmp.setText(data);


      //  getJadwal();
        getEmployee();
        getEmployee1();
        getEmployee2();
        getEmployee3();
        getEmployee4();
        getEmployee5();
        getEmployee6();
        getEmployee7();
        getEmployee8();
        getEmployee9();
        getEmployee10();



    }// Batas On Creat



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }






    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            /**  showEmployee1(s);
                showEmployee2(s);
                showEmployee3(s);
                showEmployee4(s);
                showEmployee5(s);
                showEmployee6(s);
                showEmployee7(s);
                showEmployee8(s);
                showEmployee9(s);
                showEmployee10(s); **/
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK_ALL,data);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void getEmployee1(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee1(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK_ALL1,data);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }


    private void getEmployee2(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee2(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK_ALL2,data);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }


    private void getEmployee3(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee3(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK_ALL3,data);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }


    private void getEmployee4(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee4(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK_ALL4,data);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }


    private void getEmployee5(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee5(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK_ALL5,data);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }



    private void getEmployee6(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee6(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK_ALL6,data);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }


    private void getEmployee7(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee7(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK_ALL7,data);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }


    private void getEmployee8(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee8(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK_ALL8,data);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }


    private void getEmployee9(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee9(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK_ALL9,data);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }



    private void getEmployee10(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee10(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK_ALL10,data);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }










    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_A);
            JSONObject a = result.getJSONObject(0);

            String a1_ = a.getString(konfigurasi.TAG_A1);
            String a2_ = a.getString(konfigurasi.TAG_A2);
            String a3_ = a.getString(konfigurasi.TAG_A3);
            String a4_ = a.getString(konfigurasi.TAG_A4);
            String a5_ = a.getString(konfigurasi.TAG_A5);

            a1.setText(a1_);
            a2.setText(a2_);
            a3.setText(a3_);
            a4.setText(a4_);
            a5.setText(a5_);

            String x;
            x = a5.getText().toString();

            if (x != null){
                a6.setEnabled(false);
            }else if (x == null){
                a6.setEnabled(false);
            }

            a6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent aa = new Intent(LihatJadwal.this, ActTindakan.class);
                    startActivity(aa);
                }
            });


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void showEmployee1(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result1 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_B);
            JSONObject b = result1.getJSONObject(0);

            String b1_= b.getString(konfigurasi.TAG_B1);
            String b2_= b.getString(konfigurasi.TAG_B2);
            String b3_= b.getString(konfigurasi.TAG_B3);
            String b4_= b.getString(konfigurasi.TAG_B4);
            String b5_= b.getString(konfigurasi.TAG_B5);

            b1.setText(b1_);
            b2.setText(b2_);
            b3.setText(b3_);
            b4.setText(b4_);
            b5.setText(b5_);

            String x;
            x = b5.getText().toString();

            if (x != null){
                b6.setEnabled(false);
            }

            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent bb = new Intent(LihatJadwal.this, ActTindakan.class);
                    startActivity(bb);
                }
            });


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void showEmployee2(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result2 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_C);
            JSONObject c = result2.getJSONObject(0);

            String c1_= c.getString(konfigurasi.TAG_C1);
            String c2_= c.getString(konfigurasi.TAG_C2);
            String c3_= c.getString(konfigurasi.TAG_C3);
            String c4_= c.getString(konfigurasi.TAG_C4);
            String c5_= c.getString(konfigurasi.TAG_C5);

            c1.setText(c1_);
            c2.setText(c2_);
            c3.setText(c3_);
            c4.setText(c4_);
            c5.setText(c5_);

            String x;
            x = c5.getText().toString();

            if (x != null){
                c6.setEnabled(false);
            }

            c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent cc = new Intent(LihatJadwal.this, ActTindakan.class);
                    startActivity(cc);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void showEmployee3(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result3 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_D);
            JSONObject d = result3.getJSONObject(0);

            String d1_= d.getString(konfigurasi.TAG_D1);
            String d2_= d.getString(konfigurasi.TAG_D2);
            String d3_= d.getString(konfigurasi.TAG_D3);
            String d4_= d.getString(konfigurasi.TAG_D4);
            String d5_= d.getString(konfigurasi.TAG_D5);

            d1.setText(d1_);
            d2.setText(d2_);
            d3.setText(d3_);
            d4.setText(d4_);
            d5.setText(d5_);

            String x;
            x = d5.getText().toString();

            if (x != null){
                d6.setEnabled(false);
            }else if (x == null){
                d6.setEnabled(false);
            }

            d6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent dd = new Intent(LihatJadwal.this, ActTindakan.class);
                    startActivity(dd);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void showEmployee4(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result4 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_E);
            JSONObject e = result4.getJSONObject(0);

            String e1_= e.getString(konfigurasi.TAG_E1);
            String e2_= e.getString(konfigurasi.TAG_E2);
            String e3_= e.getString(konfigurasi.TAG_E3);
            String e4_= e.getString(konfigurasi.TAG_E4);
            String e5_= e.getString(konfigurasi.TAG_E5);

            e1.setText(e1_);
            e2.setText(e2_);
            e3.setText(e3_);
            e4.setText(e4_);
            e5.setText(e5_);

            String x;
            x = e5.getText().toString();

            if (x != null){
                e6.setEnabled(false);
            }else if (x == null){
                e6.setEnabled(false);
            }

            e6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ee = new Intent(LihatJadwal.this, ActTindakan.class);
                    startActivity(ee);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void showEmployee5(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result5 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_F);
            JSONObject f = result5.getJSONObject(0);

            String f1_= f.getString(konfigurasi.TAG_F1);
            String f2_= f.getString(konfigurasi.TAG_F2);
            String f3_= f.getString(konfigurasi.TAG_F3);
            String f4_= f.getString(konfigurasi.TAG_F4);
            String f5_= f.getString(konfigurasi.TAG_F5);

            f1.setText(f1_);
            f2.setText(f2_);
            f3.setText(f3_);
            f4.setText(f4_);
            f5.setText(f5_);

            String x;
            x = f5.getText().toString();

            if (x != null){
                f6.setEnabled(false);
            }else if (x == null){
                f6.setEnabled(false);
            }

            f6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ff = new Intent(LihatJadwal.this, ActTindakan.class);
                    startActivity(ff);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void showEmployee6(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result6 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_G);
            JSONObject g = result6.getJSONObject(0);

            String g1_= g.getString(konfigurasi.TAG_G1);
            String g2_= g.getString(konfigurasi.TAG_G2);
            String g3_= g.getString(konfigurasi.TAG_G3);
            String g4_= g.getString(konfigurasi.TAG_G4);
            String g5_= g.getString(konfigurasi.TAG_G5);

            g1.setText(g1_);
            g2.setText(g2_);
            g3.setText(g3_);
            g4.setText(g4_);
            g5.setText(g5_);

            String x;
            x = g5.getText().toString();

            if (x != null){
                g6.setEnabled(false);
            }else if (x == null){
                g6.setEnabled(false);
            }

            g6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent gg = new Intent(LihatJadwal.this, ActTindakan.class);
                    startActivity(gg);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void showEmployee7(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result7 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_H);
            JSONObject h = result7.getJSONObject(0);

            String h1_= h.getString(konfigurasi.TAG_H1);
            String h2_= h.getString(konfigurasi.TAG_H2);
            String h3_= h.getString(konfigurasi.TAG_H3);
            String h4_= h.getString(konfigurasi.TAG_H4);
            String h5_= h.getString(konfigurasi.TAG_H5);

            h1.setText(h1_);
            h2.setText(h2_);
            h3.setText(h3_);
            h4.setText(h4_);
            h5.setText(h5_);

            String x;
            x = h5.getText().toString();

            if (x != null){
                h6.setEnabled(false);
            }else if (x == null){
                h6.setEnabled(false);
            }

            h6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent hh = new Intent(LihatJadwal.this, ActTindakan.class);
                    startActivity(hh);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void showEmployee8(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result8 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_I);
            JSONObject i = result8.getJSONObject(0);

            String i1_= i.getString(konfigurasi.TAG_I1);
            String i2_= i.getString(konfigurasi.TAG_I2);
            String i3_= i.getString(konfigurasi.TAG_I3);
            String i4_= i.getString(konfigurasi.TAG_I4);
            String i5_= i.getString(konfigurasi.TAG_I5);

            i1.setText(i1_);
            i2.setText(i2_);
            i3.setText(i3_);
            i4.setText(i4_);
            i5.setText(i5_);

            String x;
            x = i5.getText().toString();

            if (x != null){
                i6.setEnabled(false);
            }else if (x == null){
                i6.setEnabled(false);
            }

            i6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ii = new Intent(LihatJadwal.this, ActTindakan.class);
                    startActivity(ii);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void showEmployee9(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result9 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_J);
            JSONObject j = result9.getJSONObject(0);

            String j1_= j.getString(konfigurasi.TAG_J1);
            String j2_= j.getString(konfigurasi.TAG_J2);
            String j3_= j.getString(konfigurasi.TAG_J3);
            String j4_= j.getString(konfigurasi.TAG_J4);
            String j5_= j.getString(konfigurasi.TAG_J5);

            j1.setText(j1_);
            j2.setText(j2_);
            j3.setText(j3_);
            j4.setText(j4_);
            j5.setText(j5_);

            String x;
            x = j5.getText().toString();

            if (x != null){
                j6.setEnabled(false);
            }else if (x == null){
                j6.setEnabled(false);
            }

            j6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent jj = new Intent(LihatJadwal.this, ActTindakan.class);
                    startActivity(jj);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void showEmployee10(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result10 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_K);
            JSONObject k = result10.getJSONObject(0);

            String k1_= k.getString(konfigurasi.TAG_K1);
            String k2_= k.getString(konfigurasi.TAG_K2);
            String k3_= k.getString(konfigurasi.TAG_K3);
            String k4_= k.getString(konfigurasi.TAG_K4);
            String k5_= k.getString(konfigurasi.TAG_K5);

            k1.setText(k1_);
            k2.setText(k2_);
            k3.setText(k3_);
            k4.setText(k4_);
            k5.setText(k5_);

            String x;
            x = k5.getText().toString();

            if (x != null){
                k6.setEnabled(false);
            }else if (x == null){
                k6.setEnabled(false);
            }

            k6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent kk = new Intent(LihatJadwal.this, ActTindakan.class);
                    startActivity(kk);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





/**

        ///////////////////          2      /////////////////////////////


    private void getJadwalAll(){
        class GetEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showJadwalAll(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK_ALL,data);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }


    private void showJadwalAll(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_A);
            JSONArray result1 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_B);
         JSONArray result2 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_C);
            JSONArray result3 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_D);
            JSONArray result4 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_E);
            JSONArray result5 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_F);
            JSONArray result6 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_G);
            JSONArray result7 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_H);
            JSONArray result8 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_I);
            JSONArray result9 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_J);
            JSONArray result10 = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_K);

            JSONObject a = result.getJSONObject(0);
            JSONObject b = result1.getJSONObject(0);
         JSONObject c = result2.getJSONObject(0);
            JSONObject d = result3.getJSONObject(0);
            JSONObject e = result4.getJSONObject(0);
            JSONObject f = result5.getJSONObject(0);
            JSONObject g = result6.getJSONObject(0);
            JSONObject h = result7.getJSONObject(0);
            JSONObject i = result8.getJSONObject(0);
            JSONObject j = result9.getJSONObject(0);
            JSONObject k = result10.getJSONObject(0);


                String a1x = a.getString(konfigurasi.TAG_A1);
                String a2x = a.getString(konfigurasi.TAG_A2);
                String a3x = a.getString(konfigurasi.TAG_A3);
                String a4x = a.getString(konfigurasi.TAG_A4);
                String a5x = a.getString(konfigurasi.TAG_A5);

                String b1x= b.getString(konfigurasi.TAG_B1);
                String b2x= b.getString(konfigurasi.TAG_B2);
                String b3x= b.getString(konfigurasi.TAG_B3);
                String b4x= b.getString(konfigurasi.TAG_B4);
                String b5x= b.getString(konfigurasi.TAG_B5);

            String c1_= a.getString(konfigurasi.TAG_C1);
            String c2_= a.getString(konfigurasi.TAG_C2);
            String c3_= a.getString(konfigurasi.TAG_C3);
            String c4_= a.getString(konfigurasi.TAG_C4);
            String c5_= a.getString(konfigurasi.TAG_C5);

            String d1_= a.getString(konfigurasi.TAG_D1);
            String d2_= a.getString(konfigurasi.TAG_D2);
            String d3_= a.getString(konfigurasi.TAG_D3);
            String d4_= a.getString(konfigurasi.TAG_D4);
            String d5_= a.getString(konfigurasi.TAG_D5);

            String e1_= a.getString(konfigurasi.TAG_E1);
            String e2_= a.getString(konfigurasi.TAG_E2);
            String e3_= a.getString(konfigurasi.TAG_E3);
            String e4_= a.getString(konfigurasi.TAG_E4);
            String e5_= a.getString(konfigurasi.TAG_E5);

            String f1_= a.getString(konfigurasi.TAG_F1);
            String f2_= a.getString(konfigurasi.TAG_F2);
            String f3_= a.getString(konfigurasi.TAG_F3);
            String f4_= a.getString(konfigurasi.TAG_F4);
            String f5_= a.getString(konfigurasi.TAG_F5);

            String g1_= a.getString(konfigurasi.TAG_G1);
            String g2_= a.getString(konfigurasi.TAG_G2);
            String g3_= a.getString(konfigurasi.TAG_G3);
            String g4_= a.getString(konfigurasi.TAG_G4);
            String g5_= a.getString(konfigurasi.TAG_G5);

            String h1_= a.getString(konfigurasi.TAG_H1);
            String h2_= a.getString(konfigurasi.TAG_H2);
            String h3_= a.getString(konfigurasi.TAG_H3);
            String h4_= a.getString(konfigurasi.TAG_H4);
            String h5_= a.getString(konfigurasi.TAG_H5);

            String i1_= a.getString(konfigurasi.TAG_I1);
            String i2_= a.getString(konfigurasi.TAG_I2);
            String i3_= a.getString(konfigurasi.TAG_I3);
            String i4_= a.getString(konfigurasi.TAG_I4);
            String i5_= a.getString(konfigurasi.TAG_I5);

            String j1_= a.getString(konfigurasi.TAG_J1);
            String j2_= a.getString(konfigurasi.TAG_J2);
            String j3_= a.getString(konfigurasi.TAG_J3);
            String j4_= a.getString(konfigurasi.TAG_J4);
            String j5_= a.getString(konfigurasi.TAG_J5);

            String k1_= a.getString(konfigurasi.TAG_K1);
            String k2_= a.getString(konfigurasi.TAG_K2);
            String k3_= a.getString(konfigurasi.TAG_K3);
            String k4_= a.getString(konfigurasi.TAG_K4);
            String k5_= a.getString(konfigurasi.TAG_K5);

            // SET TEXT

            a1.setText(a1x);
            a2.setText(a2x);
            a3.setText(a3x);
            a4.setText(a4x);
            a5.setText(a5x);

            b1.setText(b1x);
            b2.setText(b2x);
            b3.setText(b3x);
            b4.setText(b4x);
            b5.setText(b5x);

            c1.setText(c1_);
            c2.setText(c2_);
            c3.setText(c3_);
            c4.setText(c4_);
            c5.setText(c5_);

            d1.setText(d1_);
            d2.setText(d2_);
            d3.setText(d3_);
            d4.setText(d4_);
            d5.setText(d5_);

            e1.setText(e1_);
            e2.setText(e2_);
            e3.setText(e3_);
            e4.setText(e4_);
            e5.setText(e5_);

            f1.setText(f1_);
            f2.setText(f2_);
            f3.setText(f3_);
            f4.setText(f4_);
            f5.setText(f5_);

            g1.setText(g1_);
            g2.setText(g2_);
            g3.setText(g3_);
            g4.setText(g4_);
            g5.setText(g5_);

            h1.setText(h1_);
            h2.setText(h2_);
            h3.setText(h3_);
            h4.setText(h4_);
            h5.setText(h5_);

            i1.setText(i1_);
            i2.setText(i2_);
            i3.setText(i3_);
            i4.setText(i4_);
            i5.setText(i5_);

            j1.setText(j1_);
            j2.setText(j2_);
            j3.setText(j3_);
            j4.setText(j4_);
            j5.setText(j5_);

            k1.setText(k1_);
            k2.setText(k2_);
            k3.setText(k3_);
            k4.setText(k4_);
            k5.setText(k5_);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

            /////////////////////      2     ////////////////////////////////////

   **/






    /**
        ///////////////              1   //////////////////////


    private void showJadwal(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(konfigurasi.TAG_ID_CONTROL);
                String d = jo.getString(konfigurasi.TAG_DOKTERC1);
                String a = jo.getString(konfigurasi.TAG_JAMC1);
                String c = jo.getString(konfigurasi.TAG_ACTC1);
                String b = jo.getString(konfigurasi.TAG_PASIENC1);


                HashMap<String,String> employees = new HashMap<>();
                employees.put(konfigurasi.TAG_ID_CONTROL,id);
                employees.put(konfigurasi.TAG_DOKTERC1, d);
                employees.put(konfigurasi.TAG_JAMC1, a);
                employees.put(konfigurasi.TAG_ACTC1, c);
                employees.put(konfigurasi.TAG_PASIENC1, b);


                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                LihatJadwal.this, list, R.layout.activity_list_item_jadwal,
                new String[]{konfigurasi.TAG_ID_CONTROL,konfigurasi.TAG_DOKTERC1,konfigurasi.TAG_JAMC1,konfigurasi.TAG_ACTC1,konfigurasi.TAG_PASIENC1},
                new int[]{R.id.id_list_jdw, R.id.jdw_list_dokter, R.id.jdw_list_jam, R.id.jdw_list_perawatan, R.id.jdw_list_pasien});

        list_jdw.setAdapter(adapter);
    }



    private void getJadwal(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatJadwal.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showJadwal();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_JADWAL_CEK, data);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }


                ////////////////////    1     //////////////////////
**/

}