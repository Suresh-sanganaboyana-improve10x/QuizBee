package com.example.quizbee.network;

import com.example.quizbee.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionApi {

    public QuestionService createQuestionService () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QuestionService questionService =  retrofit.create(QuestionService.class);
        return questionService;
    }
}
