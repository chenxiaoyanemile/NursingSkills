package com.example.lenovo.hulijinengtong.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.hulijinengtong.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_login;
    private Button btn_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }
    public void initView(){
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_regist=(Button)findViewById(R.id.btn_regist);

        btn_login.setOnClickListener(this);
        btn_regist.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                    submitLogin();
                break;
            case R.id.btn_regist:
                startActivity(new Intent(this, RegistActivity.class));
                break;
        }
    }
    private void submitLogin(){
        Intent intent=new Intent(LoginActivity.this,MainPageActivity.class);
        startActivity(intent);
        finish();
    }
}
