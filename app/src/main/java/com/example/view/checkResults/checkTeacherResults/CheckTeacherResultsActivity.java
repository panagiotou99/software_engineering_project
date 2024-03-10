package com.example.view.checkResults.checkTeacherResults;

import androidx.appcompat.app.AppCompatActivity;
import com.example.learningapp.R;
import android.os.Bundle;

public class CheckTeacherResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.my_students_results2);
        setContentView(R.layout.activity_check_teacher_results);
    }
}