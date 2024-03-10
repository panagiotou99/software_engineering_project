package com.example.view.homepage.studentHomepage;

import androidx.appcompat.app.AppCompatActivity;
import com.example.learningapp.R;
import com.example.domain.Student;
import com.example.view.checkCourses.checkStudentCourses.CheckStudentCoursesActivity;
import com.example.view.checkResults.checkStudentResults.CheckStudentResultsActivity;
import com.example.view.question.checkStudentSavedQuestions.CheckStudentSavedQuestionsActivity;
import com.example.view.course.courseRegistration.CourseRegistrationActivity;
import com.example.view.quiz.quizParticipation.QuizParticipationActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * A subclass of {@link AppCompatActivity} used for {@link Student}
 * to show the menu for a user that is a student
 *
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */

public class StudentHomepageActivity extends AppCompatActivity implements StudentHomepageView {

    Button btnParticipateInQuiz,btnRegisterToCourse,btnMyCourses,btnMyResults,btnMySavedQuestions,btnExit;
    StudentHomepagePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.studentHomepage);
        setContentView(R.layout.activity_student_homepage);

        btnParticipateInQuiz = findViewById(R.id.participate_in_quiz);
        btnRegisterToCourse = findViewById(R.id.register_to_course);
        btnMyCourses = findViewById(R.id.my_courses);
        btnMyResults = findViewById(R.id.my_results);
        btnMySavedQuestions = findViewById(R.id.my_saved_questions);
        btnExit= findViewById(R.id.exit);
        InitClickListeners();
        presenter = new StudentHomepagePresenter(this);

    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    private void InitClickListeners(){
        btnParticipateInQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickParticipateInQuiz();
            }
        });

        btnRegisterToCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickRegisterToCourses();
            }
        });

        btnMyCourses.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.onClickMyCourses();
            }
        });

        btnMyResults.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.onClickMyResults();
            }
        });

        btnMySavedQuestions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.onClickMySavedQuestions();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
                System.exit(0);
            }
        });
    }

    @Override
    public void participateInQuiz() {
        startActivity(new Intent(StudentHomepageActivity.this, QuizParticipationActivity.class));
    }

    @Override
    public void registerToCourse(){
        startActivity(new Intent(StudentHomepageActivity.this, CourseRegistrationActivity.class));
    }

    @Override
    public void myCourses(){
        startActivity(new Intent(StudentHomepageActivity.this, CheckStudentCoursesActivity.class));
    }

    @Override
    public void myResults(){
        startActivity(new Intent(StudentHomepageActivity.this, CheckStudentResultsActivity.class));
    }

    @Override
    public void mySavedQuestions(){
        startActivity(new Intent(StudentHomepageActivity.this, CheckStudentSavedQuestionsActivity.class));
    }
}