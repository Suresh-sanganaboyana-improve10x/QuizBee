package com.example.quizbee.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizbee.network.QuestionApi;
import com.example.quizbee.network.QuestionService;

public class BaseActivity extends AppCompatActivity {

    protected QuestionService questionService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupApiService();
    }

    public void setupApiService() {
        QuestionApi questionApi = new QuestionApi();
        questionService = questionApi.createQuestionService();
    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
