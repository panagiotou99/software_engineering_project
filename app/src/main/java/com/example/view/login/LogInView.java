package com.example.view.login;

public interface LogInView {
    String getEmail();
    String getPassword();

    void onInvalidInput(int code);
    void onSuccesLogin(int code);
    void onSignup();
    void onRemindPassword();
}
