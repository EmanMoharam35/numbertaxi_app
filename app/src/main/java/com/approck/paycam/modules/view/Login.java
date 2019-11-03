package com.approck.paycam.modules.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

import com.approck.paycam.R;
import com.approck.paycam.common.GoToHelper;

public class Login extends AppCompatActivity {
    Boolean encrypted = true;
    private EditText ET_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ET_password=findViewById(R.id.password);
    }

    public void login(View view) {
        GoToHelper.goHome(Login.this);
        finish();
    }

    public void show_pass(View view) {
        if (encrypted) {
            ET_password.setTransformationMethod(null);
            encrypted = false;
        } else {
            ET_password.setTransformationMethod(new PasswordTransformationMethod());
            encrypted = true;
        }
    }
}
