package com.example.view.quiz.quizParticipation;

import androidx.appcompat.app.AppCompatActivity;
import com.example.learningapp.R;

import android.os.Bundle;
public class QuizParticipationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.participate_in_quiz2);
        setContentView(R.layout.activity_quiz_participation);
    }
}