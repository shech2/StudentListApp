package com.example.studentlistapp.Model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance(){
        return _instance;
    }
    private Model(){
        for(int i=0;i<20;i++){
            addStudent(new Student("name " + i,"id "+i,"phone "+i,"address "+i, "avatar", false));
        }
    }

    public void deleteStudent(int pos){
        data.remove(pos);
    }

    List<Student> data = new LinkedList<>();
    public List<Student> getAllStudents(){
        return data;
    }

    public void addStudent(Student st){
        data.add(st);
    }


}
