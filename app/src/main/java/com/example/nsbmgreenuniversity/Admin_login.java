package com.example.nsbmgreenuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_login extends AppCompatActivity {
    Button login;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        login=(Button)findViewById(R.id.button16);
        username=(EditText)findViewById(R.id.edituse);
        password=(EditText)findViewById(R.id.editpass);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });

    }
    public void login(){
        Button btn9 = (Button) findViewById(R.id.button16);
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(user.equals("admin123") && pass.equals("nsbm123"))
        {
            Toast.makeText(this,"Welcome to NSBM Admin Panal!", Toast.LENGTH_LONG).show();

            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent int9 = new Intent(Admin_login.this, Admin_main.class);
                    startActivity(int9);
                }
            });
        }
        else
        {
            Toast.makeText(this,"Username and Password incorrect", Toast.LENGTH_LONG).show();
        }
    }
}
