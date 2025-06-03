package com.example.studentmarks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MarksAdapter extends RecyclerView.Adapter<MarksAdapter.ViewHolder> {
    private List<Bean> marksList;

    public MarksAdapter(List<Bean> marksList) {
        this.marksList = marksList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView studentName, regNo, subjectCode, subject, cat, total, marks;

        public ViewHolder(View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.tvStudentName);
            regNo = itemView.findViewById(R.id.tvRegNo);
            subjectCode = itemView.findViewById(R.id.tvSubjectCode);
            subject = itemView.findViewById(R.id.tvSubject);
            cat = itemView.findViewById(R.id.tvCat);
            total = itemView.findViewById(R.id.tvTotal);
            marks = itemView.findViewById(R.id.tvMarks);
        }

        public void bind(Bean bean) {
            studentName.setText("Name: " + bean.getStrStudentName());
            regNo.setText("Reg No: " + bean.getStrstudent_regNo());
            subjectCode.setText("Code: " + bean.getStrsubjectCode());
            subject.setText("Subject: " + bean.getStrSubject());
            cat.setText("CAT: " + bean.getStrCat());
            total.setText("Total: " + bean.getStrTotal());
            marks.setText("Marks: " + bean.getStrMarks());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mark, parent, false); // Define item_mark.xml layout
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(marksList.get(position));
    }

    @Override
    public int getItemCount() {
        return marksList.size();
    }
}

