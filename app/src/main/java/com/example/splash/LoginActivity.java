package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button Login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.ed11);
        password=(EditText) findViewById(R.id.ed22);
        Login=(Button) findViewById(R.id.btn1);
        DB= new DBHelper(this);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= username.getText().toString();
                String pass= password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this , "Please enter the details",Toast.LENGTH_LONG).show();
                else{
                    if(user.equals("AMAN")&& pass.equals("123"))
                   {
                        Toast.makeText(LoginActivity.this , "Sign in successfully",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(LoginActivity.this, "invalid login",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}