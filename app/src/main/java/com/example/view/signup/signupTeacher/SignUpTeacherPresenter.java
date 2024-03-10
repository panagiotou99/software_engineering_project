package com.example.view.signup.signupTeacher;

import com.example.dao.daoStub.UserDAO;
import com.example.domain.Teacher;
import com.example.util.SignUpChecker;

public class SignUpTeacherPresenter {
    SignUpTeacherView view;
    UserDAO userDAO;

    public SignUpTeacherPresenter(SignUpTeacherView view, UserDAO userDAO) {
        this.view = view;
        this.userDAO = userDAO;
    }

    public Teacher onSignUp(){
        if (view.getfirstName().isEmpty() || view.getlastName().isEmpty() || view.getAge().isEmpty() || view.getEmail().isEmpty() || view.getIBAN().isEmpty() || view.getPassword().isEmpty() || view.getSsn().isEmpty() || view.getBio().isEmpty() || view.getProfession().isEmpty()){
            view.onInvalidInput(1);
            return null;
        }
        if (Integer.parseInt(view.getAge()) <18){
            view.onInvalidInput(2);
            return null;
        }

        if (!SignUpChecker.isEmail(view.getEmail())){
            view.onInvalidInput(3);
            return null;
        }

        if (!SignUpChecker.isPassword(view.getPassword())){
            view.onInvalidInput(4);
            return null;
        }

        if (!SignUpChecker.isIBAN(view.getIBAN())){
            view.onInvalidInput(5);
            return null;
        }
        Teacher newTeacher = new Teacher(view.getfirstName(), view.getlastName(), Integer.parseInt(view.getAge()), view.getEmail(), view.getIBAN(), view.getPassword(), view.getProfession(), view.getBio(), Integer.parseInt(view.getSsn()));
        userDAO.registerUser(newTeacher);
        view.onValidRegistration();
        return newTeacher;
    }
}
