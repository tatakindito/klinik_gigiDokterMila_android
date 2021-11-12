package com.example.doktermila;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.doktermila.data_diri.DataDiri;
import com.example.doktermila.listGambar.Model;
import com.example.doktermila.listGambar.ModelGambar;
import com.example.doktermila.listGambar.MyConstant;
import com.example.doktermila.listGambar.MyFunction;
import com.example.doktermila.listGambar.RecyclerViewAdapter;
import com.example.doktermila.listGambar.RestApi;
import com.example.doktermila.login_register.Login;
import com.example.doktermila.perawatan.MenuTindakan;
import com.example.doktermila.riwayat.Riwayat;
import com.example.doktermila.sistem_pakar.DataPerawatan;
import com.example.doktermila.sistem_pakar.SpOpen;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.doktermila.login_register.Login.my_shared_preferences;
import static com.example.doktermila.login_register.Login.session_status;

//list public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

public class MainActivity extends MyFunction {

    // list gambar
    RecyclerView listresep;
    RecyclerView.LayoutManager layoutManager;
    //membuat variabel datamakan menggunakn List (untuk menampung data)
    List<Model> dataresep;

    //


    Button btn_logout;
    TextView txt_id, txt_username;
    String id, username;
    SharedPreferences sharedpreferences;
    FloatingActionButton situs;

    public static final String TAG_ID_USER = "id";
    public static final String TAG_USERNAME = "username";

    ViewPager viewPager;
    private ListView listView;

    private String JSON_STRING;

    String idi, user, id1,user1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        situs = findViewById(R.id.qr_img);

        // list gambar
        listresep = findViewById(R.id.listresep);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

    //list    listView = (ListView) findViewById(R.id.listVie);
        //list    listView.setOnItemClickListener(this);
    //list    getJSON();


