package com.example.quizbee;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.quizbee.model.QuizBee;
import com.example.quizbee.network.QuestionApi;
import com.example.quizbee.network.QuestionService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void questionApiTest() throws IOException {
        QuestionApi questionApi = new QuestionApi();
        QuestionService questionService = questionApi.createQuestionService();
        Call<List<QuizBee>> call = questionService.fetchQuizBee();
        List<QuizBee> quizBee = call.execute().body();
        assertNotNull(quizBee);
        assertFalse(quizBee.isEmpty());
        System.out.println(new Gson().toJson(quizBee));
    }
}