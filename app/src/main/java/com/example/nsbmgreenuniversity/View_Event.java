package com.example.nsbmgreenuniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class View_Event extends AppCompatActivity {

    ListView eventlist;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__event);

        firebaseDatabase = FirebaseDatabase.getInstance();

        eventlist = (ListView) findViewById(R.id.view2);

        list = new ArrayList<>();


        DatabaseReference databaseReference = firebaseDatabase.getReference().child("events");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    try {
                        list.add(snapshot.child("uid").getValue().toString()+"\n\n"+snapshot.child("name").getValue().toString()+"\n"+snapshot.child("venue").getValue().toString()+"\n\n"+snapshot.child("description").getValue().toString()+"\n\n"+snapshot.child("date").getValue().toString()+"\n"+snapshot.child("time").getValue().toString());
                        adapter.notifyDataSetChanged();
                    }catch (Exception e){
                        Log.d("nsbmgreenuniversity", "error : " + e.toString());
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        eventlist.setAdapter(adapter);
    }
}
