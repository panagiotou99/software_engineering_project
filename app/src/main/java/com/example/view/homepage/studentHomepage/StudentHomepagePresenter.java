package com.example.view.homepage.studentHomepage;

public class StudentHomepagePresenter {
    StudentHomepageView view;

    public StudentHomepagePresenter(StudentHomepageView view) {
        this.view = view;
    }

    public void onClickParticipateInQuiz() {
        view.participateInQuiz();
    }

    public void onClickRegisterToCourses() {
        view.registerToCourse();
    }

    public void onClickMyCourses() {
        view.myCourses();
    }
    public void onClickMyResults() {
        view.myResults();
    }
    public void onClickMySavedQuestions() {
        view.mySavedQuestions();
    }
}


