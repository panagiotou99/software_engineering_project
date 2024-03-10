package com.example.view.signup.signupTeacher;

public interface SignUpTeacherView {
    void onValidRegistration();

    String getfirstName();
    String getlastName();
    String getAge();
    String getEmail();
    String getIBAN();
    String getPassword();
    String getSsn();
    String getProfession();
    String getBio();

    void onInvalidInput(int code);
}
