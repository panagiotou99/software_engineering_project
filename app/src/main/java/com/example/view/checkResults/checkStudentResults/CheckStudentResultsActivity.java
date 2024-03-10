package com.example.view.checkResults.checkStudentResults;

import androidx.appcompat.app.AppCompatActivity;
import com.example.learningapp.R;
import android.os.Bundle;

public class CheckStudentResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.my_results2);
        setContentView(R.layout.activity_check_student_results);
    }
}