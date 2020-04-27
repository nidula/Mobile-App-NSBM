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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Lsignup extends AppCompatActivity {

    ProgressBar progressBar;
    EditText email,fname,lname,address;
    EditText password;
    Button signup,clear;
    TextView userIdShow;
    FirebaseAuth firebaseAuth;
    private int userID = 0;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsignup);

        firebaseDatabase = FirebaseDatabase.getInstance();
//        firebaseDatabase.getReference().child("Lectures").child(""+1).child("userID").setValue(1);
//        firebaseDatabase.getReference().child("Lectures").child(""+1).child("fname").setValue("nimal");

        progressBar = findViewById(R.id.progressBar2);
        email = findViewById(R.id.editText7);
        password = findViewById(R.id.editText8);
        userIdShow = (TextView) findViewById(R.id.textView58);
        signup = findViewById(R.id.button72);
        fname = findViewById(R.id.editText9);
        lname = findViewById(R.id.editText11);
        address = findViewById(R.id.editText12);
        clear = findViewById(R.id.clear);

        firebaseAuth = FirebaseAuth.getInstance();

        email.addTextChangedListener(loginTextWatcher);
        password.addTextChangedListener(loginTextWatcher);
        fname.addTextChangedListener(loginTextWatcher);
        lname.addTextChangedListener(loginTextWatcher);
        address.addTextChangedListener(loginTextWatcher);

        buildUserID();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                firebaseDatabase.getReference().child("Lectures").child(String.valueOf(userID)).child("userID").setValue(userID);
                firebaseDatabase.getReference().child("Lectures").child(String.valueOf(userID)).child("fname").setValue(fname.getText().toString());
                firebaseDatabase.getReference().child("Lectures").child(String.valueOf(userID)).child("lname").setValue(lname.getText().toString());
                firebaseDatabase.getReference().child("Lectures").child(String.valueOf(userID)).child("address").setValue(address.getText().toString());
                firebaseDatabase.getReference().child("Lectures").child(String.valueOf(userID)).child("email").setValue(email.getText().toString());

                Toast.makeText(Lsignup.this, "New lecture added", Toast.LENGTH_SHORT).show();

                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),
                        password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    firebaseAuth.getCurrentUser().sendEmailVerification()
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if(task.isSuccessful()){
                                                        Toast.makeText(Lsignup.this, "Registered successfully. Please check your email for verification",
                                                                Toast.LENGTH_LONG).show();
                                                        email.setText("");
                                                        password.setText("");
                                                    }else{
                                                        Toast.makeText(Lsignup.this,  task.getException().getMessage(),
                                                                Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });
                                } else {
                                    Toast.makeText(Lsignup.this, task.getException().getMessage(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname.setText("");
                lname.setText("");
                address.setText("");
                email.setText("");
                password.setText("");
            }
        });

    }

    private void buildUserID() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference().child("Lectures");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int j;
                for (j = 1; dataSnapshot.hasChild(String.valueOf(j)); j++) {
                }
                userID = j;
                Log.d("nsbmgreenuniversity", "userId..... : " + userID);
                userIdShow.setText("Lecturer ID: " + userID);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String emailinput = email.getText().toString().trim();
            String passinput = password.getText().toString().trim();
            String nameinput = fname.getText().toString().trim();
            String nicinput = lname.getText().toString().trim();
            String genderinput = address.getText().toString().trim();
            signup.setEnabled(!emailinput.isEmpty() && !passinput.isEmpty() && !nameinput.isEmpty() && !nicinput.isEmpty() && !genderinput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
