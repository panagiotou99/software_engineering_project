package com.example.view.homepage.teacherHomepage;

public class TeacherHomepagePresenter {
    TeacherHomepageView view;

    public TeacherHomepagePresenter(TeacherHomepageView view) {
        this.view = view;
    }

    public void onClickCreateQuiz(){
        view.createQuiz();
    }

    public void onClickCreateCourse(){
        view.createCourse();
    }

    public void onClickAddQuestions(){
        view.addQuestions();
    }

    public void onClickCheckTeacherCourses(){
        view.checkTeacherCourses();
    }

    public void onClickCheckTeacherResults(){
        view.checkTeacherResults();
    }

    public void onClickEditQuizes(){
        view.editQuizes();
    }

    void detach() {
        view = null;
    }
}

