package com.example.quizbee;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizbee.databinding.QuestionsItemBinding;
import com.example.quizbee.model.Question;



import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsViewHolder> {

    private List<Question> questions;

    void setQuestionsData(List<Question> questions) {
        this.questions = questions;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionsItemBinding binding = QuestionsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        QuestionsViewHolder questionsViewHolder = new QuestionsViewHolder(binding);
        return questionsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.binding.questionNumTxt.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
