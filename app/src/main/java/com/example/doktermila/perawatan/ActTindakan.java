package com.example.doktermila.perawatan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.doktermila.R;
import com.example.doktermila.RequestHandler;
import com.example.doktermila.konfigurasi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;

// public class ActTindakan extends AppCompatActivity implements ListView.OnItemClickListener {
public class ActTindakan extends AppCompatActivity {

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    EditText txt_tgl, txt_jam, jdw_tgw;
    TextView p_control, dokterHariIni_control, txt_id, txt_user, add_jdw;
    private TextView jamc1, pasienc1, actc1, dokterc1;
    Button btn_get_datetime, cek, ad;

    String id_user, username, aa, bb, cc, dd, ee, ff,gt,data,kosong;
    private String JSON_STRING;
    private ListView listing;


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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_tindakan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ///////////////////////// BOTTOM LIST ///////////////////////////
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


    /**
        // Inisiasi jadwal hari ini bottom sheet
        jamc1 = (TextView) findViewById(R.id.jamc1);
        pasienc1 = (TextView) findViewById(R.id.pasienc1);
        actc1 = (TextView) findViewById(R.id.actc1);
        dokterc1 = (TextView) findViewById(R.id.dokterc1);
        // batas

     **/

        p_control = (TextView) findViewById(R.id.p_control);
     //   dokterHariIni_control = (TextView) findViewById(R.id.dokterHariIni_control);
        txt_id = (TextView) findViewById(R.id.id_user);
        txt_user = (TextView) findViewById(R.id.nama_user);

