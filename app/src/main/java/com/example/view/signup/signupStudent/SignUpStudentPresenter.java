package com.example.view.signup.signupStudent;

import com.example.dao.daoStub.UserDAO;
import com.example.domain.Student;
import com.example.util.SignUpChecker;

public class SignUpStudentPresenter {

    SignUpStudentView view;
    UserDAO userDAO;

    public SignUpStudentPresenter(SignUpStudentView view, UserDAO userDAO) {
        this.view = view;
        this.userDAO = userDAO;
    }

    public Student onSignUp(){
        if (view.getfirstName().isEmpty() || view.getlastName().isEmpty() || view.getAge().isEmpty() || view.getEmail().isEmpty() || view.getIBAN().isEmpty() || view.getPassword().isEmpty() || view.getGrade().isEmpty()){
            view.onInvalidInput(1);
            return null;
        }
        if (Integer.parseInt(view.getAge()) <6){
            view.onInvalidInput(2);
            return null;
        }

        if (Integer.parseInt(view.getGrade()) <1 || Integer.parseInt(view.getGrade())>12){
            view.onInvalidInput(4);
            return null;
        }

        if (!SignUpChecker.isEmail(view.getEmail())){
            view.onInvalidInput(3);
            return null;
        }

        if (!SignUpChecker.isPassword(view.getPassword())){
            view.onInvalidInput(5);
            return null;
        }

        if (!SignUpChecker.isIBAN(view.getIBAN())){
            view.onInvalidInput(6);
            return null;
        }
        Student newStudent = new Student(view.getfirstName(), view.getlastName(), Integer.parseInt(view.getAge()), view.getEmail(), view.getIBAN(), view.getPassword(), Integer.parseInt(view.getGrade()));
        userDAO.registerUser(newStudent);
        view.onValidRegistration();
        return newStudent;
    }

}
