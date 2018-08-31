package com.example.quang.demoretrofit2.services;

import com.example.quang.demoretrofit2.SinhVien;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface DataClient {

    @Multipart
    @POST("uploadImage.php")
    Call<String> uploadImage(@Part MultipartBody.Part image);

    @FormUrlEncoded
    @POST("insert.php")
    Call<String> insertData(@Field("user") String user
                            , @Field("pass") String pass
                            , @Field("image") String image);

    @FormUrlEncoded
    @POST("login.php")
    Call<List<SinhVien>> login(@Field("user") String user
            , @Field("pass") String pass);

}
