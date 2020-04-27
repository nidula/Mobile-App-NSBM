package com.example.nsbmgreenuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Places_uni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_uni);

        Button btn8 = (Button) findViewById(R.id.button43);
        Button btn9=(Button) findViewById(R.id.button44);
        Button btn10=(Button) findViewById(R.id.button45);
        Button btn11=(Button) findViewById(R.id.button46);
        Button btn12=(Button) findViewById(R.id.button47);
        Button btn13=(Button) findViewById(R.id.button48);
        Button btn14=(Button) findViewById(R.id.button49);
        Button btn15=(Button) findViewById(R.id.button50);
        Button btn16=(Button) findViewById(R.id.button51);
        Button btn17=(Button) findViewById(R.id.button52);
        Button btn18=(Button) findViewById(R.id.button53);
        Button btn19=(Button) findViewById(R.id.button54);
        Button btn20=(Button) findViewById(R.id.button55);
        Button btn21=(Button) findViewById(R.id.button56);
        Button btn22=(Button) findViewById(R.id.button57);
        Button btn23=(Button) findViewById(R.id.button58);



        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int8 = new Intent(Places_uni.this, Admin.class);
                startActivity(int8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int9 = new Intent(Places_uni.this, SOB.class);
                startActivity(int9);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int10 = new Intent(Places_uni.this, SOC.class);
                startActivity(int10);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int11 = new Intent(Places_uni.this, SOE.class);
                startActivity(int11);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int12 = new Intent(Places_uni.this, Marketing.class);
                startActivity(int12);
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int13 = new Intent(Places_uni.this, Auditorium.class);
                startActivity(int13);
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int14 = new Intent(Places_uni.this, Library.class);
                startActivity(int14);
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int15 = new Intent(Places_uni.this, AudiCanteen.class);
                startActivity(int15);
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int16 = new Intent(Places_uni.this, MiniMart.class);
                startActivity(int16);
            }
        });
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int17 = new Intent(Places_uni.this, BOC.class);
                startActivity(int17);
            }
        });
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int18 = new Intent(Places_uni.this, RecreationCenter.class);
                startActivity(int18);
            }
        });
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int19 = new Intent(Places_uni.this, StudentCenter.class);
                startActivity(int19);
            }
        });
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int20 = new Intent(Places_uni.this, HostelComplex.class);
                startActivity(int20);
            }
        });
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int21 = new Intent(Places_uni.this, HostelCanteen.class);
                startActivity(int21);
            }
        });
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int22 = new Intent(Places_uni.this, The_edge.class);
                startActivity(int22);
            }
        });
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int23 = new Intent(Places_uni.this, bookshop.class);
                startActivity(int23);
            }
        });






    }
}
