package com.example.view.signup.signupStudent;

public interface SignUpStudentView {
    void onValidRegistration();
    void onInvalidInput(int code);
    String getfirstName();
    String getlastName();
    String getAge();
    String getEmail();
    String getIBAN();
    String getPassword();
    String getGrade();

}
