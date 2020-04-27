package com.example.nsbmgreenuniversity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soc_batch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soc_batch);

        Button btn1 = (Button) findViewById(R.id.button23);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(Soc_batch.this, Batch_namesoc181.class);
                startActivity(int1);
            }
        });
    }
    public void browser2 (View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1AlvEQ2Nhw_utY0he-BDbtr9ll3h6rEzMuRarzqMqkAg/edit#gid=0 "));
        startActivity(browserIntent);
    }
    public void browser3 (View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1CGG24VOWgU6p-kOu0dqTpJBq4wyI7h7mtFm3YIY3l48/edit#gid=0 "));
        startActivity(browserIntent);
    }
}
