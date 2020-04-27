package com.example.nsbmgreenuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Button btn29 = (Button) findViewById(R.id.button2);
        Button btn30 = (Button) findViewById(R.id.button10);

        btn29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int29 = new Intent(Map.this, google_MapsActivity.class);
                startActivity(int29);
            }
        });
        btn30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int30 = new Intent(Map.this, SOC_map.class);
                startActivity(int30);
            }
        });
    }
}
