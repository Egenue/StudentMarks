package com.example.studentmarks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText marks, studentName, subject,student_regNo, subject_code, cat, total;
    Button  btn_submit, view_all_marks;
    String strStudentName, strMarks, strSubject, strstudent_regNo, strsubject_code, strCat, strTotal;

    Bean Bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_all_marks = findViewById(R.id.btn_view_all);
        total = findViewById(R.id.total);
        cat = findViewById(R.id.cat);
        student_regNo = findViewById(R.id.student_regNo);
        marks = findViewById(R.id.et_marks);
        studentName = findViewById(R.id.et_student_name);
        subject_code = findViewById(R.id.subject_code);
        subject = findViewById(R.id.et_subject);
        btn_submit = findViewById(R.id.btn_submit);

        view_all_marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Marks.class);
                startActivity(intent);
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strStudentName = studentName.getText().toString();
                studentName.setText("");

                strsubject_code = subject_code.getText().toString();
                subject_code.setText("");

                strCat = cat.getText().toString();
                cat.setText("");

                strTotal = total.getText().toString();
                total.setText("");

                strMarks = marks.getText().toString();
                marks.setText("");

                strSubject = subject.getText().toString();
                subject.setText("");

                strstudent_regNo = student_regNo.getText().toString();
                student_regNo.setText("");

                Toast.makeText(getApplicationContext(), "Student " + strStudentName + "Added !", Toast.LENGTH_SHORT).show();

                Bean Bean = new Bean(strStudentName, strsubject_code,strCat, strTotal, strMarks,strSubject, strstudent_regNo);

                connectingToFirebase(Bean);
            }
        });
    }

    private void connectingToFirebase(Bean Bean) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("marks");
        myRef.push().setValue(Bean);
    }
}