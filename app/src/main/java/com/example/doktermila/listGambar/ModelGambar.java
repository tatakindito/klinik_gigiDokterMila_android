package com.example.doktermila.listGambar;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class ModelGambar {

    @SerializedName("pesan")
    private String mPesan;
    @SerializedName("resep")
    private List<Model> mResep;
    @SerializedName("sukses")
    private String mSukses;


    public String getPesan() {
        return mPesan;
    }

    public void setPesan(String pesan) {
        mPesan = pesan;
    }

    public List<Model> getResep() {
        return mResep;
    }

    public void setResep(List<Model> resep) {
        mResep = resep;
    }

    public String getSukses() {
        return mSukses;
    }

    public void setSukses(String sukses) {
        mSukses = sukses;
    }

}