        /** dari login session **/

        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_username = (TextView) findViewById(R.id.txt_username);
        //btn_logout = (Button) findViewById(R.id.btn_logout);


        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);

        txt_id.setText("ID : " + id);
        txt_username.setText(username);

        /** batas dari login session **/



        // list gambar
        //layoutManager = new GridLayoutManager(con,2);
        layoutManager = new LinearLayoutManager(con);
        //id dari recylerfivew
        listresep.setLayoutManager(layoutManager);

        //method menampilkan data
        getDatamakanan();
        //



        situs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewClicked();
            }
        });



        Button buttonShow = findViewById(R.id.btn);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.BottomSheetDialogTheme);

                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(R.layout.layout_bottom_sheet, (LinearLayout) findViewById(R.id.id_bottom_sheet));

                // btn tindakan = activity menu tindakan
                bottomSheetView.findViewById(R.id.btn_tindakan).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent tindakan = new Intent(MainActivity.this, DataPerawatan.class);
                        tindakan.putExtra(TAG_ID_USER, id);
                        tindakan.putExtra(TAG_USERNAME, username);
                        startActivity(tindakan);
                    }
                });

                // btn lihat jadwal = activity halaman utama
                bottomSheetView.findViewById(R.id.btn_lihat_jadwal).setOnClickListener(new View.OnClickListener() {
                    Boolean session = false;
                    @Override
                    public void onClick(View view) {
                        // Cek session login jika TRUE maka langsung buka MainActivity
                        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
                        session = sharedpreferences.getBoolean(session_status, false);
                        idi = sharedpreferences.getString(TAG_ID_USER, null);
                        user = sharedpreferences.getString(TAG_USERNAME, null);

                        if (session) {
                            Intent lijat = new Intent(MainActivity.this, SpOpen.class);
                            lijat.putExtra(TAG_ID_USER, idi);
                            lijat.putExtra(TAG_USERNAME, user);
                            lijat.putExtra(konfigurasi.PELAPOR_ID,idi);
                            lijat.putExtra(konfigurasi.USERE,user);
                            startActivity(lijat);
                        }
                    }
                });

                bottomSheetView.findViewById(R.id.btn_about).setOnClickListener(new View.OnClickListener() {
                    Boolean session = false;
                    @Override
                    public void onClick(View view) {
                        // Cek session login jika TRUE maka langsung buka MainActivity
                        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
                        session = sharedpreferences.getBoolean(session_status, false);
                        idi = sharedpreferences.getString(TAG_ID_USER, null);
                        user = sharedpreferences.getString(TAG_USERNAME, null);

                        if (session) {
                            /** Intent gt = new Intent(MainActivity.this, AmbilTestimoni.class); **/
                            Intent gt = new Intent(MainActivity.this, About.class);
                            gt.putExtra(TAG_ID_USER, idi);
                            gt.putExtra(TAG_USERNAME, user);
                            gt.putExtra(konfigurasi.PELAPOR_ID,idi);
                            gt.putExtra(konfigurasi.USERE,user);
                            startActivity(gt);
                        }
                    }
                });

                bottomSheetView.findViewById(R.id.btn_sp).setOnClickListener(new View.OnClickListener() {
                    Boolean session = false;
                    @Override
                    public void onClick(View view) {
                        // Cek session login jika TRUE maka langsung buka MainActivity
                        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
                        session = sharedpreferences.getBoolean(session_status, false);
                        idi = sharedpreferences.getString(TAG_ID_USER, null);
                        user = sharedpreferences.getString(TAG_USERNAME, null);

                        if (session) {
                            Intent ks = new Intent(MainActivity.this, DataDiri.class);
                            ks.putExtra(TAG_ID_USER, idi);
                            ks.putExtra(TAG_USERNAME, user);
                            ks.putExtra(konfigurasi.PELAPOR_ID,idi);
                            ks.putExtra(konfigurasi.USERE,user);
                            startActivity(ks);
                        }
                    }
                });

                bottomSheetView.findViewById(R.id.btn_riwayat).setOnClickListener(new View.OnClickListener() {
                    Boolean session = false;
                    @Override
                    public void onClick(View view) {
                        // Cek session login jika TRUE maka langsung buka MainActivity
                        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
                        session = sharedpreferences.getBoolean(session_status, false);
                        idi = sharedpreferences.getString(TAG_ID_USER, null);
                        user = sharedpreferences.getString(TAG_USERNAME, null);

                        if (session) {
                            Intent riwayat = new Intent(MainActivity.this, Riwayat.class);
                            riwayat.putExtra(TAG_ID_USER, idi);
                            riwayat.putExtra(TAG_USERNAME, user);
                            riwayat.putExtra(konfigurasi.PELAPOR_ID,idi);
                            riwayat.putExtra(konfigurasi.USERE,user);
                            startActivity(riwayat);
                        }
                    }
                });






                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });


        /** dari login session

         btn_logout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(session_status, false);
                editor.putString(TAG_ID_USER, null);
                editor.putString(TAG_USERNAME, null);
                editor.commit();

                Intent intent = new Intent(MainActivity.this, Login.class);
                finish();
                startActivity(intent);
            }
        });

         batas dari login session **/

    } // onCreat




    // resevasi

    Boolean session = false;
    public void onViewClicked() {
        //startActivity(new Intent(this,Qr.class));
        // Cek session login jika TRUE maka langsung buka MainActivity
        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, false);
        id1 = sharedpreferences.getString(TAG_ID_USER, null);
        user1 = sharedpreferences.getString(TAG_USERNAME, null);

        if (session) {
            Intent keSp = new Intent(MainActivity.this, MenuTindakan.class);
            keSp.putExtra(TAG_ID_USER, id1);
            keSp.putExtra(TAG_USERNAME, user1);
            startActivity(keSp);
        }


        //startActivity(new Intent(this,SpOpen.class));
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.id_logout){

            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(session_status, false);
            editor.putString(TAG_ID_USER, null);
            editor.putString(TAG_USERNAME, null);
            editor.commit();

            Intent intent = new Intent(MainActivity.this, Login.class);
            finish();
            startActivity(intent);

        }return true;

    }



    public class MyTimerTask extends TimerTask {
        @Override

        public void run(){
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    }else if (viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }


    /** list

    private void showEmployee(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(konfigurasi.TAG_ID);
                String title = jo.getString(konfigurasi.TAG_JUDUL);
                String isi = jo.getString(konfigurasi.TAG_KONTEN);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(konfigurasi.TAG_ID,id);
                employees.put(konfigurasi.TAG_JUDUL, title);
                employees.put(konfigurasi.TAG_KONTEN, isi);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                MainActivity.this, list, R.layout.activity_list_item,
                new String[]{konfigurasi.TAG_ID,konfigurasi.TAG_JUDUL,konfigurasi.TAG_KONTEN},
                new int[]{R.id.id, R.id.jdl, R.id.ktn});

        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Mengambil Data","Mohon Tunggu...",false,false);
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
                String s = rh.sendGetRequest(konfigurasi.URL_GET_ALL);
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
        String empId = map.get(konfigurasi.TAG_ID).toString();
        intent.putExtra(konfigurasi.EMP_ID,empId);
        startActivity(intent);
    }


    list   **/



    // list gambar
    private void getDatamakanan() {

        //inisialisasi retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyConstant.BASE_URL) //ke url java MyCOnstant
                .addConverterFactory(GsonConverterFactory.create())//diconvert
                .build();//dibuild

        RestApi api = retrofit.create(RestApi.class);
        //ngecal
        Call<ModelGambar> modelResepCall = api.getResep();
        modelResepCall.enqueue(new Callback<ModelGambar>() {
            @Override
            public void onResponse(Call<ModelGambar> call, Response<ModelGambar> response) {
                String pesan = response.body().getPesan();
                String sukses = response.body().getSukses();

                if (sukses.equals("true")) {
                    pesan(pesan);
                    Log.d("  Retrofit ", " Berhasil dapatkan " + pesan);
                    Log.d("  Retrofit ", " Berhasil dapatkan " + sukses);

                    dataresep = response.body().getResep();
                    //showdata makanan
                    tampildatamakanan();

                } else {
                    pesan(pesan);
                }
            }

            @Override
            public void onFailure(Call<ModelGambar> call, Throwable t) {

            }
        });

    }

    private void tampildatamakanan() {

        String items[] = new String[dataresep.size()];
        for (int i = 0; i < dataresep.size(); i++) {
            items[i] = dataresep.get(i).getNamaResep1();
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(con, dataresep);
        listresep.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setNestedScrollingEnabled(false);
    }


}