        id_user = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);

        //get session id
        final Intent intent = getIntent();
        id_user = intent.getStringExtra(konfigurasi.PELAPOR_ID);
        username = intent.getStringExtra(konfigurasi.USERE);

        gt = intent.getStringExtra(konfigurasi.CONTROL);

        txt_id.setText(id_user);
        txt_user.setText(username);



        ////////////////////////////////////////////////////////////////Date Picker
        txt_tgl = (EditText) findViewById(R.id.txt_tgl);
        txt_jam = (EditText) findViewById(R.id.txt_jam);
        btn_get_datetime = (Button) findViewById(R.id.btn_get_datetime);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int monthOfYear, int dayOfMonth,
                                  int year) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, monthOfYear);
                myCalendar.set(Calendar.MONTH, dayOfMonth);
                myCalendar.set(Calendar.DAY_OF_MONTH, year);
                updateLabel();
            }
        };

        txt_tgl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ActTindakan.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        txt_jam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ActTindakan.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        txt_jam.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });

       ////////////////////////////////////////////// // Batas Date Picker





        //Date Picker
     //   jdw_tgw = (EditText) findViewById(R.id.jdw_tgl);
        cek = (Button) findViewById(R.id.button1);

     /**   myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int monthOfYear, int dayOfMonth,
                                  int year) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, monthOfYear);
                myCalendar.set(Calendar.MONTH, dayOfMonth);
                myCalendar.set(Calendar.DAY_OF_MONTH, year);
                updateLabel();
            }
        };

        jdw_tgw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ActTindakan.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });        **/

        // Batas Date Picker

        data = txt_tgl.getText().toString();



        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
            }
        });













        btn_get_datetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**addPerawatan();
                btn_get_datetime.setEnabled(false);**/
                 showAlert();   // Ngambil fungsi showAlert();
            }
        });


    //    listing = (ListView) findViewById(R.id.lilist);
    //   listing.setOnItemClickListener(this);
    //    getJSON();

    }   // Batas On Create



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    // Date Picker
    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txt_tgl.setText(sdf.format(myCalendar.getTime()));
    }
    // Batas Date Picker




    //Menampilkan AlertDialog
    public void showAlert() {

        final String a = txt_id.getText().toString();
        final String b = txt_user.getText().toString();
        final String c = p_control.getText().toString();
        final String d = dokterHariIni_control.getText().toString();
        final String e = txt_tgl.getText().toString();
        final String f = txt_jam.getText().toString();

        aa = a;
        aa = "Id        : " + a;

        bb = b;
        bb = "Nama      : " + b;

        cc = c;
        cc = "Perawatan : " + c;

        dd = d;
        dd = "Dokter    : " + d;

        ee = e;
        ee = "Tamggal   : " + e;

        ff = f;
        ff = "Pukul     : " + f;

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Buat Jadwal");
        alert.setMessage(aa + "\n" + bb + "\n" + cc + "\n" + dd + "\n" + ee + "\n" + ff );

        alert.setNeutralButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addPerawatan();
                btn_get_datetime.setEnabled(false);
                finish();
            }
        });
        alert.show();
    }



    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addPerawatan(){

        final String nk = txt_id.getText().toString().trim();
        final String user = txt_user.getText().toString().trim();
        final String control = p_control.getText().toString().trim();
        final String dokter = dokterHariIni_control.getText().toString().trim();
        final String tgl = txt_tgl.getText().toString().trim();
        final String jam = txt_jam.getText().toString().trim();


        class AddPerawatan extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ActTindakan.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(ActTindakan.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_EMP_ID,nk);
                params.put(konfigurasi.KEY_USER,user);
                params.put(konfigurasi.KEY_KONTROL,control);
                params.put(konfigurasi.KEY_DOKTER_NOW,dokter);
                params.put(konfigurasi.KEY_TANGGAL_PERAWATAN,tgl);
                params.put(konfigurasi.KEY_JAM_PERAWATAN,jam);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD, params);
                return res;
            }
        }

        AddPerawatan ae = new AddPerawatan();
        ae.execute();
    }


    // Mengambil data dari database

  /**  private void showEmployee(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_JADWAL);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String idc1 = jo.getString(konfigurasi.TAG_ID_CONTROL);
                String jamc1 = jo.getString(konfigurasi.TAG_JAMC1);
                String pasienc1 = jo.getString(konfigurasi.TAG_PASIENC1);
                String actc1 = jo.getString(konfigurasi.TAG_ACTC1);
                String dokterc1 = jo.getString(konfigurasi.TAG_DOKTERC1);


                HashMap<String,String> employees = new HashMap<>();
                employees.put(konfigurasi.TAG_ID_CONTROL,idc1);
                employees.put(konfigurasi.TAG_JAMC1, jamc1);
                employees.put(konfigurasi.TAG_PASIENC1, pasienc1);
                employees.put(konfigurasi.TAG_ACTC1, actc1);
                employees.put(konfigurasi.TAG_DOKTERC1, dokterc1);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(

                ActTindakan.this, list, R.layout.activity_list_bottom_jadwal,
                new String[]{konfigurasi.TAG_ID_CONTROL,konfigurasi.TAG_JAMC1,konfigurasi.TAG_PASIENC1,
                        konfigurasi.TAG_ACTC1, konfigurasi.TAG_DOKTERC1},
                new int[]{R.id.idc1, R.id.jamc1, R.id.pasienc1, R.id.actc1, R.id.dokterc1}
                );

        listing.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ActTindakan.this,"Mencari","Data..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_JADWAL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent pdh = new Intent(this, Try.class);
        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String ide = map.get(konfigurasi.TAG_ID_CONTROL).toString();
        pdh.putExtra(konfigurasi.TRY,ide);
        startActivity(pdh);
    } **/



  ////////////////////// BOTTOM LIST //////////////////////////

  private void getEmployee(){
      class GetEmployee extends AsyncTask<Void,Void,String> {
          ProgressDialog loading;
          @Override
          protected void onPreExecute() {
              super.onPreExecute();
              loading = ProgressDialog.show(ActTindakan.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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
                loading = ProgressDialog.show(ActTindakan.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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
                loading = ProgressDialog.show(ActTindakan.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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
                loading = ProgressDialog.show(ActTindakan.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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
                loading = ProgressDialog.show(ActTindakan.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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
                loading = ProgressDialog.show(ActTindakan.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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
                loading = ProgressDialog.show(ActTindakan.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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
                loading = ProgressDialog.show(ActTindakan.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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
                loading = ProgressDialog.show(ActTindakan.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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
                loading = ProgressDialog.show(ActTindakan.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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
                loading = ProgressDialog.show(ActTindakan.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




}
