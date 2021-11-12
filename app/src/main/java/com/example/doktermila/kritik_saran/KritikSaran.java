package com.example.doktermila.kritik_saran;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doktermila.KetList;
import com.example.doktermila.MainActivity;
import com.example.doktermila.R;
import com.example.doktermila.RequestHandler;
import com.example.doktermila.konfigurasi;
import com.example.doktermila.perawatan.ActTindakan;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;

public class KritikSaran extends AppCompatActivity{

    private Button simpanData;
    //private Button tombolCamera;
    private ImageView tombolCamera;

    private ImageView imgCamera;
    final int kodeKamera = 99;
    Uri imageUri;
    Bitmap bitmap, bitbit;

    /** upload foto **/

    boolean check = true;
    //Button SelectImageGallery;
    EditText judul, keterangan;
    ProgressDialog progressDialog ;

    String IdPelapor = "id_pelapor" ;
    String NamaPelapor = "nama_pelapor" ;
    String JudulLaporan = "judul_laporan" ;
    String KeteranganLaporan = "keterangan_laporan" ;
    String ImagePath = "image_path" ;
    String GetKeterangan, GetJudul, GetPelapor, GetIdPelapor;


    //String ServerUploadPath ="http://pengaduanku.000webhostapp.com/pengaduan_file/laporan_masuk.php" ;

    /** batas upload foto **/

    //ambil id&username
    String id, username;
    TextView hu_id, hu_user;
    //batas ambil id&username


    //admob
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kritik_saran);

        hu_id = (TextView) findViewById(R.id.hu_id);
        hu_user = (TextView) findViewById(R.id.hu_user);

        id = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);

        hu_id.setText(id);
        hu_user.setText(username);

        keterangan = (EditText) findViewById(R.id.edt_ket_laporan);
        simpanData = (Button) findViewById(R.id.button_simpan);

        //admob
        mAdView = findViewById(R.id.adViewBann);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        simpanData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addKritik();
            }
        });

    } //batas onCreate



    //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
    private void addKritik(){

        final String nk = hu_id.getText().toString().trim();
        final String user = hu_user.getText().toString().trim();
        final String kritik = keterangan.getText().toString().trim();


        class AddKritik extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(KritikSaran.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(KritikSaran.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_USER_ID,nk);
                params.put(konfigurasi.KEY_NAMA,user);
                params.put(konfigurasi.KEY_KRITIK,kritik);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD_KRITIK, params);
                return res;
            }
        }

        AddKritik ae = new AddKritik();
        ae.execute();
    }



}
