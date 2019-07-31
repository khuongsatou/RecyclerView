package com.example.recyclerviewbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvList;
    private RecyclerView.LayoutManager layoutManager;

    private List<Student> studentList;
    private StudentAdpater studentAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Radiation();
        CreateAdapter();
    }

    private void CreateAdapter() {
        rvList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);

        studentList = new ArrayList<Student>();

        for (int i = 0; i <20 ; i++) {
            Student student = new Student();
            student.Name ="Khương " + i;
            student.Phone ="035624196" + i;
            studentList.add(student);
        }
        studentAdpater = new StudentAdpater(studentList);
        studentAdpater.setMyOnItemClick(new myOnItemClickListener() {
            @Override
            public void onClick(Student student) {
                Toast.makeText(MainActivity.this,student.Name,Toast.LENGTH_SHORT).show();
            }
        });


        rvList.setAdapter(studentAdpater);
    }

    private void Radiation() {
        rvList = (RecyclerView) findViewById(R.id.rvList);
    }
}
