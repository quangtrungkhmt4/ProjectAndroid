package com.example.quang.mohinhmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quang.mohinhmvp.XuLyDangNhap.PresenterLogicXuLyDangNhap;
import com.example.quang.mohinhmvp.XuLyDangNhap.ViewXuLyDangNhap;

public class MainActivity extends AppCompatActivity implements ViewXuLyDangNhap, View.OnClickListener {

    private EditText edtUser;
    private EditText edtPass;
    private Button btnLogin;
    private PresenterLogicXuLyDangNhap presenterLogicXuLyDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);

        presenterLogicXuLyDangNhap = new PresenterLogicXuLyDangNhap(this);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void dangNhapThanhCong() {
        Toast.makeText(this, "Thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dangNhapThatBai() {
        Toast.makeText(this, "Thất bại", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        presenterLogicXuLyDangNhap.kiemTraDangNhap(edtUser.getText().toString(),edtPass.getText().toString());
    }
}
