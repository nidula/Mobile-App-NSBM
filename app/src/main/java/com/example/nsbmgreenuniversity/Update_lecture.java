package com.example.nsbmgreenuniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Update_lecture extends AppCompatActivity {

    Button updateBtn,retriewBtn;
    EditText uid,fname,lname,address;

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_lecture);

        firebaseDatabase = FirebaseDatabase.getInstance();
        updateBtn = (Button) findViewById(R.id.button83);
        retriewBtn = (Button) findViewById(R.id.button82);
        uid = (EditText) findViewById(R.id.editText23);
        fname = (EditText) findViewById(R.id.editText24);
        lname = (EditText) findViewById(R.id.editText25);
        address = (EditText) findViewById(R.id.editText26);

        uid.addTextChangedListener(loginTextWatcher);
        fname.addTextChangedListener(loginTextWatcher);
        lname.addTextChangedListener(loginTextWatcher);
        address.addTextChangedListener(loginTextWatcher);

        retriewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    DatabaseReference reference = firebaseDatabase.getReference().child("Lectures");
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String userID = uid.getText().toString();
                            if(dataSnapshot.hasChild(userID))
                            {
                                fname.setText(dataSnapshot.child(userID).child("fname").getValue().toString());
                                lname.setText(dataSnapshot.child(userID).child("lname").getValue().toString());
                                address.setText(dataSnapshot.child(userID).child("address").getValue().toString());

                            }
                            else
                            {
                                Toast.makeText(Update_lecture.this, "Lecturer not found", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                        }
                    });
                }
                catch (Exception e)
                {
                    Log.d("nsbmgreenuniversity", "error : " + e.toString());
                }
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = uid.getText().toString();
                firebaseDatabase.getReference().child("Lectures").child(String.valueOf(userID)).child("fname").setValue(fname.getText().toString());
                firebaseDatabase.getReference().child("Lectures").child(String.valueOf(userID)).child("lname").setValue(lname.getText().toString());
                firebaseDatabase.getReference().child("Lectures").child(String.valueOf(userID)).child("address").setValue(address.getText().toString());
                Toast.makeText(Update_lecture.this, "Lecturer Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String nameinput = fname.getText().toString().trim();
            String genderinput = lname.getText().toString().trim();
            String nicinput = address.getText().toString().trim();
            String uidinput = uid.getText().toString().trim();
            updateBtn.setEnabled(!uidinput.isEmpty());
            retriewBtn.setEnabled(!uidinput.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
