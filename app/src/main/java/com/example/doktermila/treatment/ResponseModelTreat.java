package com.example.doktermila.treatment;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponseModelTreat {


    List<ModelTreat> result;
    @SerializedName("kode")
    private String mKode;
    @SerializedName("pesan")
    private String mPesan;

    public List<ModelTreat> getResult() {
        return result;
    }

    public void setResult(List<ModelTreat> result) {
        this.result = result;
    }
    public String getKode() {
        return mKode;
    }

    public void setKode(String kode) {
        mKode = kode;
    }

    public String getPesan() {
        return mPesan;
    }

    public void setPesan(String pesan) {
        mPesan = pesan;
    }

}