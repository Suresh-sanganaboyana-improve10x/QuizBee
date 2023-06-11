package com.example.quizbee.network;

import com.example.quizbee.Constants;
import com.example.quizbee.model.QuizBee;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionService {
    @GET(Constants.END_POINT)
    Call<List<QuizBee>> fetchQuizBee();

}
