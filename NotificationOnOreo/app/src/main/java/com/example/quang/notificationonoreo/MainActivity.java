package com.example.quang.notificationonoreo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationHelper notificationHelper = new NotificationHelper(this);
        notificationHelper.createNotification("DemoNoti", "Cin chao");
    }
}
