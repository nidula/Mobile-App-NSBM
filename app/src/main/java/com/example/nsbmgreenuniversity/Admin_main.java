package com.example.nsbmgreenuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        Button btn65 = (Button)findViewById(R.id.button65);
        Button btn66 = (Button)findViewById(R.id.button66);
        Button btn67 = (Button)findViewById(R.id.button67);

        Button btn68 = (Button)findViewById(R.id.button74);
        Button btn69 = (Button)findViewById(R.id.button75);
        Button btn70 = (Button)findViewById(R.id.button76);

        Button btn71 = (Button)findViewById(R.id.button77);
        Button btn72 = (Button)findViewById(R.id.button78);
        Button btn73 = (Button)findViewById(R.id.button79);

        Button btn74 = (Button)findViewById(R.id.button84);

        btn65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int65= new Intent(Admin_main.this,Admin_event.class);
                startActivity(int65);
            }
        });
        btn66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int66 = new Intent(Admin_main.this,Update_Event.class);
                startActivity(int66);
            }
        });
        btn67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int67 = new Intent(Admin_main.this,View_Event.class);
                startActivity(int67);
            }
        });


        btn68.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int68= new Intent(Admin_main.this,Ssignup.class);
                startActivity(int68);
            }
        });
        btn69.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int69 = new Intent(Admin_main.this,Update_student.class);
                startActivity(int69);
            }
        });
        btn70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int70 = new Intent(Admin_main.this,View_student.class);
                startActivity(int70);
            }
        });


        btn71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int71= new Intent(Admin_main.this,Lsignup.class);
                startActivity(int71);
            }
        });
        btn72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int72 = new Intent(Admin_main.this,Update_lecture.class);
                startActivity(int72);
            }
        });
        btn73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int73 = new Intent(Admin_main.this,View_lecture.class);
                startActivity(int73);
            }
        });

        btn74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int74 = new Intent(Admin_main.this,MainActivity.class);
                startActivity(int74);
            }
        });
    }
}
