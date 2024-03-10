package com.example.view.login;

import com.example.dao.daoStub.UserDAO;
import com.example.domain.Student;
import com.example.domain.Teacher;
import com.example.domain.User;
import com.example.util.SignUpChecker;

public class LogInPresenter {
    LogInView view;
    UserDAO userDAO;

    LogInPresenter(LogInView view, UserDAO userDAO) {
        this.view = view;
        this.userDAO = userDAO;
    }

    User onLogIn() {
        if (view.getEmail().isEmpty() || view.getPassword().isEmpty()) {
            view.onInvalidInput(1);
            return null;
        }
        if (!SignUpChecker.isEmail(view.getEmail())) {
            view.onInvalidInput(2);
            return null;
        }
        User user = userDAO.getUserfromCredentials(view.getEmail(), view.getPassword());
        if (user instanceof Student) {
            view.onSuccesLogin(1);
            return user;

        } else if (user instanceof Teacher) {
            view.onSuccesLogin(2);
            return user;
        } else {
            view.onInvalidInput(3);
            return null;
        }
    }

    void onSignUp() {
        view.onSignup();
    }

    void onRemindPassword(){
        view.onRemindPassword();
    }

}
