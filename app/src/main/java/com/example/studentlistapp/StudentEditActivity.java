package com.example.studentlistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentlistapp.Model.Model;
import com.example.studentlistapp.Model.Student;

import java.util.List;

public class StudentEditActivity extends AppCompatActivity {
    List<Student> data = Model.instance().getAllStudents();
    EditText nameTv, idTv, phoneTv, addressTv;
    CheckBox cb;
    Button cancel,save,delete;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        Intent thisI = getIntent();
        int pos = (int)thisI.getSerializableExtra("pos");

        Student st = data.get(pos);
        nameTv = findViewById(R.id.student_edit_Pt_name);
        idTv = findViewById(R.id.student_edit_Pt_id);
        phoneTv=findViewById(R.id.student_edit_Pt_phone);
        addressTv=findViewById(R.id.student_edit_Pt_address);
        cb = findViewById(R.id.student_edit_cb);
        cancel=findViewById(R.id.student_edit_cancel_btn);
        delete=findViewById(R.id.student_edit_delete_btn);
        save=findViewById(R.id.student_edit_save_btn);

        this.bind(st,pos);

        save.setOnClickListener(view -> {
            this.bindBack(pos);
            finish();

        });

        delete.setOnClickListener(view->{
            Model.instance().deleteStudent(pos);
            Intent deleteI = new Intent(this, StudentRecyclerList.class);
            startActivity(deleteI);

        });
        cancel.setOnClickListener(view -> finish());

    }

    private void bindBack( int pos) {
        data.get(pos).name=nameTv.getText().toString();
        data.get(pos).id=idTv.getText().toString();
        data.get(pos).phone=phoneTv.getText().toString();
        data.get(pos).address=addressTv.getText().toString();
        data.get(pos).cb=cb.isChecked();
    }

    public void bind(Student st, int pos) {
        nameTv.setText(st.name);
        idTv.setText(st.id);
        phoneTv.setText(st.phone);
        addressTv.setText(st.address);
        cb.setChecked(st.cb);

    }
}
