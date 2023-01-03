package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password,repassword;
    Button Login,Signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username= findViewById(R.id.ed1);
        password= findViewById(R.id.ed2);
        repassword= findViewById(R.id.ed3);
        Login= findViewById(R.id.b1);
        Signup= findViewById(R.id.b2);
        DB = new DBHelper(this);
        Login.setOnClickListener(v -> {
            Intent intent= new Intent (getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        });
        Signup.setOnClickListener(v -> {
            String user= username.getText().toString();
            String pass=password.getText().toString();
            String repass= repassword.getText().toString();

            if(user.equals("")||pass.equals("")||repass.equals(""))
                Toast.makeText(MainActivity.this, "Please enter the details",Toast.LENGTH_LONG).show();
            else {

                            Toast.makeText(MainActivity.this,"done ", Toast.LENGTH_LONG).show();

                        }
                    });
    }
}