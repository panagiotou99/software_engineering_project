package com.example.view.question.checkStudentSavedQuestions;

import androidx.appcompat.app.AppCompatActivity;
import com.example.learningapp.R;

import android.os.Bundle;

public class CheckStudentSavedQuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.my_saved_questions2);
        setContentView(R.layout.activity_check_student_saved_questions);
    }
}