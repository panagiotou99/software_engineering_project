package com.example.view.homepage.teacherHomepage;

import androidx.appcompat.app.AppCompatActivity;
import com.example.learningapp.R;
import com.example.domain.Teacher;
import com.example.view.question.addQuestions.AddQuestionsActivity;
import com.example.view.checkCourses.checkTeacherCourses.CheckTeacherCoursesActivity;
import com.example.view.checkResults.checkTeacherResults.CheckTeacherResultsActivity;
import com.example.view.course.courseCreation.CreateCourseActivity;
import com.example.view.editQuizes.EditQuizesActivity;
import com.example.view.quiz.quizCreation.CreateQuizActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * A subclass of {@link AppCompatActivity} used for {@link Teacher}
 * to show the menu for a user that is a teacher
 *
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */
public class TeacherHomepageActivity extends AppCompatActivity implements TeacherHomepageView {

    private Button btnCreateQuiz,btnCreateCourse,btnAddQuestions,btnCheckTeacherCourses,btnCheckTeacherResults,btnEditQuizes,btnExit;
    TeacherHomepagePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.teacherHomepage);
        setContentView(R.layout.activity_teacher_homepage);
        btnCreateQuiz = findViewById(R.id.create_a_quiz);
        btnCreateCourse = findViewById(R.id.create_a_course);
        btnAddQuestions = findViewById(R.id.add_questions);
        btnCheckTeacherCourses = findViewById(R.id.my_courses);
        btnCheckTeacherResults = findViewById(R.id.my_students_results);
        btnEditQuizes= findViewById(R.id.my_quizes);
        btnExit= findViewById(R.id.exit);
        InitClickListeners();
        presenter = new TeacherHomepagePresenter(this);
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    private void InitClickListeners(){
        btnCreateQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickCreateQuiz();
            }
        });

        btnCreateCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickCreateCourse();
            }
        });

        btnAddQuestions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.onClickAddQuestions();
            }
        });

        btnCheckTeacherCourses.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.onClickCheckTeacherCourses();
            }
        });

        btnCheckTeacherResults.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.onClickCheckTeacherResults();
            }
        });

        btnEditQuizes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.onClickEditQuizes();
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
    public void createQuiz() {
        startActivity(new Intent(TeacherHomepageActivity.this, CreateQuizActivity.class));
    }

    @Override
    public void createCourse(){
        startActivity(new Intent(TeacherHomepageActivity.this, CreateCourseActivity.class));
    }

    @Override
    public void addQuestions(){
        startActivity(new Intent(TeacherHomepageActivity.this, AddQuestionsActivity.class));
    }

    @Override
    public void checkTeacherCourses(){
        startActivity(new Intent(TeacherHomepageActivity.this, CheckTeacherCoursesActivity.class));
    }

    @Override
    public void checkTeacherResults(){
        startActivity(new Intent(TeacherHomepageActivity.this, CheckTeacherResultsActivity.class));
    }

    @Override
    public void editQuizes(){
        startActivity(new Intent(TeacherHomepageActivity.this, EditQuizesActivity.class));
    }
}