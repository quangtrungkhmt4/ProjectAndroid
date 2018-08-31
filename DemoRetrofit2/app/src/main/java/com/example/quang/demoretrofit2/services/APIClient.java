package com.example.quang.demoretrofit2.services;

public class APIClient {

    public static final String BASE_URL = "http://192.168.100.98/quanlysinhvien/";

    public static DataClient getData(){

        return RetrofitClient.getClient(BASE_URL).create(DataClient.class);
    }
}
