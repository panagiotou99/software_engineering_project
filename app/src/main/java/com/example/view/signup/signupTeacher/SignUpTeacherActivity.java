package com.example.view.signup.signupTeacher;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dao.daoMemory.MemoryInitializer;
import com.example.dao.daoStub.Initializer;
import com.example.domain.Teacher;
import com.example.learningapp.R;
import com.example.view.homepage.teacherHomepage.TeacherHomepageActivity;
import com.example.view.signup.signupStudent.SignUpStudentActivity;

import java.io.IOException;

/**
 * A subclass of {@link AppCompatActivity} used for {@link Teacher}
 * to register
 *
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */
public class SignUpTeacherActivity extends AppCompatActivity implements SignUpTeacherView{
    private Button btnSignUpTeacher;
    private SignUpTeacherPresenter presenter;
    private EditText firstNameInput,lastNameInput,ageInput,emailInput,ibanInput,passwordInput,gradeInput,ssnInput,bioInput,professionInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_teacher);
        setTitle(R.string.signup_teacher2);
        btnSignUpTeacher = findViewById(R.id.buttonTeacherSignUp);
        Initializer memory = new MemoryInitializer();
        try {
            memory.prepareData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        presenter = new SignUpTeacherPresenter(this, memory.getUserDAO());
        InitClickListeners();
    }

    private void InitClickListeners(){
        btnSignUpTeacher.setOnClickListener(v -> presenter.onSignUp());
    }

    @Override
    public void onValidRegistration(){
        startActivity(new Intent(SignUpTeacherActivity.this, TeacherHomepageActivity.class));
    }

    @Override
    public String getfirstName(){
        firstNameInput = findViewById(R.id.edittecherfirstName);
        return firstNameInput.getText().toString();
    }
    @Override

    public String getlastName(){
        lastNameInput = findViewById(R.id.editteacherlastName);
        return lastNameInput.getText().toString();
    }
    @Override
    public String getAge(){
        ageInput = findViewById(R.id.editteacherAge);
        return ageInput.getText().toString();
    }

    @Override
    public String getEmail(){
        emailInput = findViewById(R.id.editteacherEmail);
        return emailInput.getText().toString();
    }

    @Override
    public String getIBAN(){
        ibanInput = findViewById(R.id.editteacherIBAN);
        return ibanInput.getText().toString();
    }

    @Override
    public String getPassword(){
        passwordInput = findViewById(R.id.inputPassword);
        return passwordInput.getText().toString();
    }
    @Override

    public String getSsn(){
        ssnInput = findViewById(R.id.editteacherSsn);
        return ssnInput.getText().toString();
    }

    @Override
    public String getProfession(){
        professionInput = findViewById(R.id.editteacherProfession);
        return professionInput.getText().toString();
    }

    @Override
    public String getBio(){
        bioInput = findViewById(R.id.editteacherBio);
        return bioInput.getText().toString();
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
            title=getResources().getString(R.string.errorInputMessage2_5);
            message=getResources().getString(R.string.errorInputMessage2_5Info);
        }
        else if (code==3){
            title=getResources().getString(R.string.invalidEmail);
            message=getResources().getString(R.string.invalidEmailInfo);
        }
        else if (code==4){
            title=getResources().getString(R.string.errorInputMessage2_3Info);
            message=getResources().getString(R.string.errorInputMessage2_3);
        }
        else if (code==5){
            title=getResources().getString(R.string.errorInputMessage2_4);
            message=getResources().getString(R.string.errorInputMessage2_4Info);
        }
        else{
            title=getResources().getString(R.string.uknownError);
            message=getResources().getString(R.string.uknownErrorInfo);
        }
        new AlertDialog.Builder(SignUpTeacherActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }
}