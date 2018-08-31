package com.example.quang.studenthousing.services;

public class APIClient {
    public static final String BASE_URL = "http://192.168.100.84/StudentHousing/";

    public static DataClient getData(){

        return RetrofitClient.getClient(BASE_URL).create(DataClient.class);
    }
}
