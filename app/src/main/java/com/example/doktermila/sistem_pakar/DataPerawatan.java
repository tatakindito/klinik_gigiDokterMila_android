package com.example.doktermila.sistem_pakar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doktermila.R;
import com.example.doktermila.data_pakar.GejalaBase;
import com.example.doktermila.data_pakar.PerawatanBase;
import com.example.doktermila.treatment.DataTreatment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;

public class DataPerawatan extends AppCompatActivity {

    TextView dp_id, dp_username;
    private String id,username;

    CardView card_dperawatan, card_dgejala;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_perawatan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dp_id = (TextView) findViewById(R.id.dp_id);
        dp_username = (TextView) findViewById(R.id.dp_user);
        card_dperawatan = (CardView) findViewById(R.id.card_dperawatan);
        card_dgejala = (CardView) findViewById(R.id.card_dgejala);


        id = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);
        dp_id.setText(id);
        dp_username.setText(username);


        card_dperawatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dperawatan = new Intent(DataPerawatan.this, PerawatanBase.class);
                dperawatan.putExtra(TAG_ID_USER, id);
                dperawatan.putExtra(TAG_USERNAME, username);
                startActivity(dperawatan);
            }
        });


        card_dgejala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dgejala = new Intent(DataPerawatan.this, DataTreatment.class);
                dgejala.putExtra(TAG_ID_USER, id);
                dgejala.putExtra(TAG_USERNAME, username);
                startActivity(dgejala);
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





    /////////////////////  Tambahan MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bd,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String admin = "1";
        int idd = item.getItemId();
        if (idd==R.id.sharedg && id.equals(admin)){
            Intent myIntent = new Intent(DataPerawatan.this, GejalaBase.class);
            myIntent.putExtra(TAG_ID_USER, id);
            myIntent.putExtra(TAG_USERNAME, username);
            startActivity(myIntent);

        } if (idd==R.id.share && !id.equals(admin)){
            Toast.makeText(this, "Anda Bukan Admin", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


}