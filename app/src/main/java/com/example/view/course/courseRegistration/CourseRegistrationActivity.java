package com.example.view.course.courseRegistration;

import androidx.appcompat.app.AppCompatActivity;
import com.example.learningapp.R;
import android.os.Bundle;

public class CourseRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.register_to_course2);
        setContentView(R.layout.activity_course_registration);
    }
}