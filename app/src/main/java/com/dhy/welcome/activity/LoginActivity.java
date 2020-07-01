package com.dhy.welcome.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.dhy.welcome.MainActivity;
import com.dhy.welcome.R;

public class LoginActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editPass;
    private Button btnLogin;
    private CheckBox checkBox;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editName = findViewById(R.id.edit_name);
        editPass = findViewById(R.id.edit_pass);
        btnLogin = findViewById(R.id.btn_login);
        checkBox = findViewById(R.id.check_box);
        sp = getSharedPreferences("user",MODE_PRIVATE);
        editor = sp.edit();
        String name = sp.getString("userName", null);
        if(name==null){
            checkBox.setChecked(false);
        }else {
            editName.setText(name);
            checkBox.setChecked(true);
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString().trim();
                String pass = editPass.getText().toString().trim();
                if(name.equals("Alworm")&&pass.equals("123")){
                    if(checkBox.isChecked()){
                        editor.putString("userName", name);
                        editor.commit();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        editor.remove("userName");
                        editor.commit();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
