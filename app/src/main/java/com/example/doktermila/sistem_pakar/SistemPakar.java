package com.example.doktermila.sistem_pakar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doktermila.R;
import com.example.doktermila.RequestHandler;
import com.example.doktermila.konfigurasi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.doktermila.login_register.Login.TAG_ID_USER;
import static com.example.doktermila.login_register.Login.TAG_USERNAME;

public class SistemPakar extends AppCompatActivity {


    String id, username, getp1,getp2;
    TextView sp_id, sp_user, last_hsl, last_yn;
    Button mulai;

    String g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11;

    final Intent intent = getIntent();

    RadioGroup rgJawaban1;
    RadioButton iya, tidak;
    Button btnJawab;

    private String JSON_STRING;
    TextView tv_gejala, tv_kd_gejala, i1, i2, i3, i4, i5, i6, i7, i8, i9, k1, k2, k3, k4, k5, k6, k7, k8, k9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistem_pakar);


        sp_id = (TextView) findViewById(R.id.sp_id);
        sp_user = (TextView) findViewById(R.id.sp_user);
        last_hsl = (TextView) findViewById(R.id.last_hsl);
        last_yn = (TextView) findViewById(R.id.last_yn);

        i1 = (TextView) findViewById(R.id.i1);
        i2 = (TextView) findViewById(R.id.i2);
        i3 = (TextView) findViewById(R.id.i3);
        i4 = (TextView) findViewById(R.id.i4);
        i5 = (TextView) findViewById(R.id.i5);
        i6 = (TextView) findViewById(R.id.i6);
        i7 = (TextView) findViewById(R.id.i7);
        i8 = (TextView) findViewById(R.id.i8);
        i9 = (TextView) findViewById(R.id.i9);

        k1 = (TextView) findViewById(R.id.k1);
        k2 = (TextView) findViewById(R.id.k2);
        k3 = (TextView) findViewById(R.id.k3);
        k4 = (TextView) findViewById(R.id.k4);
        k5 = (TextView) findViewById(R.id.k5);
        k6 = (TextView) findViewById(R.id.k6);
        k7 = (TextView) findViewById(R.id.k7);
        k8 = (TextView) findViewById(R.id.k8);
        k9 = (TextView) findViewById(R.id.k9);


        id = getIntent().getStringExtra(TAG_ID_USER);
        username = getIntent().getStringExtra(TAG_USERNAME);

        sp_id.setText(id);
        sp_user.setText(username);




        tv_gejala = (TextView) findViewById(R.id.tv);
        tv_kd_gejala = (TextView) findViewById(R.id.kd);

        rgJawaban1 = (RadioGroup) findViewById(R.id.rgJawaban1);
        iya = (RadioButton) findViewById(R.id.rbJawaIya);
        tidak = (RadioButton) findViewById(R.id.rbJawaTidak);

        btnJawab = (Button) findViewById(R.id.btnJawab);


        getG7();



        btnJawab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gj = tv_kd_gejala.getText().toString();
                String g_1 = "g1";
                String g_2 = "g2";
                String g_3 = "g3";
                String g_4 = "g4";
                String g_5 = "g5";
                String g_6 = "g6";
                String g_7 = "g7";
                String g_8 = "g8";
                String g_9 = "g9";
                String g_10 = "g10";
                String g_11 = "g11";
                String g_12 = "g12";
                String g_13 = "g13";
                String g_14 = "g14";
                String g_15 = "g15";
                String g_16 = "g16";
                String g_17 = "g17";
                String g_18 = "g18";
                String g_19 = "g19";
                String g_20 = "g20";
                String g_21 = "g21";
                String g_22 = "g22";
                String g_23 = "g23";
                String g_24 = "g24";
                String g_25 = "g25";
                String g_26 = "g26";
                String g_27 = "g27";
                String g_28 = "g28";
                String g_29 = "g29";
                String g_30 = "g30";
                String g_31 = "g31";
                String g_32 = "g32";
                String g_33 = "g33";
                String g_34 = "g34";
                String g_35 = "g35";
                String g_36 = "g36";
                String g_37 = "g37";

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

                String yes = "IYA";
                String noo = "TIDAK";

                /**   if (gj.equals(g_10)){
                 kdi.setText(gj);
                 }

                 kdi2.setText(gj);
                 kdi3.setText(g_10);  **/

                int selectedId = rgJawaban1.getCheckedRadioButtonId();

                if (selectedId == iya.getId() && gj.equals(g_7)){
                    getG35();
                    G7();k1.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_28)){
                    getG29();
                    G7();k1.setText(yes);
                    G35();k2.setText(yes);
                    G28();k3.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_29)) {
                    getG36();
                    G7();k1.setText(yes);
                    G35();k2.setText(yes);
                    G28();k3.setText(yes);
                    G29();k4.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_35)) {
                    getG28();
                    G7();k1.setText(yes);
                    G35();k2.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_36)) {
                    G36();last_yn.setText(yes);
                    Intent a = new Intent(SistemPakar.this, HasilSp.class);
                    a.putExtra("val", p1);
                    a.putExtra(TAG_ID_USER, id);
                    a.putExtra(TAG_USERNAME, username);
                    a.putExtra("i1", i1.getText().toString());  a.putExtra("k1", k1.getText().toString());
                    a.putExtra("i2", i2.getText().toString());  a.putExtra("k2", k2.getText().toString());
                    a.putExtra("i3", i3.getText().toString());  a.putExtra("k3", k3.getText().toString());
                    a.putExtra("i4", i4.getText().toString());  a.putExtra("k4", k4.getText().toString());
                    a.putExtra("i5", i5.getText().toString());  a.putExtra("k5", k5.getText().toString());
                    a.putExtra("i6", i6.getText().toString());  a.putExtra("k6", k6.getText().toString());
                    a.putExtra("i7", i7.getText().toString());  a.putExtra("k7", k7.getText().toString());
                    a.putExtra("i8", i8.getText().toString());  a.putExtra("k8", k8.getText().toString());
                    a.putExtra("i9", i9.getText().toString());  a.putExtra("k9", k9.getText().toString());
                    a.putExtra("last_hsl", last_hsl.getText().toString());  a.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(a);
                    //getP1();
                }else if (selectedId == tidak.getId() && gj.equals(g_36)) {
                    Intent a = new Intent(SistemPakar.this, HasilSp.class);
                    a.putExtra("val", p1);
                    a.putExtra(TAG_ID_USER, id);
                    a.putExtra(TAG_USERNAME, username);
                    a.putExtra("i1", i1.getText().toString());  a.putExtra("k1", k1.getText().toString());
                    a.putExtra("i2", i2.getText().toString());  a.putExtra("k2", k2.getText().toString());
                    a.putExtra("i3", i3.getText().toString());  a.putExtra("k3", k3.getText().toString());
                    a.putExtra("i4", i4.getText().toString());  a.putExtra("k4", k4.getText().toString());
                    a.putExtra("i5", i5.getText().toString());  a.putExtra("k5", k5.getText().toString());
                    a.putExtra("i6", i6.getText().toString());  a.putExtra("k6", k6.getText().toString());
                    a.putExtra("i7", i7.getText().toString());  a.putExtra("k7", k7.getText().toString());
                    a.putExtra("i8", i8.getText().toString());  a.putExtra("k8", k8.getText().toString());
                    a.putExtra("i9", i9.getText().toString());  a.putExtra("k9", k9.getText().toString());
                    a.putExtra("last_hsl", last_hsl.getText().toString());  a.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(a);
                    //getP1();
                }else if (selectedId == tidak.getId() && gj.equals(g_35)){
                    getGejala(); ////////////////////////////////////////////////////// g10
                    G7();k1.setText(yes);
                    G35();k2.setText(noo);
                }else if (selectedId == tidak.getId() && gj.equals(g_29)){
                    Intent a = new Intent(SistemPakar.this, HasilSp.class);
                    a.putExtra("val", p1);
                    a.putExtra(TAG_ID_USER, id);
                    a.putExtra(TAG_USERNAME, username);
                    a.putExtra("i1", i1.getText().toString());  a.putExtra("k1", k1.getText().toString());
                    a.putExtra("i2", i2.getText().toString());  a.putExtra("k2", k2.getText().toString());
                    a.putExtra("i3", i3.getText().toString());  a.putExtra("k3", k3.getText().toString());
                    a.putExtra("i4", i4.getText().toString());  a.putExtra("k4", k4.getText().toString());
                    a.putExtra("i5", i5.getText().toString());  a.putExtra("k5", k5.getText().toString());
                    a.putExtra("i6", i6.getText().toString());  a.putExtra("k6", k6.getText().toString());
                    a.putExtra("i7", i7.getText().toString());  a.putExtra("k7", k7.getText().toString());
                    a.putExtra("i8", i8.getText().toString());  a.putExtra("k8", k8.getText().toString());
                    a.putExtra("i9", i9.getText().toString());  a.putExtra("k9", k9.getText().toString());
                    a.putExtra("last_hsl", last_hsl.getText().toString());  a.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(a);
                    //getP1();
                }else if (selectedId == tidak.getId() && gj.equals(g_28)){
                    getG17();
                    G7();k1.setText(yes);
                    G35();k2.setText(yes);
                    G28();k3.setText(noo);
                }else if (selectedId == tidak.getId() && gj.equals(g_10)){
          //////////////          //getGiSens();

                    Intent a = new Intent (SistemPakar.this, HasilSp.class);
                    a.putExtra("val", p10);
                    a.putExtra(TAG_ID_USER, id);
                    a.putExtra(TAG_USERNAME, username);
                    a.putExtra("i1", i1.getText().toString());  a.putExtra("k1", k1.getText().toString());
                    a.putExtra("i2", i2.getText().toString());  a.putExtra("k2", k2.getText().toString());
                    a.putExtra("i3", i3.getText().toString());  a.putExtra("k3", k3.getText().toString());
                    a.putExtra("i4", i4.getText().toString());  a.putExtra("k4", k4.getText().toString());
                    a.putExtra("i5", i5.getText().toString());  a.putExtra("k5", k5.getText().toString());
                    a.putExtra("i6", i6.getText().toString());  a.putExtra("k6", k6.getText().toString());
                    a.putExtra("i7", i7.getText().toString());  a.putExtra("k7", k7.getText().toString());
                    a.putExtra("i8", i8.getText().toString());  a.putExtra("k8", k8.getText().toString());
                    a.putExtra("i9", i9.getText().toString());  a.putExtra("k9", k9.getText().toString());
                    a.putExtra("last_hsl", last_hsl.getText().toString());  a.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(a);
                }else if (selectedId == tidak.getId() && gj.equals(g_7)){
                    getG9();
                    G7();
                    k1.setText(noo);
                }else if (selectedId == tidak.getId() && gj.equals(g_4)){
                    getG34(); //G10
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                    G4();k3.setText(noo);
                }else if (selectedId == tidak.getId() && gj.equals(g_17)) {
                    Intent a = new Intent(SistemPakar.this, HasilSp.class);
                    a.putExtra("val", p2);
                    a.putExtra(TAG_ID_USER, id);
                    a.putExtra(TAG_USERNAME, username);
                    a.putExtra("i1", i1.getText().toString());  a.putExtra("k1", k1.getText().toString());
                    a.putExtra("i2", i2.getText().toString());  a.putExtra("k2", k2.getText().toString());
                    a.putExtra("i3", i3.getText().toString());  a.putExtra("k3", k3.getText().toString());
                    a.putExtra("i4", i4.getText().toString());  a.putExtra("k4", k4.getText().toString());
                    a.putExtra("i5", i5.getText().toString());  a.putExtra("k5", k5.getText().toString());
                    a.putExtra("i6", i6.getText().toString());  a.putExtra("k6", k6.getText().toString());
                    a.putExtra("i7", i7.getText().toString());  a.putExtra("k7", k7.getText().toString());
                    a.putExtra("i8", i8.getText().toString());  a.putExtra("k8", k8.getText().toString());
                    a.putExtra("i9", i9.getText().toString());  a.putExtra("k9", k9.getText().toString());
                    a.putExtra("last_hsl", last_hsl.getText().toString());  a.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(a);
                }  // P1 PEMASANGAN MAHKOTA


                else if (selectedId == iya.getId() && gj.equals(g_17)){
                    getG15();
                    G7();k1.setText(yes);
                    G35();k2.setText(yes);
                    G28();k3.setText(noo);
                    G17();k4.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_15)){
                    getG16();
                    G7();k1.setText(yes);
                    G35();k2.setText(yes);
                    G28();k3.setText(noo);
                    G17();k4.setText(yes);
                    G15();k5.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_16)){
                    getG30();
                    G7();k1.setText(yes);
                    G35();k2.setText(yes);
                    G28();k3.setText(noo);
                    G17();k4.setText(yes);
                    G15();k5.setText(yes);
                    G16();k6.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_30)){
                    G30();last_yn.setText(yes);
                    Intent b = new Intent(SistemPakar.this, HasilSp.class);
                    b.putExtra("val", p2);
                    b.putExtra(TAG_ID_USER, id);
                    b.putExtra(TAG_USERNAME, username);
                    b.putExtra("i1", i1.getText().toString());  b.putExtra("k1", k1.getText().toString());
                    b.putExtra("i2", i2.getText().toString());  b.putExtra("k2", k2.getText().toString());
                    b.putExtra("i3", i3.getText().toString());  b.putExtra("k3", k3.getText().toString());
                    b.putExtra("i4", i4.getText().toString());  b.putExtra("k4", k4.getText().toString());
                    b.putExtra("i5", i5.getText().toString());  b.putExtra("k5", k5.getText().toString());
                    b.putExtra("i6", i6.getText().toString());  b.putExtra("k6", k6.getText().toString());
                    b.putExtra("i7", i7.getText().toString());  b.putExtra("k7", k7.getText().toString());
                    b.putExtra("i8", i8.getText().toString());  b.putExtra("k8", k8.getText().toString());
                    b.putExtra("i9", i9.getText().toString());  b.putExtra("k9", k9.getText().toString());
                    b.putExtra("last_hsl", last_hsl.getText().toString());  b.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(b);
                    //getP2();
                }else if (selectedId == tidak.getId() && gj.equals(g_30)){
                    Intent b = new Intent(SistemPakar.this, HasilSp.class);
                    b.putExtra("val", p2);
                    b.putExtra(TAG_ID_USER, id);
                    b.putExtra(TAG_USERNAME, username);
                    b.putExtra("i1", i1.getText().toString());  b.putExtra("k1", k1.getText().toString());
                    b.putExtra("i2", i2.getText().toString());  b.putExtra("k2", k2.getText().toString());
                    b.putExtra("i3", i3.getText().toString());  b.putExtra("k3", k3.getText().toString());
                    b.putExtra("i4", i4.getText().toString());  b.putExtra("k4", k4.getText().toString());
                    b.putExtra("i5", i5.getText().toString());  b.putExtra("k5", k5.getText().toString());
                    b.putExtra("i6", i6.getText().toString());  b.putExtra("k6", k6.getText().toString());
                    b.putExtra("i7", i7.getText().toString());  b.putExtra("k7", k7.getText().toString());
                    b.putExtra("i8", i8.getText().toString());  b.putExtra("k8", k8.getText().toString());
                    b.putExtra("i9", i9.getText().toString());  b.putExtra("k9", k9.getText().toString());
                    b.putExtra("last_hsl", last_hsl.getText().toString());  b.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(b);
                    //getP2();
                }else if (selectedId == tidak.getId() && gj.equals(g_16)) {
                    getG31();
                    G7();k1.setText(yes);
                    G35();k2.setText(yes);
                    G28();k3.setText(noo);
                    G17();k4.setText(yes);
                    G15();k5.setText(yes);
                    G16();k6.setText(noo);
                }else if (selectedId == tidak.getId() && gj.equals(g_15)){
                    Intent b = new Intent(SistemPakar.this, HasilSp.class);
                    b.putExtra("val", p2);
                    b.putExtra(TAG_ID_USER, id);
                    b.putExtra(TAG_USERNAME, username);
                    b.putExtra("i1", i1.getText().toString());  b.putExtra("k1", k1.getText().toString());
                    b.putExtra("i2", i2.getText().toString());  b.putExtra("k2", k2.getText().toString());
                    b.putExtra("i3", i3.getText().toString());  b.putExtra("k3", k3.getText().toString());
                    b.putExtra("i4", i4.getText().toString());  b.putExtra("k4", k4.getText().toString());
                    b.putExtra("i5", i5.getText().toString());  b.putExtra("k5", k5.getText().toString());
                    b.putExtra("i6", i6.getText().toString());  b.putExtra("k6", k6.getText().toString());
                    b.putExtra("i7", i7.getText().toString());  b.putExtra("k7", k7.getText().toString());
                    b.putExtra("i8", i8.getText().toString());  b.putExtra("k8", k8.getText().toString());
                    b.putExtra("i9", i9.getText().toString());  b.putExtra("k9", k9.getText().toString());
                    b.putExtra("last_hsl", last_hsl.getText().toString());  b.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(b);
                    //getP2();
                }else if (selectedId == tidak.getId() && gj.equals(g_31)){
                    Intent b = new Intent(SistemPakar.this, HasilSp.class);
                    b.putExtra("val", p2);
                    b.putExtra(TAG_ID_USER, id);
                    b.putExtra(TAG_USERNAME, username);
                    b.putExtra("i1", i1.getText().toString());  b.putExtra("k1", k1.getText().toString());
                    b.putExtra("i2", i2.getText().toString());  b.putExtra("k2", k2.getText().toString());
                    b.putExtra("i3", i3.getText().toString());  b.putExtra("k3", k3.getText().toString());
                    b.putExtra("i4", i4.getText().toString());  b.putExtra("k4", k4.getText().toString());
                    b.putExtra("i5", i5.getText().toString());  b.putExtra("k5", k5.getText().toString());
                    b.putExtra("i6", i6.getText().toString());  b.putExtra("k6", k6.getText().toString());
                    b.putExtra("i7", i7.getText().toString());  b.putExtra("k7", k7.getText().toString());
                    b.putExtra("i8", i8.getText().toString());  b.putExtra("k8", k8.getText().toString());
                    b.putExtra("i9", i9.getText().toString());  b.putExtra("k9", k9.getText().toString());
                    b.putExtra("last_hsl", last_hsl.getText().toString());  b.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(b);
                    //getP2();
                } // P2 PENCABUTAN GIGI



                else if (selectedId == iya.getId() && gj.equals(g_31)){
                    getG32();
                    G7();k1.setText(yes);
                    G35();k2.setText(yes);
                    G28();k3.setText(noo);
                    G17();k4.setText(yes);
                    G15();k5.setText(yes);
                    G16();k6.setText(noo);
                    G31();k7.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_32)){
                    G32();last_yn.setText(yes);
                    Intent c = new Intent(SistemPakar.this, HasilSp.class);
                    c.putExtra("val", p3);
                    c.putExtra(TAG_ID_USER, id);
                    c.putExtra(TAG_USERNAME, username);
                    c.putExtra("i1", i1.getText().toString());  c.putExtra("k1", k1.getText().toString());
                    c.putExtra("i2", i2.getText().toString());  c.putExtra("k2", k2.getText().toString());
                    c.putExtra("i3", i3.getText().toString());  c.putExtra("k3", k3.getText().toString());
                    c.putExtra("i4", i4.getText().toString());  c.putExtra("k4", k4.getText().toString());
                    c.putExtra("i5", i5.getText().toString());  c.putExtra("k5", k5.getText().toString());
                    c.putExtra("i6", i6.getText().toString());  c.putExtra("k6", k6.getText().toString());
                    c.putExtra("i7", i7.getText().toString());  c.putExtra("k7", k7.getText().toString());
                    c.putExtra("i8", i8.getText().toString());  c.putExtra("k8", k8.getText().toString());
                    c.putExtra("i9", i9.getText().toString());  c.putExtra("k9", k9.getText().toString());
                    c.putExtra("last_hsl", last_hsl.getText().toString());  c.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(c);
                    //getP3();
                }else if (selectedId == tidak.getId() && gj.equals(g_32)){
                    Intent c = new Intent(SistemPakar.this, HasilSp.class);
                    c.putExtra("val", p3);
                    c.putExtra(TAG_ID_USER, id);
                    c.putExtra(TAG_USERNAME, username);
                    c.putExtra("i1", i1.getText().toString());  c.putExtra("k1", k1.getText().toString());
                    c.putExtra("i2", i2.getText().toString());  c.putExtra("k2", k2.getText().toString());
                    c.putExtra("i3", i3.getText().toString());  c.putExtra("k3", k3.getText().toString());
                    c.putExtra("i4", i4.getText().toString());  c.putExtra("k4", k4.getText().toString());
                    c.putExtra("i5", i5.getText().toString());  c.putExtra("k5", k5.getText().toString());
                    c.putExtra("i6", i6.getText().toString());  c.putExtra("k6", k6.getText().toString());
                    c.putExtra("i7", i7.getText().toString());  c.putExtra("k7", k7.getText().toString());
                    c.putExtra("i8", i8.getText().toString());  c.putExtra("k8", k8.getText().toString());
                    c.putExtra("i9", i9.getText().toString());  c.putExtra("k9", k9.getText().toString());
                    c.putExtra("last_hsl", last_hsl.getText().toString());  c.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(c);
                    //getP3();
                }  // P3 ENDODONTIK ATAU PERAWATAN SALURAN AKAR GIGI



                else if (selectedId == iya.getId() && gj.equals(g_10)){
                    getG37();
                    G7();k1.setText(yes);
                    G35();k2.setText(noo);
                    G10(); k3.setText(yes);

                }else if (selectedId == iya.getId() && gj.equals(g_37)){
                    getG20();
                    G7();k1.setText(yes);
                    G35();k2.setText(noo);
                    G10(); k3.setText(yes);
                    G37();k4.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_19)){
                    G19();last_yn.setText(yes);
                    Intent d = new Intent(SistemPakar.this, HasilSp.class);
                    d.putExtra("val", p4);
                    d.putExtra(TAG_ID_USER, id);
                    d.putExtra(TAG_USERNAME, username);
                    d.putExtra("i1", i1.getText().toString());  d.putExtra("k1", k1.getText().toString());
                    d.putExtra("i2", i2.getText().toString());  d.putExtra("k2", k2.getText().toString());
                    d.putExtra("i3", i3.getText().toString());  d.putExtra("k3", k3.getText().toString());
                    d.putExtra("i4", i4.getText().toString());  d.putExtra("k4", k4.getText().toString());
                    d.putExtra("i5", i5.getText().toString());  d.putExtra("k5", k5.getText().toString());
                    d.putExtra("i6", i6.getText().toString());  d.putExtra("k6", k6.getText().toString());
                    d.putExtra("i7", i7.getText().toString());  d.putExtra("k7", k7.getText().toString());
                    d.putExtra("i8", i8.getText().toString());  d.putExtra("k8", k8.getText().toString());
                    d.putExtra("i9", i9.getText().toString());  d.putExtra("k9", k9.getText().toString());
                    d.putExtra("last_hsl", last_hsl.getText().toString());  d.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(d);
                    //getP4();
                }else if (selectedId == iya.getId() && gj.equals(g_20)){
                    getG33();
                    G7();k1.setText(yes);
                    G35();k2.setText(noo);
                    G10(); k3.setText(yes);
                    G37();k4.setText(yes);
                    G20();k5.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_33)){
                    getG19();
                    G7();k1.setText(yes);
                    G35();k2.setText(noo);
                    G10(); k3.setText(yes);
                    G37();k4.setText(yes);
                    G20();k5.setText(yes);
                    G33();k6.setText(yes);
                }else if (selectedId == tidak.getId() && gj.equals(g_33)){
                    Intent d = new Intent(SistemPakar.this, HasilSp.class);
                    d.putExtra("val", p4);
                    d.putExtra(TAG_ID_USER, id);
                    d.putExtra(TAG_USERNAME, username);
                    d.putExtra("i1", i1.getText().toString());  d.putExtra("k1", k1.getText().toString());
                    d.putExtra("i2", i2.getText().toString());  d.putExtra("k2", k2.getText().toString());
                    d.putExtra("i3", i3.getText().toString());  d.putExtra("k3", k3.getText().toString());
                    d.putExtra("i4", i4.getText().toString());  d.putExtra("k4", k4.getText().toString());
                    d.putExtra("i5", i5.getText().toString());  d.putExtra("k5", k5.getText().toString());
                    d.putExtra("i6", i6.getText().toString());  d.putExtra("k6", k6.getText().toString());
                    d.putExtra("i7", i7.getText().toString());  d.putExtra("k7", k7.getText().toString());
                    d.putExtra("i8", i8.getText().toString());  d.putExtra("k8", k8.getText().toString());
                    d.putExtra("i9", i9.getText().toString());  d.putExtra("k9", k9.getText().toString());
                    d.putExtra("last_hsl", last_hsl.getText().toString());  d.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(d);
                    //getP4();
                }else if (selectedId == tidak.getId() && gj.equals(g_20)){
                    Intent d = new Intent(SistemPakar.this, HasilSp.class);
                    d.putExtra("val", p4);
                    d.putExtra(TAG_ID_USER, id);
                    d.putExtra(TAG_USERNAME, username);
                    d.putExtra("i1", i1.getText().toString());  d.putExtra("k1", k1.getText().toString());
                    d.putExtra("i2", i2.getText().toString());  d.putExtra("k2", k2.getText().toString());
                    d.putExtra("i3", i3.getText().toString());  d.putExtra("k3", k3.getText().toString());
                    d.putExtra("i4", i4.getText().toString());  d.putExtra("k4", k4.getText().toString());
                    d.putExtra("i5", i5.getText().toString());  d.putExtra("k5", k5.getText().toString());
                    d.putExtra("i6", i6.getText().toString());  d.putExtra("k6", k6.getText().toString());
                    d.putExtra("i7", i7.getText().toString());  d.putExtra("k7", k7.getText().toString());
                    d.putExtra("i8", i8.getText().toString());  d.putExtra("k8", k8.getText().toString());
                    d.putExtra("i9", i9.getText().toString());  d.putExtra("k9", k9.getText().toString());
                    d.putExtra("last_hsl", last_hsl.getText().toString());  d.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(d);
                    //getP4();
                }else if (selectedId == tidak.getId() && gj.equals(g_19)){
                    Intent d = new Intent(SistemPakar.this, HasilSp.class);
                    d.putExtra("val", p4);
                    d.putExtra(TAG_ID_USER, id);
                    d.putExtra(TAG_USERNAME, username);
                    d.putExtra("i1", i1.getText().toString());  d.putExtra("k1", k1.getText().toString());
                    d.putExtra("i2", i2.getText().toString());  d.putExtra("k2", k2.getText().toString());
                    d.putExtra("i3", i3.getText().toString());  d.putExtra("k3", k3.getText().toString());
                    d.putExtra("i4", i4.getText().toString());  d.putExtra("k4", k4.getText().toString());
                    d.putExtra("i5", i5.getText().toString());  d.putExtra("k5", k5.getText().toString());
                    d.putExtra("i6", i6.getText().toString());  d.putExtra("k6", k6.getText().toString());
                    d.putExtra("i7", i7.getText().toString());  d.putExtra("k7", k7.getText().toString());
                    d.putExtra("i8", i8.getText().toString());  d.putExtra("k8", k8.getText().toString());
                    d.putExtra("i9", i9.getText().toString());  d.putExtra("k9", k9.getText().toString());
                    d.putExtra("last_hsl", last_hsl.getText().toString());  d.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(d);
                    //getP4();
                }else if (selectedId == tidak.getId() && gj.equals(g_25)) {
                    Intent d = new Intent(SistemPakar.this, HasilSp.class);
                    d.putExtra("val", p4);
                    d.putExtra(TAG_ID_USER, id);
                    d.putExtra(TAG_USERNAME, username);
                    d.putExtra("i1", i1.getText().toString());  d.putExtra("k1", k1.getText().toString());
                    d.putExtra("i2", i2.getText().toString());  d.putExtra("k2", k2.getText().toString());
                    d.putExtra("i3", i3.getText().toString());  d.putExtra("k3", k3.getText().toString());
                    d.putExtra("i4", i4.getText().toString());  d.putExtra("k4", k4.getText().toString());
                    d.putExtra("i5", i5.getText().toString());  d.putExtra("k5", k5.getText().toString());
                    d.putExtra("i6", i6.getText().toString());  d.putExtra("k6", k6.getText().toString());
                    d.putExtra("i7", i7.getText().toString());  d.putExtra("k7", k7.getText().toString());
                    d.putExtra("i8", i8.getText().toString());  d.putExtra("k8", k8.getText().toString());
                    d.putExtra("i9", i9.getText().toString());  d.putExtra("k9", k9.getText().toString());
                    d.putExtra("last_hsl", last_hsl.getText().toString());  d.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(d);
                    //getP4();
                }else if (selectedId == tidak.getId() && gj.equals(g_18)){
                    Intent d = new Intent(SistemPakar.this, HasilSp.class);
                    d.putExtra("val", p4);
                    d.putExtra(TAG_ID_USER, id);
                    d.putExtra(TAG_USERNAME, username);
                    d.putExtra("i1", i1.getText().toString());  d.putExtra("k1", k1.getText().toString());
                    d.putExtra("i2", i2.getText().toString());  d.putExtra("k2", k2.getText().toString());
                    d.putExtra("i3", i3.getText().toString());  d.putExtra("k3", k3.getText().toString());
                    d.putExtra("i4", i4.getText().toString());  d.putExtra("k4", k4.getText().toString());
                    d.putExtra("i5", i5.getText().toString());  d.putExtra("k5", k5.getText().toString());
                    d.putExtra("i6", i6.getText().toString());  d.putExtra("k6", k6.getText().toString());
                    d.putExtra("i7", i7.getText().toString());  d.putExtra("k7", k7.getText().toString());
                    d.putExtra("i8", i8.getText().toString());  d.putExtra("k8", k8.getText().toString());
                    d.putExtra("i9", i9.getText().toString());  d.putExtra("k9", k9.getText().toString());
                    d.putExtra("last_hsl", last_hsl.getText().toString());  d.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(d);
                    //getP4();
                }  //  P4 PENAMBALAN GIGI




                 else if (selectedId == iya.getId() && gj.equals(g_25)){
                    getG26();
                    G7();k1.setText(yes);
                    G35();k2.setText(noo);
                    G10();k3.setText(yes);
                    G37();k4.setText(noo);
                    G25();k5.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_26)){
                    getG27();
                    G7();k1.setText(yes);
                    G35();k2.setText(noo);
                    G10();k3.setText(yes);
                    G37();k4.setText(noo);
                    G25();k5.setText(yes);
                    G26();k5.setText(yes);
                    k1.setText(yes);k2.setText(noo);k3.setText(yes);k4.setText(noo);k5.setText(yes);k6.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_27)){
                     G27();last_yn.setText(yes);
                    Intent e = new Intent(SistemPakar.this, HasilSp.class);
                    e.putExtra("val", p5);
                    e.putExtra(TAG_ID_USER, id);
                    e.putExtra(TAG_USERNAME, username);
                    e.putExtra("i1", i1.getText().toString());  e.putExtra("k1", k1.getText().toString());
                    e.putExtra("i2", i2.getText().toString());  e.putExtra("k2", k2.getText().toString());
                    e.putExtra("i3", i3.getText().toString());  e.putExtra("k3", k3.getText().toString());
                    e.putExtra("i4", i4.getText().toString());  e.putExtra("k4", k4.getText().toString());
                    e.putExtra("i5", i5.getText().toString());  e.putExtra("k5", k5.getText().toString());
                    e.putExtra("i6", i6.getText().toString());  e.putExtra("k6", k6.getText().toString());
                    e.putExtra("i7", i7.getText().toString());  e.putExtra("k7", k7.getText().toString());
                    e.putExtra("i8", i8.getText().toString());  e.putExtra("k8", k8.getText().toString());
                    e.putExtra("i9", i9.getText().toString());  e.putExtra("k9", k9.getText().toString());
                    e.putExtra("last_hsl", last_hsl.getText().toString());  e.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(e);
                    //getP5();
                }else if (selectedId == tidak.getId() && gj.equals(g_37)){
                    getG25();
                    G7();k1.setText(yes);
                    G35();k2.setText(noo);
                    G10();k3.setText(yes);
                    G37();k4.setText(noo);
                }else if (selectedId == tidak.getId() && gj.equals(g_27)){
                    Intent e = new Intent(SistemPakar.this, HasilSp.class);
                    e.putExtra("val", p5);
                    e.putExtra(TAG_ID_USER, id);
                    e.putExtra(TAG_USERNAME, username);
                    e.putExtra("i1", i1.getText().toString());  e.putExtra("k1", k1.getText().toString());
                    e.putExtra("i2", i2.getText().toString());  e.putExtra("k2", k2.getText().toString());
                    e.putExtra("i3", i3.getText().toString());  e.putExtra("k3", k3.getText().toString());
                    e.putExtra("i4", i4.getText().toString());  e.putExtra("k4", k4.getText().toString());
                    e.putExtra("i5", i5.getText().toString());  e.putExtra("k5", k5.getText().toString());
                    e.putExtra("i6", i6.getText().toString());  e.putExtra("k6", k6.getText().toString());
                    e.putExtra("i7", i7.getText().toString());  e.putExtra("k7", k7.getText().toString());
                    e.putExtra("i8", i8.getText().toString());  e.putExtra("k8", k8.getText().toString());
                    e.putExtra("i9", i9.getText().toString());  e.putExtra("k9", k9.getText().toString());
                    e.putExtra("last_hsl", last_hsl.getText().toString());  e.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(e);
                    //getP5();
                }else if (selectedId == tidak.getId() && gj.equals(g_26)){
                    Intent e = new Intent(SistemPakar.this, HasilSp.class);
                    e.putExtra("val", p5);
                    e.putExtra(TAG_ID_USER, id);
                    e.putExtra(TAG_USERNAME, username);
                    e.putExtra("i1", i1.getText().toString());  e.putExtra("k1", k1.getText().toString());
                    e.putExtra("i2", i2.getText().toString());  e.putExtra("k2", k2.getText().toString());
                    e.putExtra("i3", i3.getText().toString());  e.putExtra("k3", k3.getText().toString());
                    e.putExtra("i4", i4.getText().toString());  e.putExtra("k4", k4.getText().toString());
                    e.putExtra("i5", i5.getText().toString());  e.putExtra("k5", k5.getText().toString());
                    e.putExtra("i6", i6.getText().toString());  e.putExtra("k6", k6.getText().toString());
                    e.putExtra("i7", i7.getText().toString());  e.putExtra("k7", k7.getText().toString());
                    e.putExtra("i8", i8.getText().toString());  e.putExtra("k8", k8.getText().toString());
                    e.putExtra("i9", i9.getText().toString());  e.putExtra("k9", k9.getText().toString());
                    e.putExtra("last_hsl", last_hsl.getText().toString());  e.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(e);
                    //getP5();
                }  // P5 Fissure Sealant



                else if (selectedId == iya.getId() && gj.equals(g_8)) {
                    getG11();
                    G7();k1.setText(noo);
                    G9();k2.setText(yes);
                    G8();k3.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_9)){
                    getG8();
                    G7();k1.setText(noo);
                    G9();k2.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_11)){
                    getG12();
                    G7();k1.setText(noo);
                    G9();k2.setText(yes);
                    G8();k3.setText(yes);
                    G11();k4.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_12)){
                    getG13();
                    G7();k1.setText(noo);
                    G9();k2.setText(yes);
                    G8();k3.setText(yes);
                    G11();k4.setText(yes);
                    G12();k5.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_13)){
                    G13();last_yn.setText(yes);
                    Intent f = new Intent(SistemPakar.this, HasilSp.class);
                    f.putExtra("val", p6);
                    f.putExtra(TAG_ID_USER, id);
                    f.putExtra(TAG_USERNAME, username);
                    f.putExtra("i1", i1.getText().toString());  f.putExtra("k1", k1.getText().toString());
                    f.putExtra("i2", i2.getText().toString());  f.putExtra("k2", k2.getText().toString());
                    f.putExtra("i3", i3.getText().toString());  f.putExtra("k3", k3.getText().toString());
                    f.putExtra("i4", i4.getText().toString());  f.putExtra("k4", k4.getText().toString());
                    f.putExtra("i5", i5.getText().toString());  f.putExtra("k5", k5.getText().toString());
                    f.putExtra("i6", i6.getText().toString());  f.putExtra("k6", k6.getText().toString());
                    f.putExtra("i7", i7.getText().toString());  f.putExtra("k7", k7.getText().toString());
                    f.putExtra("i8", i8.getText().toString());  f.putExtra("k8", k8.getText().toString());
                    f.putExtra("i9", i9.getText().toString());  f.putExtra("k9", k9.getText().toString());
                    f.putExtra("last_hsl", last_hsl.getText().toString());  f.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(f);
                    //getP6();
                }else if (selectedId == tidak.getId() && gj.equals(g_13)){
                    Intent f = new Intent(SistemPakar.this, HasilSp.class);
                    f.putExtra("val", p6);
                    f.putExtra(TAG_ID_USER, id);
                    f.putExtra(TAG_USERNAME, username);
                    f.putExtra("i1", i1.getText().toString());  f.putExtra("k1", k1.getText().toString());
                    f.putExtra("i2", i2.getText().toString());  f.putExtra("k2", k2.getText().toString());
                    f.putExtra("i3", i3.getText().toString());  f.putExtra("k3", k3.getText().toString());
                    f.putExtra("i4", i4.getText().toString());  f.putExtra("k4", k4.getText().toString());
                    f.putExtra("i5", i5.getText().toString());  f.putExtra("k5", k5.getText().toString());
                    f.putExtra("i6", i6.getText().toString());  f.putExtra("k6", k6.getText().toString());
                    f.putExtra("i7", i7.getText().toString());  f.putExtra("k7", k7.getText().toString());
                    f.putExtra("i8", i8.getText().toString());  f.putExtra("k8", k8.getText().toString());
                    f.putExtra("i9", i9.getText().toString());  f.putExtra("k9", k9.getText().toString());
                    f.putExtra("last_hsl", last_hsl.getText().toString());  f.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(f);
                    //getP6();
                }else if (selectedId == tidak.getId() && gj.equals(g_12)){
                    Intent f = new Intent(SistemPakar.this, HasilSp.class);
                    f.putExtra("val", p6);
                    f.putExtra(TAG_ID_USER, id);
                    f.putExtra(TAG_USERNAME, username);
                    f.putExtra("i1", i1.getText().toString());  f.putExtra("k1", k1.getText().toString());
                    f.putExtra("i2", i2.getText().toString());  f.putExtra("k2", k2.getText().toString());
                    f.putExtra("i3", i3.getText().toString());  f.putExtra("k3", k3.getText().toString());
                    f.putExtra("i4", i4.getText().toString());  f.putExtra("k4", k4.getText().toString());
                    f.putExtra("i5", i5.getText().toString());  f.putExtra("k5", k5.getText().toString());
                    f.putExtra("i6", i6.getText().toString());  f.putExtra("k6", k6.getText().toString());
                    f.putExtra("i7", i7.getText().toString());  f.putExtra("k7", k7.getText().toString());
                    f.putExtra("i8", i8.getText().toString());  f.putExtra("k8", k8.getText().toString());
                    f.putExtra("i9", i9.getText().toString());  f.putExtra("k9", k9.getText().toString());
                    f.putExtra("last_hsl", last_hsl.getText().toString());  f.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(f);
                    //getP6();
                }else if (selectedId == tidak.getId() && gj.equals(g_11)){
                    Intent f = new Intent(SistemPakar.this, HasilSp.class);
                    f.putExtra("val", p6);
                    f.putExtra(TAG_ID_USER, id);
                    f.putExtra(TAG_USERNAME, username);
                    f.putExtra("i1", i1.getText().toString());  f.putExtra("k1", k1.getText().toString());
                    f.putExtra("i2", i2.getText().toString());  f.putExtra("k2", k2.getText().toString());
                    f.putExtra("i3", i3.getText().toString());  f.putExtra("k3", k3.getText().toString());
                    f.putExtra("i4", i4.getText().toString());  f.putExtra("k4", k4.getText().toString());
                    f.putExtra("i5", i5.getText().toString());  f.putExtra("k5", k5.getText().toString());
                    f.putExtra("i6", i6.getText().toString());  f.putExtra("k6", k6.getText().toString());
                    f.putExtra("i7", i7.getText().toString());  f.putExtra("k7", k7.getText().toString());
                    f.putExtra("i8", i8.getText().toString());  f.putExtra("k8", k8.getText().toString());
                    f.putExtra("i9", i9.getText().toString());  f.putExtra("k9", k9.getText().toString());
                    f.putExtra("last_hsl", last_hsl.getText().toString());  f.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(f);
                    //getP6();
                }else if (selectedId == tidak.getId() && gj.equals(g_9)) {
                    getG4();
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                }else if (selectedId == tidak.getId() && gj.equals(g_8)){
                    Intent e = new Intent(SistemPakar.this, HasilSp.class);
                    e.putExtra("val", p6);
                    e.putExtra(TAG_ID_USER, id);
                    e.putExtra(TAG_USERNAME, username);
                    e.putExtra("i1", i1.getText().toString());  e.putExtra("k1", k1.getText().toString());
                    e.putExtra("i2", i2.getText().toString());  e.putExtra("k2", k2.getText().toString());
                    e.putExtra("i3", i3.getText().toString());  e.putExtra("k3", k3.getText().toString());
                    e.putExtra("i4", i4.getText().toString());  e.putExtra("k4", k4.getText().toString());
                    e.putExtra("i5", i5.getText().toString());  e.putExtra("k5", k5.getText().toString());
                    e.putExtra("i6", i6.getText().toString());  e.putExtra("k6", k6.getText().toString());
                    e.putExtra("i7", i7.getText().toString());  e.putExtra("k7", k7.getText().toString());
                    e.putExtra("i8", i8.getText().toString());  e.putExtra("k8", k8.getText().toString());
                    e.putExtra("i9", i9.getText().toString());  e.putExtra("k9", k9.getText().toString());
                    e.putExtra("last_hsl", last_hsl.getText().toString());  e.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(e);
                    //getP6();
                }  // P6 SCALLING



                else if (selectedId == iya.getId() && gj.equals(g_4)){
                    getG2();
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                    G4();k3.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_2)){
                    getG5();
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                    G4();k3.setText(yes);
                    G2();k4.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_3)){
                    G3();last_yn.setText(yes);
                    Intent g = new Intent(SistemPakar.this, HasilSp.class);
                    g.putExtra("val", p7);
                    g.putExtra(TAG_ID_USER, id);
                    g.putExtra(TAG_USERNAME, username);
                    g.putExtra("i1", i1.getText().toString());  g.putExtra("k1", k1.getText().toString());
                    g.putExtra("i2", i2.getText().toString());  g.putExtra("k2", k2.getText().toString());
                    g.putExtra("i3", i3.getText().toString());  g.putExtra("k3", k3.getText().toString());
                    g.putExtra("i4", i4.getText().toString());  g.putExtra("k4", k4.getText().toString());
                    g.putExtra("i5", i5.getText().toString());  g.putExtra("k5", k5.getText().toString());
                    g.putExtra("i6", i6.getText().toString());  g.putExtra("k6", k6.getText().toString());
                    g.putExtra("i7", i7.getText().toString());  g.putExtra("k7", k7.getText().toString());
                    g.putExtra("i8", i8.getText().toString());  g.putExtra("k8", k8.getText().toString());
                    g.putExtra("i9", i9.getText().toString());  g.putExtra("k9", k9.getText().toString());
                    g.putExtra("last_hsl", last_hsl.getText().toString());  g.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(g);
                    //getP7();
                }else if (selectedId == iya.getId() && gj.equals(g_1)){
                    getG3();
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                    G4();k3.setText(yes);
                    G2();k4.setText(yes);
                    G5();k5.setText(yes);
                    G6();k6.setText(yes);
                    G18();k7.setText(yes);
                    G1();k8.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_5)){
                    getG6();
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                    G4();k3.setText(yes);
                    G2();k4.setText(yes);
                    G5();k5.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_6)){
                    getG18();
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                    G4();k3.setText(yes);
                    G2();k4.setText(yes);
                    G5();k5.setText(yes);
                    G6();k6.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_18)){
                    getG1();
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                    G4();k3.setText(yes);
                    G2();k4.setText(yes);
                    G5();k5.setText(yes);
                    G6();k6.setText(yes);
                    G18();k7.setText(yes);
                }else if (selectedId == tidak.getId() && gj.equals(g_18)){
                    Intent g = new Intent(SistemPakar.this, HasilSp.class);
                    g.putExtra("val", p7);
                    g.putExtra(TAG_ID_USER, id);
                    g.putExtra(TAG_USERNAME, username);
                    g.putExtra("i1", i1.getText().toString());  g.putExtra("k1", k1.getText().toString());
                    g.putExtra("i2", i2.getText().toString());  g.putExtra("k2", k2.getText().toString());
                    g.putExtra("i3", i3.getText().toString());  g.putExtra("k3", k3.getText().toString());
                    g.putExtra("i4", i4.getText().toString());  g.putExtra("k4", k4.getText().toString());
                    g.putExtra("i5", i5.getText().toString());  g.putExtra("k5", k5.getText().toString());
                    g.putExtra("i6", i6.getText().toString());  g.putExtra("k6", k6.getText().toString());
                    g.putExtra("i7", i7.getText().toString());  g.putExtra("k7", k7.getText().toString());
                    g.putExtra("i8", i8.getText().toString());  g.putExtra("k8", k8.getText().toString());
                    g.putExtra("i9", i9.getText().toString());  g.putExtra("k9", k9.getText().toString());
                    g.putExtra("last_hsl", last_hsl.getText().toString());  g.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(g);
                    //getP7();
                }else if (selectedId == tidak.getId() && gj.equals(g_6)){
                    Intent g = new Intent(SistemPakar.this, HasilSp.class);
                    g.putExtra("val", p7);
                    g.putExtra(TAG_ID_USER, id);
                    g.putExtra(TAG_USERNAME, username);
                    g.putExtra("i1", i1.getText().toString());  g.putExtra("k1", k1.getText().toString());
                    g.putExtra("i2", i2.getText().toString());  g.putExtra("k2", k2.getText().toString());
                    g.putExtra("i3", i3.getText().toString());  g.putExtra("k3", k3.getText().toString());
                    g.putExtra("i4", i4.getText().toString());  g.putExtra("k4", k4.getText().toString());
                    g.putExtra("i5", i5.getText().toString());  g.putExtra("k5", k5.getText().toString());
                    g.putExtra("i6", i6.getText().toString());  g.putExtra("k6", k6.getText().toString());
                    g.putExtra("i7", i7.getText().toString());  g.putExtra("k7", k7.getText().toString());
                    g.putExtra("i8", i8.getText().toString());  g.putExtra("k8", k8.getText().toString());
                    g.putExtra("i9", i9.getText().toString());  g.putExtra("k9", k9.getText().toString());
                    g.putExtra("last_hsl", last_hsl.getText().toString());  g.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(g);
                    //getP7();
                }else if (selectedId == tidak.getId() && gj.equals(g_5)){
                    Intent g = new Intent(SistemPakar.this, HasilSp.class);
                    g.putExtra("val", p7);
                    g.putExtra(TAG_ID_USER, id);
                    g.putExtra(TAG_USERNAME, username);
                    g.putExtra("i1", i1.getText().toString());  g.putExtra("k1", k1.getText().toString());
                    g.putExtra("i2", i2.getText().toString());  g.putExtra("k2", k2.getText().toString());
                    g.putExtra("i3", i3.getText().toString());  g.putExtra("k3", k3.getText().toString());
                    g.putExtra("i4", i4.getText().toString());  g.putExtra("k4", k4.getText().toString());
                    g.putExtra("i5", i5.getText().toString());  g.putExtra("k5", k5.getText().toString());
                    g.putExtra("i6", i6.getText().toString());  g.putExtra("k6", k6.getText().toString());
                    g.putExtra("i7", i7.getText().toString());  g.putExtra("k7", k7.getText().toString());
                    g.putExtra("i8", i8.getText().toString());  g.putExtra("k8", k8.getText().toString());
                    g.putExtra("i9", i9.getText().toString());  g.putExtra("k9", k9.getText().toString());
                    g.putExtra("last_hsl", last_hsl.getText().toString());  g.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(g);
                    //getP7();
                }else if (selectedId == tidak.getId() && gj.equals(g_1)){
                    Intent g = new Intent(SistemPakar.this, HasilSp.class);
                    g.putExtra("val", p7);
                    g.putExtra(TAG_ID_USER, id);
                    g.putExtra(TAG_USERNAME, username);
                    g.putExtra("i1", i1.getText().toString());  g.putExtra("k1", k1.getText().toString());
                    g.putExtra("i2", i2.getText().toString());  g.putExtra("k2", k2.getText().toString());
                    g.putExtra("i3", i3.getText().toString());  g.putExtra("k3", k3.getText().toString());
                    g.putExtra("i4", i4.getText().toString());  g.putExtra("k4", k4.getText().toString());
                    g.putExtra("i5", i5.getText().toString());  g.putExtra("k5", k5.getText().toString());
                    g.putExtra("i6", i6.getText().toString());  g.putExtra("k6", k6.getText().toString());
                    g.putExtra("i7", i7.getText().toString());  g.putExtra("k7", k7.getText().toString());
                    g.putExtra("i8", i8.getText().toString());  g.putExtra("k8", k8.getText().toString());
                    g.putExtra("i9", i9.getText().toString());  g.putExtra("k9", k9.getText().toString());
                    g.putExtra("last_hsl", last_hsl.getText().toString());  g.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(g);
                    //getP7();
                }else if (selectedId == tidak.getId() && gj.equals(g_3)){
                    Intent g = new Intent(SistemPakar.this, HasilSp.class);
                    g.putExtra("val", p7);
                    g.putExtra(TAG_ID_USER, id);
                    g.putExtra(TAG_USERNAME, username);
                    g.putExtra("i1", i1.getText().toString());  g.putExtra("k1", k1.getText().toString());
                    g.putExtra("i2", i2.getText().toString());  g.putExtra("k2", k2.getText().toString());
                    g.putExtra("i3", i3.getText().toString());  g.putExtra("k3", k3.getText().toString());
                    g.putExtra("i4", i4.getText().toString());  g.putExtra("k4", k4.getText().toString());
                    g.putExtra("i5", i5.getText().toString());  g.putExtra("k5", k5.getText().toString());
                    g.putExtra("i6", i6.getText().toString());  g.putExtra("k6", k6.getText().toString());
                    g.putExtra("i7", i7.getText().toString());  g.putExtra("k7", k7.getText().toString());
                    g.putExtra("i8", i8.getText().toString());  g.putExtra("k8", k8.getText().toString());
                    g.putExtra("i9", i9.getText().toString());  g.putExtra("k9", k9.getText().toString());
                    g.putExtra("last_hsl", last_hsl.getText().toString());  g.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(g);
                    //getP7();
                }else if (selectedId == tidak.getId() && gj.equals(g_2)){
                    getG14();
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                    G4();k3.setText(yes);
                    G2();k4.setText(noo);

                }else if (selectedId == tidak.getId() && gj.equals(g_14)) {
                    Intent g = new Intent(SistemPakar.this, HasilSp.class);
                    g.putExtra("val", p7); // ke veneer
                    g.putExtra(TAG_ID_USER, id);
                    g.putExtra(TAG_USERNAME, username);
                    g.putExtra("i1", i1.getText().toString());  g.putExtra("k1", k1.getText().toString());
                    g.putExtra("i2", i2.getText().toString());  g.putExtra("k2", k2.getText().toString());
                    g.putExtra("i3", i3.getText().toString());  g.putExtra("k3", k3.getText().toString());
                    g.putExtra("i4", i4.getText().toString());  g.putExtra("k4", k4.getText().toString());
                    g.putExtra("i5", i5.getText().toString());  g.putExtra("k5", k5.getText().toString());
                    g.putExtra("i6", i6.getText().toString());  g.putExtra("k6", k6.getText().toString());
                    g.putExtra("i7", i7.getText().toString());  g.putExtra("k7", k7.getText().toString());
                    g.putExtra("i8", i8.getText().toString());  g.putExtra("k8", k8.getText().toString());
                    g.putExtra("i9", i9.getText().toString());  g.putExtra("k9", k9.getText().toString());
                    g.putExtra("last_hsl", last_hsl.getText().toString());  g.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(g);
                    //getP7();
                }  // P7 KAWAT GIGI



                else if (selectedId == iya.getId() && gj.equals(g_14)){
                    getG21();
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                    G4();k3.setText(yes);
                    G2();k4.setText(noo);
                    G14();k5.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_21)){
                    getG22();
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                    G4();k3.setText(yes);
                    G2();k4.setText(noo);
                    G14();k5.setText(yes);
                    G21();k6.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_22)){
                    getG23();
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                    G4();k3.setText(yes);
                    G2();k4.setText(noo);
                    G14();k5.setText(yes);
                    G21();k6.setText(yes);
                    G22();k7.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_23)){
                    getG24();
                    G7();k1.setText(noo);
                    G9();k2.setText(noo);
                    G4();k3.setText(yes);
                    G2();k4.setText(noo);
                    G14();k5.setText(yes);
                    G21();k6.setText(yes);
                    G22();k7.setText(yes);
                    G23();k8.setText(yes);
                }else if (selectedId == iya.getId() && gj.equals(g_24)){
                    G24();last_yn.setText(yes);
                    Intent h = new Intent(SistemPakar.this, HasilSp.class);
                    h.putExtra("val", p8);
                    h.putExtra(TAG_ID_USER, id);
                    h.putExtra(TAG_USERNAME, username);
                    h.putExtra("i1", i1.getText().toString());  h.putExtra("k1", k1.getText().toString());
                    h.putExtra("i2", i2.getText().toString());  h.putExtra("k2", k2.getText().toString());
                    h.putExtra("i3", i3.getText().toString());  h.putExtra("k3", k3.getText().toString());
                    h.putExtra("i4", i4.getText().toString());  h.putExtra("k4", k4.getText().toString());
                    h.putExtra("i5", i5.getText().toString());  h.putExtra("k5", k5.getText().toString());
                    h.putExtra("i6", i6.getText().toString());  h.putExtra("k6", k6.getText().toString());
                    h.putExtra("i7", i7.getText().toString());  h.putExtra("k7", k7.getText().toString());
                    h.putExtra("i8", i8.getText().toString());  h.putExtra("k8", k8.getText().toString());
                    h.putExtra("i9", i9.getText().toString());  h.putExtra("k9", k9.getText().toString());
                    h.putExtra("last_hsl", last_hsl.getText().toString());  h.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(h);
                    //getP8();
                }else if (selectedId == tidak.getId() && gj.equals(g_24)){
                    Intent h = new Intent(SistemPakar.this, HasilSp.class);
                    h.putExtra("val", p8);
                    h.putExtra(TAG_ID_USER, id);
                    h.putExtra(TAG_USERNAME, username);
                    h.putExtra("i1", i1.getText().toString());  h.putExtra("k1", k1.getText().toString());
                    h.putExtra("i2", i2.getText().toString());  h.putExtra("k2", k2.getText().toString());
                    h.putExtra("i3", i3.getText().toString());  h.putExtra("k3", k3.getText().toString());
                    h.putExtra("i4", i4.getText().toString());  h.putExtra("k4", k4.getText().toString());
                    h.putExtra("i5", i5.getText().toString());  h.putExtra("k5", k5.getText().toString());
                    h.putExtra("i6", i6.getText().toString());  h.putExtra("k6", k6.getText().toString());
                    h.putExtra("i7", i7.getText().toString());  h.putExtra("k7", k7.getText().toString());
                    h.putExtra("i8", i8.getText().toString());  h.putExtra("k8", k8.getText().toString());
                    h.putExtra("i9", i9.getText().toString());  h.putExtra("k9", k9.getText().toString());
                    h.putExtra("last_hsl", last_hsl.getText().toString());  h.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(h);
                    //getP8();
                }else if (selectedId == tidak.getId() && gj.equals(g_23)){
                    Intent h = new Intent(SistemPakar.this, HasilSp.class);
                    h.putExtra("val", p8);
                    h.putExtra(TAG_ID_USER, id);
                    h.putExtra(TAG_USERNAME, username);
                    h.putExtra("i1", i1.getText().toString());  h.putExtra("k1", k1.getText().toString());
                    h.putExtra("i2", i2.getText().toString());  h.putExtra("k2", k2.getText().toString());
                    h.putExtra("i3", i3.getText().toString());  h.putExtra("k3", k3.getText().toString());
                    h.putExtra("i4", i4.getText().toString());  h.putExtra("k4", k4.getText().toString());
                    h.putExtra("i5", i5.getText().toString());  h.putExtra("k5", k5.getText().toString());
                    h.putExtra("i6", i6.getText().toString());  h.putExtra("k6", k6.getText().toString());
                    h.putExtra("i7", i7.getText().toString());  h.putExtra("k7", k7.getText().toString());
                    h.putExtra("i8", i8.getText().toString());  h.putExtra("k8", k8.getText().toString());
                    h.putExtra("i9", i9.getText().toString());  h.putExtra("k9", k9.getText().toString());
                    h.putExtra("last_hsl", last_hsl.getText().toString());  h.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(h);
                    //getP8();
                }else if (selectedId == tidak.getId() && gj.equals(g_22)){
                    Intent h = new Intent(SistemPakar.this, HasilSp.class);
                    h.putExtra("val", p8);
                    h.putExtra(TAG_ID_USER, id);
                    h.putExtra(TAG_USERNAME, username);
                    h.putExtra("i1", i1.getText().toString());  h.putExtra("k1", k1.getText().toString());
                    h.putExtra("i2", i2.getText().toString());  h.putExtra("k2", k2.getText().toString());
                    h.putExtra("i3", i3.getText().toString());  h.putExtra("k3", k3.getText().toString());
                    h.putExtra("i4", i4.getText().toString());  h.putExtra("k4", k4.getText().toString());
                    h.putExtra("i5", i5.getText().toString());  h.putExtra("k5", k5.getText().toString());
                    h.putExtra("i6", i6.getText().toString());  h.putExtra("k6", k6.getText().toString());
                    h.putExtra("i7", i7.getText().toString());  h.putExtra("k7", k7.getText().toString());
                    h.putExtra("i8", i8.getText().toString());  h.putExtra("k8", k8.getText().toString());
                    h.putExtra("i9", i9.getText().toString());  h.putExtra("k9", k9.getText().toString());
                    h.putExtra("last_hsl", last_hsl.getText().toString());  h.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(h);
                    //getP8();
                }else if (selectedId == tidak.getId() && gj.equals(g_21)){
                    Intent h = new Intent(SistemPakar.this, HasilSp.class);
                    h.putExtra("val", p8);
                    h.putExtra(TAG_ID_USER, id);
                    h.putExtra(TAG_USERNAME, username);
                    h.putExtra("i1", i1.getText().toString());  h.putExtra("k1", k1.getText().toString());
                    h.putExtra("i2", i2.getText().toString());  h.putExtra("k2", k2.getText().toString());
                    h.putExtra("i3", i3.getText().toString());  h.putExtra("k3", k3.getText().toString());
                    h.putExtra("i4", i4.getText().toString());  h.putExtra("k4", k4.getText().toString());
                    h.putExtra("i5", i5.getText().toString());  h.putExtra("k5", k5.getText().toString());
                    h.putExtra("i6", i6.getText().toString());  h.putExtra("k6", k6.getText().toString());
                    h.putExtra("i7", i7.getText().toString());  h.putExtra("k7", k7.getText().toString());
                    h.putExtra("i8", i8.getText().toString());  h.putExtra("k8", k8.getText().toString());
                    h.putExtra("i9", i9.getText().toString());  h.putExtra("k9", k9.getText().toString());
                    h.putExtra("last_hsl", last_hsl.getText().toString());  h.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(h);
                    //getP8();
                }


                else if (selectedId == iya.getId() && gj.equals(g_34)){
                    G34();last_yn.setText(yes);
                    Intent i = new Intent(SistemPakar.this, HasilSp.class);
                    i.putExtra("val", p9);
                    i.putExtra(TAG_ID_USER, id);
                    i.putExtra(TAG_USERNAME, username);
                    i.putExtra("i1", i1.getText().toString());  i.putExtra("k1", k1.getText().toString());
                    i.putExtra("i2", i2.getText().toString());  i.putExtra("k2", k2.getText().toString());
                    i.putExtra("i3", i3.getText().toString());  i.putExtra("k3", k3.getText().toString());
                    i.putExtra("i4", i4.getText().toString());  i.putExtra("k4", k4.getText().toString());
                    i.putExtra("i5", i5.getText().toString());  i.putExtra("k5", k5.getText().toString());
                    i.putExtra("i6", i6.getText().toString());  i.putExtra("k6", k6.getText().toString());
                    i.putExtra("i7", i7.getText().toString());  i.putExtra("k7", k7.getText().toString());
                    i.putExtra("i8", i8.getText().toString());  i.putExtra("k8", k8.getText().toString());
                    i.putExtra("i9", i9.getText().toString());  i.putExtra("k9", k9.getText().toString());
                    i.putExtra("last_hsl", last_hsl.getText().toString());  i.putExtra("last_yn", last_yn.getText().toString());
                    startActivity(i);
                    //getP9();
                }else if (selectedId == tidak.getId() && gj.equals(g_34)){
                    // getTidakSakit();
                    Intent i = new Intent(SistemPakar.this, HasilSp.class);
                    i.putExtra("val", p11);
                    i.putExtra(TAG_ID_USER, id);
                    i.putExtra(TAG_USERNAME, username);
                    startActivity(i);
                }

                else {
                    showToast("Kamu Belum Memilih Jawaban");
                }
            }
        });



    }  // ON CREAT





    private void showToast(String message){
        Toast.makeText(this, "" + message, Toast.LENGTH_LONG).show();
    }

    /**

     @Override
     public boolean onSupportNavigateUp() {
     onBackPressed();
     return true;
     }

     @Override
     public void onBackPressed() {
     super.onBackPressed();
     }

     @Override
     protected void onDestroy() {
     super.onDestroy();
     unbinder.unbind();
     }

     **/








    private void getGejala(){                                     //g10
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showGejala(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_PAKAR);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showGejala(String json){               //g10
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA);
            String gejala = a.getString(konfigurasi.TAG_GEJALA);                 //g10


            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }







    private void getG1(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG1(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_G1);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG1(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_1);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_1);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_1);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);




        } catch (JSONException e) {
            e.printStackTrace();
        }


    }








    private void getG2(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG2(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_2);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG2(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_2);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_2);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_2);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }








    private void getG3(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG3(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_3);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG3(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_3);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_3);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_3);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }







    private void getG4(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG4(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_4);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG4(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_4);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_4);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_4);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }







    private void getG5(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG5(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_5);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG5(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_5);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_5);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_5);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }






    private void getG6(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG6(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_6);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG6(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_6);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_6);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_6);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }







    private void getG7(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG7(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_G7);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG7(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_G7);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_G7);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_G7);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }






    private void getG8(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG8(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_8);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG8(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_8);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_8);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_8);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getG9(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG9(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_9);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG9(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_9);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_9);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_9);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }






    private void getG11(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG11(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_11);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG11(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_11);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_11);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_11);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }






    private void getG12(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG12(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_12);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG12(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_12);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_12);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_12);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getG13(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG13(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_13);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG13(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_13);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_13);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_13);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }






    private void getG14(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG14(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_14);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG14(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_14);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_14);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_14);


            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getG15(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG15(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_15);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG15(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_15);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_15);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_15);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getG16(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG16(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_16);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG16(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_16);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_16);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_16);


            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getG17(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG17(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_17);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG17(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_17);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_17);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_17);


            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getG18(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG18(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_18);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG18(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_18);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_18);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_18);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }






    private void getG19(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG19(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_19);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG19(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_19);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_19);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_19);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getG20(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG20(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_20);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG20(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_20);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_20);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_20);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getG21(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG21(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_21);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG21(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_21);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_21);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_21);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getG22(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG22(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_22);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG22(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_22);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_22);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_22);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getG23(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG23(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_23);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG23(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_23);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_23);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_23);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getG24(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG24(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_24);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG24(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_24);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_24);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_24);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getG25(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG25(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_25);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG25(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_25);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_25);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_25);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void getG26(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG26(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_26);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG26(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_26);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_26);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_26);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getG27(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG27(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_27);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG27(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_27);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_27);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_27);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }







    private void getG28(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG28(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_28);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG28(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_28);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_28);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_28);


            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void getG29(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG29(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_29);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG29(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_29);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_29);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_29);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void getG30(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG30(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_30);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG30(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_30);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_30);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_30);


            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getG31(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG31(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_31);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG31(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_31);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_31);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_31);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }






    private void getG32(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG32(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_32);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG32(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_32);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_32);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_32);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }







    private void getG33(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG33(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_33);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG33(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_33);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_33);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_33);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void getG34(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG34(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_34);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG34(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_34);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_34);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_34);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void getG35(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG35(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_35);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG35(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_35);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_35);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_35);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }




    private void getG36(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG36(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_36);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG36(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_36);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_36);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_36);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }




    private void getG37(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showG37(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_37);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void showG37(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_37);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_37);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_37);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(gejala);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }






    /**

    private void getP1(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(perawatan);


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
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(perawatan);


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
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(perawatan);


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
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(perawatan);


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
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(perawatan);


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
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(perawatan);


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
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(perawatan);


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
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(perawatan);


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
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
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

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(perawatan);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }







    private void getGiSens(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showGisens(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_GISENS);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showGisens(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_GISENS);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_GISENS);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_GISENS);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(perawatan);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }






    private void getTidakSakit(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showTidakSakit(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_TIDAKS);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();

    }

    public void showTidakSakit(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_PERAWATAN_TIDAKS);
            String kode = a.getString(konfigurasi.TAG_KODE_PERAWATAN_TIDAKS);
            String perawatan = a.getString(konfigurasi.TAG_PERAWATAN_TIDAKS);

            tv_kd_gejala.setText(kode);
            tv_gejala.setText(perawatan);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }   **/


    ///////////////////////  p1 ////////////////////////////

    private void G7(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g7show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_G7);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }

    public void g7show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_G7);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_G7);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_G7);

         //   k1.setText(kode);
            i1.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G35(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g35show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_35);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g35show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_35);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_35);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_35);

           // k2.setText(kode);
            i2.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void G28(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g28show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_28);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g28show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_28);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_28);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_28);

        //    k3.setText(kode);
            i3.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void G29(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g29show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_29);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g29show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_29);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_29);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_29);

          //  k4.setText(kode);
            i4.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G36(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g36show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_36);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g36show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_36);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_36);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_36);

         //   k5.setText(kode);
           // i5.setText(gejala);
            last_hsl.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    //////////////////////////////////////////////////////////

    ////////////////////////  p2  //////////////////////////////

    private void G17(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g17show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_17);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g17show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_17);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_17);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_17);

           // k3.setText(kode);
            i4.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void G15(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g15show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_15);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g15show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_15);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_15);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_15);

         //   k4.setText(kode);
            i5.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G16(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g16show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_16);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g16show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_16);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_16);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_16);

       //     k5.setText(kode);
            i6.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G30(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g30show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_30);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g30show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_30);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_30);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_30);

         //   k6.setText(kode);
         //   i7.setText(gejala);
            last_hsl.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////



    ///////////////////////////  p3   /////////////////////////////////

    private void G31(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g31show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_31);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g31show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_31);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_31);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_31);

        //    k5.setText(kode);
            i7.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G32(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g32show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_32);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g32show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_32);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_32);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_32);

          //  k6.setText(kode);
          //  i8.setText(gejala);
            last_hsl.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    ////////////////////////////////////////////////////////////////////////////////


    ///////////////////////////  p4  /////////////////////////////////////


    private void G10(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g10show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_PAKAR);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g10show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA);
            String gejala = a.getString(konfigurasi.TAG_GEJALA);

      //      k2.setText(kode);
            i3.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void G37(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g37show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_37);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g37show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_37);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_37);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_37);

        //    k3.setText(kode);
            i4.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





    private void G20(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g20show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_20);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g20show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_20);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_20);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_20);

          //  k4.setText(kode);
            i5.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G33(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g33show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_33);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g33show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_33);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_33);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_33);

         //   k5.setText(kode);
            i6.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G19(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g19show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_19);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g19show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_19);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_19);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_19);

       //     k6.setText(kode);
        //    i7.setText(gejala);
            last_hsl.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////  p5  ////////////////////////////////////

    private void G25(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g25show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_25);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g25show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_25);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_25);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_25);

         //   k3.setText(kode);
            i5.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G26(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g26show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_26);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g26show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_26);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_26);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_26);

        //    k4.setText(kode);
            i6.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void G27(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g27show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_27);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g27show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_27);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_27);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_27);

        //    k5.setText(kode);
         //   i7.setText(gejala);
            last_hsl.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////////////

    /////////////////////////////////  p6  ///////////////////////////////////////


    private void G9(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g9show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_9);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g9show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_9);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_9);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_9);

        //    k1.setText(kode);
            i2.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G8(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g8show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_8);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g8show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_8);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_8);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_8);

        //    k2.setText(kode);
            i3.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void G11(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g11show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_11);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g11show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_11);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_11);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_11);

        //    k3.setText(kode);
            i4.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void G12(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g12show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_12);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g12show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_12);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_12);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_12);

        //    k4.setText(kode);
            i5.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G13(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g13show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_13);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g13show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_13);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_13);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_13);

         //   k5.setText(kode);
         //   i6.setText(gejala);
            last_hsl.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////


    ///////////////////////////////  p7  ////////////////////////////////////

    private void G4(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g4show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_4);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g4show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_4);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_4);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_4);

         //   k1.setText(kode);
            i3.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G2(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g2show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_2);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g2show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_2);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_2);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_2);

         //   k2.setText(kode);
            i4.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G5(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g5show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_5);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g5show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_5);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_5);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_5);

         //   k3.setText(kode);
            i5.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G6(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g6show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_6);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g6show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_6);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_6);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_6);

         //   k4.setText(kode);
            i6.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G18(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g18show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_18);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g18show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_18);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_18);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_18);

        //    k5.setText(kode);
            i7.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G1(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g1show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_G1);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g1show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_1);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_1);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_1);

        //    k6.setText(kode);
            i8.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G3(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g3show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_3);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g3show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_3);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_3);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_3);

         //   k7.setText(kode);
         //   i9.setText(gejala);
            last_hsl.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////


    //////////////////////////////////  p8  //////////////////////////////////////////

    private void G14(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g14show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_14);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g14show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_14);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_14);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_14);

        //    k2.setText(kode);
            i5.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void G21(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g21show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_21);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g21show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_21);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_21);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_21);

        //    k3.setText(kode);
            i6.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G22(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g22show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_22);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g22show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_22);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_22);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_22);

        //    k4.setText(kode);
            i7.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G23(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g23show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_23);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g23show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_23);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_23);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_23);

        //    k5.setText(kode);
            i8.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void G24(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g24show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_24);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g24show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_24);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_24);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_24);

        //    k6.setText(kode);
            last_hsl.setText(gejala);
        //    i9.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////


    private void G34(){
        class GetGejala extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SistemPakar.this,"Tunggu Yaa...","Sabaarr!!..",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                g34show(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_34);
                return s;
            }
        }
        GetGejala ge = new GetGejala();
        ge.execute();
    }


    public void g34show(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY_GEJALA);
            JSONObject a = result.getJSONObject(0);

            String id = a.getString(konfigurasi.TAG_ID_GEJALA_34);
            String kode = a.getString(konfigurasi.TAG_KODE_GEJALA_34);
            String gejala = a.getString(konfigurasi.TAG_GEJALA_34);

            //    k6.setText(kode);
            //i4.setText(gejala);
            last_hsl.setText(gejala);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}