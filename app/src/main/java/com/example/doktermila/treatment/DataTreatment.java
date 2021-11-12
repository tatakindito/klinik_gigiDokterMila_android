package com.example.doktermila.treatment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.doktermila.R;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;

public class DataTreatment extends MyFungsiTreat {

    RecyclerView listtreatment;
    RecyclerView.LayoutManager layoutManager;
    //membuat variabel datamakan menggunakn List (untuk menampung data)
    List<ModelTreat> datatreatment;

    TextView treatmentNama_user, treatmenUser_id;
    String id, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_treatment);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        treatmenUser_id = (TextView) findViewById(R.id.treatmenUser_id);
        treatmentNama_user = (TextView) findViewById(R.id.treatmentNama_user);

        id = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);

        treatmenUser_id.setText(id);
        treatmentNama_user.setText(username);

        listtreatment = findViewById(R.id.listtreatment);

        layoutManager = new LinearLayoutManager(con);
        //id dari recylerfivew
        listtreatment.setLayoutManager(layoutManager);

        getDataTreatment();


    }     //oncreat



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    private void getDataTreatment() {

        //inisialisasi retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyConstantTreat.BASE_URL) //ke url java MyCOnstant
                .addConverterFactory(GsonConverterFactory.create())//diconvert
                .build();//dibuild

        RestApiTreat api = retrofit.create(RestApiTreat.class);
        //ngecal
        Call<ModelGambarTreat> modelResepCall = api.getResep();
        modelResepCall.enqueue(new Callback<ModelGambarTreat>() {
            @Override
            public void onResponse(Call<ModelGambarTreat> call, Response<ModelGambarTreat> response) {
                String pesan = response.body().getPesan();
                String sukses = response.body().getSukses();

                if (sukses.equals("true")) {
                    pesan(pesan);
                    Log.d("  Retrofit ", " Berhasil dapatkan " + pesan);
                    Log.d("  Retrofit ", " Berhasil dapatkan " + sukses);

                    datatreatment = response.body().getResep();
                    //showdata makanan
                    tampildatamakanan();

                } else {
                    pesan(pesan);
                }
            }

            @Override
            public void onFailure(Call<ModelGambarTreat> call, Throwable t) {

            }
        });

    }






    private void tampildatamakanan() {

        String items[] = new String[datatreatment.size()];
        for (int i = 0; i < datatreatment.size(); i++) {
            items[i] = datatreatment.get(i).getNamaResep1();
        }
        RecyclerViewAdapterTreat adapter = new RecyclerViewAdapterTreat(con, datatreatment);
        listtreatment.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setNestedScrollingEnabled(false);
    }



}