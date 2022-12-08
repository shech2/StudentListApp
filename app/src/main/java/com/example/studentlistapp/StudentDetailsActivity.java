package com.example.studentlistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentlistapp.Model.Model;
import com.example.studentlistapp.Model.Student;

import java.util.List;

public class StudentDetailsActivity extends AppCompatActivity {

    List<Student> data = Model.instance().getAllStudents();
    TextView nameTv, idTv, phoneTv, addressTv;
    CheckBox cb;
    Button back,edit;
    Intent thisI;
    int pos;
    Student st;
    public Intent editI;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);


        thisI = getIntent();
        pos = (int)thisI.getSerializableExtra("pos");
        st = data.get(pos);
        nameTv = findViewById(R.id.student_details_tv_st_name);
        idTv = findViewById(R.id.student_details_tv_st_ID);
        phoneTv=findViewById(R.id.student_details_tv_st_phone);
        addressTv=findViewById(R.id.student_details_tv_st_address);
        cb = findViewById(R.id.student_details_cb);
        back=findViewById(R.id.student_details_back_btn);
        edit=findViewById(R.id.student_details_edit_btn);

        this.bind(st,pos);

        edit.setOnClickListener(view -> {
            editI = new Intent(this, StudentEditActivity.class);
            editI.putExtra("pos",pos);
            startActivity(editI);

        });

        back.setOnClickListener(view -> finish());

    }

    public void bind(Student st, int pos) {
        nameTv.setText(st.name);
        idTv.setText(st.id);
        phoneTv.setText(st.phone);
        addressTv.setText(st.address);
        cb.setChecked(st.cb);

    }


    @Override
    protected void onStart() {
        super.onStart();
        bind(st,pos);
    }


}