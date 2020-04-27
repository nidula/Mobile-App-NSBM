package com.example.nsbmgreenuniversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Batch_namesoc181 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_namesoc181);
    }
    public void web1 (View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1fps8D5wJM9WPt16JhPeXG-xYTm6mgcWeoJ7Go88LtfE/edit#gid=1010307311"));
        startActivity(browserIntent);
    }
    public void web2 (View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1fps8D5wJM9WPt16JhPeXG-xYTm6mgcWeoJ7Go88LtfE/edit#gid=1010307311"));
        startActivity(browserIntent);
    }
}
