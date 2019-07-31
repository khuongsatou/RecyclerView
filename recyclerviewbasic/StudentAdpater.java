package com.example.recyclerviewbasic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdpater extends RecyclerView.Adapter<StudentAdpater.StudentHolder> {
    private List<Student> studentList;

    private myOnItemClickListener myOnItemClick;

    public void setMyOnItemClick(myOnItemClickListener myOnItemClick) {
        this.myOnItemClick = myOnItemClick;
    }

    public StudentAdpater(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //khai báo đối tượng view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, final int position) {
        //đưa data vào hàng tương ứng
        holder.tvInfo.setText(studentList.get(position).Name+" | "+studentList.get(position).Phone);
        holder.tvInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myOnItemClick.onClick(studentList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentHolder extends RecyclerView.ViewHolder {

        public TextView tvInfo;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);

            tvInfo = (TextView) itemView.findViewById(R.id.tvInfo);
        }




    }
}
