package com.example.view.checkCourses.checkStudentCourses;

import androidx.appcompat.app.AppCompatActivity;
import com.example.learningapp.R;
import android.os.Bundle;

public class CheckStudentCoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.my_courses2);
        setContentView(R.layout.activity_check_student_courses);
    }
}