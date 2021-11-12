package com.example.doktermila.treatment;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelGambarTreat {

    @SerializedName("pesan")
    private String mPesan;
    @SerializedName("resep")
    private List<ModelTreat> mResep;
    @SerializedName("sukses")
    private String mSukses;


    public String getPesan() {
        return mPesan;
    }

    public void setPesan(String pesan) {
        mPesan = pesan;
    }

    public List<ModelTreat> getResep() {
        return mResep;
    }

    public void setResep(List<ModelTreat> resep) {
        mResep = resep;
    }

    public String getSukses() {
        return mSukses;
    }

    public void setSukses(String sukses) {
        mSukses = sukses;
    }

}

