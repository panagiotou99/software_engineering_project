package com.example.view.course.courseCreation;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dao.daoMemory.MemoryInitializer;
import com.example.dao.daoStub.Initializer;
import com.example.learningapp.R;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class CreateCourseActivity extends AppCompatActivity implements CreateCourseView {

    private Button buttonCreateCourse;
    private CreateCoursePresenter presenter;
    private TextView invalidInputMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.create_a_course2);
        setContentView(R.layout.activity_create_course);
        buttonCreateCourse = findViewById(R.id.buttonCreateCourse);
        invalidInputMessage= findViewById(R.id.invalidInputMessage);
        Initializer memory = new MemoryInitializer();
        try {
            memory.prepareData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InitClickListeners();
        presenter = new CreateCoursePresenter(this, memory.getCourseDAO());
    }

    private void InitClickListeners(){
        buttonCreateCourse.setOnClickListener(v -> presenter.onSubmitForm());
    }

    @Override
    public String getCourseID(){
        EditText courseIdInput = findViewById(R.id.courseId);
        return courseIdInput.getText().toString();
    }

    @Override
    public String getCourseGrade(){
        EditText courseGradeInput = findViewById(R.id.courseGrade);
        return courseGradeInput.getText().toString();
    }

    @Override
    public String getCourseTitle(){
        EditText courseTitle = findViewById(R.id.courseTitle);
        return courseTitle.getText().toString();
    }

    @Override
    public String getCoursePrice(){
        EditText coursePrice = findViewById(R.id.coursePrice);
        return coursePrice.getText().toString();
    }

    @Override
    public String courseDescription(){
        EditText courseDescription = findViewById(R.id.courseDescription);
        return courseDescription.getText().toString();
    }

    @Override
    public void showEmptyInputMessage(){
        invalidInputMessage.setText(R.string.errorInputMessage1_1);
    }

    @Override
    public void showInvalidGradeMessage(){
        invalidInputMessage.setText(R.string.errorInputMessage2_2);
    }

    @Override
    public void onValidInput(){
        invalidInputMessage.setText(R.string.succesfulCourseCreation);
    }
}