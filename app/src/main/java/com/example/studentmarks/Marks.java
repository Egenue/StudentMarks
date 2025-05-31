package com.example.studentmarks;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Marks extends AppCompatActivity {

    EditText marks, studentName, subject,student_regNo, subject_code, cat, total;
    Button btn_submit, view_all_marks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);

        view_all_marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
            }
        });

        connectingToFirebase(new Bean());
    }

    private void connectingToFirebase(Bean bean) {
        // Get Firebase database reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("marks");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated
                Bean value = dataSnapshot.getValue(Bean.class);

                String StudentRegNo = value.getStrstudent_regNo();
                String StudentName = value.getStrStudentName();
                String Cat = value.getStrCat();
                String Marks = value.getStrMarks();
                String Total = value.getStrTotal();
                String SubjectName = value.getStrSubject();
                String SubjectCode = value.getStrsubjectCode();
                studentName.setText(StudentName);
                student_regNo.setText(StudentRegNo);
                cat.setText(Cat);
                marks.setText(Marks);
                total.setText(Total);
                subject.setText(SubjectName);
                subject_code.setText(SubjectCode);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

}