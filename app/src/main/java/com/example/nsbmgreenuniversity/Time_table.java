package com.example.nsbmgreenuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Time_table extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        Button btn4 = (Button) findViewById(R.id.button19);
        Button btn5 = (Button) findViewById(R.id.button20);
        Button btn6 = (Button) findViewById(R.id.button21);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4 = new Intent(Time_table.this, Soc_batch.class);
                startActivity(int4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5 = new Intent(Time_table.this, Sob_batch.class);
                startActivity(int5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int6 = new Intent(Time_table.this, Soe_batch.class);
                startActivity(int6);
            }
        });
    }
}
