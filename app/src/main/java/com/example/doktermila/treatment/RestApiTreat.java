package com.example.doktermila.treatment;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface RestApiTreat {
    //ngambil respon dari GSON
    @GET("getdataresep")
    Call<ModelGambarTreat> getResep();

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseModelTreat> insertData(@Field("nama_resep") String nama,
                                   @Field("detail") String detail,
                                   @Field("gambar") String gambar);
    //update menggunakan 3 parameter
    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseModelTreat> updateData( @Field("id_resep") String id,
                                    @Field("nama_resep") String nama,
                                    @Field("detail") String detail,
                                    @Field("gambar") String gambar);
    //delete menggunakan parameter id
    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseModelTreat> deleteData(@Field("id_resep") String id);

    //delete menggunakan parameter id for new delete
    @FormUrlEncoded
    @POST("delete_new.php")
    Call<ResponseModelTreat> deleteNewData(@Field("id_resep") String id);
}
