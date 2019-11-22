package com.example.esoftwarica.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esoftwarica.Model.Students;
import com.example.esoftwarica.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentsViewHolder> {
  private Context context;
  public List<Students> StudentList;

    public StudentAdapter(Context context, List<Students> studentsList) {
        this.context = context;
        this.StudentList = studentsList;
}

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new StudentsViewHolder(view, context, StudentList);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {
        Students students=StudentList.get(position);

        holder.name.setText(students.getName());
        holder.age.setText(students.getAge()+ "");
        holder.gender.setText(students.getGender());
        holder.address.setText(students.getAddress());
        holder.image.setImageResource(students.getImage());

        
    }

    @Override
    public int getItemCount() {
        return StudentList.size();
    }


    public class StudentsViewHolder extends RecyclerView.ViewHolder{
        TextView name, age, address,gender;
        ImageView image;
        ImageView btnDelete;
        Context context;
        List<Students> list;

        public StudentsViewHolder(@NonNull View itemView, Context context, final List<Students> list) {
            super(itemView);
            name = itemView.findViewById(R.id.tvStudentName);
            age = itemView.findViewById(R.id.tvStudentAge);
            address = itemView.findViewById(R.id.tvStudentAddress);
            gender = itemView.findViewById(R.id.tvStudentGender);
            image = itemView.findViewById(R.id.image);
            btnDelete = itemView.findViewById(R.id.imgDelete);

            this.context = context;
            this.list = list;

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });
        }
    }
}