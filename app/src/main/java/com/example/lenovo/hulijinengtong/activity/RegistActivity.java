package com.example.lenovo.hulijinengtong.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lenovo.hulijinengtong.R;

public class RegistActivity extends AppCompatActivity {
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        init();
    }
    private void init(){
        btn_register=(Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegistActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(RegistActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
