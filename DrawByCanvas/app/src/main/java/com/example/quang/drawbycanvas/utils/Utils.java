package com.example.quang.drawbycanvas.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

public class Utils {
    public static boolean checkPermission(Context mContext) {
        int READ_EXTERNAL_STORAGE = mContext.checkCallingOrSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
        int WRITE_EXTERNAL_STORAGE = mContext.checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        return READ_EXTERNAL_STORAGE == PackageManager.PERMISSION_GRANTED
                && WRITE_EXTERNAL_STORAGE == PackageManager.PERMISSION_GRANTED;
    }
}
