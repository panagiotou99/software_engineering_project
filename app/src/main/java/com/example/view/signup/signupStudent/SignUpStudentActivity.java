package com.example.view.signup.signupStudent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dao.daoMemory.MemoryInitializer;
import com.example.dao.daoStub.Initializer;
import com.example.domain.Student;
import com.example.learningapp.R;
import com.example.view.homepage.studentHomepage.StudentHomepageActivity;
import com.example.view.login.LogInActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

/**
 * A subclass of {@link AppCompatActivity} used for {@link Student}
 * to register
 *
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */
public class SignUpStudentActivity extends AppCompatActivity implements SignUpStudentView {
    private Button btnSignUpStudent;
    private SignUpStudentPresenter presenter;
    private EditText firstNameInput,lastNameInput,ageInput,emailInput,ibanInput,passwordInput,gradeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_student);
        setTitle(R.string.signup_student2);
        btnSignUpStudent = findViewById(R.id.buttonStudentSignUp);
        Initializer memory = new MemoryInitializer();
        try {
            memory.prepareData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        presenter = new SignUpStudentPresenter(this, memory.getUserDAO());
        InitClickListeners();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    private void InitClickListeners(){
        btnSignUpStudent.setOnClickListener(v -> presenter.onSignUp());
    }

    @Override
    public void onValidRegistration(){
        startActivity(new Intent(SignUpStudentActivity.this, StudentHomepageActivity.class));
    }

    @Override
    public String getfirstName(){
        firstNameInput = findViewById(R.id.editstudentfirstName);
        return firstNameInput.getText().toString();
    }

    @Override
    public String getlastName(){
        lastNameInput = findViewById(R.id.editstudentlastName);
        return lastNameInput.getText().toString();
    }

    @Override
    public String getAge(){
        ageInput = findViewById(R.id.editstudentAge);
        return ageInput.getText().toString();
    }

    @Override
    public String getEmail(){
        emailInput = findViewById(R.id.editstudentEmail);
        return emailInput.getText().toString();
    }

    @Override
    public String getIBAN(){
        ibanInput = findViewById(R.id.editstudentIBAN);
        return ibanInput.getText().toString();
    }

    @Override
    public String getPassword(){
        passwordInput = findViewById(R.id.inputPassword);
        return passwordInput.getText().toString();
    }

    @Override
    public String getGrade(){
        gradeInput = findViewById(R.id.editstudentGrade);
        return gradeInput.getText().toString();
    }

    @Override
    public void onInvalidInput(int code){
        String title = null;
        String message = null;
        if (code==1){
            title=getResources().getString(R.string.errorInputMessage1_1);
            message=getResources().getString(R.string.errorInputMessage1_1Info);
        }
        else if (code==2){
            title=getResources().getString(R.string.errorInputMessage2_1);
            message=getResources().getString(R.string.errorInputMessage2_1Info);
        }
        else if (code==3){
            title=getResources().getString(R.string.invalidEmail);
            message=getResources().getString(R.string.invalidEmailInfo);
        }
        else if (code==4){
            title=getResources().getString(R.string.errorInputMessage2_2);
            message=getResources().getString(R.string.errorInputMessage2_2Info);
        }
        else if (code==5){
            title=getResources().getString(R.string.errorInputMessage2_3Info);
            message=getResources().getString(R.string.errorInputMessage2_3);
        }
        else if (code==6){
            title=getResources().getString(R.string.errorInputMessage2_4);
            message=getResources().getString(R.string.errorInputMessage2_4Info);
        }
        else{
            title=getResources().getString(R.string.uknownError);
            message=getResources().getString(R.string.uknownErrorInfo);
        }
        new AlertDialog.Builder(SignUpStudentActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }
}