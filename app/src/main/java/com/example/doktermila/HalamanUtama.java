package com.example.doktermila;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.doktermila.Spinner.Rabu;
import com.example.doktermila.Spinner.Selasa;
import com.example.doktermila.Spinner.Senin;
import com.example.doktermila.perawatan.ActTindakan;
import com.example.doktermila.riwayat.Riwayat;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import androidx.viewpager.widget.ViewPager;

import static com.example.doktermila.konfigurasi.TAG_KK;
import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;
import static com.example.doktermila.login_register.Login.my_shared_preferences;
import static com.example.doktermila.login_register.Login.session_status;

public class HalamanUtama extends AppCompatActivity{

    ViewPager viewPager;
    private ListView lilis;

    private String JSON_STRING;
    FloatingActionButton addJdw;

    TextView jId,jUser,add_jdw;
    private String id_pelapor,username;

    SharedPreferences sharedpreferences;
    String id_p, user_p,add,kosong,tarik;
    Button cek;

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    EditText jdw_tgw;

    Spinner spinner;
    String[] SPINNERVALUES = {"ANDROID","PHP","BLOGGER"};
    String SpinnerValue;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        jId = (TextView) findViewById(R.id.j_id);
        jUser = (TextView) findViewById(R.id.j_user);

        //get session id
        final Intent intent = getIntent();
        id_pelapor = intent.getStringExtra(konfigurasi.PELAPOR_ID);
        username = intent.getStringExtra(konfigurasi.USERE);

        jId.setText(id_pelapor);
        jUser.setText(username);

        addJdw = findViewById(R.id.addJdw);

        lilis = (ListView) findViewById(R.id.list);
        getJSON();



        //Date Picker
        jdw_tgw = (EditText) findViewById(R.id.jdw_tgl);
        cek = (Button) findViewById(R.id.button1);

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

        jdw_tgw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(HalamanUtama.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // Batas Date Picker



        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent o = new Intent(HalamanUtama.this, LihatJadwal.class);
                o.putExtra("cekjadwal",jdw_tgw.getText().toString());
                startActivity(o);
            }
        });


    /**   SPINNER

        spinner =(Spinner)findViewById(R.id.spinner1);

        cek = (Button)findViewById(R.id.button1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(HalamanUtama.this, android.R.layout.simple_list_item_1, SPINNERVALUES);

        spinner.setAdapter(adapter);


        //Adding setOnItemSelectedListener method on spinner.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerValue = (String)spinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        cek.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                switch(SpinnerValue){

                    case "Senin":
                            i = new Intent(HalamanUtama.this, Senin.class);
                        startActivity(i);
                        break;

                    case "Selasa":
                        i = new Intent(HalamanUtama.this, Selasa.class);
                        startActivity(i);
                        break;

                    case "Rabu":
                        i = new Intent(HalamanUtama.this, Rabu.class);
                        startActivity(i);
                        break;


                }
            }
        }); **/


        addJdw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewClicked();
                finish();
            }
        });

    } // onCreat



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
        jdw_tgw.setText(sdf.format(myCalendar.getTime()));
    }
    // Batas Date Picker




    Boolean session = false;

    public void onViewClicked() {

        // Cek session login jika TRUE maka langsung buka MainActivity
        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, false);
        id_p = sharedpreferences.getString(TAG_ID_USER, null);
        user_p = sharedpreferences.getString(TAG_USERNAME, null);

        if (session) {
            Intent toAct = new Intent(HalamanUtama.this, ActTindakan.class);
            toAct.putExtra(konfigurasi.PELAPOR_ID,id_p);
            toAct.putExtra(konfigurasi.USERE,user_p);
            startActivity(toAct);
        }
    }


    //Dibawah ini merupakan perintah untuk menampilkan data dari database
    private void showEmployee(){
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

                HalamanUtama.this, list, R.layout.list_jadwal,

                new String[]{konfigurasi.TAG_ID_CONTROL,konfigurasi.TAG_JAMC1,konfigurasi.TAG_PASIENC1,
                        konfigurasi.TAG_ACTC1, konfigurasi.TAG_DOKTERC1},
                new int[]{R.id.id_jdw, R.id.jdw_jam, R.id.jdw_pasien, R.id.jdw_perawatan, R.id.jdw_dokter}

                );

        lilis.setAdapter(adapter);

    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HalamanUtama.this,"Mencari","Data..",false,false);
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


}
