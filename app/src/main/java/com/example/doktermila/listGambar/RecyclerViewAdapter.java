package com.example.doktermila.listGambar;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doktermila.KeteranganGambar;
import com.example.doktermila.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Server on 25/09/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {
    //buat variabel
    Context con;
    List <Model> data_resep;
    //buat constructor dari variabel diatas
    public RecyclerViewAdapter(Context con, List<Model> data_resep) {
        this.con = con;
        this.data_resep = data_resep;
    }

    //membuat view baru untuk menampung data
    @Override
    public RecyclerViewAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tampilan_iklan,parent,false);
        MyHolder holder = new MyHolder(v);


        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyHolder holder, final int position) {
        holder.txtnama.setText(data_resep.get(position).getNamaResep1());
        holder.txtdetail.setText(data_resep.get(position).getDetail1());
        Picasso.with(con)
                .load(MyConstant.IMAGE_URL+data_resep.get(position).getGambar1())
                .error(R.mipmap.ic_launcher)
                .into(holder.imgMakanan);
        Log.e("TAG","data rv"+data_resep.get(position).getNamaResep1());
        Log.e("TAG","data rv"+data_resep.get(position).getDetail1());

        //event click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirim = new Intent(con, KeteranganGambar.class);
                //tambaahan
                kirim.putExtra("id",data_resep.get(position).getIdResep1());

                kirim.putExtra("nm",data_resep.get(position).getNamaResep1());
                kirim.putExtra("gb",data_resep.get(position).getGambar1());
                kirim.putExtra("i",data_resep.get(position).getDetail1());
                con.startActivity(kirim);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data_resep.size();
    }

    public void setNestedScrollingEnabled(boolean b) {
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imgMakanan ;
        TextView txtnama, txtdetail;
        public MyHolder(View itemView) {
            super(itemView);
            imgMakanan = (ImageView) itemView.findViewById(R.id.imgmakanan);
            txtnama = (TextView) itemView.findViewById(R.id.txtnama);
            txtdetail = (TextView) itemView.findViewById(R.id.txtisi);
        }
    }
}