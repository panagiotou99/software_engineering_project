package com.example.view.quiz.quizCreation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.learningapp.R;

public class CreateQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.create_a_quiz2);
        setContentView(R.layout.activity_create_quiz);
    }
}