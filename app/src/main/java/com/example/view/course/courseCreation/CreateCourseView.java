package com.example.view.course.courseCreation;

public interface CreateCourseView {

    String getCourseID();

    String getCourseGrade();

    String getCourseTitle();

    String getCoursePrice();

    String courseDescription();

    void showEmptyInputMessage();

    void showInvalidGradeMessage();

    void onValidInput();
}