package com.example.quang.demoemotion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String unicode = "0x1F606";
        int u = Integer.parseInt(unicode.substring(2), 16);
        final TextView tv = findViewById(R.id.tv);
        tv.setText(getEmojiByUnicode(u));

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, tv.getText().toString()+"", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }
}
