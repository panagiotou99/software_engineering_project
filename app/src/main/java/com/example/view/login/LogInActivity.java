package com.example.view.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.dao.daoMemory.MemoryInitializer;
import com.example.dao.daoStub.Initializer;
import com.example.domain.User;
import com.example.learningapp.R;
import com.example.view.homepage.studentHomepage.StudentHomepageActivity;
import com.example.view.homepage.teacherHomepage.TeacherHomepageActivity;
import com.example.view.signup.SignUpActivity;

import java.io.IOException;

/**
 * A subclass of {@link AppCompatActivity} used for {@link User}
 * to login
 *
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */
public class LogInActivity extends AppCompatActivity implements LogInView{

    Button btnLogin,btnPasswordReminder,btnSignUp;
    EditText emailInput,passwordInput;
    Initializer initializer;
    LogInPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        setTitle(R.string.welcome_message);
        btnLogin = findViewById(R.id.loginButton);
        btnSignUp = findViewById(R.id.signupButton);
        btnPasswordReminder = findViewById(R.id.remindpasswordButton);
        initializer = new MemoryInitializer();
        try {
            initializer.prepareData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        presenter = new LogInPresenter(this, initializer.getUserDAO());
        InitClickListeners();
    }

    private void InitClickListeners(){
        btnLogin.setOnClickListener(v -> presenter.onLogIn());

        btnSignUp.setOnClickListener(v -> presenter.onSignUp());

        btnPasswordReminder.setOnClickListener(v -> presenter.onRemindPassword());
    }

    @Override
    public String getEmail(){
        emailInput = findViewById(R.id.inputEmail);
        return emailInput.getText().toString().trim();
    }

    @Override
    public String getPassword(){
        passwordInput = findViewById(R.id.inputPassword);
        return passwordInput.getText().toString().trim();
    }

    @Override
    public void onSuccesLogin(int code){
        if (code==1){
            startActivity(new Intent(getApplicationContext(), StudentHomepageActivity.class));
        }
        else{
            startActivity(new Intent(getApplicationContext(), TeacherHomepageActivity.class));
        }
    }

    @Override
    public void onSignup() {
        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
    }

    @Override
    public void onRemindPassword() {
        new AlertDialog.Builder(LogInActivity.this)
                .setCancelable(true)
                .setTitle(R.string.notAvailable)
                .setMessage(R.string.remindPasswordIsnotAvailable)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    @Override
    public void onInvalidInput(int code){
        String title = null;
        String message = null;
        if (code==1){
            title=getResources().getString(R.string.emptyInput);
            message=getResources().getString(R.string.emptyInputInfo);
        }
        else if (code==2){
            title=getResources().getString(R.string.invalidEmail);
            message=getResources().getString(R.string.invalidEmailInfo);
        }
        else if (code==3){
            title=getResources().getString(R.string.noUserFound);
            message=getResources().getString(R.string.noUserFoundInfo);
        }
        else{
            title=getResources().getString(R.string.uknownError);
            message=getResources().getString(R.string.uknownErrorInfo);
        }
        new AlertDialog.Builder(LogInActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }
}