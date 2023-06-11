package com.example.quizbee;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quizbee.base.BaseActivity;
import com.example.quizbee.databinding.ActivityQuestionsBinding;

import com.example.quizbee.model.Question;
import com.example.quizbee.model.QuizBee;
import com.example.quizbee.network.QuestionApi;
import com.example.quizbee.network.QuestionService;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionsActivity extends BaseActivity {

    private ActivityQuestionsBinding binding;
    private List<Question> questions = new ArrayList<>();
    private QuestionsAdapter questionsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fetchQuestions();
        setupQuestionsAdapter();
        setupQuestionsRv();
    }

    public void setQuestions(Question question) {
        binding.questionTxt.setText(question.getQuestion());
        binding.answerARb.setText(question.getAnswers().get(0));
        binding.answerBRb.setText(question.getAnswers().get(1));
        binding.answerCRb.setText(question.getAnswers().get(2));
        binding.answerDRb.setText(question.getAnswers().get(3));
    }
    public void fetchQuestions() {
        Call<List<QuizBee>> call = questionService.fetchQuizBee();
        call.enqueue(new Callback<List<QuizBee>>() {
            @Override
            public void onResponse(Call<List<QuizBee>> call, Response<List<QuizBee>> response) {
                if (response.isSuccessful()) {
                    questions = response.body().get(0).getQuestions();
                    questionsAdapter.setQuestionsData(questions);
                    setQuestions(questions.get(0));
                }
                showToast("Successfully fetch the data");
            }

            @Override
            public void onFailure(Call<List<QuizBee>> call, Throwable t) {
                showToast("Failed to load data");
            }
        });
    }

    public void setupQuestionsAdapter() {
        questionsAdapter = new QuestionsAdapter();
        questionsAdapter.setQuestionsData(new ArrayList<>());
    }

    public void setupQuestionsRv() {
        binding.questionsRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        binding.questionsRv.setAdapter(questionsAdapter);
    }
}