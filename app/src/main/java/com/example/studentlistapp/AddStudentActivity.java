package com.example.studentlistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentlistapp.Model.Model;
import com.example.studentlistapp.Model.Student;

import java.util.List;

public class AddStudentActivity extends AppCompatActivity {
    List<Student> data = Model.instance().getAllStudents();
    EditText namePt, idPt, phonePt, addressPt;
    CheckBox cb;
    Button cancel,save;
    Intent addI;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        namePt = (EditText)findViewById(R.id.student_add_st_Pt_name);
        idPt = findViewById(R.id.student_add_st_Pt_id);
        phonePt=findViewById(R.id.student_add_st_Pt_phone);
        addressPt=findViewById(R.id.student_add_st_Pt_address);
        cb = findViewById(R.id.student_add_st_cb);
        cancel=findViewById(R.id.student_add_st_cancel_btn);
        save=findViewById(R.id.student_add_st_save_btn);


        cancel.setOnClickListener(view -> finish());
        save.setOnClickListener((view)->{
            Student st=new Student(namePt.getText().toString(),idPt.getText().toString(),phonePt.getText().toString(),addressPt.getText().toString(),"",cb.isChecked());
            data.add(st);
            finish();
        });

    }
}