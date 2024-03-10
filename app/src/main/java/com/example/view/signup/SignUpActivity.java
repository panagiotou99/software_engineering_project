package com.example.view.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.domain.User;
import com.example.learningapp.R;
import com.example.view.login.LogInActivity;
import com.example.view.signup.signupStudent.SignUpStudentActivity;
import com.example.view.signup.signupTeacher.SignUpTeacherActivity;

/**
 * A subclass of {@link AppCompatActivity} used for {@link User}
 * to determine the type of user that is going to be registered
 *
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */
public class SignUpActivity extends AppCompatActivity {

    private Button btnLogin,btnSignUpStudent,btnSignUpTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.signup2);
        setContentView(R.layout.activity_sign_up);
        btnLogin = findViewById(R.id.change_to_login);
        btnSignUpStudent = findViewById(R.id.bttnSignUpStudent);
        btnSignUpTeacher = findViewById(R.id.bttnSignUpTeacher);

        InitClickListeners();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    private void InitClickListeners(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
            }
        });

        btnSignUpStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SignUpStudentActivity.class));
            }
        });

        btnSignUpTeacher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(SignUpActivity.this, SignUpTeacherActivity.class));
            }
        });
    }
}