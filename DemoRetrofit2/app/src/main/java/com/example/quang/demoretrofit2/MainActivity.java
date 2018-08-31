package com.example.quang.demoretrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quang.demoretrofit2.services.APIClient;
import com.example.quang.demoretrofit2.services.DataClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText edtUser, edtPass;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findID();
        initViews();
    }

    private void findID() {
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }

    private void initViews() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();

                if (user.isEmpty() || pass.isEmpty()){
                    return;
                }

                DataClient dataClient = APIClient.getData();
                Call<List<SinhVien>> callBack = dataClient.login(user,pass);
                callBack.enqueue(new Callback<List<SinhVien>>() {
                    @Override
                    public void onResponse(Call<List<SinhVien>> call, Response<List<SinhVien>> response) {
                        ArrayList<SinhVien> arrSV = (ArrayList<SinhVien>) response.body();
                        if (arrSV.size() > 0){
                            Log.e("00000000",arrSV.get(0).getUser());
                            Log.e("00000000",arrSV.get(0).getPass());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<SinhVien>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Không tồn tại", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}
